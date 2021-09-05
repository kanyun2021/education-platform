package cn.whu.dhji.enums;

import lombok.Getter;



@Getter
public enum ResultCode {
    //E0xxxxx系统相关
    SUCCESS("E000000", "成功"),
    OPERATE_FAIL("E000001", "操作失败"),
    FORMAT_ERROR("E000002", "输入格式非法"),
    DATA_ERROR("E000003", "输入数值不合理"),
    SYSTEM_ERROR("E000004", "系统错误"),
    WRONG_PARAM("E000005", "参数错误或为空"),
    CONNECT_ERROR("E000006", "与第三方服务器通信异常"),
    AUTH_FAILED("E000007", "认证失败"),
    AUTH_NOT_ENOUGH("E00008", "权限不足"),
    NOT_EXIST("E000009", "不存在"),
    HAS_EXIST("E000010", "已存在"),
    OWN_RESOURCE("E000011", "拥有资源，无法删除"),
    NAME_DUMPLICATED("E000012", "命名重复"),

    //用户相关
    USER_NOT_EXIST("E010101", "用户不存在或已被禁止"),
    USER_HAS_EXIST("E010102", "用户已存在"),
    NAME_DUPLICATION("E010103", "名字重复"),
    USER_NOT_LOGIN("E010104", "用户未登录"),
    REPEATED_LOGIN("E010105", "重复登录"),
    USER_PASSWORD_ERROR("E010106", "用户密码错误"),
    LOGOUT_FAIL("E010107", "退出失败"),
    SESSION_INVALID("E010108", "登录失效"),
    USER_DEPARTMENT_NOT_EXIST("E010109", "用户部门不能为空"),

    ORGANIZATION_NOT_EXIST("E010201", "组织不存在"),
    ORGANIZATION_HAS_EXIST("E010202", "组织已存在"),
    ORGANIZATION_CAN_NOT_DELETE("E010203", "组织无法删除,存在关联用户"),


    ROLE_NOT_EXIST("E010301", "角色不存在"),
    ROLE_CAN_NOT_DELETE("E010302", "该角色无法删除,存在关联用户"),

    USER_SMS_CODE_NOT_EXIST("E010401", "用户注册验证码不能为空"),
    USER_PHONE_NOT_EXIST("E010402", "注册手机号码不能为空"),
    USER_SMS_CODE_INVALID("E010403", "用户注册验证码失效"),
    USER_SMS_CODE_WRONG("E010404", "验证码不匹配"),

    // permission相关
    PERMISSION_NOT_EXIST("E090101", "权限不存在"),


    //Exam
    EXAM_ADD_FAIL("E020101", "增加EXAM失败"),
    EXAM_DELETE_FAIL("E020102", "删除EXAM失败"),
    EXAM_UPDATE_FAIL("E020103", "更新EXAM失败"),

    //Example
    EXAMPLE_ADD_FAIL("E030101", "增加EXAMPLE失败"),

    //Nav
    NAV_TYPE_NOT_MATCH("E040101", "URL类型必须要有url字段"),

    //File
    FILE_EMPTY("E050101", "上传文件为空"),
    FILE_TYPE_ERROR("E050102", "上传文件为空"),
    FILE_NOT_EXIST("E050103", "文件不存在"),


    //SMS
    SMS_TIME_INTERVAL_ILLEGAL("E060101", "发送短信请求时间间隔非法"),

    USER_NOT_MOBILE("E070101", "禁止登录后台管理用户"),

    ARCHIVE_CAN_NOT_DELETE("E080101", "无法删除栏目")

    ;


    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
