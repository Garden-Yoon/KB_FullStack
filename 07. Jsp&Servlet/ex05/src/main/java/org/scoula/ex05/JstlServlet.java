package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/jstl_ex")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Member> members = new ArrayList<>();
        for(int i=0; i<10; i++){
            // 10명의 Member 객체를 만들고 리스트에 저장
            Member member = new Member("홍길동_"+i, "hong_"+i);
            members.add(member);
        }
        // 10명의 리스트 정보를 request scope에 속성 설정
        request.setAttribute("members", members);
        request.setAttribute("role", "ADMIN");

        // 로그인 창에서 넘겨받은 id값 저장
        String userid = request.getParameter("userid");

        // 넘겨받은 값을 이용해 새로운 member 객체 생성
        Member user = new Member("윤정원", "id");

        // session scope에 user로 해당 member 객체 정보 저장
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        request.setAttribute("today", new Date());

        request.getRequestDispatcher("jstl_ex.jsp")
                .forward(request, response);
    }
}