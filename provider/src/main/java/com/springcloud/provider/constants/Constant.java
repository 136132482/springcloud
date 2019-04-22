package com.springcloud.provider.constants;

import java.util.HashMap;
import java.util.Map;

public class Constant extends Constants {
    /**
     * 用户缓存标识
     */
    public static final String USERCACHE = "USERCACHE";

    /**
     * 用户权限标识
     */
    public static final String PERMISSIONCACHE = "PERMISSIONCACHE";

    /**
     * sortType
     */
    public static final String SORTTYPE = "sortType";

    /**
     * accountPwd用户登录密码字段
     */
    public static final String ACCOUNTPWD = "accountPwd";

    /**
     * params字段
     */
    public static final String PARAMS = "params";

    /**
     * params字段
     */
    public static final String CRON = "cron";

    /**
     * 登陆的失效时间，2个小时
     */
    public static final int LOGIN_EXPIRE_TIME = 60*60*2;

    /**
     * gcid的过滤路径开关
     */
    public static final String GCIDEXCLUDEPATHFLAG = "gcIdExcludePathFlag";

    /**
     * gcid的过滤路径
     */
    public static final String GCIDEXCLUDEPATH = "gcIdExcludePath";

    /**
     * sql注入拦截的开关
     */
    public static final String SQLINJECTIONCHECKFLAG = "sqlInjectionCheckFlag";

    /**
     * 跳过sql注入检测的路径
     */
    public static final String SQLINJECTIONNOTCHECKPATH = "sqlInjectionNotCheckPath";

    /**
     * sql注入拦截的字符
     */
    public static final String SQLINJECTIONCHECKCHARACTER = "sqlInjectionCheckCharacter";

    /**
     * sql注入不检测的字符
     */
    public static final String NOTCHECKPARAMS = "notCheckParams";

    /**
     * int类型的boolean值 真 1
     */
    public static final Integer TRUE = 1;
    /**
     * int类型的boolean值 假 0
     */
    public static final Integer FALSE = 0;

    /**
     * 等于符号常量
     */
    public static final String E_Q = "eq";
    /**
     * 大于符号常量
     */
    public static final String G_T = "gt";
    /**
     * 小于符号常量
     */
    public static final String L_T = "lt";

    /**
     * 0字符串
     */
    public static final String ZERO_STR = "0";

    /**
     * 特殊字符串
     */
    public static final String SPECIAL_STR = "^§^";

    /**
     * 开始标志
     */
    public final static String START_TYPE = "start round";

    /**
     * 结束标志
     */
    public final static String END_TYPE = "end round";

    /**
     * 财务短信催收关键字
     */
    public final static String BALANCE_SMS_NOTIFY = "BALANCE_SMS_NOTIFY";

    /**
     * 系统部门
     */
    public final static String SYS_DEPT = "SYS_DEPT";
    /**
     * 系统角色
     */
    public final static String SYS_ROLE = "SYS_ROLE";
    /**
     * 集中房型
     */
    public final static String ROOM_TYPE = "ROOM_TYPE";
    /**
     * 集中项目
     */
    public final static String HOUSE_ITEM = "HOUSE_ITEM";
    /**
     * 系统城市
     */
    public final static String SYS_CITY = "SYS_CITY";

    /**
     * 系统用户
     */
    public final static String SYS_USER = "SYS_USER";

    /**
     * 未知款关联title
     */
    public final static String UNKNOW_MONEY_TITLE = "【由未知款关联】";

    /**
     * 操作日志redis存储key
     */
    public final static String HAND_RECORD_LOG_REDIS_KEY = "HAND_RECORD_LOG_REDIS_KEY";

    /**
     * 消息推送redis存储key
     */
    public final static String PUSH_MESSAGE_REDIS_KEY = "PUSH_MESSAGE_REDIS_KEY";

    /**
     * 批量保洁redis存储key-周鹏-原版
     */
    public final static String TABLE_CLEAN_REDIS_KEY = "TABLE_CLEAN_REDIS_KEY";

