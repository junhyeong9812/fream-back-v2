package com.fream.back.global.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
@DataJpaTest
class BaseTimeEntityTest {
    // TODO: 테스트 구현


}