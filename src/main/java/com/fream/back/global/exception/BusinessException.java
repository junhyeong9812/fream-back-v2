package com.fream.back.global.exception;

/**
 * BusinessException 명세
 *
 * 목적: 비즈니스 로직 수행 중 발생하는 예외의 기본 클래스
 *
 * 필수 필드:
 * - errorCode: ErrorCode (에러 코드)
 *
 * 필수 생성자:
 * - BusinessException(ErrorCode errorCode)
 * - BusinessException(ErrorCode errorCode, String message)
 * - BusinessException(ErrorCode errorCode, Throwable cause)
 *
 * 필수 메서드:
 * - getErrorCode(): ErrorCode 반환
 * - getHttpStatus(): HttpStatus 반환
 *
 * 제약사항:
 * - RuntimeException 상속
 * - errorCode는 필수 (null 불가)
 */
public class BusinessException extends RuntimeException {
    // TODO: TDD로 구현
}