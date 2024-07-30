package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 해당 요청은 내부에서 쓰이지 않으므로 무의히하다
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress", "서울");

        // response_redirct url로 redirect시킴
        response.sendRedirect("response_redirect");
    }
}