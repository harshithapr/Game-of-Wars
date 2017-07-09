
public class Input 
{
	private int size;
	private String algo;
	private char player;
	private int depth;
	private int[][] boardValues;
	private char[][] boardState;
	Input(int size, String algo, char player, int depth, int[][] boardValues,char[][] boardState)
	{
		this.size=size;
		this.algo=algo;
		this.player=player;
		this.depth=depth;
		this.boardValues=boardValues;
		this.boardState=boardState;
	}
	public int getSize()
	{
		return size;
	}
	public String getAlgo()
	{
		return algo;
	}
	public char getPlayer()
	{
		return player;
	}
	public int getDepth()
	{
		return depth;
	}
	public int[][] getBoardValues()
	{
		return boardValues;
	}
	public char[][] getBoardState()
	{
		return boardState;
	}
	public void display()
	{
		System.out.println(size);
		System.out.println(algo);
		System.out.println(player);
		System.out.println(depth);
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(boardValues[i][j]+"\t");
			}
			System.out.print("\n");
		}
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(boardState[i][j]);
			}
			System.out.print("\n");
		}
	}
}
