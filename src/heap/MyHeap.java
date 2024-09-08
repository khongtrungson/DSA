package heap;

import java.util.ArrayList;
import java.util.List;

public class MyHeap {
    private List<Integer> heap;

    public MyHeap() {
        this.heap = new ArrayList<>();
    }
    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }
    private int rightChild(int index){
        return index * 2 + 2;
    }
    private int parent(int index){
        return (index - 1)/2;
    }

    private void swap(int index1,int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2,temp);
    }
    public void insert(int value){
        heap.add(value);
        int current = heap.size() - 1;
        while(current > 0 && heap.get(parent(current)) < heap.get(current) ){
            swap(current,parent(current));
            current = parent(current);
        }
    }
    public void printAll(){
        for (int i : heap) {
            System.out.println(i);
        }
    }
    public  void remove(){
        if(heap.size() == 0){
            return;
        }
        if(heap.size() == 1){
            heap.remove(0);
            return;
        }
        heap.set(0,heap.remove(heap.size()-1));
        int index,maxIndex;
        index = maxIndex = 0;
        // sink down here
        while(true){
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            if(leftChild < heap.size() && heap.get(maxIndex) < heap.get(leftChild)){
                maxIndex = leftChild;
            }
            if(rightChild < heap.size() && heap.get(maxIndex) < heap.get(rightChild)){
                maxIndex = rightChild;
            }
            if(maxIndex != index){
                swap(maxIndex,index);
                index = maxIndex;
            }else{
                return;
            }

        }
    }

    public static void main(String[] args) {
        MyHeap heap = new MyHeap();
        heap.insert(10);
        heap.insert(10);
        heap.insert(30);
        heap.insert(49);
        heap.remove();
        heap.printAll();
    }
}
