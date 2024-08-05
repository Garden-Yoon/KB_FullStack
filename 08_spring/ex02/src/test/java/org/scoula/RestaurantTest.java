package org.scoula;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

//@WebAppConfiguration // 웹 어플리케이션 컨텍스트 설정 (안될 경우 추가)
@ExtendWith(SpringExtension.class)  // Spring 테스트를 위한 확장 기능 사용
// 설정파일 위치, Spring Context를 가져올 설정 클래스 지정
@ContextConfiguration(classes = {RootConfig.class}) 
@Log4j
class RestaurantTest {
    @Autowired
    private Restaurant restaurant;

    @Test
    void getChef() {
        // restaurant 객체가 null이 아님을 확인하는 메소드
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("---------------------------");
        log.info(restaurant.getChef());
    }
}