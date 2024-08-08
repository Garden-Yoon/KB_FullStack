package org.scoula.board.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller     // Controller 기능을 하는 빈 등록
@Log4j
@RequestMapping("/board")   // url 공통 주소 할당
@RequiredArgsConstructor    // 생성자 주입
public class BoardController {
    final private BoardService service;

    // http://localhost:800/board/list
    // return 값이 void이기 때문에 뷰도 경로가 동일 (board/list)
    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        // Model의 속성에 데이터를 담을 경우 뷰로 전달 가능
        model.addAttribute("list", service.getList());
    }

    // Get
    @GetMapping("/create")
    public void create(){
        log.info("create");
    }

    @PostMapping("/create")
    public String create(BoardDTO board) {
        log.info("create" + board);
        // service -> mapper.java -> mapper.xml
        service.create(board);
        // 게시물 목록 페이지로 리다이렉트
        return "redirect:/board/list";
    }
}
