package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    // 게시글 하나에 여러 개의 첨부 파일이 추가될 수 있다
    private List<BoardAttachmentVO> attaches;

    // VO랑 다르게 클래스 사용 가능
    List<MultipartFile> files = new ArrayList<>();  // 실제 업로드된 파일(Multipart) 목록


    // VO -> DTO 변환
    public static BoardDTO of(BoardVO vo) {
//        VO가 null이면 null 반환, null이 아니면 BoardDTO로 변환
        return vo == null? null : BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .content(vo.getContent())
                .writer(vo.getWriter())
                .attaches(vo.getAttaches())
                .regDate(vo.getRegDate())
                .updateDate(vo.getUpdateDate())
                .build();
    }

    // DTO -> VO 변환
    public BoardVO toVO() {
        return BoardVO.builder()
                .no(no)
                .title(title)
                .content(content)
                .writer(writer)
                .attaches(attaches)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }



}
