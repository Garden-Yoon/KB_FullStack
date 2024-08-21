package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@EnableWebMvc : MVC 패턴 (frontcontroller 패턴)사용하겠다
@EnableWebMvc
// controller  패키지 내부에서 컴포넌트를 찾아라
@ComponentScan(basePackages = {
        "org.scoula.exception",
        "org.scoula.board.controller",
        "org.scoula.controller",
        "org.scoula.weather.controller"})
public class ServletConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")    // url이 /resources/로 시작하는 경로
                .addResourceLocations("/resources/");   // webapp/resouces/ 경로
    }

    // View의 이름을 설정해주는 메소드
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    // Servlet 3.0 파일 업로드 사용 시
    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver resolver
                = new StandardServletMultipartResolver();
        return resolver;
    }
}
