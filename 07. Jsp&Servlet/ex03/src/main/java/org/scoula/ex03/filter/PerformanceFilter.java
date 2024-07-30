package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// 모든 요청에 대해 다 동작하도록 함 (루트('/')아래의 모든 파일)
@WebFilter(urlPatterns = {"/*"})
public class PerformanceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();

        // 캐스팅 필요 :
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(
                request.getMethod() +": " +
                request.getRequestURI() + "실행시간: " + (end - start));

    }
}
