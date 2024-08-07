package org.scoula.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
class TimeMapperTest {
    @Autowired
    private TimeMapper timeMapper;  //DI

    @Test
    @DisplayName("TimeMapper의 getTime()")
    void getTime() {
        log.info(timeMapper.getClass().getName());  // TimeMapper의 실제 클래스 이름을 가져온다
        log.info(timeMapper.getTime());     // TimeMapper의 getTime() 메소드 호출
    }

    @Test
    @DisplayName("TimeMapper의 getTime2()")
    void getTime2() {
        log.info("getTime2");
        log.info(timeMapper.getTime2());
    }
}