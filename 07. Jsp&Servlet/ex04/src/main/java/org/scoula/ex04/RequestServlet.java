package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 속성 설정
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress", "서울");

        // forward
        // response.jsp로 요청을 전달할 RequestDispatcher를 가져온다
        RequestDispatcher dis = request.getRequestDispatcher("/response.jsp");
        // request와 response를 포워딩시킨다
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}