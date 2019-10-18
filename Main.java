import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int n = 11;
		int[] stations = {4, 11};
		int w = 1;
		// return 3
		
//		int n = 16;
//		int[] stations = {9};
//		int w = 2;
		// return 3
		
		System.out.println(new Solution().solution(n, stations, w));
	}

}

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