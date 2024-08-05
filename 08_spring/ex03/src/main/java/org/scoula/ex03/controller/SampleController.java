package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.SampleDTOList;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller // Bean 등록 + Controller 명시
@RequestMapping("/sample")  // 해당 클래스에 있는 메소드는 해당 URL로 매핑하겠다
@Log4j
public class SampleController {
    // 주소 -> localhost:8080/sample
    @RequestMapping("")
    public void basic(){
        log.info("basic............");
    }

    // GET과 POST 두개 다 처리하는 메소드
    // localhost:8080/sample/basic
    @RequestMapping(value="/basic", method={RequestMethod.GET, RequestMethod.POST})
    public void basicGet(){
        log.info("basicGet............");
    }

    // RequestMapping + Get 요청을 합친 어노테이션, GET 요청만 처리 가능
    // localhost:8080/sample/basicOnlyGet
    @GetMapping("/basicOnlyGet")
    public void basicGet2(){
        log.info("basicOnlyGet...........");
    }

    // localhost:8080/sample/ex01
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        // 넣어준 값이 없을 경우 초기값으로 나온다
        log.info("" + dto);
        return "ex01";
    }

    // @RequestParam은 DTO 객체를 안쓰고 각각 파라미터를 받아줄 때 사용
    // 필드 두 개 다 제대로 안넣어주면 예외 발생, 개별 파라미터는 뷰로 전달 불가
    // localhost:8080/sample/ex02
    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name,
            @RequestParam("age") int age){
        log.info("name: " + name);
        log.info("age: " + age);
        return "ex02";
    }

    // 같은 이름으로 여러번 전달하는 경우 List나 배열로 받아올 수 있다
    // localhost:8080/sample/ex02List
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids){
        log.info("ids: " + ids);
        return "ex02List";
    }

    // localhost:8080/sample/ex02Bean
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list){
        log.info("list: " + list);
        return "ex02Bean";
    }

    // localhost:8080/sample/ex03?title=test&dueDate=2023/01/01
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo){
        log.info("todo: " + todo);
        return "ex03";
    }

    // localhost:8080/sample/ex04?name=aaa&age=11&page=9
    @GetMapping("/ex04")
    // page를 기본 자료형으로 넘기면 뷰로 전달되지 않는다.
    // 따라서 @ModelAttribute로 전달해야 한다 (request scope 저장)
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page){
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "sample/ex04";
    }
}
