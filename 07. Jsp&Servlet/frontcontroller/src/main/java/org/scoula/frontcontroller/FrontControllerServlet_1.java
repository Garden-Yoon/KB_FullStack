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
public class FrontControllerServlet_1 extends DispatcherServlet {

    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    @Override
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
        getMap.put("/", homeController::getIndex);

        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getView);

        getMap.put("/todo/create", todoController::postCreate);
        getMap.put("/todo/update", todoController::postUpdate);
        getMap.put("/todo/delete", todoController::postDelete);
    }


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


    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI();    // "/context값/식별값"
        String contextPath = request.getContextPath();  // "/context값"
        // substring(시작인덱스) : 시작인덱스부터 문자열을 잘라준다
        return requestURI.substring(contextPath.length());  // substring을 통해 "/식별값"을 얻어온다
    }

    private Command getCommand(HttpServletRequest request) {
        String commandName = getCommandName(request);

        Command command;
        if(request.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }
        return command;
    }

    public void execute(Command command, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // command의 execute 호출
        String viewName = command.execute(request, response);
        if(viewName.startsWith("redirect:")) { //redirect 처리
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { //forward 처리
            String view = prefix + viewName + suffix;
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
    }
}
}