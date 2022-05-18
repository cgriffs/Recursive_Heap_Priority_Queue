public class Node {
    public int priority;
    public String name;

    public Node(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public int getPriority(){
        return priority;
    }

    public String getName(){
        return name;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public void setName(String name){
        this.name = name;
    }
}