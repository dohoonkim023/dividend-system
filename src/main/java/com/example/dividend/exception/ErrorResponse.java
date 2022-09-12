package com.example.dividend.exception;

import lombok.Builder;
import lombok.Data;

//에러가 발생 한경우 던져줄 모델 클래스
@Data
@Builder
public class ErrorResponse {
    private int code;
    private String message;
}
