package Puzzles;

/**
 * Created by yelha on 1/27/2017.
 */
public class MinStack {

    int size = 32;
    int index = -1;
    MinNode[] data;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new MinNode[this.size];
    }

    public void push(int x) {

        if (index + 2 > size) {
            resize();
        }

        MinNode tmp = new MinNode();
        if (index == -1) {
            tmp.min = x;
        } else {
            tmp.min = Math.min(this.getMin(), x);
        }
        tmp.data = x;
        data[++index] = tmp;
    }

    public void resize() {
        size = size * 2;
        MinNode[] tmpData = new MinNode[this.size];
        for (int i = 0; i <= index; i++) {
            tmpData[i] = data[i];
        }

        data = tmpData;
    }

    public void pop() {
        if (index == -1) {
            return;
        } else {
            index--;
        }
    }

    public int top() {
        return data[index].data;
    }

    public int getMin() {
        return data[index].min;
    }

    class MinNode {
        int min;
        int data;
    }
}
