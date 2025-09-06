package com.fream.back.global.exception;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/**
 * GlobalExceptionHandler 테스트 명세
 *
 * 테스트 케이스:
 * 1. BusinessException_처리시_ErrorCode의_상태코드_반환
 * 2. ValidationException_처리시_400_반환_필드에러_포함
 * 3. ConstraintViolation_처리시_400_반환
 * 4. 일반Exception_처리시_500_반환
 * 5. 모든_응답은_ApiResponse_형태
 * 6. 스택트레이스는_응답에_포함되지_않음
 */
@WebMvcTest(GlobalExceptionHandler.class)
class GlobalExceptionHandlerTest {
    // TODO: 테스트 구현
}