# Eco & Rich 백엔드

---

## 기능목록
- 사원의 현재 정보 조회 ( GET : /details/{id} )
- 사원이 이력 정보 조회 ( GET : /histories/{id} )
- 부서 및 위치 정보 조회 
  - 부서 정보 : GET : /{id}
  - 위치 정보 : GET : /locations/{id}
- 부서의 급여를 특정 비율로 인상 및 사원 정보 업데이트 ( PATCH : /{id} )

## 코드컨벤션 / 구현방법
테이블관계에 맞춰 JPA를 활용했습니다. (Table -> Entity, View -> VO)  
테이블과 맵핑되는 Entity 객체의 필드의 경우, 스네이크케이스를,  
클라이언트에게 반환되는 DTO 필드의 경우 카멜케이스를 적용하여  
변수/필드명으로 어떤 계층에서 사용되는지 쉽게 확인할 수 있게 구분하였습니다.

Null이 허용되는 필드의 경우 Wrapper클래스를, NotNull일 경우 원시타입을 사용했습니다.  

Service 계층에서 항상 DTO 객체로 반환합니다.  
데이터 수정의 경우, 더티체킹과 DynamicUpdate을 사용하여 쿼리를 최적화 했습니다.

Department 도메인의 경우 Location, Country, Region을 서브도메인으로  
Employee 도메인의 경우 Job, JobHistory를 서브도메인으로 구현했습니다.

코드 가독성을 위해 빌드패턴을 사용하였으며 기능확장성/유지보수성을 고려하였습니다.

도메인별 구현하는 단계에 따라 브랜치를 나눠서 진행했습니다.  
dev/hr-management : 인사기능구현  
dev/exception-handling : 예외처리  
api : API 조회 및 반환 + 예외처리


---

## 공공 API
> [한국항공공사의 실시간 항공운항 현황 정보 상세 조회 서비스](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15113771)는 인증키가
> 수 시간이 지나도 유효하지 않아 문의 보낸상태이며
> 기관별 동기화 시간이 상이하다고 하여 기다리고 있는 상태입니다.  
> 
> 때문에, 코인명 및 시세 정보를 조회하는 API 정보를 받아서 반환하는 기능을 추가로 구현하였습니다. 

### API URL
#### 항공조회 서비스
- GET : api/public/flights
  - OpenAPI로 조회된 JSON 데이터가 바로 반환됩니다.
  - 현재 인증키가 유효하지 않아 예외처리된 메세지가 반환됩니다. 
#### 코인정보(Upbit) 조회
- GET : api/coin
  - Upbit에 상장되어 있는 코인의 마켓ID, 한글명, 영어명이 목록이 반환됩니다.
- GET : api/coin/{ids}
  - Ids는 ```,``` 로 구분됩니다. (Upbit Open API 지원)
  - DTO 객체로 조회된 결과에 선택적으로 정보를 반환합니다.  
  확장성을 위해 [JsonHelper](src%2Fmain%2Fjava%2Fcom%2Fecoandrich%2FmaycodingTest%2FAPI%2FUtil%2FJsonHelper.java)
  클래스를 구현하였습니다.  
  (해당 클래스는 자바 Reflection과 json-simple을 사용했습니다.)
  - DTO에 존재하는 필드(카멜케이스로 통일)만 반환됩니다.

