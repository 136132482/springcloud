package com.springcloud.provider.exception;


import com.springcloud.provider.constants.CodeMsg;
import com.springcloud.provider.constants.Constant;
import com.springcloud.provider.constants.Constants;
import com.springcloud.provider.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 * Created by odfly on 2017/1/3.
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {
    private static final Logger log = Logger.getLogger(GlobalHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        String msg = e.getMessage();
        log.error("ExceptionHandler 捕获的异常：", e);
        ModelAndView mv = new ModelAndView();
        if (e instanceof ParamException) {//获取参数异常
            if (msg != null && msg.contains(Constants.EXCEPT_SPLIT)) {
                String[] exceptionMsg = msg.split(Constants.EXCEPT_SPLIT);
                ResponseUtil.writeJSON(exceptionMsg[0], exceptionMsg[1]);
                exceptionMsg = null;
            } else {
                ResponseUtil.writeJSON(CodeMsg.setMsg(msg));
                //log.info("ExceptionHandler 捕获的异常：", e);
            }
            ResponseUtil.writeJSON(Constant.SYSTEM_GETPARAMETER);
        } else if (msg != null && msg.contains("updating database")) {
            ResponseUtil.writeJSON(Constant.SYSTEM_ADD_DATA_ERROR);
            //log.error("ExceptionHandler 捕获的异常：", e);
        } else {
            ResponseUtil.writeJSON(Constant.SYSTEM_UNKNOWN_ERROR);
            
        }
        msg = null;
        e = null;
        return mv;
    }
}
