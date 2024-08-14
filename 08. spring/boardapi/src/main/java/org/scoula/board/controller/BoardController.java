package org.scoula.board.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")   // url 공통 주소 할당
@RequiredArgsConstructor    // 생성자 주입
@Slf4j
public class BoardController {
    private final BoardService service;

    // GET :: http://localhost:8080/api/board
    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    // GET :: http://localhost:8080/api/board/1
    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(@PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

    // POST :: http://localhost:8080/api/board
    @PostMapping("")
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.create(board));
    }
}