package org.scoula.ex05.dto;

// JAVA Bean, name Property와 password Property 존재
public class LoginDTO {
    private String name;    // attribute : 기본적으로 바깥에서 접근하기 힘듬
    private String password;

    // default 생성자
    public LoginDTO() {
    }

    // 전체 생성자
    // LoginDTO 쓰려면 LoginServlet에서 전체생성자를 통해 생성해준다
    public LoginDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getter & Setter
    // getName을 주석처리하면 EL에서 [name]특성을 읽을 수 없음
    public String getName() {   // property : getter/setter를 통해 바깥에서 접근 가능
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
