우리는 웹 브라우저에 특정 주소로 접속하기 위해서 호스트 이름으로 접속을 한다([www.naver.com](http://www.naver.com) 처럼)

하지만 호스트 이름으로는 해당 호스트의 위치를 알 수 없기 때문에 호스트 이름을 IP 주소로 변환해주는 절차가 필요하다.

그러한 임무를 수행하는 것이 바로 DNS(Domain Name Server)이다.

---

## DNS(Domain Name Server)란?

-   호스트 이름을 IP주소로 변환해준다
-   계층형으로 이루어져있고 UDP프로토콜을 사용한다
    -   UDP 프로토콜을 사용하는 이유는 DNS에서 보내지는 데이터의 크기는 매우 작다(Name, IP Address). 그렇기 때문에 UDP 프로토콜을 사용해도 데이터가 유실 될 확률이 적을 뿐만 아니라 유실 되어도 빠르게 다시 요청할 수 있다. 또한 DNS는 준비동작이기에 빠르게 가져오는것이 효율적이다. 준비단계가 실제 메인 단계와 비슷하거나 더 오래 걸린다면 존재의 의미가...

---

## DNS 구조

DNS 서버가 한곳에 하나만 있다면 여러가지 문제가 생길 수 있다.

우선 Single Point Failure이 일어날 수 있다.

또한 트래픽양이 단일 DNS 서버에 집중되기 때문에 부하가 많이 생긴다. 게다가 서버의 위치가 누구에게나 가깝지는 않다.

특정 클라이언트에게는 아주 멀리 있을 수 있기 때문에 많은 지연이 생길 수 있다.

이런 이유에서 DNS는 계층형으로 분산되어있다.

계층의 구조는 3개의 단계로 나뉘어져있다.

1.  Root DNS Server
    -   루트 서버는 TLD 서버의 IP 주소를 제공
2.  Top-level DNS Server
    -   책임 DNS 서버에 대한 IP 주소 제공
3.  Authoriative DNS Server
    -   각 기관별로 자신의 책임 DNS 서버를 갖고 있을 수 있고 IP주소로 매핑하는 공개적 DNS 레코드를 제공해야함

---

## DNS 질의 과정

DNS Client는 우선 자신의 local 에 접속하고자 하는 IP주소가 있는지 확인할 것이다. 

만약 존재한다면 바로 연결을 시도할 것이다.

하지만 그렇지 않다면 아래의 과정을 따르게 된다

(www.example.com 으로 접속을 가정)

1\. 클라이언트(요청자)는 자신의 Local DNS Server에 해당 IP주소를 알고 있는지 질의할 것이다.

이것을 재귀적 질의라고 한다. 자신을 대신하여 필요한 매핑을 Local DNS Server에게 요구하고 있기 때문이다.

2\. Local DNS Server는 Root DNS Server로 질의한다. Root DNS Server는 com을 보고 com을 가진 Top-level Domain DNS Server로 질의할 것이다.

3\. TLD DNS Server은 example.com 을 확인하고 example.com을 가진 Authoritative DNS Server으로 요청을 보내게 된다.

DNS Server의 응답은 로컬 DNS Server으로 응답되기 때문에 반복적 질의이다.
