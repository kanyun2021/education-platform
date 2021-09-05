package cn.whu.dhji.utils;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.tuple.Triple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerUtils {
    /**
     * 根据后缀名判断是否是ajax请求
     * @param request : http请求对象
     * @return : 布尔值
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        if (request.getServletPath().endsWith(".do")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  执行参数的空值校验和类型校验
     *
     * @param params    由前端传递到后端的参数
     * @param checkingParams    需要检查的参数，Triple内部的结构为：参数名，参数类型，参数中文名称（用于错误提示的）
     * @return
     *      status: 所有参数校验通过返回status:0，否则返回status:1
     *      msg: 成功不同返回，失败返回具体的错误提示
     */
    public static Map<String, Object> checkParams(Map<String, Object> params,
                                                  List<Triple<String, Class, String>> checkingParams) {

        Map<String, Object> result = new HashMap<String, Object>(){ {
            put("status", 0);
            put("msg", "校验成功");
        }
        };

        for(Triple<String, Class, String> param : checkingParams) {
            Object data = params.get(param.getLeft());
            if(data == null || data.getClass() != param.getMiddle()) {
                result.put("status", 1);
                result.put("msg", "错误：参数'"+param.getRight()+"'不能为空");
                return result;
            }
        }

        return result;
    }

    public static void writeJson(Map<String,Object> map, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.write(JSONObject.toJSONString(map));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
