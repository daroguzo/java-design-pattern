# Design Pattern

## Singleton 패턴

프로그램 내에 인스턴스를 오직 한 개만 제공, 여러 개의 쓰레드가 공유 해야할 정보들을 하나의 인스턴스에 담아 놓고, 공통적으로 사용

### 자바에서 enum을 사용하지 않고 싱글톤 패턴을 구현하는 방법은?

1. 이른 초기화(Thread Safe)

    ```java
    public class Singleton {
    	private static final Singleton instance = new Singleton();
        
      private Singleton(){} 
    
      public static Singleton getInstance(){
          return instance;   
    	}
    }
    ```

2. 정적 블록 초기화(Thread Safe)

    ```java
    public class Singleton {
    	private static Singleton instance;
        
      private Singleton(){} 
    
      static {
    		try {
    			instance = new Singleton();
    		} catch(Exception e) {
    			throw new RuntimeException("Exception Handling!");
    		}
    	}
    }
    ```

3. 지연 초기화(정적 블록 초기화)

    ```java
    public class Singleton {
    	private static Singleton instance;
        
      private Singleton(){} 
    
      public static Singleton getInstance() {
    		if (instance == null) {
    			instance = new Singleton();
    		}
    		return instance; 
    	}
    }
    ```

4. 동기화 블럭 사용 지연 초기화

    ```java
    public class Singleton {
    	private static Singleton instance;
        
      private Singleton(){} 
    
      public static synchronized Singleton getInstance() {
    		if (instance == null) {
    			instance = new Singleton();
    		}
    		return instance; 
    	}
    }
    ```

5. 지연 초기화, Double Checking Locking(volatile)

    ```java
    public class Singleton {
    	private static Singleton instance;
        
      private Singleton(){} 
    
      public Singleon getInstance() {
    		if (instance == null) {
    			synchronized(Singleton.class) {
    				if(instance == null) {
    					instance = new Singleton();
    				}
    			}
    		}
    		return instance;
    	}
    }
    ```

6. 지연 초기화, 게으른 홀더(Bill Pugh Singleton Implementaion)

### private 생성자와 static 메소드를 사용하는 방법의 단점은?

- Non Thread Safe

### enum을 사용해 싱글톤 패턴을 구현하는 방법의 장점과 단점은?

- 장점: 리플렉션, 직렬화-역직렬화에 안전, Thread Safe
- 단점: enum 이외의 클래스 상속 불가, 이른 초기화

### static inner class를 사용해 싱글톤 패턴을 구현하라

```java
private Settings() {}

private static class SettingHolder {
	private static final Settings ISTANCE= new Settings();
}

public static Settings getInstance() {
	return SettingsHolder.INSTANCE;
}
```

- volatile, synchronized 키워드 없이 동시성 해결

## **Factory method 패턴**

### 구체적으로 어떤 것을 만들지는 서브 클래스가 정한다.

- 팩토리 메소드 패턴을 적용했을 때의 장단점은?
    - 기존 코드를 건드리지 않고 새로운 인스턴스를 다른 방법으로 얼마든지 확장 가능  > Product, Creator 간에 느슨한 결합
    - 단점: 각자의 역할을 나누기 때문에 클래스 증가는 불가피
- “확장에 열려있고 변경에 닫혀있는 객체 지향 원칙”을 설명하세요.(OCP)
    - 변경에 닫혀있다: 기존 코드를 변경하지 않는다.
- 자바 8에 추가된 default 메소드에 대해 설명하세요.
    - interface에 기본 구현체 선언 가능
    - Java9 interface private

## Abstract Factory 패턴