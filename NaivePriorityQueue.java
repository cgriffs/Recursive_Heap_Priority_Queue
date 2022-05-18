import java.util.ArrayList;

public class NaivePriorityQueue {

    private int size = 0;
    private ArrayList<Node> list = new ArrayList<>();

    public void insert(Node nn){
        int index = -1;
        if (size == 0) this.list.add(0,nn);
        else{
            for(int i=0; i< size; i++){
                if(nn.getPriority() > list.get(i).getPriority()){
                    index = i;
                    break;
                }
            }
        }
        if(index==-1) index = size;
        this.list.add(index,nn);
        this.size++;
    }

    public Node Remove(){
        if (isEmpty()) return null;

        Node nodeToReturn = this.list.get(0);
        this.list.remove(0);
        this.size--;

        return nodeToReturn;
    }
    
    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public static void main(String[] args) {
        NaivePriorityQueue q = new NaivePriorityQueue();
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

        for(int i =0; i < 5; i++){
            Node node = q.Remove();
            System.out.println("Dequeue Node Priority: " + node.priority + "Name: " + node.name);
        }
    }
}
