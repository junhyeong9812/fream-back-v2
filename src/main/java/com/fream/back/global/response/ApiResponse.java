package com.fream.back.global.response;

import java.time.LocalDateTime;

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
    private LocalDateTime timestamp;

    //private 생성자
    private ApiResponse(String status, T data, String message, LocalDateTime timestamp) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.timestamp = timestamp;
    }

    // 정적 팩토리 메서드들
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("SUCCESS", data, null, LocalDateTime.now());
    }

    public static ApiResponse<?> success() {
        return new ApiResponse<>("SUCCESS", null, null, LocalDateTime.now());
    }

    public static ApiResponse<?> error(String message) {
        return new ApiResponse<>("ERROR", null, message, LocalDateTime.now());
    }

    public static ApiResponse<?> fail(String message) {
        return new ApiResponse<>("FAIL", null, message, LocalDateTime.now());
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

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

}