package com.example.dividend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice  //우리가 구현해준 컨트롤러와 조금 가까운 위치에 있음. 필터의 경우 더 바깥쪽으로 있
public class CustomExceptionHandler {

    @ExceptionHandler(AbstractException.class)  // 이 메소드에서 에러가 발생한경우, 어떻게 던져줄지 정해준다.
    protected ResponseEntity<ErrorResponse> handleCustomException(AbstractException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                                                    .code(e.getStatusCode())
                                                    .message(e.getMessage())
                                                    .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.resolve(e.getStatusCode()));
    }
}
