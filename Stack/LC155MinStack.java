class MinStack {
        class Node{
            int data;
            int min;
            Node next;

            public Node(int data, int min){
                this.data = data;
                this.next = null;
                this.min = min;
            }
        }

        Node head;

        public MinStack() {
            this.head = null;
        }
        
        public void push(int val) {
            if(this.head == null){
                this.head = new Node(val, val);
            }else{
                int min = this.head.min;
                if(val < this.head.min){
                    min = val;
                }

                Node newNode = new Node(val, min);
                newNode.next = this.head;
                this.head = newNode;
            }
        }
        
        public void pop() {
            this.head = this.head.next;
        }
        
        public int top() {
            return this.head.data;
        }
        
        public int getMin() {
            return this.head.min;
        }
}