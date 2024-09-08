package set;

public class MyHashSet {
    private final int SIZE = 1000;
    private Node[] nodes;

    private int hash(int value){
        return value%SIZE;
    }
    public void printAll(){
        for(int i =0 ;i<SIZE;i++){
            if(nodes[i] != null){
                Node temp = nodes[i];
                while(temp != null){
                    System.out.println(temp.value);
                    temp= temp.next;
                }
            }
        }
    }
    public void add(int value){
        int index = hash(value);
        Node temp = nodes[index];
       if(nodes[index] == null){
           nodes[index]=new Node(value);
       }
        else {
            while(temp != null ){
                if(temp.value == value){
                    return;
                }
               temp= temp.next;
            }
            temp.next = new Node(value);
        }
    }

    public void delete(int value){
        int index = hash(value);
        if(nodes[index] != null){
            Node temp = nodes[index];
            if(nodes[index].value == value){
                nodes[index] = null;
            }else {
                Node pre = null;
                while(!(temp.value == value)){
                    pre = temp;
                    temp=temp.next;
                }
                pre.next = temp.next;
            }
        }
    }

    public boolean contain(int value){
        int index = hash(value);
        Node temp = nodes[index];
        while( temp != null){
            if(temp.value == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public MyHashSet() {
        nodes = new Node[SIZE];
    }

    class Node{
        public Node(int value) {
            this.value = value;
        }
        private int value;
        private Node next;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(10);
        myHashSet.add(10);
        myHashSet.add(101);
        myHashSet.add(101);
        myHashSet.add(101);
        myHashSet.add(101);
        myHashSet.add(101);
        myHashSet.add(101);
        myHashSet.delete(101);
        myHashSet.add(102);
        myHashSet.add(1003);
        myHashSet.add(104);
        myHashSet.printAll();
    }

}
