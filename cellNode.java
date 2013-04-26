
public class cellNode {

  public cellNode cellNodeRight;
	public cellNode cellNodeTop;
	public cellNode cellNodeLeft;
	public cellNode cellNodeBottom;
	public int data;
	
	public int col;
	public int row;
	
	public cellNode(){
		cellNodeBottom=cellNodeLeft=cellNodeRight=cellNodeTop = null;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}
	
}
