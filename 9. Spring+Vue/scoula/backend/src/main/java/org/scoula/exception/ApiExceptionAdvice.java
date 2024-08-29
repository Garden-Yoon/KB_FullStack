package org.scoula.exception;

import org.scoula.member.exception.PasswordMissmatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionAdvice {
    // 패스워드 불일치 예외 발생 시 400으로 처리
    @ExceptionHandler(PasswordMissmatchException.class)
    protected ResponseEntity<?> handlePasswordError(Exception e) {
        return ResponseEntity
                .status(400)
                .header(HttpHeaders.CONTENT_TYPE, "text/plain;charset=UTF-8")
                . body(e.getMessage());
    }



    // 404 에러
//    @ExceptionHandler(NoSuchElementException.class)
//    protected ResponseEntity<String> handleIllegalArgumentException(NoSuchElementException e) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .header("Content-Type", "text/plain;charset=UTF-8")
//                .body("해당 ID의 요소가 없습니다.");
//    }

    // 500 에러
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(e.getMessage());
    }
}
