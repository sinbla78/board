# LOMBOK - 지양해야 할 annotation

## lombok이란

- 자바에서 @Getter, @Setter같은 annotation 기반으로, 기존 DTO, VO, Domain Class작성할 때, 멤버 변수에 대한 Getter/Setter Method, Equals(), hashcode(),ToString()과 멤버 변수에 값을 설정하는 생성자 등등을 자동으로 생성하여 주는 라이브러리이다.

## 지양할 필요가 있는 Annotation

- @AllArgsConstructor
  - 클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성한다.
  - 이와 비슷한 @RequriedArgsConstructor도 있다.초기화 되지 않는 모든 final필드, @NonNull과 같이 제약조건이 설정되어있는 모든 필드들에 대한 생성자를 자동으로 생성할 수 있다.
  - 발생할 수 있는 문제 상황
    - 예로 들어, 두 개의 같은 타입 인스턴스 멤버를 선언한 상황에서 개발자가 선언된 인스턴스 멤버의 순서를 바꾸면, 개발자도 인식하지 못하는 사이에 lombok이 생성자의 파라미터 순서를 필드 선언 순서에 따라 변경하게 된다. 이때, IDE가 제공해주는 리팩토링은 전혀 동작하지 않고, 두 필드가 동일 타입이기 때문에 기존 소스에서도 오류가 발생하지 않아 아무런 문제없이 동작하는 것으로 보이지만, 실제로 입력된 값이 바뀌어 들어가는 상황이 발생한다.

- @Data
  - @Data = @RequiredArgsConstructor + @Getter + @Setter + @ToString + @EqualsAndHashCode
    - 각 annotation의 주의사항을 모두 포함한다.
    - @EqualsAndHashCode : equals 메소드와 hashcode 메소드를 생성한다
      - 예를 들어, 객체를 Set에 저장한 뒤 필드 값을 변경하면 hashCode가 변경되면서 이전에 저장한 객체를 찾을 수 없는 문제가 발생한다.
    - @RequriedArgsConstructor의 주의사항은 앞에서 거론했다.
    - @Data 대신, @Getter, @Setter, @ToString으로 명시하는 것을 권장한다.

- @NoArgsConstructor
  - 파라미터가 없는 생성자를 생성한다.
  - 사용 시 주의 사항
    - 필드들이 final로 생성되어 있는 경우에는 필드를 초기화할 수 없기 때문에 생성자를 만들 수 없고 에러가 발생한다. → @NoArgsConstructor(force=true) 옵션을 이용해 final 필드를 강제 초기화 시켜 생성자를 만들 수 있다.
    - @Nonnull 같이 필드에 제약조건이 설정되어 있는 경우, 추후 초기화를 진행하기 전까지 생성자 내 null-check 로직이 생성되지 않는다.
- @Builder
  - @Builder를 사용하면 객체 생성이 명확해진다. 가급적 클래스 보다는 직접 만든 생성자 혹은 static 객체 생성 메소드에 붙이는 것을 권장한다.
  - @Builder를 붙이면 파라미터 순서가 아닌 이름으로 값을 설정하기 때문에 리팩토링에 유연하게 대응할 수 있고, 필드 순서를 변경해도 문제가 없다.

## @Getter, @Setter ???

- @Setter는 꼭 필요한 경우에만 설정해야 한다고 알고 있다. 값을 바꿀 수 있는 어노테이션이기 때문에, 값을 바꿀 필요가 있는 경우에만 설정하고 이외의 상황에는 절대 선언하면 안된다.
- @Getter도 필요한 경우에만 설정하는 것이 가장 좋지만, 남발해도 크게 위험하지 않는 것(?)으로 알고 있다. 값에 접근은 가능하나 변경할 수 없기 때문이다.

- 생성자 주입 시, @AllArgsConstructor을 사용할 수 있다. final 선언을 하고 싶다면 @RequriedArgsConstructor를 사용한다.
- Setter 주입 시, @Autowired를 사용한다.