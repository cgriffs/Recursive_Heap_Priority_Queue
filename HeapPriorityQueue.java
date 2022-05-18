import java.util.ArrayList;

public class HeapPriorityQueue {
    private int size = 0;
    private ArrayList<Node> list = new ArrayList<>();

    public void insert(Node nn){
        this.list.add(nn);
        this.size++;this.heapifyUp(size -1);
    }

    public Node Remove() {
        if(this.isEmpty()) return null;
        Node ntr = this.list.get(0);
        this.list.set(0,this.list.get(this.size -1));
        this.list.remove(this.size -1);
        this.size--;
        this.heapifyDown(0);
        return ntr;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    private void heapifyUp(int i) {
        //recursive bottom up
        int parent = (i-1)/2;
        if(i !=0 && this.list.get(i).priority > this.list.get(parent).priority ) {
            Node temp = this.list.get(i);
            this.list.set(i, this.list.get(parent));
            this.list.set(parent, temp);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int i) {
        //recursive top down
        int largest = i;
        int left = 2*i+1;
        int right =2*i+2;
        if(left < size && this.list.get(left).priority > this.list.get(largest).priority)
            largest = left;
        if(right < size && this.list.get(right).priority > this.list.get(largest).priority)
            largest = right;

        if(largest!= i){
            Node temp = this.list.get(largest);
            this.list.set(largest, this.list.get(i));
            this.list.set(i, temp);
            heapifyDown(largest);
        }
    }

    public static void main(String[] args){
        HeapPriorityQueue q = new HeapPriorityQueue();

        Node n1 = new Node(10,"first");
        Node n2 = new Node(5,"second");
        Node n3 = new Node(8,"third");
        Node n4 = new Node(30,"fourth");
        Node n5 = new Node(0,"fifth");

        q.insert(n1);
        q.insert(n2);
        q.insert(n3);
        q.insert(n4);
        q.insert(n5);

        for(int i=0;i<26;i++){
            System.out.print(q.list.get(i).priority + " ");
        }
    }

}
