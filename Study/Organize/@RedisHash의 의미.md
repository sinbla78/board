# @RedisHash의 의미?

- 해당 클래스의 엔티티들이 수많이 저장될 텐데, 이들만을 보관하는 Hash Key를 설정.
- 이 해쉬 공간 속에서 각 엔티티들이 hash_id (@id에 맵핑되는 값)을 가지게 된다.
- 결과적으로 삼중 해쉬맵을 사용한다고 이해하면 된다.
  - HashMap<String, HashMap<String, Account>>로 이해하면 된다.
  - 첫번째 String은 @RedisHash의 이름
  - 두번째 String은 hash_id이다.
  - Account는 key:value 형태로 값을 저장하고 있으며, getter로 value를 가져올 수 있음
    (필드 이름이 key가 된다.)

------



### **@SpringBootApplication**

- Spring Boot를 자동으로 실행시켜주는 어노테이션으로 Bean 등록은 두 단계로 진행된다.
- @ComponentScan 통해 Component들을 Bean으로 등록한다.
-  @EnableAutoConfiguration을 통해 미리 정의해둔 자바 설정 파일들을 Bean으로 등록한다.
- @Configiguration : 스프링 IOC Container에게 해당 클래스가 Bean 구성 Class임을 알려주는 어노테이션이다.  ➡️ @Bean을 해당 클래스의 메소드에 적용하면, @Autowired로 빈을 부를 수 있다.(설정에 관련된 정보 어노테이션)

![img](https://blog.kakaocdn.net/dn/WPgH6/btqHsdZhJq8/XYTPUB5ckcUKPG5cJ18jV0/img.jpg)

**@EnableAutoConfiguration**

- 스프링 어플리케이션 컨텍스트를 만들 때 자동으로 설정하는 기능을 켠다.

- classpath의 내용에 기반해서 자동 생성해 준다. 만약 tomcat-embed-core.jar가 존재하면 톰 캣 서버가 setting된다.

**@ComponentScan**

- @Component, @Service, @Repository, @Controller, @Configuration이 붙은 빈들을 찾아서 Context에 빈을 등록해 주는 어노테이션
- @Indexed 어노테이션을 사용하는 이유는 사용자 ID로 데이터를 조회를 위해서 어노테이션을 생성 해 줍니다.

------



### 스프링 빈(Bean)이란?

빈이란 콩이다.는 장난이고 빈이란 다음과 같이 설명할 수 있다.

> **빈(Bean)이란 스프링 IoC 컨테이너가 관리하는 자바 객체를 의미한다.**

스프링에서 **POJO(Plain Old Java Object)**를 beans라고 부른다.
Spring Framework에서는 **ApplicationContext.getBean()**과 같은 메서드를 이용하여 직접 호출할 수 있다.