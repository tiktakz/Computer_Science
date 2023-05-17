### TCP 3-way Handshake

-   TCP가 연결지향형인 이유는 데이터를 보내기 전, A와 B는 3-way handshake를 통해 연결을 확인하기 때문이다
-   연결이 수립된것을 확인하고 데이터를 받을 준비가 되었는지 확인

### 과정
![다운로드 (2)](https://github.com/tiktakz/TIL/assets/86278689/f1babcb5-f76c-49be-999e-b5d1e6696fa3)

1.  SYN 비트를 1로 설정한 특별한 SYN 세그먼트와 최초의 임의의 순서번호(client\_isn)를 선택하여 TCP 세그먼트에 넣어 연결을 요청
2.  서버역시 SYN=1 비트와 client가 보낸 시퀀스번호(client\_isn)에 +1 한 값을 ACK 해준다. 거기에 더해 서버의 시퀀스를 보낸다(server\_isn)
3.  클라이언트는 연결을 승인하며 SYN=0으로 보내고 server\_isn + 1 값을 보내며 연결 승인을 확인. 이 단계에서는 세그먼트 내 데이터를 포함시킬 수 있다.
