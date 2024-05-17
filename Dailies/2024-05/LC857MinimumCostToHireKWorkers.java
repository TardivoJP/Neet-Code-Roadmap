import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinimumCostToHireKWorkers {
    public static void main(String[] args) {
        int[] quality1 = {10,20,5};
        int[] wage1 = {70,50,30};
        int k1 = 2;

        int[] quality2 = {3,1,10,10,1};
        int[] wage2 = {4,8,2,2,7};
        int k2 = 3;

        int[] quality3 = {4,4,4,5};
        int[] wage3 = {13,12,13,12};
        int k3 = 2;

        System.out.println(mincostToHireWorkers(quality1, wage1, k1)); // expected 105.0
        System.out.println(mincostToHireWorkers(quality2, wage2, k2)); // expected 30.66667
        System.out.println(mincostToHireWorkers(quality3, wage3, k3)); // expected 26.00000
    }

    public static class Worker{
        int quality;
        double ratio;

        public Worker(int quality, double ratio){
            this.quality = quality;
            this.ratio = ratio;
        }
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Worker[] workers = new Worker[quality.length];

        for(int i=0; i<quality.length; i++){
            workers[i] = new Worker(quality[i], (double) wage[i] / quality[i]);
        }
        Arrays.sort(workers, Comparator.comparingDouble((Worker w) -> w.ratio));


        double min = Double.MAX_VALUE;
        double qualitySum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Worker w : workers){
            qualitySum += w.quality;
            pq.add(w.quality);

            if(pq.size() > k){
                qualitySum -= pq.poll();
            }

            if(pq.size() == k){
                min = Math.min(min, qualitySum * w.ratio);
            }
        }

        return min;
    }
}