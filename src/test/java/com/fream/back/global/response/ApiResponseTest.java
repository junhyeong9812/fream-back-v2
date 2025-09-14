package com.fream.back.global.response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
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
    @DisplayName("success 정적 메서드가 존재한다")
    void successMethodExists() {
        // when & then
        ApiResponse response = ApiResponse.success("data");
        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("success 메서드는 제네릭을 지원한다")
    void successSupportsGeneric() {
        // when
        ApiResponse<String> response = ApiResponse.success("data");

        // then
        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("success 메서드는 SUCCESS 상태를 설정한다")
    void successSetsStatusToSuccess() {
        // when
        ApiResponse<String> response = ApiResponse.success("data");

        // then
        assertThat(response.getStatus()).isEqualTo("SUCCESS");
    }

    @Test
    @DisplayName("success 메서드는 데이터를 저장한다")
    void successStoresData() {
        // given
        String testData = "test";

        // when
        ApiResponse<String> response = ApiResponse.success(testData);

        // then
        assertThat(response.getData()).isEqualTo(testData);
    }

    @Test
    @DisplayName("success 메서드는 message를 null로 설정한다")
    void successSetsMessageToNull() {
        // when
        ApiResponse<String> response = ApiResponse.success("data");

        // then
        assertThat(response.getMessage()).isNull();
    }

    @Test
    @DisplayName("생성시 timestamp가 자동 설정된다")
    void timestampIsSetAutomatically() {
        // given
        LocalDateTime before = LocalDateTime.now();

        // when
        ApiResponse<String> response = ApiResponse.success("data");

        // then
        assertThat(response.getTimestamp()).isNotNull();
        assertThat(response.getTimestamp()).isAfterOrEqualTo(before);
    }

    @Test
    @DisplayName("error 정적 메서드로 에러 응답을 생성한다")
    void errorMethodCreatesErrorResponse() {
        // given
        String errorMsg = "Error";

        // when
        ApiResponse<?> response = ApiResponse.error(errorMsg);

        // then
        assertThat(response.getStatus()).isEqualTo("ERROR");
        assertThat(response.getMessage()).isEqualTo(errorMsg);
        assertThat(response.getData()).isNull();
    }

    @Test
    @DisplayName("필드들은 변경 불가능하다")
    void fieldsAreImmutable() {
        // given
        ApiResponse<String> response = ApiResponse.success("data");

        // when & then
        // setter가 없음을 컴파일 타임에 확인
        // response.setStatus("FAIL"); // 컴파일 에러

        // 또는 리플렉션으로 확인
        assertThat(response.getClass().getMethods())
                .filteredOn(m -> m.getName().startsWith("set"))
                .isEmpty();
    }

    @Test
    @DisplayName("ApiResponse는 final 클래스다")
    void apiResponseIsFinalClass() {
        // when & then
        assertThat(Modifier.isFinal(ApiResponse.class.getModifiers())).isTrue();
    }


}