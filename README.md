# TestCase ADMIN 서버

------

## ![imge](https://img.shields.io/badge/ProjectType-TeamProject-green) ![imge](https://img.shields.io/badge/Language-Java-yellow) ![imge](https://img.shields.io/badge/TOOL-STS-green)

## 프로그램 소개 :thumbsup:

- 시험기간 동기들과 예상 시험문제와 답안지를 만들어 카카오톡 단체방에 서로 공유하여 풀던 기억을 되
  살려, 누구나 쉽게 문제를 내고 푸는 퀴즈 앱을 제작하기로 결심
- 누구나 쉽게 문제를 등록하고 풀어볼 수 있으며 더불어학습능력향상과 시험에 대비하는 능력을 키울
  수 있을 것으로 예상됨.
- application.yml 파일은 직접 resources 폴더에 생성해야 합니다.

## 주요 기술 요소

- SpringBoot + JPA + MySQL + Maven 을 이용한 프로젝트입니다.
- JWT 엑세스 토큰을 이용하여 로그인을 처리하였습니다.
- 순환 참조 방지를 위하여 @JsonIgnoreProperties, @JsonBackReference를 사용하였습니다.
- Swaager를 이용하여 RESTful API를 문서화하였습니다.
- Spring Security를 이용하여 사용자의 권한에 따라 접근 가능한 페이지를 나누었습니다.
- DB와 OOP의 불일치성을 해결하기 위하여 JPA를 사용하였습니다.

## 전체 시스템 구조도

![image](https://user-images.githubusercontent.com/50865982/99224982-a2343500-282a-11eb-9eb2-69dfadd54366.png)



------

## 프로그램 기능소개

|                 기능 명                 |                          기능 설명                           |
| :-------------------------------------: | :----------------------------------------------------------: |
|           전체 회원 조회            |          전체 회원을 조회할 수 있습니다.          |
|             전체 게시글 및 문제 조회              | 전체 게시글 및 문제를 조회할 수 있습니다.  |
|         회원 탈퇴          |    관리자는 회원을 탈퇴시킬 수 있습니다.     |
|         게시글 및 문제 삭제         | 관리자는 게시글 및 문제를 삭제할 수 있습니다. |


