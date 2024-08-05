package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration : 설정
@Configuration
// @ComponentScan : 해당 패키지에서 @Component를 찾아서 등록해주겠다
@ComponentScan(basePackages = {"org.scoula"})
//org.scoula.controlle로 경로를 주면 Restaurant와 경로가 맞지 않아서 null이 된다
//@ComponentScan(basePackages = {"org.scoula.controller"})
public class RootConfig {
}
