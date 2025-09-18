package com.fream.back.global.response;

/**
 * ErrorCode 명세
 *
 * 목적: 시스템 전체 에러 코드 정의
 *
 * 필수 속성:
 * - code: String (에러 코드, ex: "E001")
 * - message: String (사용자 친화적 메시지)
 * - httpStatus: HttpStatus (HTTP 상태 코드)
 *
 * 필수 에러 코드:
 * 공통 (Common) - C로 시작:
 * - INVALID_INPUT: C001, "입력값이 올바르지 않습니다", 400
 * - UNAUTHORIZED: C002, "인증이 필요합니다", 401
 * - FORBIDDEN: C003, "접근 권한이 없습니다", 403
 * - NOT_FOUND: C004, "요청한 리소스를 찾을 수 없습니다", 404
 * - INTERNAL_SERVER_ERROR: C500, "서버 오류가 발생했습니다", 500
 *
 * 사용자 (User) - U로 시작:
 * - USER_NOT_FOUND: U001, "사용자를 찾을 수 없습니다", 404
 * - DUPLICATE_EMAIL: U002, "이미 사용중인 이메일입니다", 409
 * - INVALID_PASSWORD: U003, "비밀번호가 올바르지 않습니다", 400
 *
 * 제약사항:
 * - enum으로 구현
 * - 코드는 카테고리를 나타내는 접두사 + 숫자
 * - getter 메서드 제공
 */
public enum ErrorCode {
    // TODO: TDD로 구현
    INVALID_INPUT("C001");

    private final String code;
    private final String message;

    ErrorCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}