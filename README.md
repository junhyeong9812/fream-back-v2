# FREAM Backend v2 - TDD 재구축

## 프로젝트 소개

[FREAM Backend](https://github.com/junhyeong9812/fream-back) 프로젝트를 TDD(Test-Driven Development) 방식으로 재구축하는 프로젝트입니다. 중고 거래 플랫폼인 KREAM을 클론코딩하면서 테스트 주도 개발을 실습합니다.

## 기술 스택

- Java 21
- Spring Boot 3.5.5
- Spring Data JPA
- H2 Database
- JUnit 5
- Gradle

## 프로젝트 구조

```
fream-back-v2/
├── global/                        # 전역 공통 모듈
│   ├── entity/                   # 기본 엔티티
│   │   ├── BaseEntity.java      
│   │   └── BaseTimeEntity.java   
│   ├── response/                 # 응답 포맷
│   │   ├── ApiResponse.java      
│   │   └── ErrorCode.java        
│   └── exception/                # 예외 처리
│       ├── BusinessException.java
│       └── GlobalExceptionHandler.java
│
└── domain/                       # 비즈니스 도메인
    ├── user/                     # 사용자 도메인
    │   ├── core/                # 도메인 엔티티
    │   │   ├── User.java
    │   │   ├── Email.java
    │   │   └── UserGrade.java
    │   └── features/            # 기능별 모듈
    │       ├── register/
    │       ├── login/
    │       └── profile/
    ├── product/                  # 상품 도메인
    │   ├── core/
    │   └── features/
    │       ├── bidding/
    │       └── instant-purchase/
    └── trade/                    # 거래 도메인
```

## TDD 개발 프로세스

### RED → GREEN → REFACTOR

1. **RED**: 실패하는 테스트 작성
2. **GREEN**: 테스트를 통과하는 최소 코드 구현
3. **REFACTOR**: 코드 개선 및 중복 제거

## 학습 목표

### TDD 실습
- 테스트 먼저 작성하는 습관 형성
- 작은 단위부터 점진적 구현
- 리팩토링을 통한 코드 품질 개선

### 클린 아키텍처
- 도메인 중심 설계
- 의존성 방향 관리 (Domain ← Application ← Infrastructure)
- 기능별 모듈화를 통한 높은 응집도

### 실용적 접근
- 과도한 추상화 지양
- 유지보수 용이한 구조
- 점진적 마이그레이션 가능한 설계

## 실행 방법

```bash
# 프로젝트 클론
git clone https://github.com/your-username/fream-back-v2.git
cd fream-back-v2

# 테스트 실행
./gradlew test

# 애플리케이션 실행
./gradlew bootRun
```

global entity 설계 완료
global response 개발준

## 참고 자료

- [FREAM Backend 원본 프로젝트](https://github.com/junhyeong9812/fream-back)
- Clean Architecture - Robert C. Martin
- TDD by Example - Kent Beck