    /**
     * 批量保洁记录redis存储key
     */
    public final static String TABLE_CLEAN_RECORD_BATCH_REDIS_KEY = "TABLE_CLEAN_RECORD_BATCH_REDIS_KEY";

    /**
     * 排序类型-升序关键字
     */
    public final static String SORT_TYPE_ASC = "asc";
    /**
     * 排序类型-降序关键字
     */
    public final static String SORT_TYPE_DESC = "desc";

    /**
     * 总计关键字
     */
    public final static String TOTAL_KEY = "Total";

    /**
     * 百分号
     */
    public final static String PERCENT_SIGN = "%";

    /**
     * 空值关键字
     */
    public final static String EMPTY_KEY = "EMPTY";

    /**
     * 成租审批redis key
     */
    public final static String CHENGZU_APPROVAL_REDIS_KEY = "CHENGZU_APPROVAL";

    /**
     * 签约审批redis key
     */
    public final static String QIANYUE_APPROVAL_REDIS_KEY = "QIANYUE_APPROVAL";

    /**
     * 基础信息redis前缀
     */
    public final static String BASIS_PREFIX = "BASIS_PREFIX:";

    /**
     * 获取相反的int型boolean 变量值
     *
     * @param intBoolean {@link #TRUE} {@link #FALSE}
     * @return
     */
    public static Integer getNotIntegerBoolean(Integer intBoolean) {
        if (TRUE.equals(intBoolean)) {
            return FALSE;
        }
        return TRUE;
    }

    public static String getCityName(String cityCode) {
        String cityName = "";
        //北京
        if ("010".equals(cityCode)) {
            cityName = "bj";
        }
        //上海
        else if ("021".equals(cityCode)) {
            cityName = "sh";
        }
        //天津
        else if ("022".equals(cityCode)) {
            cityName = "tj";
        }
        //重庆
        else if ("023".equals(cityCode)) {
            cityName = "cq";
        }
        //武汉
        else if ("027".equals(cityCode)) {
            cityName = "wh";
        }
        //深圳
        else if ("0755".equals(cityCode)) {
            cityName = "sz";
        }
        //广州
        else if ("020".equals(cityCode)) {
            cityName = "gz";
        }
        //杭州
        else if ("0571".equals(cityCode)) {
            cityName = "hz";
        }
        //南京
        else if ("025".equals(cityCode)) {
            cityName = "nj";
        }
        //成都
        else if ("028".equals(cityCode)) {
            cityName = "cd";
        }
        //西安
        else if ("029".equals(cityCode)) {
            cityName = "xa";
        }
        //郑州
        else if ("0371".equals(cityCode)) {
            cityName = "zz";
        }
        //济南
        else if ("0531".equals(cityCode)) {
            cityName = "jn";
        }
        //兰州
        else if ("0931".equals(cityCode)) {
            cityName = "lz";
        }
        //苏州
        else if ("0512".equals(cityCode)) {
            cityName = "su";
        }
        //太原
        else if ("0351".equals(cityCode)) {
            cityName = "ty";
        }
        //乌鲁木齐
        else if ("0991".equals(cityCode)) {
            cityName = "xj";
        }
        //中山
        else if ("0411".equals(cityCode)) {
            cityName = "zs";
        }
        //佛山
        else if ("0757".equals(cityCode)) {
            cityName = "fs";
        }
        //珠海
        else if ("0756".equals(cityCode)) {
            cityName = "zh";
        }
        //东莞
        else if ("0769".equals(cityCode)) {
            cityName = "dg";
        }
        //青岛
        else if ("0532".equals(cityCode)) {
            cityName = "qd";
        }
        //哈尔滨
        else if ("0451".equals(cityCode)) {
            cityName = "hrb";
        }
        //沈阳
        else if ("024".equals(cityCode)) {
            cityName = "sy";
        }
        //长春
        else if ("0431".equals(cityCode)) {
            cityName = "cc";
        }
        //大连
        else if ("0411".equals(cityCode)) {
            cityName = "dl";
        }
        //南昌
        else if ("0791".equals(cityCode)) {
            cityName = "nc";
        }
        //长沙
        else if ("0731".equals(cityCode)) {
            cityName = "cs";
        }
        //乐山
        else if ("0833".equals(cityCode)) {
            cityName = "ls";
        }
        //福州
        else if ("0591".equals(cityCode)) {
            cityName = "fz";
        }
        //厦门
        else if ("0592".equals(cityCode)) {
            cityName = "xm";
        }
        //宜宾
        else if ("0831".equals(cityCode)) {
            cityName = "yb";
        }
        //昆山
        else if ("0512".equals(cityCode)) {
            cityName = "ks";
        }
        //南宁
        else if ("0771".equals(cityCode)) {
            cityName = "nn";
        }
        //海南
        else if ("0898".equals(cityCode)) {
            cityName = "hn";
        }
        //无锡
        else if ("0510".equals(cityCode)) {
            cityName = "wx";
        }
        //石家庄
        else if ("0311".equals(cityCode)) {
            cityName = "sjz";
        }
        //宜春
        else if ("0795".equals(cityCode)) {
            cityName = "yc";
        }
        return cityName;
    }

