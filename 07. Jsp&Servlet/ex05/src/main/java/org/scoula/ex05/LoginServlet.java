package org.scoula.ex05;

import org.scoula.ex05.domain.Member;
import org.scoula.ex05.dto.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    // Get 메소드로 보낸 데이터를 받아오기 위해서는 doGet 메소드 사용
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 요청에서 파라미터 얻기
        // getParameter 내에 있는 이름은 input의 name과 같아야 한다
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

        // 결과를 scope에 저장
        // 위에서 만들어진 변수 정보를 request 내에 세팅한다
//        request.setAttribute("userid", userid);
//        request.setAttribute("passwd", passwd);

        // DTO 객체로 scope에 저장 (캡슐화를 하기 위함)
        LoginDTO loginDTO = new LoginDTO(userid, passwd);

        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);

        request.setAttribute("login", loginDTO);

        // 로그인 처리
        HttpSession session = request.getSession();
        Member member = new Member("홍길동", userid);
//        session.setAttribute("member", member);     // session에 정보 저장
        session.setAttribute("user", member);     // session에 user라는 키로 정보 저장,
        // login 상태에 사용할 예정?

        // 결과 출력 포워딩
        // 설정한 request를 login.jsp로 보내서 화면을 띄워준다
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
