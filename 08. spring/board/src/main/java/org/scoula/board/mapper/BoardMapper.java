package org.scoula.board.mapper;

import org.apache.ibatis.annotations.Select;
import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    @Select("select * from tbl_board order by no desc")
    public List<BoardVO> getList();
}
