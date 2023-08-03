import os
from operator import itemgetter, attrgetter

title_project = "# EveryDay - Practice"


sub_project = "### push 후 자동으로 README 수정 기능"

dic = {}

base_readme = f"""## 스터디 방향성 및 목표
> SSAFY 10기 15반 스터디 Org

## 😎 목차
1. [Members 및 진행방식](#Members)
2. [진행상황](#진행상황)
3. [스터디방법](#스터디-방법)

### Members

<table>
 <tr>
    <td align="center"><a href="https://github.com/rnrudejr9"><img src="https://avatars.githubusercontent.com/rnrudejr9" width="130px;" alt=""></a></td>
    <td align="center"><a href="https://github.com/SeokJuGo"><img src="https://avatars.githubusercontent.com/SeokJuGo" width="130px;" alt=""></a></td>
    <td align="center"><a href="https://github.com/JunJI97"><img src="https://avatars.githubusercontent.com/y0ungKim" width="130px;" alt=""></a></td>
    <td align="center"><a href="https://github.com/JunJI97"><img src="https://avatars.githubusercontent.com/JunJI97" width="130px;" alt=""></a></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/rnrudejr9"><b>구경덕</b></a></td>
    <td align="center"><a href="https://github.com/SeokJuGo"><b>고석주</b></a></td>
    <td align="center"><a href="https://github.com/y0ungKim"><b>김영진</b></a></td>
    <td align="center"><a href="https://github.com/JunJI97"><b>지준영</b></a></td>
  </tr>
  <tr> 
    <td align="center"><img src="https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=Java&logoColor=white"></td>
    <td align="center"><img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"><br/></td>
    <td align="center"><img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"><br/></td>
    <td align="center"><img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"><br/></td>
  </tr> 
    <tr> 
    <td align="center">
	    <ul><li>하루에 최소 1개문제 풀기</li></ul>
	    <ul><li>깃허브, 백준 잔디 기르기</li></ul>
	    <ul><li>solved.ac 골드1 달성</li></ul>
	    <ul><li>천천히 꾸준히 도전하기</li></ul>
	</td>
    <td align="center">
	    <ul><li>Daily 스트릭으로 코드 연습</li></ul>
	    <ul><li>자바 라이브러리 숙달</li></ul>
	    <ul><li>백준 기초 알고리즘 1,2, 중급 클리어하기</li></ul>
	    <ul><li>골드1달성하기</li></ul>
    </td>
    <td align="center">
	    <ul><li>최적화 알고리즘 탐색(Big-O, 속도, 메모리)</li></ul>
	    <ul><li>배운 것, 습득한 것 활용하여 구현해보기</li></ul>
	    <ul><li>타인의 코드와 비교하여 개선하기</li></ul>
    </td>
    <td align="center">
	    <ul><li> 백준 골드 입성</li></ul>
	    <ul><li> 주요 라이브러리 적응</li></ul>
	    <ul><li> 삼성 기출 풀이시간 단축(3h)</li></ul>
	    <ul><li> B형 도전하기</li></ul>
    </td>
  </tr> 
</table>

<br>
<br>

###  진행 방식
<table>
  <tr>
    <td>진행 기간</td>
    <td>2023년 7월 24일 ~ ing </td>
  </tr>
  <tr>
    <td>스터디 장소</td>
    <td>Online / 멀티캠퍼스 역삼</td>
  </tr>
  <tr>
    <td>정기 스터디 시간</td>
    <td>Online : 월 / 화 / 수 Offline : 금 07시 30분</td>
  </tr>
  <tr>
    <td>플랫폼</td>
    <td>백준 / solved.ac</td>
  </tr>
  <tr>
    <td>언어</td>
    <td><img src="https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=Java&logoColor=white"> 
  </tr>
</table>

<br/>
"""

