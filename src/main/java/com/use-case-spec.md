[유스케이스 명세서]


## 프로젝트 등록

프로젝트 정보를 등록한다.

### 액터 (현재 유스케이스를 실행하는 액터)
- 주 액터
    - 회원 : PMS 시스템에 가입되어 있는 사람
    - 관리자 : PMS 시스템을 관리하는 사람
- 보조 액터
    - 없음

    
### 성공 시나리오

- 회원이 '로그인' 버튼을 클릭한다.
    - 시스템은 로그인 화면을 제공한다.
- 회원은 아이디와 비밀번호를 적고 '다음' 버튼을 클릭한다.
    - 시스템은 로그인이 된 화면을 보여준다.
- 만약 비회원이라면 '회원 가입'을 한다.
    - 시스템은 회원 가입 화면을 보여준다.
    - 회원은 가입 정보를 다 입력하고 '생성' 버튼을 누른다.
        -시스템은 회원 가입 확인 메세지를 보여준다.
- 회원이 '검색'을 누른다.
    - 시스템은 검색 화면을 보여준다.
        - 회원이 원하는 검색하고 싶은 카테고리(지역, 언어, 목적, 수준)을 선택하고 '검색' 버튼을 누른다.
            - 시스템은 회원이 원하는 검색에 맞춰 게시판을 보여준다.
                - 회원이 원하는 게시물 하나를 클릭한다.
                    - 시스템은 그 게시물을 보여준다. 
                - 회원이 게시물 작성을 위하여 '글쓰기' 버튼을 누른다.
                    - 시스템은 게시물을 작성하는 화면을 보여준다.
                         - 회원이 게시물 작성을 마치고 글을 '등록' 버튼을 클릭한다.
                            - 시스템은 게시물을 등록 확인 메세지를 보여준다.
                - 회원이 게시물을 수정하기 위해 자신이 올린 게시물을 클릭하고 '수정' 버튼을 누른다.
                    - 시스템은 글을 수정할 수 있는 화면(게시물 작성 화면)을 보여준다.
                        - 회원이 글 수정 후 '수정' 버튼을 누른다.
                            - 시스템은 게시물 수정 확인 메세지를 보여준다.
                - 회원이 게시물을 삭제하기 위해 자신이 올린 게시물을 클릭하고 '삭제' 버튼을 누른다.
                    -시스템은 정말 삭제하시겠습니까라는 확인 메세지를 보여준다.
                        - 회원이 '취소' 버튼을 누른다.
                            - 시스템은 이전 화면으로 돌아간다.
                        - 회원이 '삭제' 버튼을 누른다.
                            - 시스템은 게시물 삭제 확인 메세지를 보여준다.

- 관리자는 '로그인' 버튼을 클릭한다.
    - 시스템은 로그인 화면을 제공한다.
- 관리자는 아이디와 패스워드를 적고 '다음' 버튼을 눌러준다.
    - 시스템은 관리인 전용 로그인 확인 메세지를 보여준다.
- 관리자는 소개글에 들어간다.
    - 시스템은 소개글 화면을 보여준다.
        - 관리자는 글을 쓰거나 수정하기 위하여 '수정' 버튼을 누른다.
            - 시스템은 글을 수정할 수 있는 화면을 보여준다.
                - 관리자는 글을 다 쓰고 나서 '수정' 버튼을 누른다.
                    - 시스템은 수정 확인 메세지를 보여준다.
- 관리자는 공지사항에 들어간다.
    - 시스템은 공지사항 화면과 목록을 보여준다.
        - 관리자는 공지사항을 새로 작성하기 위해 '글쓰기' 버튼을 누른다.
            - 시스템은 글을 수정하는 창을 제공한다.
                - 관리자는 글을 작성하고 나서 '등록' 버튼을 누른다.
                    - 시스템은 공지사항 글 등록 확인 메세지를 보여준다.
        - 관리자는 공지 사항을 수정하기 위하여 자신의 게시글에서 '수정' 버튼을 누른다.
            - 시스템은 수정할 수 있는 화면을 보여준다.
                - 관리자는 수정한 후 '수정' 버튼을 누른다.
                    - 시스템은 수정 완료 확인 메세지를 보여준다.
        - 관리자는 공지 사항을 삭제하기 위하여 '삭제' 버튼을 누른다.
            - 시스템은 정말 삭제하시겠습니까라는 확인 메세지를 클릭한다.
                - 관리자는 '취소' 버튼을 누른다.
                    - 시스템은 이전 화면으로 돌아간다.
                - 관리자는 '삭제' 버튼을 누른다.
                    - 시스템은 공지 사항을 삭제 확인 메세지를 보여준다.
- 관리자는 관리자만 접근 가능한 회원 관리 목록에 들어간다.
    - 시스템은 회원 관리 목록을 보여준다.
    - 관리자는 회원 가입이 된 회원들의 목록을 확인할 수 있다.
        


### 예외 시나리오

- DBMS 접속 불가,
    - 시스템은 저장 실패 메세지를 출력한다.
- 사용자 로그인이 타임아웃,
    - 시스템은 로그인 화면으로 간다.
- 로그인에서 중복되지 않은 아이디일 경우,
    - 중복 확인 메세지를 출력한다.
- 로그인에서 8자리 미만의 암호를 입력한 경우,
    - 비밀번호 확인 메세지를 출력한다.
- 로그인 정보가 올바르지 않을 경우,
    - 로그인 실패 메세지를 출력한다.
- 검색한 게시물의 결과가 없을 경우,
    - '결과 없음'의 메세지를 출력한다.
- 게시물 작성시 제시된 카테고리를 전부 작성하지 않을 경우,
    - 카테고리를 모두 선택해달라는 메세지를 출력한다.
- 글을 수정하는 도중 강제로 화면 이동을 하려고 할 때,
    - 경고 메세지를 출력한다.