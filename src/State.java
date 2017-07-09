
public class State 
{
	private static int size;
	private static int[][] boardScore;
	private char[][] board;
	private char player;
	private char pawn;
	State(char[][] board, char player, char pawn)
	{
		this.board=board;
		this.player=player;
		this.pawn=pawn;
		
	}
	State(State s)
	{
		this.board=s.board;
		this.player=s.player;
	}
	public static void setBoardSize(int s)
	{
		size=s;
	}
	public static void setBoardScore(int[][] score)
	{
		boardScore=score;
	}
	public static int getBoardSize()
	{
		return size;
	}
	public static int[][] getBoardScore()
	{
		return boardScore;
	}
	public char[][] getBoard()
	{
		return board;
	}
	public char getPlayer()
	{
		return player;
	}
	public char getPawn()
	{
		return pawn;
	}
	public void display()
	{
		System.out.println("Display from State Class");
		System.out.println(size);
		System.out.println(player);
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(boardScore[i][j]+"\t");
			}
			System.out.print("\n");
		}
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public boolean isFill()
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(board[i][j]=='.')
					return false;
			}
		}
		return true;
	}
}
