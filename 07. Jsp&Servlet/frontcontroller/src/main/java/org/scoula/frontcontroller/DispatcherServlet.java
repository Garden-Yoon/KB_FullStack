package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 경로 지정하는 방법은 2가지가 있다. 1) 디렉토리 기반, 2) 확장명 기반
// 디렉토리 기반(ex: /board), 확장명 기반(*.do)
@WebServlet(name = "frontControllerServlet", value ="/")
public class DispatcherServlet extends HttpServlet {

    // 요청별로 Map을 가진다
    Map<String, Command> getMap;    // GET 요청이 들어왔을 경우 사용할 맵
    Map<String, Command> postMap;   // POST 요청이 들어왔을 경우 사용할 맵

    // 뷰의 기본 경로와 확장자를 설정해준다
    String prefix ="/WEB-INF/views/";
    String suffix=".jsp";


    @Override
    public void init() throws ServletException {
        // Map은 인터페이스이므로 구현 클래스인 HashMap으로 객체 생성
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        createMap(getMap, postMap);
    }

    protected void createMap(Map<String, Command> map, Map<String, Command> postMap) {}


    //GET 요청을 처리해주는 메소드
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Command command = getCommand(request);
        if(command != null) {
            execute(command, request, response);
        } else { // 404 에러 처리
            String view = prefix + "404" + suffix;
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // 요청 URL에서 식별값만 잘라서 return해주는 메소드
    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI();    // "/context값/식별값"
        String contextPath = request.getContextPath();  // "/context값"
        // substring(시작인덱스) : 시작인덱스부터 문자열을 잘라준다
        return requestURI.substring(contextPath.length());  // substring을 통해 "/식별값"을 얻어온다
    }

    // 요청 URL에서 식별값에 해당하는 Command를 리턴해주는 메소드
    private Command getCommand(HttpServletRequest request) {
        // request에서 command 이름만 추출
        String commandName = getCommandName(request);
        Command command;
        // equalsIgnoreCase : 대소문자 구분없이 같은지 비교
        // request에서 받아온 메소드가 GET이면 getNap에서 커맨드를 찾고
        if(request.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            // request에서 받아온 메소드가 POST이면 postMap에서 커맨드를 찾는다
            command = postMap.get(commandName);
        }
        return command;
    }


    public void execute(Command command, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // command의 execute 호출
        // command의 실행 결과는 jsp의 이름으로 받아온다
        String viewName = command.execute(request, response);
        if(viewName.startsWith("redirect:")) { //redirect 처리
            // redirect로 처리할 경우, view의 경로에서 "redirect:"를 제외하고 띄운다
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { //forward 처리
            // 가지고 온 뷰의 이름에 "/views"를 앞에, ".jsp"를 뒤에 붙여준다
            String view = prefix + viewName + suffix;
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }
}