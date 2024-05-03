class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    public static void main(String[] args){
        /* int[] testcase = {2, 1, 3, 4};
        int k = 1; */

        int[] testcase = {2, 0, 2, 0};
        int k = 0;

        System.out.println(minOperations(testcase, k));
    }

    public static int minOperations(int[] nums, int k) {
        int arrayXOR = 0;

        for(int i=0; i<nums.length; i++){
            arrayXOR = arrayXOR ^ nums[i];
        }

        String arrBinary = Integer.toBinaryString(arrayXOR);
        String kBinary = Integer.toBinaryString(k);

        if(arrBinary.length() > kBinary.length()){
            kBinary = normalize(kBinary, arrBinary.length());
        }else if(arrBinary.length() < kBinary.length()){
            arrBinary = normalize(arrBinary, kBinary.length());
        }

        int countFlips = 0;

        for(int i=0; i<arrBinary.length(); i++){
            if(arrBinary.charAt(i) != kBinary.charAt(i)){
                countFlips++;
            }
        }

        return countFlips;
    }

    public static String normalize(String str, int targetSize){
        StringBuilder sb = new StringBuilder();

        sb.append(str);

        while(sb.length() < targetSize){
            sb.insert(0, "0");
        }

        return sb.toString();
    }
}
