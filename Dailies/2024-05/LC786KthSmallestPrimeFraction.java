import java.util.Comparator;
import java.util.PriorityQueue;

class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] inpu1 = {1,2,3,5};
        int k1 = 3;

        int[] inpu2 = {1,7};
        int k2 = 1;

        int[] result;

        result = kthSmallestPrimeFraction(inpu1, k1); // expected 2 5
        printArr(result);

        result = kthSmallestPrimeFraction(inpu2, k2); // expected 1 7
        printArr(result);
        
    }

    public static void printArr(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static class Fraction {
        double value;
        int i;
        int j;

        public Fraction(double value, int i, int j){
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Fraction> queue = new PriorityQueue<>(Comparator.comparingDouble((Fraction o) -> o.value));

        for(int i=0; i<arr.length - 1; i++){
            queue.add(new Fraction(((double) arr[i] / arr[arr.length-1]), i, arr.length-1));
        }

        while(k > 1){
            Fraction cur = queue.poll();

            if(cur.j - 1 > cur.i){
                queue.add(new Fraction(((double) arr[cur.i] / arr[cur.j - 1]), cur.i, cur.j - 1));
            }

            k--;
        }

        return new int[]{arr[queue.peek().i],arr[queue.peek().j]};
    }
}