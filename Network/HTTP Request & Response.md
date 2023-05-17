HTTP Protocol은 HTTP Request와 HTTP Reponse 메시지를 주고 받는다.

이 두개의 메시지에는 어떤 내용이 포함되어있는지 알아보고자 한다

---

## HTTP Get Message

GET /blanks/index.html HTTP/1.1  
Host: [www.whatever.com](http://www.whatever.com)  
Connection: close  
User-agent: Mozilla/5.0  
Accept-language: kr

Get Message의 첫줄은 요청라인(request line) 이라고 하고 3개의 필드로 나뉘어져있다

1.  Method : GET,POST,DELETE,PUT 등. GET 방식은 객체를 요청할 때 사용
2.  URL
3.  HTTP Version

첫번째 줄을 제외한 나머지 줄은 헤더라인(header line) 이라고 한다

1.  Host : TCP로 이미 연결이 수립되었다는건데 굳이 Host를 넣는 이유는 웹 캐시에서 필요하기 때문
2.  Connection : Close의 의미는 비지속 연결을 하겠다
3.  브라우저 타입
4.  원하는 객체의 언어 버전. 만약 존재하지 않으면 기본 버전을 보낸다

---

## HTTP Response Message

HTTP/1.1 200 OK  
Connection : close  
Date: Tue, 18 Aug 2023 23:15:04 GMT  
Server: Apache/2.2.3 (Cent OS)  
Last-Mopdified : Tue, 18 Aug 2023 15:23:44 GMT  
Content-Length: 6821  
Content-Type: text/html  
(DATA DATA DATA ... )

Response Message는 3개의 섹션으로 나뉘어져있다.  
상태라인, 헤더라인, 개체 몸체

1.  상태라인 : 버전, 상태코드, 문장으로 이루어져있다.
2.  헤더라인
    -   Connection:close : TCP연결을 닫을 것이라는 뜻
    -   DATE : HTTP 응답이 서버에 의해 생성되고 보내진 날짜와 시간
    -   Server: 아파치 웹서버에서 만들어졌다
    -   Last-Modified: 마지막 수정된 시간과 날짜를 나타내는데 웹캐시(프록시 서버)에서 객체의 상태 변화를 확인하기 위해 사용
3.  상태코드
    -   200 OK: 성공된 요청
    -   301 Moved Permanently: 요청 객체가 새로운 주소로 이동
    -   400 Bad Request: 서버가 요청을 이해하지 못함
    -   404 Not Found: 요청한 문서가 서버에 존재하지 않음
    -   505 HTTP Version Not Supported: HTTP 프로토콜 버전을 서버가 지원하지 않는다
