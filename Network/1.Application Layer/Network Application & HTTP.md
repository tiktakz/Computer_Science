## Application Layer

-   네트워크 애플리케이션의 핵심 포인트는 end-device 사이에서 네트워크로 통신
-   실제로 통신하는 것은 프로세스(Process)
-   Process는 Socket을 통해 네트워크로 메시지를 주고 받는다. 그래서 Socket은 App Layer과 Transport Layer 사이의 인터페이스
-   메시지를 교환하려면 어디로 보내야하는지 알아야한다 -> IP
-   메시지를 받은 호스트 내에서 어떤 프로세스가 수신해야하는지 알아야한다 -> Port Number (ex. Web server : 80)
-   Client - Server 구조에서 Server는 고정IP 를 갖고 있는 항상 동작하고 있음
-   Client끼리는 통신하지 않음
-   두개의 프로세스에서 세션을 시작하기 위해서 접속을 기다리는 프로세스를 Server, 세션을 시작하기 위해 접속을 초기화 하는 프로세스를 Client

## HTTP(HyperText Transfer Protocol)

-   서로 다른 종단 시스템에서 실행되는 애플리케이션의 프로세스들은 어떻게 메시지를 주고 받는가?
-   Application-layer Protocol (HTTP는 웹에서 사용)
-   TCP 사용
-   Stateless(비상태)
    -   HTTP 에서는 서버는 클라이언트에 대한 어떠한 정보도 저장하지 않는다. 즉, 똑같은 요청을 하면 똑같은 객체를 다시 보냄.
-   Non-persistent Connection(비지속 연결)
    -   각 요구/응답 쌍 이후 TCP 연결이 끊어짐. 하나의 TCP 연결은 하나의 요청과 응답.
-   HTTP 는 Request / Response 수행
-   [HTTP Request Message and Response Message 더 알아보기](https://developerkim.tistory.com/46)

## Cookie

-   클라이언트의 상태를 저장하지 않는 특징을 갖고 있는 HTTP는 어떻게 사용자를 확인할까
-   Cookie를 사용해서 사용자를 추적.

1.  최초 HTTP Request 하면 서버가 사용자에 대한 쿠키 생성
2.  Client가 서버에 요청을 보내면 서버는 HTTP 응답 메시지에 'Set-cookie: ' 를 포함해서 응답.
3.  이후 Client는 HTTP Request에 Cookie를 포함해서 요청함

-   [쿠키와 세션의 차이는?](https://developerkim.tistory.com/47)

## Web Cache(Proxy Server)

-   Origin Web server을 대신하여 HTTP 요청을 처리. 자체적으로 객체의 사본을 저장 중

1.  Cient는 웹 캐시와 TCP 연결 후, HTTP Request
2.  Web Cache에 요청한 객체가 있으면 HTTP Response
3.  Web Cache에 없으면 웹 캐시는 Origin Server과 TCP 연결 후 HTTP Request
4.  Origin Server은 웹 캐시로 HTTP Response, 이후 웹 캐시는 객체 저장함.
5.  웹 캐시는 다시 Client로 전달

-   이렇기 때문에 캐시는 서버이자 클라이언트
-   사용이유
    -   클라이언트 요구에 대한 응답시간 감소
    -   웹 트래픽 줄이면서 모든 애플리케이션 성능 개선
-   그렇다면 저장되어 있는 객체가 Origin Server에서 변경된다면 ?
-   **조건부 GET (Conditional GET)** 을 통해서 최신 상태를 확인한다
-   If-Modified Since를 통해서 확인

## DNS(Domain Name Server)

-   인터넷 디렉터리 서비스이다
-   호스트의 이름을 IP주소로 변환하여 연결 할 수 있게 해준다
-   UDP를 사용하여 연결하고 포트번호 53번을 사용
-   제공해주는 기능

1.  Host Aliasing : 정식 호스트 이름 외에도 별칭 호스트를 사용해서 정식 호스트 이름을 얻을 수 있음
2.  부하 분산 : 인기가 많은 웹 사이트는 보통 여러 IP 주소를 갖고 있는데, 여러 IP 주소는 하나의 정식 호스트 이름과 연결 되어있다. DNS는 이런 IP들의 집합을 갖고 있는데 요청이 들어오면 순환 방식으로 응답을 하기 때문에 트래픽을 분산 시킬 수 있다.

[DNS 알아보기](https://developerkim.tistory.com/48 "DNS 알아보기")
