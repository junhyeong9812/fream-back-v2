package com.fream.back.global.response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * ApiResponse 테스트 명세
 *
 * 테스트 케이스:
 * 1. success_메서드는_SUCCESS_상태와_데이터_포함
 * 2. success_메서드_데이터없이_호출시_data는_null
 * 3. error_메서드는_ERROR_상태와_에러메시지_포함
 * 4. fail_메서드는_FAIL_상태와_메시지_포함
 * 5. timestamp는_생성시점_자동_설정
 * 6. 불변객체_테스트_필드_변경_불가
 */


class ApiResponseTest {
    // TODO: 테스트 구현
    @Test
    @DisplayName("ApiResponse 클래스가 존재한다.")
    void apiResponseClassExists(){
        //given & when
        ApiResponse response = new ApiResponse();

        //then
        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("ApiResponse는 제네릭 타입을 지원한다.")
    void supportsGenericType(){
        //given & when
        ApiResponse<String> stringApiResponse = new ApiResponse<>();
        ApiResponse<Integer> integerApiResponse = new ApiResponse<>();

        //then
        assertThat(stringApiResponse).isNotNull();
        assertThat(integerApiResponse).isNotNull();
    }

    @Test
    @DisplayName("status 필드를 가진다.")
    void hasStatusField(){
        //given
        ApiResponse<String> response = new ApiResponse<>();

        //when
        String status = response.getStatus();

        //then
        assertThat(status).isNull();
    }

    @Test
    @DisplayName("status를 설정할 수 있다.")
    void canSetStatus(){
        //given
        ApiResponse<String> response = new ApiResponse<>();
        String expectedStatus="SUCCESS";

        //when
        response.setStatus(expectedStatus);

        //then
        assertThat(response.getStatus()).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("data 필드를 가진다.")
    void hasDataField(){
        //given
        ApiResponse<String> response = new ApiResponse<>();

        //when
        String data = response.getData();

        //then
        assertThat(data).isNull();
    }

    @Test
    @DisplayName("data를 설정할 수 있다.")
    void canSetData(){
        //given
        ApiResponse<String> response = new ApiResponse<>();
        String testData = "test data";

        //when
        response.setData(testData);

        //then
        assertThat(response.getData()).isEqualTo(testData);
    }

    @Test
    @DisplayName("message 필드를 가진다.")
    void hasMessageField(){
        //given
        ApiResponse<String> response = new ApiResponse<>();

        //when
        String message = response.getMessage();

        //then
        assertThat(message).isNull();
    }

    @Test
    @DisplayName("message를 설정할 수 있다.")
    void canSetMessage(){
        //given
        ApiResponse<String> response = new ApiResponse<>();
        String testMessage = "Error occurred";

        //when
        response.setMessage(testMessage);

        //then
        assertThat(response.getMessage()).isEqualTo(testMessage);
    }


}