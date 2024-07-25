package org.scoula.ex02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// name은 서블릿 이름, value는 서블릿의 경로
// @WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name = "MyServlet", urlPatterns = {"/xxx", "/yyy"})
public class HelloServlet extends HttpServlet {
    private String message;



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // charset 설정 추가해야 한글 안깨짐
        response.setContentType("text/html; charset=UTF-8");

        // Hello
        System.out.println("HelloServlet 요청");
        PrintWriter out = response.getWriter();
        out.println("<h1>hello Servlet</h1>");

    }

    // 서블릿 초기화하는 메소드
    @Override
    public void init() throws ServletException {
        System.out.println("init 호출");
    }

    // 서블릿 종료하는 메소드
    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }

}