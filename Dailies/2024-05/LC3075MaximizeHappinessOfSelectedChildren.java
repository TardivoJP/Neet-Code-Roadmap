import java.util.*;

class LC3075MaximizeHappinessOfSelectedChildren {
  public static void main(String[] args) {
    int[] input1 = {1,2,3};
    int k1 = 2;
    
    int[] input2 = {1,1,1,1};
    int k2 = 2;
    
    int[] input3 = {2,3,4,5};
    int k3 = 1;
    
    System.out.println(maximumHappinessSum(input1, k1)); // expected 4
    System.out.println(maximumHappinessSum(input2, k2)); // expected 1
    System.out.println(maximumHappinessSum(input3, k3)); // expected 5
  }
  
  public static long maximumHappinessSum(int[] happiness, int k) {
    Arrays.sort(happiness);
    
    int decrement = 0;
    long answer = 0;
    
    for(int i=happiness.length - 1; i> happiness.length - k - 1; i--){
      if(happiness[i] - decrement <= 0){
        break;
      }
      
      answer += happiness[i] - decrement;
      decrement++;
    }
    
    return answer;
  }
}