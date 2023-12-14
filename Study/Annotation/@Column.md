### @Column(length = )

@Column(length = ) 은 실제 데이터베이스 열의 특정 특성을 나타내기 위해 사용된다. 열은 VARCHAR() 타입으로 생성되고 (length = ) 안에 입력된 값보다 긴 문자열을 넣으려고 하면 SQL error가 나타난다. @Column은 유효성 검사를 제공하지 않으므로 테이블 열 속성 지정에만 사용된다.

VARCHAR는 데이터를 삽입하면 데이터값외에 삽입된 문자열의 길이를 저장하는데 255글자 이하에는 1바이트, 그 이상은 2바이트의 추가 공간을 필요로 한다.

length는 문자열의 최대 길이를 의미한다.

### @Size

@Size는 연결된 문자열의 길이가 min과 max사이인지 확인하는 어노테이션이다.

### @Length

@Length는 Hiberbate의 @Size어노테이션이다. 이것도 마찬가지로 문자열의 길이가 min과 max 사이인지 확인한다.

### @Component

@Component 어노테이션은 기본적으로 타입기반의 자동주입 어노테이션이다. 

@Component는 개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 Annotation 이다.

스프링의 컴포넌트 스캔 기능에 의해 스캔될 때, 주어진 패키지 내에서 @Component 어노테이션이 적용된 클래스를 식별하고, 그러한 클래스의 빈을 생성하여 ApplicationContext에 등록한다.

(value = "") 옵션이 있고, 해당 옵션을 사용하지 않는다면 class의 이름을 camelCase(카멜표기법)로 변경한 것을 bean id로 사용한다.