# 데코레이터 패턴

**확장이 필요할 때 기존 코드를 변경하지 않고 부가 기능을 추가하는 패턴**

- 상속이 아닌 위임을 사용해서 보다 유연하게(런타임에) 부가 기능 추가 가능

```java
// 기존 (서브 클래싱)
public class SpamFilteringCommentService extends CommentService {

    @Override
    public void addComment(String comment) {
        boolean isSpam = isSpam(comment);
        if (!isSpam) {
            super.addComment(comment);
        }
    }

    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
```

![Untitled](https://gmlwjd9405.github.io/images/design-pattern-decorator/decorator-pattern.png)

- Component
    - 기본 기능(ConcreteComponent), Decorator 공통 기능 정의
    - Component를 통해 실제 객체 사용
- ConcreteDecorator A, B
    - Decorator의 하위 클래스, 기본 기능에 기능 추가

![Untitled](%E1%84%83%E1%85%A6%E1%84%8F%E1%85%A9%E1%84%85%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%203e9d3/Untitled.png)

```java
// 사용
public class App {

    private static boolean enabledSpamFilter = true;

    private static boolean enabledTrimming = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if (enabledSpamFilter) {
            commentService = new SpamFilteringCommentDecorator(commentService);
        }

        if (enabledTrimming) {
            commentService = new TrimmingCommentDecorator(commentService);
        }

        Client client = new Client(commentService);
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }
}
```

- 장점
    - 새로운 클래스를 만들지 않고 기존 기능 조합 가능
  
    - 컴파일 타임이 아닌 런타임에 동적으로 기능을 변경 가능
- 단점
    - 데코레이터를 조합하는 코드가 복잡해질 수 있음
- 관련 객체 지향 원칙
    - 단일 책임 원칙
    - 개방 폐쇄 원칙