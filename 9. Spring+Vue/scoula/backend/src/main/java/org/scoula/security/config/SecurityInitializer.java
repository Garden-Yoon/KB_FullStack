package org.scoula.security.config;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
//    // 문자셋 필터
//    private CharacterEncodingFilter encodingFilter(){
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        return filter;
//    }
//
//    @Override
//    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
//        // 인코딩 필터와 멀티파트 필터를 필터 체인에 추가
//        insertFilters(servletContext, encodingFilter(), new MultipartFilter());
//    }
}