package org.scoula.board.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.UploadFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
    public ResponseEntity<BoardDTO> create( BoardDTO board) {
        return ResponseEntity.ok(service.create(board));
    }

    // PUT :: http://localhost:8080/api/board/7
    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable("no") Long no,  BoardDTO board) {
        return ResponseEntity.ok(service.update(board));
    }

    // DELTETE :: http://localhost:8080/api/board/7
    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
        return ResponseEntity.ok(service.delete(no));
    }

    @GetMapping("/download/{no}")
    public void download(@PathVariable Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attachment = service.getAttachment(no);
        File file = new File(attachment.getPath());
        UploadFiles.download(response, file, attachment.getFilename());
    }
    @DeleteMapping("/deleteAttachment/{no}")
    public ResponseEntity<Boolean> deleteAttachment(@PathVariable Long no) throws Exception {
        return ResponseEntity.ok(service.deleteAttachment(no));
    }
}