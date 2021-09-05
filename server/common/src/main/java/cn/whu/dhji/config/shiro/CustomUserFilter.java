package cn.whu.dhji.config.shiro;

import cn.whu.dhji.utils.ControllerUtils;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CustomUserFilter extends UserFilter {
    /**
     * 放行所有OPTIONS的请求，OPTIONS请求直接允许,让后续程序逻辑加入跨域控制头部信息
     * 如果这里没有放行，会导致OPTIONS请求被拦截，即使返回了正常的200状态
     * 但是返回头中没有跨域相关的请求控制信息，浏览器依然认为后端不支持跨域请求
     *
     * 【教育平台】
     * 这样可以实现跨域请求的顺利进行
     * 但是这样真的安全吗？是否需要考虑用CORS进行更细致的配置？
     * 教育平台需要跨域请求吗？
     *
     */
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            if("OPTIONS".equals(httpServletRequest.getMethod())) return true;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    /**
     * 用户未登录状态下所有的ajax请求返回json格式数据
     * 而非ajax请求的需要授权的页面则转到登录页面
     * @param request :
     * @param response :
     * @return :
     * @throws Exception :
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
        if(request instanceof HttpServletRequest &&
                ControllerUtils.isAjaxRequest((HttpServletRequest)request)) {
            Map<String,Object> map = new HashMap<>();
            map.put("status", "-1");
            map.put("msg", "未登录");
            map.put("测试", "在CustomUserFilter被拦截");
            ControllerUtils.writeJson(map, (HttpServletResponse) response);
        }else {
            saveRequestAndRedirectToLogin(request, response);
        }
        return false;
    }

}
