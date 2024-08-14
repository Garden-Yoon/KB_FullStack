package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

// VO는 테이블 컬럼과 동일하게 필드를 생성한다
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private Long no;
    private String title;
    private String content;
    private String writer;

    // 게시글 하나에 여러 개의 첨부파일이 추가될 수 있다
    private List<BoardAttachmentVO> attaches;

    private Date regDate;
    private Date updateDate;
}
