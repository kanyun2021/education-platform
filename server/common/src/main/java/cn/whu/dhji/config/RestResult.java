package cn.whu.dhji.config;

import cn.whu.dhji.enums.ResultCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.Builder;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult {
    private String code;
    private String msg;
    private Object data;

    private static final RestResult SUCCESS = new RestResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());

    public RestResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Builder(builderMethodName = "error")
    public static RestResult error(ResultCode code) {
        RestResult restResult = new RestResult();

        restResult.setCode(code.getCode());
        restResult.setMsg(code.getMsg());
        return restResult;
    }

    @Builder(builderMethodName = "success")
    public static RestResult success() {
        return SUCCESS;
    }

    @Builder(builderMethodName = "successData")
    public static RestResult successData(Object data) {
        RestResult restResult = new RestResult();

        restResult.setCode(ResultCode.SUCCESS.getCode());
        restResult.setMsg(ResultCode.SUCCESS.getMsg());
        restResult.setData(data);
        return restResult;
    }
}
