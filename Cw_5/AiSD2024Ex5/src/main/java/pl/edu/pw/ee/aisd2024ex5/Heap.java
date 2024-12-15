package pl.edu.pw.ee.aisd2024ex5;
import java.util.ArrayList;

public class Heap {
    private ArrayList<HuffNode> heap;
    public Heap(ArrayList<HuffNode> list) {
        this.heap = new ArrayList<>();
        for (HuffNode node : list) {
            this.addToHeap(node);
        }
    }

    public void addToHeap(HuffNode newNode) {
        heap.add(newNode);
        heapUp();
    }

    public HuffNode removeFromHeap() {
        int last = heap.size() - 1;
        switchNodes(0, last);
        HuffNode ret = heap.remove(last);
        heapDown();

        return ret;
    }

    private void switchNodes(int p, int c){
        HuffNode tempNode = heap.get(p);
        heap.set(p, heap.get(c));
        heap.set(c, tempNode);
    }

    private void heapUp() {
        int c = heap.size()-1;
        int p = (c-1)/2;
        while(heap.get(p).compareTo(heap.get(c)) > 0 && c != 0) {
            switchNodes(p, c);
            c = p;
            p = (c-1)/2;

        }
    }

    private void heapDown() {
        int p = 0;
        int size = heap.size();
        int c = 1;
        while (c<size){
            if(c<size-1 && heap.get(c).compareTo(heap.get(c+1))>0)
                c+=1;
            if(heap.get(c).compareTo(heap.get(p))<0){
                switchNodes(p,c);
            }
            else
                return;
            p=c;
            c=2*p+1;
        }
    }
    public int getSize(){
        return this.heap.size();
    }
}
