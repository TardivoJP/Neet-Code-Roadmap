import java.util.Arrays;

class StudentAttendanceRecordTwo {
    public static void main(String[] args) {
        System.out.println(checkRecord(2)); // expected 8
        System.out.println(checkRecord(1)); // expected 3

        // These two don't seem to work on my enviroment but they are accepted on leetcode
        //System.out.println(checkRecord(10101)); // expected 183236316
        //System.out.println(checkRecord(99995)); // expected 969766675
    }

    public static int MOD = 1000000007;

    public static int checkRecord(int n) {
        int[][][] memo = new int[n + 1][2][3];
        for(int[][] array2D : memo){
            for(int[] array1D : array2D){
                Arrays.fill(array1D, -1);
            }
        }
        return generateRecords(0, n, 0, 0, memo);
    }

    public static int generateRecords(int size, int n, int numberAs, int consecutiveLs, int[][][] memo){
        if(size >= n){
            return 1;
        }

        if(memo[size][numberAs][consecutiveLs] != -1){
            return memo[size][numberAs][consecutiveLs];
        }

        int count = 0;

        if(numberAs < 1){
            count = generateRecords(size + 1, n, numberAs + 1, 0, memo) % MOD;
        }

        if(consecutiveLs < 2){
            count = (count + generateRecords(size + 1, n, numberAs, consecutiveLs + 1, memo)) % MOD;
        }

        count = (count + generateRecords(size + 1, n, numberAs, 0, memo)) % MOD;

        memo[size][numberAs][consecutiveLs] = count;

        return count;
    }
}