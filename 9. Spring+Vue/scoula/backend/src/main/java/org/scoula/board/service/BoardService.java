package org.scoula.board.service;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.common.pagination.Page;
import org.scoula.common.pagination.PageRequest;

import java.util.List;


public interface BoardService {
    Page<BoardDTO> getPage(PageRequest pageRequest);

    public List<BoardDTO> getList();

    public BoardDTO get(Long no);

    //    public void create(BoardDTO board);
    public BoardDTO create(BoardDTO board);

//    public boolean update(BoardDTO board);
    public BoardDTO update(BoardDTO board);

//    public boolean delete(Long no);
    public BoardDTO delete(Long no);



    public BoardAttachmentVO getAttachment(Long no);

    public boolean deleteAttachment(Long no);
}
