package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@EnableWebMvc : MVC 패턴 (frontcontroller 패턴)사용하겠다
@EnableWebMvc
// controller  패키지 내부에서 컴포넌트를 찾아라
@ComponentScan(basePackages = {
        "org.scoula.controller",
        "org.scoula.controller",
        "org.scoula.board.controller"
})
public class ServletConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//         루트 경로로 요청이 들어오면 "forward:/resources/index.html" 경로로 포워드
        registry.addViewController("/")
                .setViewName("forward:/resources/index.html");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")    // url이 "/resources/"로 시작하는 경로
                .addResourceLocations("/resources/");   // webapp.resources/ 경로
//        "/assets/**" 패턴으로 들어오는 요청을 "/resources/assets/" 위치의 파일로 매핑
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("/resources/assets/");
    }


//    // View의 이름을 설정해주는 메소드
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/views/");
//        bean.setSuffix(".jsp");
//        registry.viewResolver(bean);
//    }

    // Servlet 3.0 파일 업로드 사용 시
    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver resolver
                = new StandardServletMultipartResolver();
        return resolver;
    }
}
