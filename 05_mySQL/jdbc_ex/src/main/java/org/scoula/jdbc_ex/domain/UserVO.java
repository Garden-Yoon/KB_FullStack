package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//VO : Value Object (테이블의 한 행을 매핑)
public class UserVO {
    // 테이블 내에서 각각의 컬럼 명과 동일
    private String id;
    private String password;
    private String name;
    private String role;
}
