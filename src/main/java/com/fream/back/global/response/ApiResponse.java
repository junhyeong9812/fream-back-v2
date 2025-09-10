package com.fream.back.global.response;

/**
 * ApiResponse 명세
 *
 * 목적: 모든 API 응답의 표준 포맷 제공
 *
 * 필수 필드:
 * - status: String (SUCCESS, ERROR, FAIL)
 * - data: T (제네릭 타입, nullable)
 * - message: String (nullable)
 * - timestamp: LocalDateTime (응답 생성 시간)
 *
 * 필수 정적 메서드:
 * - success(T data): 성공 응답 생성 (status=SUCCESS)
 * - success(): 데이터 없는 성공 응답
 * - error(ErrorCode errorCode): 에러 응답 생성 (status=ERROR)
 * - error(String message): 커스텀 메시지 에러 응답
 * - fail(String message): 실패 응답 생성 (status=FAIL)
 *
 * 제약사항:
 * - 불변 객체 (final class, final fields)
 * - 생성자는 private
 * - 모든 필드는 getter만 제공
 * - timestamp는 생성 시점 자동 설정
 */
public final class ApiResponse<T> {
    // TODO: TDD로
    private String status;
    private T data;
    private String message;

    public ApiResponse(){

    }

    public String getStatus(){
        return status;
    }

    public T getData(){
        return data;
    }

    public String getMessage(){
        return message;
    }
}