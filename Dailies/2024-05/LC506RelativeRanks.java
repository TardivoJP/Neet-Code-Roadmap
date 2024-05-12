import java.util.Comparator;
import java.util.PriorityQueue;

class LC506RelativeRanks {
  public static void main(String[] args) {
    int[] input1 = {5,4,3,2,1};
    int[] input2 = {10,3,8,9,4};
    int[] input3 = {1,3,2,5,4};
    
    String [] output;
    
    output = findRelativeRanks(input1); // expected Gold Medal Silver Medal Bronze Medal 4 5 
    printStrArr(output);
    
    output = findRelativeRanks(input2); // expected Gold Medal 5 Bronze Medal Silver Medal 4
    printStrArr(output);
    
    output = findRelativeRanks(input3); // expected 5 Bronze Medal 4 Gold Medal Silver Medal
    printStrArr(output);
  }
  
  public static void printStrArr(String[] arr){
    for(String s : arr){
      System.out.print(s + " ");
    }
    System.out.println();
  }

  public static class Athlete{
    int score;
    int arrayIdx;

    public Athlete(int score, int arrayIdx){
      this.score = score;
      this.arrayIdx = arrayIdx;
    }
  }
  
  public static String[] findRelativeRanks(int[] score) {
    PriorityQueue<Athlete> pq = new PriorityQueue<>(Comparator.comparingInt((Athlete a) -> a.score).reversed());

    for(int i=0; i<score.length; i++){
      pq.add(new Athlete(score[i], i));
    }

    String[] answer = new String[score.length];
    int count = 1;
    
    while(!pq.isEmpty()){
      switch(count){
        case 1:
          answer[pq.poll().arrayIdx] = "Gold Medal";
          break;
        case 2:
          answer[pq.poll().arrayIdx] = "Silver Medal";
          break;
        case 3:
          answer[pq.poll().arrayIdx] = "Bronze Medal";
          break;
        default:
          answer[pq.poll().arrayIdx] = Integer.toString(count);
          break;
      }
      
      count++;
    }
    
    return answer;
  }
}