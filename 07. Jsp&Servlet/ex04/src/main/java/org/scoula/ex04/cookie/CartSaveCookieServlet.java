package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_save_cookie")
public class CartSaveCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // MIME 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();

        // 입력 파라미터 얻기
        String product = request.getParameter("product");

        // request에서 모든 쿠키를 가져온다
        Cookie[] cookies= request.getCookies();
        // 비어있는 쿠키 생성
        Cookie c = null;

        if(cookies == null || cookies.length == 0){
            // 저장된 쿠키가 없으면 새 쿠키 생성
            c = new Cookie("product", product);
        } else {
//            쿠키가 있으면 쿠키의 길이로 인덱스를 넣어준다
//            Cookie의 개수가 4개일때는 ("proudct.5", product) 로 들어간다
            c = new Cookie("product" + (cookies.length+1), product);
        }

        // 쿠키의 유효기간 설정ㄹ해주는 메소드, 해당 메소드 추가하면 OS 파일에 쿠키가 저장된다
        // 해당 메소드가 없으면 기본적으로 메모리에 저장되어 브라우저 종료 시 쿠키가 사라진다
//        c.setMaxAge(60*60); // OS 파일 
        // 쿠키 응답 처리 : response에 쿠키를 추가
        response.addCookie(c); // 브라우저 메모리

        // HTML 작성 및 출력
        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_view_cookie'>장바구니 보기</a>");
        out.print("</body></html>");

    }

}