    /**
     * CODE 1000
     * SYS_MSG 用户未登录
     * MSG 请检查输入信息的合法性
     */
    public static final Map<String, String> USER_NOT_LOGIN = new HashMap<String, String>() {
        {
            put(CODE, "1000");
            put(SYS_MSG, "用户未登录或token已失效");
            put(MSG, "请重新登录一下 哦!");
        }
    };
    /**
     * CODE 1001
     * SYS_MSG 系统找不到该用户
     * MSG 获取不到用户信息
     */
    public static final Map<String, String> USER_GET_NOT = new HashMap<String, String>() {
        {
            put(CODE, "1001");
            put(SYS_MSG, "系统找不到该用户");
            put(MSG, "获取不到用户信息!");
        }
    };
    /**
     * CODE 1002
     * SYS_MSG 用户已存在
     * MSG 用户已存在
     */
    public static final Map<String, String> USER_IN = new HashMap<String, String>() {
        {
            put(CODE, "1002");
            put(SYS_MSG, "用户已存在");
            put(MSG, "用户已存在哦!");
        }
    };
    /**
     * CODE 1003
     * SYS_MSG 输入用户名
     * MSG 请输入用户名
     */
    public static final Map<String, String> USER_NAME_NOT = new HashMap<String, String>() {
        {
            put(CODE, "1003");
            put(SYS_MSG, "输入用户名");
            put(MSG, "请输入用户名!");
        }
    };
    /**
     * CODE 1004
     * SYS_MSG 用户名错误
     * MSG 请检查用户名是否正确
     */
    public static final Map<String, String> USER_NAME_ERROR = new HashMap<String, String>() {
        {
            put(CODE, "1004");
            put(SYS_MSG, "用户名错误");
            put(MSG, "请检查用户名是否正确!");
        }
    };
    /**
     * CODE 1005
     * SYS_MSG 输入密码
     * MSG 请输入密码
     */
    public static final Map<String, String> USER_PASSWORD_NOT = new HashMap<String, String>() {
        {
            put(CODE, "1005");
            put(SYS_MSG, "输入密码");
            put(MSG, "请输入密码!");
        }
    };
    /**
     * CODE 1006
     * SYS_MSG 密码错误
     * MSG 请检查密码是否正确
     */
    public static final Map<String, String> USER_PASSWORD_ERROR = new HashMap<String, String>() {
        {
            put(CODE, "1006");
            put(SYS_MSG, "密码错误");
            put(MSG, "请检查密码是否正确!");
        }
    };
    /**
     * CODE 1007
     * SYS_MSG 用户名或密码错误
     * MSG 请检查用户名和密码是否正确
     */
    public static final Map<String, String> USER_NAME_AND_PWD_ERROR = new HashMap<String, String>() {
        {
            put(CODE, "1007");
            put(SYS_MSG, "用户名或密码错误");
            put(MSG, "请检查用户名和密码是否正确!");
        }
    };
    /**
     * CODE 1008
     * SYS_MSG 验证码不存在
     * MSG 请输入正确验证码
     */
    public static final Map<String, String> CODE_NOT = new HashMap<String, String>() {
        {
            put(CODE, "1008");
            put(SYS_MSG, "输入验证码");
            put(MSG, "请输入正确验证码!");
        }
    };
    /**
     * CODE 1009
     * SYS_MSG 用户未登录
     * MSG 请检查输入信息的合法性
     */
    public static final Map<String, String> CODE_ERROR = new HashMap<String, String>() {
        {
            put(CODE, "1009");
            put(SYS_MSG, "验证码错误");
            put(MSG, "请检验验证码是否正确!");
        }
    };
    /**
     * CODE 1010
     * SYS_MSG 注销成功
     * MSG 您已安全退出
     */
    public static final Map<String, String> USER_EXIT = new HashMap<String, String>() {
        {
            put(CODE, "1010");
            put(SYS_MSG, "注销成功");
            put(MSG, "您已安全退出!");
        }
    };

