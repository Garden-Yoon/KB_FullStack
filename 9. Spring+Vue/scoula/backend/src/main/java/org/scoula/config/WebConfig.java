package org.scoula.config;

import org.scoula.security.config.SecurityConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    final String LOCATION ="c:/upload";
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L;
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L;
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5;


    
    // RootConfig 클래스를 뭐로 할 것인지 반환
    @Override
    public Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class, SecurityConfig.class};
    }



    // ServletConfig 클래스를 뭐로 할 것인지 반환
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class};
    }

    // DispatcherServlet이 매핑할 URL 패턴
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};  // 모든 url 매핑
    }

    // UTF-8 인코딩을 강제로 사용하도록 하는 필터 반환
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
        }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        // 파일 업로드 설정
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                LOCATION,   /// 업로드 처리 디렉토리 경로
                MAX_FILE_SIZE,  // 업로드 가능한 파일 하나의 최대 크기
                MAX_REQUEST_SIZE,   // 업로드 가능한 전체 최대 크기 여러 파일 업로드하는 경우
                FILE_SIZE_THRESHOLD);   // 메모리 파일의 최대 크기 (이보다 작으면 실제 메모리에서만 작업
        registration.setMultipartConfig(multipartConfig);
    }

}
