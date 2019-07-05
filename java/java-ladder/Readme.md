#  사다리 게임

## 목적
- 레벨1이 끝난 시점에 다시 한번 만들어보기 
    - 지난 미션 코드 : https://github.com/dpudpu/java-ladder 
- git 연습 
- Stream 연습 (for 사용x)
- TDD 연습
- 3시간 안에 끝내기 (설계 외) 

<br>

## 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
  
#### 실행 결과  
- 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.

```text
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

사다리 결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 3000
crong : 꽝
jk : 5000
```

<br>

# 기능 구현 목록

1. 참여할 사람 이름 입력 
   - 쉼표로 구분한다.
   - 예외처리
2. 플레이어 인스턴스 만들기
3. 보상 입력
   - 쉼표로 구분한다.
4. 보상 인스턴스 만들기
5. 사다리 높이 입력 
6. 사다리 인스턴스 만들기 
7. 실행 결과 구하기 



## 구현할 클래스 

### domain

- Height (사다리의 높이)
  - [예외처리] 1 이상 
- Position
  - [예외처리] 1 이상
  - previous()
  - next()
- Player 
  - [예외처리] 5자 이하 
  - [예외처리] 공백  불가 
  - [예외처리] null 불가
  - Position, name을 가진다.
- Players
  - [예외처리] size 2 이상
- Rewards
  - [예외처리] Players의 size와 같다
  - Map<Position, String> 포지션과 이름을 가진다.
- Ladder
  - Height, List<Line>을 상태로 가진다. 
  - Players, Rewards를 받아서 Result를 생성해준다.
- Line
  - width(Players.size)만큼 Direction 생성
- Direction  (enum)
  - 첫번째 Direction 왼쪽은 false, 마지막 Direction 오른쪽은 false
  - 연속 true면 안 된다.
    - 이 전 Direction이 true면 다음은 무조건 false
- Result

### generator

- LinesGenerator
- DirectionsGenerator
- 