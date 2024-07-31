package org.scoula.ex05;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // session scope에 user로 해당 member 객체 정보 저장
        HttpSession session = request.getSession();
        session.invalidate();

        // 사용자를 로그인 화면으로 리다이렉트합니다.
        response.sendRedirect("login_form.jsp");

    }
}