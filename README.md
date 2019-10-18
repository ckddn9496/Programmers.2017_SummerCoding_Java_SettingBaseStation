# Programmers.2017_SummerCoding_Java_SettingBaseStation

## 프로그래머스 > 코딩테스트 연습 > 2017 서머코딩 > 기지국설치

### 1. 문제설명

문제: https://programmers.co.kr/learn/courses/30/lessons/12979

input으로 아파트의 숫자 `n`, 이미 설치되있는 기지국의 위치 `int[] stations`, 기지국의 전파도달거리 `w`가 들어온다. `n`개의 아파트에 모두 전파가 닿기 위해 추가해야할 기지국의 갯수를 return하는 문제.

### 2. 풀이

처음 `stations`를 탐색하며 전파가 도달하지 못하는 연속된 길이를 구한다. 이후 연속된 길이를 안다면 범위가 `w`인 기지국이 맡을 수 있는 거리는 `2 * w + 1`이므로 길이데 대해 몇개의 기지국이 필요한지는 간단한 나눗셈으로 알 수 있다.

```java

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        List<Integer> blanks = new ArrayList<>();
        
        int sIdx = 0;
        for (int i = 0; i < stations.length; i++) {
        	int eIdx = stations[i] -1 - w;
        	if (sIdx < eIdx) {
        		blanks.add(eIdx - sIdx);
        	}
        	sIdx = stations[i] - 1 + w + 1;
        }
        
        if (sIdx < n) {
        	blanks.add(n - sIdx);
        }
        
        int width = w*2 + 1;
        for (int i = 0; i < blanks.size(); i++) {
        	answer += (blanks.get(i) - 1)/width + 1;
        }

        return answer;
    }
}

```
