package bst;

public class MyRBST {
    private Node root;
    private void addV2(Node current,int value){
        if(current == null){
            current = new Node(value);
        }
        if(value < current.value){
            add(current.left,value);
        } else if (value > current.value) {
            add(current.right,value);
        }
    }
    private Node add(Node current,int value){
        if(current == null)
            return new Node(value);
        if(value < current.value){
            current.left = add(current.left,value);
        } else if (value > current.value) {
            current.right = add(current.right,value);
        }
        return current;
    }
    private boolean contain(Node current,int value){
        if(current == null){
            return false;
        }
        if(current.value == value){
            return true;
        }
        if(value < current.value){
            return contain(current.left,value);
        }else{
            return contain(current.right,value);
        }
    }
    private int minTree(Node current){
        while(current.left!=null){
            current = current.left;
        }
        return current.value;
    }
    private Node delete(Node current,int value){
        if(current == null )
            return null;
        if(value < current.value){
            current.left = delete(current.left,value);
        } else if (value > current.value) {
            current.right = delete(current.right,value);
        }else {
            if(current.left == null && current.right == null){
                return null;
            } else if (current.left == null) {
                current = current.right;
            } else if (current.right == null) {
                current = current.left;
            }else {
                int subTreeMin = minTree(current.right);
                current.value = subTreeMin;
                return delete(current.right,subTreeMin);
            }
        }
        return current;
    }
    public void delete(int value){
        delete(root,value);
    }
    public void add(int value){
        addV2(root,value);
    }
    public boolean contain(int value){
        return contain(root,value);
    }
    public


    class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
}
