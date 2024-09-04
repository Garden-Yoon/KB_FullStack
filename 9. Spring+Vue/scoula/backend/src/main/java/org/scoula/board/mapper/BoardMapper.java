package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.common.pagination.PageRequest;

import java.util.List;

public interface BoardMapper {
    // 게시글 전체 개수 반환
    int getTotalCount();
    // 페이지 요청 정보 받아서 해당 페이지에 맞는 데이터만 가져옴
    List<BoardVO> getPage(PageRequest pageRequest);

    // tbl_board 테이블에서 모든 컬럼을 no 컬럼 기준으로 내림차순 정렬
//    @Select("select * from tbl_board order by no desc")
    // BoardVO 객체의 리스트를 반환
    public List<BoardVO> getList();

    // 특정 번호(no)에 해당하는 BoardVO 객체 반환
    public BoardVO get(Long no);

    // 새로운 BoardVO 게시물을 생성
    public void create(BoardVO board);

    // 기존 게시글을 업데이트
    public int update(BoardVO board);

    // 해당 no 값을 가진 게시글을 삭제
    public int delete(Long no);


    public void createAttachment(BoardAttachmentVO attach);
    public List<BoardAttachmentVO> getAttachmentList(Long bno);
    public BoardAttachmentVO getAttachment(Long no);
    public int deleteAttachment(Long no);

}
