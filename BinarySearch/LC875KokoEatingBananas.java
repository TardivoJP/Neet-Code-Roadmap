class KokoEatingBananas {
    public static void main(String[] args) {
        int[] testcase1 = {3,6,7,11};
        int testh1 = 8;

        int[] testcase2 = {30,11,23,4,20};
        int testh2 = 5;

        int[] testcase3 = {30,11,23,4,20};
        int testh3 = 6;

        System.out.println(minEatingSpeed(testcase1, testh1));
        System.out.println(minEatingSpeed(testcase2, testh2));
        System.out.println(minEatingSpeed(testcase3, testh3));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for(int i=1; i<piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

        int leftPtr = 1;
        int rightPtr = max;

        int time = 0;
        int best = rightPtr;

        while(leftPtr <= rightPtr){
            int middle = (rightPtr - leftPtr) / 2 + leftPtr;

            outerloop:
            for(int i=0; i<piles.length; i++){
                int cur = piles[i];

                if(cur - middle <= 0){
                    time++;
                }else{
                    time += (int) Math.ceil((double) cur / middle);
                }

                if(time > h){
                    break outerloop;
                }
            }

            if(time <= h){
                best = middle;
                time = 0;
                rightPtr = middle - 1;
            }else{
                leftPtr = middle + 1;
                time = 0;
            }
        }

        return best;
    }
}