package com.fream.back.global.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * BaseEntity 계층 구조 통합 테스트 명세
 *
 * 목적: BaseEntity, BaseTimeEntity, BaseAuditEntity의
 *      상속 관계와 모든 기능이 올바르게 동작하는지 검증
 *
 * 테스트 대상:
 * - BaseEntity (id, isDeleted, delete(), restore())
 * - BaseTimeEntity extends BaseEntity (createdAt, updatedAt)
 * - BaseAuditEntity extends BaseTimeEntity (createdBy, updatedBy)
 *
 * 테스트 케이스:
 * 1. 상속 계층 구조 검증
 *    - BaseTimeEntity가 BaseEntity의 모든 기능 상속
 *    - BaseAuditEntity가 BaseTimeEntity의 모든 기능 상속
 *
 * 2. BaseEntity 기능 검증
 *    - 모든 하위 엔티티에서 id 관리 가능
 *    - 모든 하위 엔티티에서 soft delete 기능 동작
 *
 * 3. BaseTimeEntity 기능 검증
 *    - BaseTimeEntity와 BaseAuditEntity에서 시간 필드 관리
 *    - 생성/수정 시간 독립적 설정 가능
 *
 * 4. BaseAuditEntity 기능 검증
 *    - 모든 상위 클래스 기능과 함께 audit 필드 관리
 *    - 생성자/수정자 정보 독립적 설정 가능
 *
 * 5. 실제 사용 시나리오
 *    - 엔티티 생성 → 수정 → 삭제 → 복구 전체 라이프사이클
 *    - 각 단계별 필드 상태 검증
 */
class BaseEntityHierarchyIntegrationTest {

    //각 레벨별 테스트용 구체 클래스
    static class SimpleEntity extends BaseEntity {
        private String name;
        public SimpleEntity(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }

    static class TimeTrackedEntity extends BaseTimeEntity{
        private String description;

        public TimeTrackedEntity(String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }
    }

    static class FullAuditEntity extends BaseAuditEntity{
        private String content;

        public FullAuditEntity(String content){
            this.content = content;
        }

        public String getContent(){
            return content;
        }
    }

    @Test
    @DisplayName("BaseTimeEntity는 BaseEntity의 모든 기능을 상속받는다.")
    void timeEntityInheritsFromBaseEntity(){
        //given
        TimeTrackedEntity entity = new TimeTrackedEntity("test description");

        //when & then
        //baseEntity 기능 확인
        assertThat(entity.getId()).isNull();
        assertThat(entity.getIsDeleted()).isFalse();

        entity.delete();
        assertThat(entity.getIsDeleted()).isTrue();

        entity.restore();
        assertThat(entity.getIsDeleted()).isFalse();
    }

    @Test
    @DisplayName("BaseAuditEntity는 BaseTimeEntity의 모든 기능을 상속받는다.")
    void auditEntityInheritsFromTimeEntity(){
        //given
        FullAuditEntity entity = new FullAuditEntity("test content");

        //when & then
        //baseEntity 기능
        assertThat(entity.getId()).isNull();
        assertThat(entity.getIsDeleted()).isFalse();

        //BaseTimeEntity 기능
        assertThat(entity.getCreatedAt()).isNull();
        assertThat(entity.getUpdatedAt()).isNull();

        //BaseAuditEntity 기능
        assertThat(entity.getCreatedBy()).isNull();
        assertThat(entity.getUpdatedBy()).isNull();
    }

    @Test
    @DisplayName("각 엔티티 레벨에서 독립적으로 기능이 동작한다.")
    void eachLevelFunctionsIndependently(){
        //given
        SimpleEntity simple = new SimpleEntity("simple");
        TimeTrackedEntity timeTracked = new TimeTrackedEntity("time");
        FullAuditEntity fullAudit = new FullAuditEntity("audit");

        //when
        //각 delete 동작
        simple.delete();
        timeTracked.delete();
        fullAudit.delete();

        //then
        assertThat(simple.getIsDeleted()).isTrue();
        assertThat(timeTracked.getIsDeleted()).isTrue();
        assertThat(fullAudit.getIsDeleted()).isTrue();
    }
}