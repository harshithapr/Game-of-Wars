
public class Action 
{
	private int row;
	private int col;
	String move;
	Action(int row, int col, String move)
	{
		this.row=row;
		this.col=col;
		this.move=move;
	}
	public int getRow()
	{
		return row;
	}
	public int getCol()
	{
		return col;
	}
	public String getMove()
	{
		return move;
	}
}