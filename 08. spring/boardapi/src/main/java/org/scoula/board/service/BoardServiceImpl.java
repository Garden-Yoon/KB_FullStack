package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.invoke.MutableCallSite;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.scoula.common.util.UploadFiles.upload;

@Log4j
@Service    // Service 역할을 하는 Bean 등록
@RequiredArgsConstructor    // final 필드로 생성자 추가
public class BoardServiceImpl implements BoardService {

    private final static String BASE_DIR = "c:/upload/board";
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

    // 2개 이상의 insert문이 실행될 수 있으므로 트랜잭션  처리 필요
    // RuntimeException인 경우만 자동 rollback
    @Transactional
    @Override
    public BoardDTO create(BoardDTO board) {
        log.info("create................"+ board);

        // DTO를 VO로 변경해서 mapper의 메소드 호출
        BoardVO boardVO = board.toVO();
        mapper.create(boardVO);

        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) {     // 첨부파일이 있는 경우
            upload(boardVO.getNo(), files);
        }
        // 변경된 vo의 no를 가져와서 다시 dto에 반영
//        board.setNo(vo.getNo());
        return get(board.getNo());
    }

    private void upload(Long bno, List<MultipartFile> files) {
        for(MultipartFile part : files) {
            if(part.isEmpty()) continue;
            try {
                String uploadPath = UploadFiles.upload(BASE_DIR, part);
                BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
                mapper.createAttachment(attach);
            } catch (IOException e) {
                throw new RuntimeException(e);  //@Transactional에서 감지, 자동 rollback;
            }
        }
    }


    @Override
    public BoardDTO update(BoardDTO board) {
        log.info("update................"+ board);
//         mapper의 update를 호출해서 수정된 행의 수가 1일 경우 true 반환
//        return mapper.update(board.toVO()) == 1;
        mapper.update(board.toVO());
        return get(board.getNo());
    }

    @Override
    public BoardDTO delete(Long no) {
        log.info("delete..............."+ no);

        // 삭제된 행의 개수가 1인지 확인해서 boolean 반환
//        return mapper.delete(no) == 1;

        BoardDTO board = get(no);
        mapper.delete(no);
        return board;
    }

    // 첨부파일 한 개 얻기
    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        return mapper.getAttachment(no);
    }

    // 첨부파일 삭제
    @Override
    public boolean deleteAttachment(Long no) {
        return mapper.deleteAttachment(no) == 1;
    }
}