end_readme = f"""
## 💁‍♂️ 스터디 방법

### 1️⃣ 커밋 규칙

| Type | 내용 |
|--|--|
| solved | 해결함 |
| fix | 수정 |
| refactor | 리펙토링 |
| docs | 문서관련 |

```
< TYPE > : < SUB >
< BLANK >
< DETAIL > 
```
```
❓(예시)
solved : P_피보나치수열_1103 해결

재귀함수 방식으로 접근하여 해결
```

### 2️⃣ 디렉토리 구조

* N : 해당일 수
* `본인별명`.`weekN`.`dayN` 순으로 디렉토리를 구성한다.

```
❓(예시)
koo.week1.day1
```

### 3️⃣ 파일명

* `P` _ `문제이름` _	`문제번호`  순으로 작성한다.
* 문제이름은 공백없이 붙여서 작성한다.
 ```
❓(예시) 
P_피보나치함수_1003.java
```

### 4️⃣ 깃 브랜치 구조

| 브랜치 명 | 포함될 내용 | 비고 |
|:----------|:----------:|----------:|
| master | 메인 브랜치 | main branch |
| solved | 해결완료 | sub branch |
| 각자 별명 | 개인 브랜치 | private | 

```
❓(예시) 
koo 브랜치 생성
```

### 5️⃣ 참여 방법
1. 깃 레포지토리 `fork`
2. `새로운 브랜치` 생성 ( 본인 별명 )
3. 원격저장소의 브랜치 생성확인
4. pull 하여 `로컬저장소`에서 관리
5. 풀이 한 소스코드를 `commit / push`
6. `PR` 실시
7. 코드리뷰
"""


class Problem:
    def __init__(self, id, week, day, filename, address):
        self.id = id
        self.week = week
        self.day = day
        self.filename = filename
        self.address = address

    def get_week(self):
        return self.week

    def get_day(self):
        return self.day

    def get_filename(self):
        return self.filename

    def __str__(self) -> str:
        return " | " + self.week + " | " + self.day + " | [" + self.filename + "](" + self.address + ")" + "|\n"


def print_files_in_dir(root_dir, prefix, problems):
    value = 1
    global dic
    try:
        for (root, dirs, files) in os.walk(root_dir):
            for filename in files:
                ext = os.path.splitext(filename)[-1]
                if ext == '.java':
                    print("%s %s" % (root, filename))
                    split_dir = root.split(prefix)
                    address = root.replace(prefix, "")
                    address += prefix + filename
                    if len(split_dir) >= 5:
                        username = str(split_dir[2])
                        print(dic)
                        week = str(split_dir[3])

                        if username in dic:
                            if week in dic[username]:
                                dic[username][week] += 1
                            else:
                                dic[username] = dict({week:1},**dic[username])
                        else:
                            dic[username] = dict({week: 1})
                            key = dic[username]
                            if key == None:
                                print("is none")
                            else:
                                dic[username] = dict({week:1})


                        day = str(split_dir[4])
                        filename = str(filename)
                        if week and day and filename:
                            problems.append(Problem(str(value), week, day, filename, address))
                            value += 1
    except PermissionError:
        pass


def make_info_header(name, dic):
    index = 0;
    info = f"{name}\n\n"
    info += f"| # | week | day |\n"
    info += f"|---|---|---| \n"
    for temp in dic:
        info += f"| {index + 1} | {temp[0]} | {temp[1]} / 3 | \n"

    print(info)
    return info


def make_info_data(problems):
    info = f"### 총 푼 문제수 = {len(problems)} 🎉\n\n"
    info += f"| # | week | day | problem |\n| ------------- | ------------- | ------------- | ------------- |\n"
    for index in range(0, len(problems)):
        temp = f"| {index + 1} {problems[index]}"
        info += temp

    info += """"""
    return info


if __name__ == "__main__":
    problems = []
    personal_dir = "../"
    prefix = "/"
    print_files_in_dir(personal_dir, prefix, problems)
    projects = sorted(problems, key=attrgetter('week', 'day'), reverse=False)

    header = ""
    printTarget = ""

    for temp in dic:
        dic_temp = sorted(dic[temp].items(), key=lambda item: item[0], reverse=False)
        print(dic_temp)
        header = make_info_header(temp, dic_temp)
        printTarget += header



    print(printTarget)

    info = make_info_data(projects)


    with open("../README.md", 'w', encoding='utf-8') as f:
        f.write(base_readme + "\n")
        f.write(title_project + "\n")
        f.write(sub_project + "\n")
        f.write(printTarget + "\n")
        f.write(end_readme + "\n")
        f.write(info)
        f.close()
