package com.fream.back.global.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BaseTimeEntity 테스트 명세
 *
 * 테스트 케이스:
 * 1. 엔티티_생성시_시간필드는_null
 * 2. 영속화시_createdAt과_updatedAt_자동_설정
 * 3. 엔티티_수정시_updatedAt만_변경
 * 4. createdAt은_수정_불가
 * 5. isNew는_id가_null일때_true_반환
 */
//@DataJpaTest
class BaseTimeEntityTest {
    // TODO: 테스트 구현

    //테스트용 구현체 클래스
    static class TestTimeEntity extends BaseTimeEntity{
    }

    @Test
    @DisplayName("BaseTimeEntity를 상속한 클래스를 생성할 수 있다.")
    void canCreateTimeEntityClass(){
        //given & when
        TestTimeEntity entity = new TestTimeEntity();

        //then
        assertThat(entity).isNotNull();
    }

    @Test
    @DisplayName("BaseEntity의 기능을 상속받는다.")
    void inheritsBaseEntityFeatures(){
        //given
        TestTimeEntity entity = new TestTimeEntity();

        //when & then
        assertThat(entity.getId()).isNull();
        assertThat(entity.getIsDeleted()).isFalse();

        entity.delete();
        assertThat(entity.getIsDeleted()).isTrue();
    }

    @Test
    @DisplayName("createAt 필드를 가진다.")
    void hasCreatedAtField(){
        //given
        TestTimeEntity entity = new TestTimeEntity();

        //when
        LocalDateTime createdAt = entity.getCreatedAt();

        //then
        assertThat(createdAt).isNull(); //초기값은 null
    }

}