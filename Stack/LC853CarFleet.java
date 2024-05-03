import java.util.Arrays;
import java.util.Comparator;

class CarFleet {
    public static void main(String[] args) {
        int[] testecase1pos = {10,8,0,5,3};
        int[] testecase1speed = {2,4,1,1,3};
        int testecase1target = 12;

        int[] testecase2pos = {3};
        int[] testecase2speed = {3};
        int testecase2target = 1;

        int[] testecase3pos = {0,2,4};
        int[] testecase3speed = {4,2,1};
        int testecase3target = 100;

        int[] testecase4pos = {8,3,7,4,6,5};
        int[] testecase4speed = {4,4,4,4,4,4};
        int testecase4target = 10;

        int[] testecase5pos = {8,12,16,11,7};
        int[] testecase5speed = {6,9,10,9,7};
        int testecase5target = 17;

        int[] testecase6pos = {11,14,13,6};
        int[] testecase6speed = {2,2,6,7};
        int testecase6target = 16;

        int[] testecase7pos = {5,26,18,25,29,21,22,12,19,6};
        int[] testecase7speed = {7,6,6,4,3,4,9,7,6,4};
        int testecase7target = 31;

        int[] testecase8pos = {21,19,18,12};
        int[] testecase8speed = {4,6,6,7};
        int testecase8target = 31;

        carFleet(testecase1target, testecase1pos, testecase1speed);
        carFleet(testecase2target, testecase2pos, testecase2speed);
        carFleet(testecase3target, testecase3pos, testecase3speed);
        carFleet(testecase4target, testecase4pos, testecase4speed);
        carFleet(testecase5target, testecase5pos, testecase5speed);
        carFleet(testecase6target, testecase6pos, testecase6speed);
        carFleet(testecase7target, testecase7pos, testecase7speed);
        carFleet(testecase8target, testecase8pos, testecase8speed);
    }

    public static class Car{
        int position;
        int speed;
        double steps;

        public Car(int position, int speed, double steps){
            this.position = position;
            this.speed = speed;
            this.steps = steps;
        }
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];

        System.out.println(target);

        for(int i=0; i<position.length; i++){
            cars[i] = new Car(position[i], speed[i], (((double) target - (double) position[i]) / (double) speed[i]));
        }

        Arrays.sort(cars, Comparator.comparingInt(car -> car.position));
        
        Car pivot = cars[position.length-1];
        int answer = 1;        

        for(int i=position.length-2; i>=0; i--){
            if(cars[i].steps > pivot.steps){
                pivot = cars[i];
                answer++;
            }
        }

        return answer;
    }
}