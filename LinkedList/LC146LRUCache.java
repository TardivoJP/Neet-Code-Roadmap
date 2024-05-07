import java.util.HashMap;

class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(){}

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    int capacity;
    HashMap<Integer, Node> cache;
    Node leastUsed;
    Node mostUsed;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.leastUsed = new Node();
        this.mostUsed = new Node();

        this.mostUsed.next = this.leastUsed;
        this.leastUsed.prev = this.mostUsed;
    }

    public void insert(Node node){
        Node temp = this.mostUsed.next;

        this.mostUsed.next = node;
        node.prev = this.mostUsed;
        node.next = temp;
        temp.prev = node;
    }

    public void remove(Node node){
        Node previousNode = node.prev;
        Node nextNode = node.next;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)){
            return -1;
        }

        remove(this.cache.get(key));
        insert(this.cache.get(key));

        return this.cache.get(key).val;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            remove(this.cache.get(key));
            this.cache.remove(key);
        }

        this.cache.put(key, new Node(key, value));
        insert(this.cache.get(key));

        if(this.cache.size() > capacity){
            Node leastUsed = this.leastUsed.prev;
            remove(this.cache.get(leastUsed.key));
            this.cache.remove(leastUsed.key);
        }
    }
}