package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Transactional // Test가 성공하더라도 자동으로 롤백된다
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    @DisplayName("BoardMapper의 목록 불러오기")
    void getList() {
//        모든 BoardVO 리스트를 가져와서 각 객체를 출력한다
        for (BoardVO board : mapper.getList()) {
            log.info(board);
        }
    }

    @Test
    @DisplayName("BoardMapper의 게시글 읽기")
    void get() {
        // 존재하는 게시물 번호로 테스트
        // 존재하지 않는 게시물 번호를 넣으면 테스트는 통과하나, 빈 테이블로 나온다
        BoardVO board = mapper.get(2L);
        log.info(board);
    }

    @Test
    @DisplayName("BoardMapper의 새 글 작성")
    public void create(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("user0");

        mapper.create(board);
        log.info(board);
    }

    @Test
    @DisplayName("BoardMapper의 글 수정")
    public void update(){
        BoardVO board = new BoardVO();
        // no에는 존재하는 no값을 적어줘야 제대로 수정이 된다
        board.setNo(5L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user05");

        // count에는 수정된 행의 수를 반환
        int count = mapper.update(board);
        log.info("UPDATE COUNT: " + count);
    }

    @Test
    @DisplayName("BoardMapper의 글 삭제")
    public void delete(){
        // 삭제된 행의 개수
        log.info("DELETE COUNT :" + mapper.delete(6L));
    }
}