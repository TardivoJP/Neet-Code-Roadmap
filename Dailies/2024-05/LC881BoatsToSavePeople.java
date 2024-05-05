import java.util.Arrays;

class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people1 = {1,2};
        int limit1 = 3;

        int[] people2 = {3,2,2,1};
        int limit2 = 3;

        int[] people3 = {3,5,3,4};
        int limit3 = 5;

        int[] people4 = {5,1,4,2};
        int limit4 = 6;

        int[] people5 = {3,8,7,1,4};
        int limit5 = 9;

        int[] people6 = {25};
        int limit6 = 50;

        System.out.println(numRescueBoats(people1, limit1)); //expected 1
        System.out.println(numRescueBoats(people2, limit2)); //expected 3
        System.out.println(numRescueBoats(people3, limit3)); //expected 4
        System.out.println(numRescueBoats(people4, limit4)); //expected 2
        System.out.println(numRescueBoats(people5, limit5)); //expected 3
        System.out.println(numRescueBoats(people6, limit6)); //expected 1
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;

        int left = 0;
        int right = people.length - 1;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                answer++;
                left++;
                right--;
            }else{
                answer++;
                right--;
            }
        }

        return answer;
    }
}