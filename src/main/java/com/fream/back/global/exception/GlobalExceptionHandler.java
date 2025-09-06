package com.fream.back.global.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler 명세
 *
 * 목적: 전역 예외 처리 및 일관된 응답 포맷 제공
 *
 * 필수 처리 메서드:
 * - handleBusinessException(BusinessException e):
 *   비즈니스 예외 처리, ErrorCode의 HttpStatus 반환
 *
 * - handleValidationException(MethodArgumentNotValidException e):
 *   @Valid 검증 실패 처리, 400 반환
 *   필드별 에러 메시지 포함
 *
 * - handleConstraintViolation(ConstraintViolationException e):
 *   제약조건 위반 처리, 400 반환
 *
 * - handleGeneralException(Exception e):
 *   예상치 못한 예외 처리, 500 반환
 *   로그 기록 필수
 *
 * 제약사항:
 * - @RestControllerAdvice 어노테이션 필요
 * - 모든 응답은 ApiResponse 형태로 반환
 * - 예외 스택트레이스는 로그에만 기록 (응답에 포함 X)
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // TODO: TDD로 구현
}