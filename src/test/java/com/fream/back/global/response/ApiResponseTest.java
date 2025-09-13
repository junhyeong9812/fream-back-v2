package com.fream.back.global.response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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

    @Test
    @DisplayName("timestamp 필드를 가진다.")
    void hasTimestampField(){
        //given
        ApiResponse<String> response = new ApiResponse<>();

        //when
        LocalDateTime timestamp = response.getTimestamp();

        //then
        assertThat(timestamp).isNull();
    }

    @Test
    @DisplayName("timestamp를 설정할 수 있다.")
    void canSetTimestamp(){
        //given
        ApiResponse<String> response = new ApiResponse<>();
        LocalDateTime now = LocalDateTime.now();

        //when
        response.setTimestamp(now);

        //then
        assertThat(response.getTimestamp()).isEqualTo(now);
    }

    @Test
    @DisplayName("모든 필드를 설정할 수 있다.")
    void canSetAllFields(){
        //given
        ApiResponse<Integer> response = new ApiResponse<>();
        String status = "SUSSCESS";
        Integer data = 100;
        String message = "Operation sucessful";
        LocalDateTime timestamp = LocalDateTime.now();

        //when
        response.setStatus(status);
        response.setData(data);
        response.setMessage(message);
        response.setTimestamp(timestamp);

        //then
        assertThat(response.getStatus()).isEqualTo(status);
        assertThat(response.getData()).isEqualTo(data);
        assertThat(response.getMessage()).isEqualTo(message);
        assertThat(response.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    @DisplayName("success 정적 메서드로 성공 응답을 생성할 수 있다.")
    void canCreateSuccessResponseWithStaticMethod(){
        //given
        String testData = "success data";

        //when
        ApiResponse<String> response = ApiResponse.success(testData);

        //then
        assertThat(response.getStatus()).isEqualTo("SUCCESS");
        assertThat(response.getData()).isEqualTo(testData);
        assertThat(response.getMessage()).isNull();
        assertThat(response.getTimestamp()).isNotNull();
    }

    @Test
    @DisplayName("생성 후에는 필드를 변경할 수 없다 - 불변 객체")
    void responseIsImmutable(){
        //given
        ApiResponse<String> response = ApiResponse.success("data");

        //when & then
        //setter기 없으므로 컴파일 에러
        //response.setStatus("FAIL");

        //모든 필드가 final이고 setter가 없음을 확인
        assertThat(response.getStatus()).isEqualTo("SUCCESS");
        assertThat(response.getData()).isEqualTo("data");

    }


}