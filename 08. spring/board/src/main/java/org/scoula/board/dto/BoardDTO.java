package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardVO;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    // VO -> DTO 변환
    public static BoardDTO of(BoardVO vo) {
//        VO가 null이면 null 반환, null이 아니면 BoardDTO로 변환
        return vo == null? null : BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .content(vo.getContent())
                .writer(vo.getWriter())
                .regDate(vo.getRegDate())
                .updateDate(vo.getUpdateDate())
                .build();
    }

    // DTO -> VO 변환
    public BoardVO toVO() {
        return BoardVO.builder()
                .no(getNo())
                .title(getTitle())
                .content(getContent())
                .writer(getWriter())
                .regDate(getRegDate())
                .updateDate(getUpdateDate())
                .build();
    }



}
