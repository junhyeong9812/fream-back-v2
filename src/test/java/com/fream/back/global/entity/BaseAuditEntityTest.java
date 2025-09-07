package com.fream.back.global.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseAuditEntityTest {

    static class TestAuditEntity extends BaseAuditEntity{
    }

    @Test
    @DisplayName("BaseAuditEntity를 상송한 클래스를 생성할 수 있다.")
    void canCreateAuditEntityClass(){
        //given & when
        TestAuditEntity entity = new TestAuditEntity();

        //then
        assertThat(entity).isNotNull();
    }

    @Test
    @DisplayName("BaseTimeEntity의 모든 기능을 상속받는다.")
    void inheritsBaseTimeEntityFeatures(){
        //given
        TestAuditEntity entity = new TestAuditEntity();

        //when & then
        //BaseEntity 기능
        assertThat(entity.getId()).isNull();
        assertThat(entity.getIsDeleted()).isFalse();

        //BaseTimeEntity 기능
        assertThat(entity.getCreatedAt()).isNull();
        assertThat(entity.getUpdatedAt()).isNull();
    }

    @Test
    @DisplayName("createdBy 필드를 가진다.")
    void hasCreatedByField(){
        //given
        TestAuditEntity entity = new TestAuditEntity();

        //when
        String createdBy = entity.getCreatedBy();

        //then
        assertThat(createdBy).isNull();
    }

    @Test
    @DisplayName("createdBy 필드를 설정할 수 있다.")
    void canSetCreatedBy(){
        //given
        TestAuditEntity entity = new TestAuditEntity();
        String creator = "admin";
        //when
        entity.setCreatedBy(creator);

        //then
        assertThat(entity.getCreatedBy()).isEqualTo(creator);

    }

    @Test
    @DisplayName("updatedBy 필드를 가진다.")
    void hasUpdatedByField(){
        //given
        TestAuditEntity entity = new TestAuditEntity();

        //when
        String updatedBy = entity.getUpdatedBy();

        //then
        assertThat(updatedBy).isNull();
    }

    @Test
    @DisplayName("updatedBy 필드를 설정할 수 있다.")
    void canSetUpdatedBy(){
        //given
        TestAuditEntity entity = new TestAuditEntity();
        String updater = "user1";

        //when
        entity.setUpdatedBy(updater);

        //then
        assertThat(entity.getUpdatedBy()).isEqualTo(updater);
    }

}