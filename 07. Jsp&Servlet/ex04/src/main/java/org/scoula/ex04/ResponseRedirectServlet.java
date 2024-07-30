package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response_redirect")
public class ResponseRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 요청이 달라졌기 때문에 해당 값들은 null이 나온다. 이전 서블릿의 속성은 세션으로 저장해줘야 한다
        String username = (String) request.getAttribute("username");
        String useraddress = (String) request.getAttribute("useraddress");

        // 속성 설정
        request.setAttribute("username", username);
        request.setAttribute("useraddress", useraddress);

        // forword
        RequestDispatcher rd = request.getRequestDispatcher("/redirect_response.jsp");
        rd.forward(request, response);
    }
}