package org.scoula.frontcontroller.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController {
    public String getIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "index";     // index.jsp 이름을 반환
    }
}