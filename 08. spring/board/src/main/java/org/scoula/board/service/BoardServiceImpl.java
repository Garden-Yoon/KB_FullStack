package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j
@Service    // Service 역할을 하는 Bean 등록
@RequiredArgsConstructor    // final 필드로 생성자 추가
public class BoardServiceImpl implements BoardService {
    //    생성자가 하나 있다면 그 생성자로 주입 가능
    final private BoardMapper mapper;

    @Override
    public List<BoardDTO> getList() {
        log.info("getList................");
        return mapper.getList().stream()    //BoardVO의 스트림
                .map(BoardDTO::of)  // 전부 BoardDTO로 변환 -> BoardDTO의 스트림
                .toList();  // BoardDTO의 리스트로 변환
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get..........." + no);
        BoardDTO board = BoardDTO.of(mapper.get(no));
        // board 객체가 null이면 NoSuchElementException 예외 발생, null이 아니면 해당 객체 반환
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void create(BoardDTO board) {
        log.info("create................"+ board);

        // DTO를 VO로 변경해서 mapper의 메소드 호출
        BoardVO vo = board.toVO();
        mapper.create(vo);
        // 변경된 vo의 no를 가져와서 다시 dto에 반영
        board.setNo(vo.getNo());


    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update................"+ board);
        // mapper의 update를 호출해서 수정된 행의 수가 1일 경우 true 반환
        return mapper.update(board.toVO()) == 1;
    }

    @Override
    public boolean delete(Long no) {
        log.info("delete..............."+ no);

        // 삭제된 행의 개수가 1인지 확인해서 boolean 반환
        return mapper.delete(no) == 1;
    }
}
