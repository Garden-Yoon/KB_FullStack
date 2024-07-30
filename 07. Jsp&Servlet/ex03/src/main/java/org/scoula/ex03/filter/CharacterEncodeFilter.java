package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter 어노테이션 적용해야 필터로 인식한다
// /* : 모든 URL 패턴에 대해 필터를 적용하겠다
@WebFilter(urlPatterns = {"/*"})
// Filter 인터페이스 구현 필수
public class CharacterEncodeFilter implements Filter {
    // 필터 초기화 메소드, 필터 생성 시 호출됨
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    // 필터 소멸 메소드, 필터가 소멸될 때 호출됨 (자원 해제 작업 수행)
    @Override
    public void destroy() {
    }

    // 실제 로직을 구현하는 메소드, 요청(request)과 응답(response)를 받아올 때, 필터가 수행할 작업
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // request의 문자 인코딩을 UTF-8로 변경
        request.setCharacterEncoding("UTF-8");
        // 다음 필터나 서블릿으로 요청과 응답 전달
        chain.doFilter(request, response);

    }
}