    /**
     * CODE 1011
     * SYS_MSG 用户已冻结
     * MSG 当前账号已冻结， 请联系管理员！
     */
    public static final Map<String, String> USER_FREEZE = new HashMap<String, String>() {
        {
            put(CODE, "1011");
            put(SYS_MSG, "用户已冻结");
            put(MSG, "当前账号已冻结， 请联系管理员！");
        }
    };
    /**
     * CODE 1012
     * SYS_MSG 用户待审核
     * MSG 用户待审核
     */
    public static final Map<String, String> USER_PENDING = new HashMap<String, String>() {
        {
            put(CODE, "1012");
            put(SYS_MSG, "用户待审核");
            put(MSG, "用户待审核");
        }
    };
    /**
     * CODE 1013
     * SYS_MSG 用户已删除
     * MSG 用户已删除
     */
    public static final Map<String, String> USER_DELETED = new HashMap<String, String>() {
        {
            put(CODE, "1013");
            put(SYS_MSG, "用户已删除");
            put(MSG, "用户已删除");
        }
    };
    /**
     * CODE 1014
     * SYS_MSG 用户已存在黑名单中
     * MSG 用户已存在黑名单中
     */
    public static final Map<String, String> USER_EXIST_BLACK_LIST = new HashMap<String, String>() {
        {
            put(CODE, "1013");
            put(SYS_MSG, "用户已存在黑名单中");
            put(MSG, "用户已存在黑名单中");
        }
    };

    /**
     * CODE 1015
     * SYS_MSG 该用户没有这次操作的权限
     * MSG 该用户没有这次操作的权限
     */
    public static final Map<String, String> USER_PERMISSION = new HashMap<String, String>(3) {
        {
            put(CODE, "1015");
            put(SYS_MSG, "该用户没有这次操作的权限");
            put(MSG, "该用户没有这次操作的权限");
        }
    };

    /**
     * 财务模块关键字
     */
    public static final String FINANCE_MODULE_KEY = "BALANCE";


    /**
     * 房乾自有客户安全码
     */
    public static final String FQ_GCIDS_TEST = "#0100099#0100010#";

    /**
     * 房乾自有客户安全码
     */
    public static final String FQ_GCIDS = "#0371040#0532003#0101164#03510005#05000003#0290011#0101015#021173" +
            "#021156#0351008#0371070#027001#025001#0280077#0200011#025018#021004" +
            "#05000026#0101020#0101060#029007#0531020#0371038#05000021#0531018#0280010#05000009#0100085#021066" +
            "#0751003#0280007#021137#0280009#0101003#0100006#0291013" +
            "#0280008#0100095#025110#0101037#05310003#0100088#021015#0351010" +
            "#0101000#0751011#0531014#0591001#0371006#0591002#0105588#0100099" +
            "#0351007#0791001#021007#0280018#0757001#0100092#0101001#0101050" +
            "#0100087#0539001#0281030#0280045#0280006#0281032#05920014#0571006" +
            "#0281029#0500030#0571017#0531007#0751001#0281033#0100094#0351004#025009#0250025#0101049#0100010#0280080#";

