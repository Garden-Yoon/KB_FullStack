package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view_cookie")
public class CartViewCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // MIME 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();

        // HTML 작성 및 출력
        out.print("<html><body>");
        out.print("장바구니 리스트<br>");


        // 기존 쿠키 가져오기
        Cookie[] cookies= request.getCookies();

        if(cookies != null ){
            for (Cookie c : cookies){
                // 각 쿠키의 이름과 값을 출력
                out.print(c.getName() + ": " + c.getValue() + "<br>");
            }
        } else {
            out.print("장바구니 비었음<br>");
        }

        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_delete_cookie'>장바구니 비우기</a><br>");
        out.print("</body></html>");

    }
}