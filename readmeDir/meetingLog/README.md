## 업무일지

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