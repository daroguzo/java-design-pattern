# 프로토타입 패턴

기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법

- 장점
    - 복잡한 객체를 만드는 과정을 숨길 수 있다.
    - 추상적인 타입 리턴 가능
    - 기존 객체를 복제하는 과정 > 새 인스턴스를 만드는 과정(시간 or 메모리)
    - 객체를 복사하는 비용 > 네트워크 접근 비용 or DB 접근 비용
- 단점
    - 복제한 객체를 만드는 과정 자체가 복잡할 수 있다.(순환 참조)

```java
Phone original = new Phone();
Phone clone = original.clone();

// true
clone != original

// true
clone.equals(original)

// true
clone.getClass() == original.getClass();
```

- 만드는 방법

```java
// Cloneable 인터페이스 구현

@Override
protected Object clone() throws CloneNotSupportedException {
	return super.clone();
}
```

- clone()은 기본적으로 얕은 복사(shallow copy)
    - 얕은 복사(shallow copy)
        - 주소 값 복사
        - 해당 객체만 복사하여 새 객체 생성
        - 복사본과 원본은 같은 메모리 주소 참조
        - 해당 메모리 주소 값 변경 > 원본 & 복사본 값 모두 변경
    - 깊은 복사(deep copy)
        - 실제 값을 새로운 메모리 공간에 복사
        - 해당 객체와 인스턴스 변수까지 복사
        - 모두 복사하여 새 주소에 담기 때문에 참조 공유X

- ModelMapper

  객체의 프로퍼티를 다른 객체의 프로퍼티로 매핑해주는 유틸리티

  AS- IS

    ```java
    TestEntity testEntity = testRepository.findById("test");
    
            TestDto testDto = new TestDto();
            testDto.setEmail(testEntity.getEmail());
            testDto.setGender(testEntity.getGender());
            testDto.setId(testEntity.getId());
            
            // ...
    ```

  TO BE

    ```java
    TestEntity testEntity = testRepository.findById("test");
     
    TestDto testDto = modelMapper.map(testEntity, TestDto.class);
    ```

    - source와 destination의 타입을 분석하여 매칭 전략 및 기타 설정 값에 따라 일치하는 속성 결정 > 매핑
    - 객체 타입이나 프로퍼티가 다른 경우에도 설정된 전략에 따라 최선의 매핑 과정 실행
    - 모호한 연관관계들은 매핑되지 않음