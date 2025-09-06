package com.fream.back.global.entity;

/**
 * BaseEntity 명세
 *
 * 목적: 모든 엔티티의 기본이 되는 추상 클래스
 *
 * 필수 필드:
 * - id: Long 타입, 자동 생성 전략 사용
 * - isDeleted: Boolean 타입, 기본값 false (Soft Delete 지원)
 *
 * 필수 메서드:
 * - delete(): isDeleted를 true로 변경
 * - restore(): isDeleted를 false로 변경
 * - getId(): id 반환
 * - getIsDeleted(): 삭제 상태 반환
 *
 * 제약사항:
 * - @MappedSuperclass 어노테이션 필요
 * - id는 생성 후 변경 불가
 * - 추상 클래스로 직접 인스턴스화 불가
 */
public abstract class BaseEntity {
    // TODO: TDD로 구현
    private Long id;
    private Boolean isDeleted = false; //기본값 설정

    public Long getId(){
        return id;
    }

    public Boolean getIsDeleted(){
        return isDeleted;
    }
}