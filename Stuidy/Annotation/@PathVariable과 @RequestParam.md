### @PathVariable과 @RequestParam

- 위 2개의 어노테이션은 데이터를 전달하기 위한 방법들 중 하나로, URI를 통해 전달된 값을 파라미터로 받아오는 역할을 합니다.
- URI를 통해 값을 전달하는 방식
  - http://localhost:8000/board?page=1&listSize=10
  - http://localhost:8000/board/1

-  쿼리스트링을 사용하여 여러개의 값을 전달하는 첫번째 방식은 @RequestParam을 통해 받아오고, 두번째 방식은 @PathVariable을 사용하여 받아올 수 있습니다.

1. @RequestParam 과 @PathVariable은 둘 다 데이터를 받아오는 데에 사용한다

2. @PathVariable은 값을 하나만 받아올 수 있으므로, 쿼리스트링 등을 이용한 여러 개 데이터를 받아올 때는 @RequestParam을 사용한다.