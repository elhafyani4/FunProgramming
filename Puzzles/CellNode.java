package Puzzles;

public class CellNode {

    public CellNode cellNodeRight;
    public CellNode cellNodeTop;
    public CellNode cellNodeLeft;
    public CellNode cellNodeBottom;
    public int data;

    public int col;
    public int row;

    public CellNode() {
        cellNodeBottom = cellNodeLeft = cellNodeRight = cellNodeTop = null;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
