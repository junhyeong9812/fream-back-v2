package com.fream.back.global.response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ErrorCodeTest {

    @Test
    @DisplayName("ErrorCode enum이 존재한다.")
    void errorCodeEnumExists(){
        //when & then
        Class<ErrorCode> clazz = ErrorCode.class;
        assertThat(clazz).isNotNull();
        assertThat(clazz.isEnum()).isTrue();
    }

    @Test
    @DisplayName("INVALID_INPUT 에러코드가 존재한다.")
    void invalidInputErrorCodeExists(){
        //when
        ErrorCode errorCode = ErrorCode.INVALID_INPUT;

        //then
        assertThat(errorCode).isNotNull();
        assertThat(errorCode.name()).isEqualTo("INVALID_INPUT");
    }

    @Test
    @DisplayName("INVALID_INPUT은 code를 가진다.")
    void invalidInputHasCode(){
        //given
        ErrorCode errorCode = ErrorCode.INVALID_INPUT;

        //when
        String code = errorCode.getCode();

        assertThat(code).isEqualTo("C001");
    }
    
    @Test
    @DisplayName("INVALID_INPUT은 message를 가진다.")
    void invalidInputHasMessage(){
        //given
        ErrorCode errorCode = ErrorCode.INVALID_INPUT;

        //when
        String message = errorCode.getMessage();

        //then
        assertThat(message).isEqualTo("입력값이 올바르지 않습니다.");

    }

}