    /**
     * 房乾自有客户安全码
     */
    public static final String FQ_GCIDS_BAK = "#0371040#0532003#0101164#03510005#05000003#0290011#0101015#021173" +
            "#021156#0351008#0371070#027001#025001#0280077#0200011#025018#021004" +
            "#05000026#0101020#0101060#029007#0531020#0371038#05000021#0531018#0280010#05000009#0100085#021066" +
            "#0751003#0280007#021137#0280009#0101003#0100006#0291013" +
            "#0280008#0100095#025110#0101037#05310003#0100088#021015#0351010" +
            "#0101000#0751011#0531014#0591001#0371006#0591002#0105588#0100099" +
            "#0351007#0791001#021007#0280018#0757001#0100092#0101001#0101050" +
            "#0100087#0539001#0281030#0280045#0280006#0281032#05920014#0571006" +
            "#0281029#0500030#0571017#0531007#0751001#0281033#0100094#0351004#025009#0250025#0101049#0100010#0280080#";


    /**
     * 房乾自有客户安全码
     */
    public static final String FQ_GCIDS_NORMAL = "#0371040#0532003#0101164#03510005#05000003#0290011#0101015#021173" +
            "#021156#0351008#0371070#027001#025001#0280077#0200011#025018#021004" +
            "#05000026#0101020#0101060#029007#0531020#0371038#05000021#0531018#0280010#05000009#0100085#021066" +
            "#0751003#0280007#021137#0280009#0101003#0100006#0291013" +
            "#0280008#0100095#025110#0101037#05310003#0100088#021015#0351010" +
            "#0101000#0751011#0531014#0591001#0371006#0591002#0105588#0100099" +
            "#0351007#0791001#021007#0280018#0757001#0100092#0101001#0101050" +
            "#0100087#0539001#0281030#0280045#0280006#0281032#05920014#0571006" +
            "#0281029#0500030#0571017#0531007#0751001#0281033#0100094#0351004#025009#0250025#0101049#0100010#0280080" +
            "#0531001#025099#";


