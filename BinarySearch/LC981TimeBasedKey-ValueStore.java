import java.util.ArrayList;
import java.util.HashMap;

class TimeMap {
    public static void main(String[] args){
        TimeMap obj = new TimeMap();

        /* obj.set("foo","bar",1);

        System.out.println(obj.get("foo",1));
        System.out.println(obj.get("foo",3));

        obj.set("foo","bar2",4);

        System.out.println(obj.get("foo",4));
        System.out.println(obj.get("foo",5)); */


        obj.set("love","high",10);
        obj.set("love","low",20);

        System.out.println(obj.get("love",5));
        System.out.println(obj.get("love",10));
        System.out.println(obj.get("love",15));
        System.out.println(obj.get("love",20));
        System.out.println(obj.get("love",25));
    }

    public static class Pair{
        String val;
        int time;

        public Pair(String val, int time){
            this.val = val;
            this.time = time;
        }
    }

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!this.map.containsKey(key)){
            this.map.put(key, new ArrayList<>());
            this.map.get(key).add(new Pair(value, timestamp));
        }else{
            this.map.get(key).add(new Pair(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!this.map.containsKey(key)){
            return "";
        }else{
            if(this.map.get(key).size() == 0){
                return "";
            }else{
                return closestTimestamp(this.map.get(key), timestamp);
            }
        }
    }

    private String closestTimestamp(ArrayList<Pair> list, int timestamp){
        int left = 0;
        int right = list.size() - 1;
        String value = "";

        while(left <= right){
            int middle = (left + right) / 2;

            if(timestamp == list.get(middle).time){
                return list.get(middle).val;
            }      

            if(list.get(middle).time > timestamp){
                right = middle - 1;
            }else{
                value = list.get(middle).val;
                left = middle + 1;
            }
        }

        return value;
    }
}