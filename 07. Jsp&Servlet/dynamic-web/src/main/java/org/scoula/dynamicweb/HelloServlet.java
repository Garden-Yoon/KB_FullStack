package org.scoula.dynamicweb;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// name은 서블릿 이름, value는 서블릿의 경로
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Servelt22!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // charset 설정 추가해야 한글 안깨짐
        response.setContentType("text/html; charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        // servlet에서 html 코드를 쓰기 위해서는 out.println()을 사용해야 한다
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        // 중간에 " 작성할 경우 \(역슬래쉬) 필수
        out.println("<a href='/'>Home 홈으로</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}