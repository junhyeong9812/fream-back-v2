package com.fream.back.global.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
/**
 * BaseEntity 테스트 명세
 *
 * 테스트 케이스:
 * 1. 엔티티_생성시_isDeleted는_false
 * 2. delete_호출시_isDeleted가_true로_변경
 * 3. restore_호출시_isDeleted가_false로_변경
 * 4. id는_null로_시작 (영속화 전)
 */

class BaseEntityTest {
    // TODO: 테스트 구현

    static class TestEntity extends BaseEntity {

    }
    @Test
    @DisplayName("BaseEntity를 상속한 크래스를 생성할 수 있다.")
    void canCreateEntityClass(){
        //given & when
        TestEntity entity = new TestEntity();

        //then
        assertThat(entity).isNotNull();

    }

    @Test
    @DisplayName("id 필드를 가진다.")
    void hasIdField(){
        //given
        TestEntity entity = new TestEntity();

        //when & then
        //id getter가 있는지 확인
        Long id = entity.getId();
        assertThat(id).isNull();
    }

    @Test
    @DisplayName("isDeleted 필드를 가진다.")
    void hasIsDeletedField(){
        //given
        TestEntity entity = new TestEntity();

        //when
        Boolean isDeleted = entity.getIsDeleted();

        //then
        assertThat(isDeleted).isNotNull();
    }

    @Test
    @DisplayName("isDeleted를 true로 변경할 수 있다.")
    void canChangeIsDeletedToTrue(){
        //given
        TestEntity entity = new TestEntity();

        //when
        entity.setIsDeleted(true);

        //then
        assertThat(entity.getIsDeleted()).isTrue();
    }

}