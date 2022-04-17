# 플라이웨이트 패턴

**객체를 가볍게 만들어 메모리 사용을 줄이는 패턴**

- 자주 변하는 속성, 변하지 않는 속성을 분리, 재사용(캐싱) > 메모리 절약


- 불변 객체 생성

    ```java
    public final class Font {
    
        final String family;
    
        final int size;
    
        public Font(String family, int size) {
            this.family = family;
            this.size = size;
        }
    
        public String getFamily() {
            return family;
        }
    
        public int getSize() {
            return size;
        }
    }
    ```

    ```java
    public class FontFactory {
    
        private Map<String, Font> cache = new HashMap<>();
    
        public Font getFont(String font) {
            if (cache.containsKey(font)) {
                return cache.get(font);
            } else {
                String[] split = font.split(":");
                Font newFont = new Font(split[0], Integer.parseInt(split[1]));
                cache.put(font, newFont);
                return newFont;
            }
        }
    }
    
    // 사용
    fontFactory.getFont("nanum:12")
    ```

- 장점
    - 애플리케이션에서 사용하는 메모리 절약
- 단점
    - 복잡도 증가
- 특징
    - 같은 폰트는 1개만 생성되며 생성된 객체를 공유
    - singleton으로 구현하는 경우도 있음