package com.springcloud.provider.interceptor;

import com.alibaba.fastjson.JSONObject;

import com.springcloud.provider.annotation.NoAccessRequired;
import com.springcloud.provider.config.SpringContextUtil;
import com.springcloud.provider.constants.Constant;
import com.springcloud.provider.util.HttpHelper;
import com.springcloud.provider.util.RequestUtil;
import com.springcloud.provider.util.SignKeyUitl;
import com.springcloud.provider.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by odfly on 2017/1/4.
 */
public class RequestInterceptor implements HandlerInterceptor {
    private static final ThreadLocal<Long> startTimeThreadLocal =
            new NamedThreadLocal<Long>("ThreadLocal StartTime");
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 请求日志处理bean
     */
//    RequestLogSolr requestLogSolr = SpringContextUtil.getBean("requestLogSolr");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 处理器实际执行之前
//        logger.error("+++处理器执行之前++");
        if (request.getContentType() != null && request.getContentType() != "") {
            if (request.getContentType().contains("multipart/form-data")) {
                //form表单文件上传
                Map<String, String> stringStringMap = RequestUtil.convertRequestParamsToMap(request);
                request.setAttribute("requestParams",JSONObject.toJSONString(stringStringMap) );//获取请求内容
            } else if ("file".equals(request.getHeader("Request-Type"))) {
                //file文件上传
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("userid", request.getHeader("userid"));
                jsonObject.put("token", request.getHeader("token"));
                jsonObject.put("gcid", request.getHeader("gcid"));
                request.setAttribute("requestParams", jsonObject.toJSONString());//获取请求内容
            } else if ("body".equals(request.getHeader("Request-Type")) || StringUtil.isEmpty(request.getParameter(Constant.DATA))) {
                //body方式请求
                request.setAttribute("requestParams", HttpHelper.getBodyString(request));//获取body请求内容
                //request.setAttribute(Constant.USERID, request.getHeader(Constant.USERID));//保存当前用户ID到request中
            } else {
                //parameter方式请求
                request.setAttribute("requestParams", request.getParameter(Constant.DATA));//获取请求参数内容
            }
        } else {
            if ("file".equals(request.getHeader("Request-Type"))) {
                //file文件上传
                Map<String, String> stringStringMap = RequestUtil.convertRequestParamsToMap(request);
                request.setAttribute("requestParams",JSONObject.toJSONString(stringStringMap) );//获取请求内容
            } else if ("body".equals(request.getHeader("Request-Type")) || StringUtil.isEmpty(request.getParameter(Constant.DATA))) {
                //body方式请求
//                request.setAttribute("requestParams", HttpHelper.getBodyString(request));//获取body请求内容
                String reqstring = HttpHelper.getBodyString(request);
                JSONObject json = null;
                try {
                    json = JSONObject.parseObject(reqstring);
                }catch (Exception e){

                }
                SignKeyUitl sku = SpringContextUtil.getBean("signKeyUitl");
                if (null != json && StringUtil.isNotBlank(json.getString("signkey"))) {
                    /*if(SignKeyUitl.checkDateKey(json.get("signkey").toString(),sku.getApartment(),json.get("params").toString())){
                        request.setAttribute("requestParams", reqstring);
                    }else{
                        return false;
                    }*/
                    request.setAttribute("requestParams", reqstring);
                } else {
                    request.setAttribute("requestParams", reqstring);
                }

                //request.setAttribute(Constant.USERID, request.getHeader(Constant.USERID));//保存当前用户ID到request中
            } else {
                //parameter方式请求
//                request.setAttribute("requestParams", request.getParameter(Constant.DATA));//获取请求参数内容
                String reqstring = request.getParameter(Constant.DATA);
                try {
                    JSONObject json = JSONObject.parseObject(reqstring);
                    SignKeyUitl sku = SpringContextUtil.getBean("signKeyUitl");
                    if (null != json && StringUtil.isNotBlank(json.getString("signkey"))) {
                    /*if(SignKeyUitl.checkDateKey(json.get("signkey").toString(),sku.getApartment(),json.get("params").toString())){
                        request.setAttribute("requestParams", reqstring);
                    }else{
                        return false;
                    }*/
                        request.setAttribute("requestParams", reqstring);
                    } else {
                        request.setAttribute("requestParams", reqstring);
                    }
                }catch (Exception e){
                    logger.error("+++parameter方式请求+cache+",e);
                    request.setAttribute("requestParams", reqstring);
                }
            }
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        NoAccessRequired noAccessRequired = method.getAnnotation(NoAccessRequired.class);
//        if (noAccessRequired != null && "payType".equals(method.getName())) {
//        } else {
//            request.setAttribute(Constant.USERID, RequestUtil.getParameterToString(Constant.USERID));//保存当前用户ID到request中
//            request.setAttribute(Constant.GCID, RequestUtil.getParameterToString(Constant.GCID));//保存当前公司ID到request中
//        }
        /*
        request.setAttribute(Constant.USERID, RequestUtil.getParameterToString(Constant.USERID));//保存当前用户ID到request中
        request.setAttribute(Constant.GCID, RequestUtil.getParameterToString(Constant.GCID));//保存当前公司ID到request中
        */
        /*if (logger.isDebugEnabled()) {
            long beginTime = System.currentTimeMillis();//1、开始时间
            startTimeThreadLocal.set(beginTime);        //线程绑定变量（该数据只有当前请求的线程可见）
            logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
                    .format(beginTime), request.getRequestURI());
        }*/
        /*HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //String requestMethod = request.getServletPath().substring(request.getServletPath().lastIndexOf("/")+1);
        //如果请求方法为ui,不做任何处理
        if ("swaggerResources".equals(method.getName())) {
            return true;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelandView) throws Exception {
        // 处理器执行完毕之后
        if (modelandView != null) {
            logger.info("ViewName: " + modelandView.getViewName());
        }
//        System.out.println("处理器执行完毕啦！");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        // 请求处理完成之后
        // 保存日志
        // 打印JVM信息。
        /*if (logger.isDebugEnabled()) {
            long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
            long endTime = System.currentTimeMillis();    //2、结束时间
            logger.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                    new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), endTime - beginTime,
                    request.getRequestURI(), Runtime.getRuntime().maxMemory() / 1024 / 1024, Runtime.getRuntime().totalMemory() / 1024 / 1024, Runtime.getRuntime().freeMemory() / 1024 / 1024,
                    (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024 / 1024);
        }
        System.out.println("请求处理完成啦！");*/

        //将请求信息插入solr
//        try{
//            TableJjrUser user = RequestUtil.getLoginUser();
//            String gcId = RequestUtil.getParameterToString("gcid");
//            String userId = "";
//            String userName = "";
//            if (null != user && StringUtil.isNotBlank(user.getId())){
//                gcId = user.getGcid();
//                userId = user.getId();
//                userName = user.getNickName();
//            }
//            RequestLog log = new RequestLog(new Date(),
//                    userId,
//                    userName,
//                    request.getRequestURI(),
//                    (String) request.getAttribute("requestParams"),
//                    WebUtil.getHost(request),
//                    gcId);
//            requestLogSolr.insertRequestLog(log);
//        }catch (Exception ex){
//        	logger.error("afterCompletion error ",e);
//
//        }
    }
}
