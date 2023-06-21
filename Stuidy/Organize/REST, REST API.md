# REST, REST API

## REST, REST API의 개념

### REST란?

- REST의 정의

  “Representational State Transfer”의 약자

  - 자원을 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든 것을 의미한다.
  - 즉, 자원의 표현에 의한 상태 전달

  1. 자원의 표현

  - 자원 : 해당 소프트웨어가 관리하는 모든 것

  1. 상태(정보) 전달

  - 데이터가 요청되어지는 시점에서 자원의 상태(정보)를 전달한다.
  - JSON 혹은 XML를 통해 데이터를 주고 받는 것이 일반적이다.

  월드 와이드 웹(WWW)과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 개발 아키텍처한 형식이다.

  - REST는 기본적으로 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일이다.
  - REST는 네트워크 상에서 Client와 Server 사이의 통신 방식 중 하나이다.

  ### REST의 구체적인 개념

  1. HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용하는 것을 의미한다.

  - 즉, REST는 자원 기반의 구조(ROA, Resource Oriented Architecture)설게의 중심에 Resource가 있고 HTTP Method 를 통해 Resource를 처리하도록 설게된 아키텍쳐를 의미한다.

  - 웹 사이트의 이미지, 텍스트, DB 내용 등의 모든 자원에 고유한 ID인 HTTP URL를 부여한다.

  - CRUD Operation

    - Create : 생성(POST)
    - Read : 조회(GET)
    - Update : 수정(PUT)
    - Delete : 삭제(Delete)
    - Head : HEADER 정보 조회(HEAD)

    ------

### REST API란?

- API란?

  API는 컴퓨터나 컴퓨터 프로그램 사이의 연결이다.

- REST API의 정의

  - REST 기반으로 서비스  API를 구현한 것
  - 최근 Open API, 마이크로 서비스등을 제공하는 업체 대부분은 REST API를 제공한다.

- REST API의 특징