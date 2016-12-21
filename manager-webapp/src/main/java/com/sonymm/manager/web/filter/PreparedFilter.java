package com.sonymm.manager.web.filter;

import com.google.common.base.Strings;
import com.sonymm.manager.web.utils.ServletUtil;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 2:41
 */
@WebFilter(filterName = "preparedFilter", urlPatterns = "/*")
public class PreparedFilter implements Filter {
    @Resource
    private Environment environment;

    private String contextPath;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        contextPath = environment.getProperty("server.contextPath");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        if(!Strings.isNullOrEmpty(contextPath)){
            servletRequest.setAttribute("ctx", contextPath);
        }
        String requestUrl = ServletUtil.getRequestUrl(request);
        if(!ServletUtil.endsWithAny(requestUrl)){
            ServletUtil.setRequest(request);
            ServletUtil.setResponse(response);
            try{
                filterChain.doFilter(servletRequest, servletResponse);
            } finally {
                ServletUtil.clearServletContext();
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
