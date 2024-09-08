package bst;

public class MyBST {
    private Node root;

    public void add(int value){
        if(root == null){
            root = new Node(value);
        }else {
            Node temp = root;
            while(temp != null){
                if(value == temp.value)
                    return;
                if(value< temp.value){
                    if(temp.left == null){
                        temp.left = new Node(value);
                        return;
                    }
                    temp = temp.left;
                }else {
                    if(temp.right == null){
                        temp.right = new Node(value);
                        return;
                    }
                    temp = temp.right;
                }
            }
        }
    }

    public boolean contain(int value){
        if(root == null){
            return false;
        }
        Node temp = root;
        while(temp!=null){
            if(value == temp.value){
                return true;
            }
            if(value < temp.value){
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        return false;
    }

    class Node{
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyBST myBST = new MyBST();
        myBST.add(20);
        myBST.add(10);
        myBST.add(82);
        myBST.add(63);
        System.out.println(myBST.contain(64));
    }
}
