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

}