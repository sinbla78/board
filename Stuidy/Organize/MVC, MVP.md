# MVC, MVP

> 디자인 패턴

## Model View Controller (MVC)



![img](https://velog.velcdn.com/images%2Fbisu8018%2Fpost%2Ffee545f8-36e7-43a4-acc3-693978ea4360%2Fimage.png)

- MVC 디자인 패턴은 애플리케이션을 Model,View,Controkker로 세 가지로 나뉜다.

  #### Model

  - Model은 View에 표시하는데 필요한 데이터를 의미한다.
  - Model은 비즈니스 로직(비즈니스 모델 및 데이터 모델)을 설명하는 Class 모음이다.
  - 데이터를 변경하고 조작하는 방법으로 데이터에 대한 비즈니스 규칙을 정의한다.

  #### View

  - View는 XML, HTML등과 같은 UI 구성 요소를 나타낸다.
  - View는 Controller에서 수신한 데이터를 결과오 표시한다.
  - 모델과 뷰는 관찰자 패턴을 사용하여 서로 상호작용한다. 

  #### Controller

  - Controller는 들어오는 요청을 처리한다.
  - Model을 통해 사용자의 데이토를 처리하고 결과를 View로 다시 전달한다.
  - 일반적으로는 View와 Model 사이의 중재자 역할을 한다.
------

## Model View Presenter (MVP)

![img](https://velog.velcdn.com/images%2Fbisu8018%2Fpost%2Fd04038f8-ecfe-4082-8bd5-e59c7b289313%2Fimage.png)

- MVC 패턴에서 파생되었으며 Controller가 Presenter로 대체되었다. MVP 패턴은 어플리케이션을 Model, View,  Presenter 세 가지 측면으로 나뉜다.

  #### Presenter

  - Presenter는 View를 통해 사용자로 부터 입력받은 후, Model의 도움을 받아 사용자의 데이터를 처리하고, 결과를 다시 View로 전달한다.
  -  Presenter는 인터페이스를 통해 View와 통신한다. 인터페이스는 필요한 데이터를 전달하는 Presenter Class에서 정의된다.
  -  View 컴포넌트 요소는 이 인터페이스를 구현하고 원하는 방식으로 데이터를 렌더링한다.
  - MVP 디자인 패턴에서 Presenter는 Model을 조작하고 View도 업데이트한다. View와 Presenter는 서로 완전히 분리되어, 인터페이스를 통해 통신한다. 
  - View의 탈동조화(decoupling) 모킹이 더 쉽고 MVC 디자인 패턴에 대해 MVP 디자인 패턴을 활용하는 애플리케이션의 단위 테스트가 훨씬 더 쉬워진다.