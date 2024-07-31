package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

    // 설정에 있는 application scope를 sc에 할당해서 초기화
    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // application scope에 속성 설정
        sc.setAttribute("scopeName", "applicationScope 값");     // Application Scope

        // 현재 세션을 가져오거나, 미존재 시 새로 생성
        HttpSession session = req.getSession();
        // session scope에 속성 설정
        session.setAttribute("scopeName", "sessionScope 값");    // Session Scope
        
        // request는 객체를 생성하지 않아도 바로 사용 가능하다
        req.setAttribute("scopeName", "requestScope 값");    // Request Scope
        // 아래 2줄 주석처리하고 LoginServlet으로 옮기면 로그인 처리기능 만들 수 있음
//        Member member = new Member("홍길동", "hong");
//        req.setAttribute("member", member);   // request scope

        // scope.jsp로 화면 포워딩
        req.getRequestDispatcher("scope.jsp").forward(req, resp);
    }
}