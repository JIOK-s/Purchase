# 지옥이들의 쇼핑몰 프로젝트
## 개발환경
- JAVA ver.11.0.13
- DB : mysql 8.0.32
- Spring boot : ver.2.7.10

## ERD
### 매입파트
<img src="img/purchase-erd.png"/>

## 발생한 문제와 해결
- 문제
  - 유저상품정보를 상속받는 차량상품과 일반상품이 상속되지 않는 문제 발생
- 해결
  - @builder가 상속되지 않는 점을 파악하여 어노테이션을 수정

## 회의록
[링크] readmeDir/meetingLog/README.md
