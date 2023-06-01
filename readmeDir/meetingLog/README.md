## 업무일지
- 2023-06-01
  - jpaRepository와 custumRepository를 모두 사용할 수 있게 수정
  - membersService test 및 save 구현


- 2023-05-25
  - Members Repository 생성 및 save, findByMbrId 함수 작성
  - Hello class Test 코드 수정
  - ERD Members 테이블 데이터 타입 작성
  - ERD Members 테이블 상세주소 컬럼 추가


- 2023-05-23
  - jacoco 설치 및 테스트
    - 라인 커버리지 80%를 목표로 설정
    - main() 메소드 커버할 수 있도록 테스트 케이스를 추가한다

        ```java
        public class TestMainMethod {
            @Test
            public void testMainMethod() {
                String[] args = {};
                클래스명.main(args); // main() 메소드를 호출
            }
        }
        ```

    - enum의 getCode() 커버할 수 있도록 테스트 케이스 수정
    - QClass 및 lombok 테스트 제외


- 2023-05-13
  - 매입 entity 작성 완료
  - entity 테스트 코드 작성 완료
  

- 2023-05-05
  - 코드 PULL REQUEST시 CI, CD를 통해 자동 서버 배포되도록 설정 및 테스트 완료
  - 시세, 평가사 테이블 생성
    - 연관 관계 수정
    - 테스트 코드 작성 및 수정

  
- 2023-05-02
  - application에서 db설정 분리
  - travis 서버에서 jar, script, appspect만 ec2로 전달하도록 수정
  - 자동 배포하도록 deploy.sh 생성


- 2023-04-30
  - travis ci - s3 연동
    - 개인 계정이 아닌 organization에서 진행되게 수정
    - pr말고 push 될 때 build 되게끔 수정
    - deploy될 때 master branch가 아닌 경우(develop)에도 deploy가 되게 진행
  - travis ci - codedeploy연동


- 2023-04-25
  - github에 push할 때, travis ci를 이용하여 자동 build할 수 있게 세팅
  - IAM 사용자 생성 후 엑세스 키와 비밀 엑세스 키를 TRAVIS에 environment variable에 세팅


- 2023-04-18
  - EC2 deploy.sh 작성 완료
  - EC2 서버에서 배포 완료


- 2023-04-15
  - jpa 설정(application.yml) 수정
    - ddl-auto 설정 변경 및 show-sql 설정 변경 
  - test코드 변경
  - RDS 사용자 ID 생성 및 권한 부여
  - EC2 환경에서 배포(진행중)


- 2023-04-11
  - AWS EC2 환경 구축
    - java 설치
    - time_zone 변경
    - hostname 및 hosts 변경
  - AWS RDS 환경 구축
    - RDS 생성
    - RDS 로컬 CONNECTION


- 2023-04-08
    - AWS EC2 환경 구축
    - 개발 워크플로우 작성
    - 업무 내용 노션 정리