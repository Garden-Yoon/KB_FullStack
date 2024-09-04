package org.scoula.common.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageRequest {
    private int page; // 요청 페이지
    private int amount; // 한 페이지 당 데이터 건수
    public PageRequest() {
        page = 1; // 쪽수
        amount = 10; // 한 페이지에 들어갈 게시글 개수
    }

    public static PageRequest of(int page, int amount) {
        return new PageRequest(page, amount);
    }

    // 해당 페이지에서 데이터를 가져올 때, 데이터의 시작 위치 계산
    public int getOffset() { // offset 값 계산
        return (page - 1) * amount;
    }
}