package com.fream.back.global.entity;

import java.time.LocalDateTime;

/**
 * BaseTimeEntity 명세
 *
 * 목적: BaseEntity를 상속받아 시간 정보를 추가로 관리하는 추상 클래스
 *
 * 필수 필드 (BaseEntity 상속):
 * - createdAt: LocalDateTime, 생성 시간 (수정 불가)
 * - updatedAt: LocalDateTime, 수정 시간 (자동 갱신)
 *
 * 필수 메서드:
 * - getCreatedAt(): 생성 시간 반환
 * - getUpdatedAt(): 수정 시간 반환
 * - isNew(): 신규 엔티티 여부 (id가 null이면 true)
 *
 * 제약사항:
 * - BaseEntity를 상속
 * - @EntityListeners(AuditingEntityListener.class) 필요
 * - createdAt은 한 번 설정되면 변경 불가
 * - updatedAt은 엔티티 변경 시 자동 갱신
 */
public abstract class BaseTimeEntity extends BaseEntity {
    // TODO: TDD로 구현
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public void setCreatedAt(LocalDateTime now){
        this.createdAt = now;
    }

    public void setUpdatedAt(LocalDateTime now){
        this.updatedAt = now;
    }

}