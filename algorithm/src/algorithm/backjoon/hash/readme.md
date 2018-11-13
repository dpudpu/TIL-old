
## 시간초과로 실패 목록
1. 정규표현식 사용해서 모두 비교
2. 직접 ChainHash 구현 
    - 번호의 앞자리로 해시코드 생성 후 버킷에 담음   
    ex) 1234 - table[1], 955 - table[9]
    
3. Sort 후 앞자리 같고 길이가 다르면 비교 
    - 정규표현식으로 비교 
    
    
## 해결 방법
- 실패의 가장 큰 이유는 Integer.parsInt로 첫자리를 정수로 바꿔서다. (그냥 문자로 비교)
  (그래도 BufferedReader > Scanner)
- 정규표현 대신 startsWith 사용
- 앞자리 추출방법 변경 split(" ")[0] -> charAt(0)
    
    
### 정리 
0. 정렬을 하고 나면 이중 for문을 사용하지 않아도 된다.
1. 문자열에서 문자 하나만 얻을 때는 
split(" ")[0] 보다 **charAt(0)** 이 더 빠르다. 
2760ms -> 1704ms 로 향상
2. parsInst 속도 많이 잡아먹는다.
3. startswith가 matches로 비교하는 것보다 아주 조금 더 빨랐다.

```java
boolean check = true;
            for (int i = 1; i < n && check; i++)
                check = !numbers[i].startsWith(numbers[i - 1]);
            System.out.println(check?"YES":"NO");
```