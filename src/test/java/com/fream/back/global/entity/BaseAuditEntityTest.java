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

}