    /**
     * 平安所属GCID
     */
    public static final String PA_GCIDS = "#0100050#0100062#0100066#0100084#0100086#0100098#0100688#0101002#" +
            "0101004#0101005#0101006#01010062#0101007#0101008#0101009#0101010#0101011#0101012#0101013#0101014#" +
            "01010154#0101016#0101017#0101018#0101019#0101021#0101022#0101023#0101025#0101026#0101027#0101028#" +
            "0101029#0101030#0101031#0101032#0101033#0101034#0101035#0101036#0101039#0101048#0101051#0101052#" +
            "0101053#0101054#0101055#0101056#0101057#0101058#0101059#0101061#0101062#0101063#0101064#0101065#" +
            "0101066#0101067#0101068#0101069#0101070#0101072#0101073#0101074#0101075#0101076#0101077#0101078#" +
            "0101079#0101081#0101082#0101083#0101084#0101085#0101086#0101087#0101088#0101089#0101090#0101091#" +
            "0101092#0101093#0101094#0101095#0101096#0101097#0101098#0101099#0101101#0101102#0101103#0101104#" +
            "0101105#0101106#0101107#0101108#0101109#0101110#0101111#0101112#0101113#0101114#0101115#0101116#" +
            "0101117#0101118#0101119#0101120#0101121#0101122#0101123#0101124#0101125#0101126#0101127#0101128#" +
            "0101129#0101130#0101131#0101132#0101133#0101134#0101135#0101136#0101137#0101138#0101139#0101140#" +
            "0101141#0101142#0101143#0101144#0101145#0101146#0101147#0101148#0101149#0101150#0101151#0101152#" +
            "0101153#0101154#0101155#0101156#0101157#0101158#0101159#0101160#0101161#0101162#0101163#0101165#" +
            "0101166#0101167#0101168#0101169#0101171#0101172#0101173#0101174#0101175#0101176#0101177#0101178#" +
            "0101179#0101180#0101181#0101182#0101183#0101184#0101185#0101186#0101187#0101188#0101189#0101190#" +
            "0101191#0101192#0101193#0101194#0101195#0101196#0101197#0101199#0101200#0101201#0101202#0102002#" +
            "0109999#0199999#0200001#0200002#0200003#0200004#0200005#0200007#0200008#0200009#0200010#0200012#" +
            "0200013#0200014#0200015#0200016#0200017#0200018#0200019#0200020#0200021#0200022#0200023#0200024#" +
            "0200025#0200026#0200027#0200028#0200029#0200030#0200031#0200032#0200033#0200034#0200035#0200036#" +
            "0200037#0200038#0200039#0200040#0200041#0200042#0200043#0200044#021001#021002#021005#021008#021009#" +
            "021010#021011#021012#021013#021014#021016#021017#021018#021019#021020#021021#021022#021023#021024#" +
            "021025#021026#021027#021028#021029#021030#021031#021032#021033#021034#021035#021036#021037#021038#" +
            "021039#021040#021041#021042#021043#021044#021045#021046#021047#021048#021049#021050#021051#021052#" +
            "021053#021054#021055#021056#021057#021058#021059#021060#021061#021062#021063#021064#021065#021067#" +
            "021068#021069#021070#021071#021072#021073#021074#021075#021076#021077#021078#021079#021080#021081#" +
            "021082#021083#021084#021085#021086#021087#021088#021089#021090#021091#021092#021093#021094#021095#" +
            "021096#021097#021098#021099#021100#021101#021102#021103#021104#021105#021106#021107#021108#021109#" +
            "021110#021111#021112#021113#021114#021115#021116#021117#021118#021119#021120#021121#021122#021123#" +
            "021124#021125#021126#021127#021128#021129#021130#021131#021132#021133#021134#021135#021136#021138#" +
            "021139#021140#021141#021142#021143#021144#021145#021146#021147#021148#021149#021150#021151#021152#" +
            "021153#021154#021155#021157#021158#021159#021160#021161#021162#021163#021164#021165#021166#021167#" +
            "021168#021169#021170#021171#021172#021174#021175#021177#021178#021179#021180#021181#021182#021183#" +
            "021184#021185#021186#021187#021188#021189#021190#021191#021192#021193#021194#021195#021196#021197#" +
            "021198#021199#021200#021201#021202#021203#021204#021205#021206#021207#021208#021209#021210#021211#" +
            "021212#021213#021214#021215#021216#021217#021218#021219#021220#021221#021222#021223#021224#021225#" +
            "021226#022#0221002#023001#023002#023003#023004#023005#023006#023007#023008#023009#023010#0231001#" +
            "0231032#024001#024002#025002#025003#025004#025006#025008#025010#025011#025012#025013#025014#025016#" +
            "025017#025019#025020#025021#025022#025023#025024#025025#025026#025027#025028#025029#025030#027#0271008#" +
            "0271009#0271010#0271011#0271013#0271014#0271015#0271016#0271017#0271018#0271020#0271021#0271022#" +
            "0271024#0271025#0271026#0271027#0271028#0271029#0271030#0271031#0271032#0271033#0271034#0280001#" +
            "0280004#028001#0280011#0280012#028002#0280033#028004#0280040#0280041#0280042#0280043#0280046#" +
            "0280047#0280048#0280049#028005#0280050#0280051#0280052#0280053#0280054#0280055#0280056#0280057#" +
            "0280058#0280059#028006#0280060#0280061#0280062#0280063#0280064#0280065#0280066#0280067#0280068#" +
            "0280069#028007#0280070#0280071#0280072#0280073#0280074#0280075#0280076#0280078#0280079#0281066#" +
            "029001#029002#029003#029004#029005#029006#029008#029009#029011#029012#029013#029014#0291015#0291016#" +
            "0291032#031201#0351001#0351002#0351003#0351005#0351006#0351009#0351011#03710001#0371002#0371003#" +
            "0371004#0371005#0371007#03710101#0371011#0371012#0371013#0371014#0371015#0371016#0371017#0371018#" +
            "0371019#0371020#0371021#0371022#0371023#0371024#0371025#0371026#0371027#0371028#0371029#0371031#" +
            "0371032#0371033#0371036#0371037#0371041#0371042#0371043#0371044#0371045#0371046#0371047#0371048#" +
            "0371050#0371051#0371052#0371053#0371054#0371055#0371056#0371057#0371058#0371059#0371060#0371061#" +
            "0371062#0371063#0371064#0371065#0371066#0371067#0371068#0371069#04110001#04330001#05000001#05000002#" +
            "05000005#05000006#05000007#05000010#05000011#05000012#05000013#05000020#05000022#05000023#05000027#" +
            "05000028#05000029#05000030#05000031#0500021#0510002#0512001#0512002#0512003#0512004#0512005#0512006#" +
            "0512007#0512008#0512009#0512010#0512011#0512012#0512013#0512014#0512015#0512016#0512017#0512018#" +
            "0512019#0530001#05310010#05310011#0531002#0531003#0531004#0531005#0531006#0531009#0531012#0531015#" +
            "0531016#0531017#0531019#05320001#0532001#0532004#0532005#0532010#0532011#0532012#05510001#05510002#" +
            "05510003#05510005#0551001#0551002#0551003#0551004#0551005#0551006#0551007#0551008#0551009#0551010#" +
            "0551011#0551012#0551013#0551014#0551015#0551016#0551017#0551018#0551019#0551020#0551021#0551022#" +
            "0551023#0551024#0564001#0571001#0571002#0571003#0571004#0571005#0571007#0571008#0571009#0571010#" +
            "0571011#0571013#0571014#0571015#0571016#0571018#0571019#0571020#0571021#0571022#0571023#0571024#" +
            "0571025#0571026#0571027#0574001#05770006#05920012#05920013#05920015#063001#07310006#0731001#0731002#" +
            "0731003#0731004#0731041#0751002#0751004#0751005#0751006#0751007#0751008#0751009#0751010#0751012#" +
            "0751013#0751014#0751015#0751016#0751017#0751018#0751019#0751020#0751021#0751022#0751023#0751024#" +
            "0751025#0751026#0751027#0751028#0751029#0751030#0751031#0751032#0751033#0751034#0751035#0751036#" +
            "0751037#0751038#0751039#0751040#0751041#0751042#0751043#0751044#0751045#0751046#0751047#0751048#" +
            "0751049#0751050#0751051#0751052#0751053#0751054#0751055#0751056#0825001#0898001#0931001#0931002#" +
            "1234567#45010001#4501002#9999#";
    public static class contractStatus{
        public static final String CONTRACT_STATUS_BE_SIGNED_UP = "1";
        public static final String CONTRACT_STATUS_IMMINENT_MOVE_INTO = "2";
        public static final String CONTRACT_STATUS_IN_THE_RENT = "3";
        public static final String CONTRACT_STATUS_SOON_TO_EXPIRE = "4";
        public static final String CONTRACT_STATUS_EXPIRED = "5";
    };

    /**
     *
     * 商户信息审核状态
     *
     */
    public static class businessAuditStatus{
        //待审核
        public static final String UNAUDITED = "0";
        //审核中
        public static final String AUDITING = "1";
        //审核通过
        public static final String AUDIT_PASS = "2";
        //审核失败
        public static final String AUDIT_FAILURE = "3";

    }

    /**
     *
     * 商户类型
     *
     */
    public static class businessType {
        //自然人
        public static final String NATURAL_PERSON = "1";
        //个体工商户
        public static final String INDIVIDUAL_HOUSEHOLD = "2";
        //企业工商户
        public static final String BUSINESS_AND_INDUSTRIAL_HOUSEHOLDS = "3";

    }

}
