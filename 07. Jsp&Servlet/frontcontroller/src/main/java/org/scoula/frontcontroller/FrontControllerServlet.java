package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 경로 지정하는 방법은 2가지가 있다. 1) 디렉토리 기반, 2) 확장명 기반
// 디렉토리 기반(ex: /board), 확장명 기반(*.do)
@WebServlet(name = "frontControllerServlet", value ="/")
public class FrontControllerServlet extends DispatcherServlet {
    
    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    @Override
    protected void createMap(Map<String, Command> map, Map<String, Command> postMap) {
        // "/" 경로로 HomeController의 getIndex 메소드를 찾을 수 있다 (메소드 참조)
        // put으로 Map에 아이템을 넣어준다
        getMap.put("/", homeController::getIndex);

        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getView);

        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }
}