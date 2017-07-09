import java.util.ArrayList;

public class Problem 
{
	private State initialState;
	private int depth;
	Problem(State initialState,int depth)
	{
		this.initialState=initialState;
		this.depth=depth;
	}
	public State getinitialState()
	{
		return initialState;
	}
	public int getDepth()
	{
		return depth;
	}
	public ArrayList<Action> Actions(State s)
	{
		ArrayList<Action> acts=new ArrayList<Action>();
		int n=State.getBoardSize();
		char[][] sb=s.getBoard();
		char player=s.getPlayer();
		char opp;
		if(player=='X')
			opp='O';
		else
			opp='X';
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				{

					if(sb[i][j]=='.')
					{
						
						int flag=0;
						if(i-1>=0 && sb[i-1][j]==player)
							flag=1;
						else if(i+1<n && sb[i+1][j]==player)
							flag=1;
						else if(j-1>=0 && sb[i][j-1]==player)
							flag=1;
						else if(j+1<n && sb[i][j+1]==player)
							flag=1;
					
//						int sflag=0;
//						if(flag==1)
//						{
//						if(i-1>=0 && sb[i-1][j]==opp)
//							sflag=1;
//						else if(i+1<n && sb[i+1][j]==opp)
//							sflag=1;
//						else if(j-1>=0 && sb[i][j-1]==opp)
//							sflag=1;
//						else if(j+1<n && sb[i][j+1]==opp)
//							sflag=1;
//						}
//						if(sflag==0)
							acts.add(new Action(i,j,"Stake"));
						if(flag==1)
						{
							acts.add(new Action(i,j,"Raid"));
						}
						
						
					}
				}	
		}
		return acts;
	}
	public State Result(State s,Action a)
	{
		State next;
		int n=State.getBoardSize();
		char[][] sb1=s.getBoard();
		char[][] sb=new char[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				{
					sb[i][j]=sb1[i][j];
				}
		char player=s.getPlayer();
		int i=a.getRow();
		int j=a.getCol();
		String move=a.getMove();
		char opp;
		if(player=='X')
			opp='O';
		else
			opp='X';
		
		if(move=="Stake")
		{
			sb[i][j]=player;
//			next=new State(sb,opp,player);
		}
		else if(move=="Raid")
		{
			sb[i][j]=player;
			if(i-1>=0 && sb[i-1][j]==opp)
				sb[i-1][j]=player;
			if(i+1<n && sb[i+1][j]==opp)
				sb[i+1][j]=player;
			if(j-1>=0 && sb[i][j-1]==opp)
				sb[i][j-1]=player;
			if(j+1<n && sb[i][j+1]==opp)
				sb[i][j+1]=player;
		}
		next=new State(sb,opp,player);
		return next;
	}
	public boolean cutoff_test(State s,int depth)
	{
		if(depth<=0 || s.isFill())
//		if(depth<=0)
			return true;
		else
			return false;
	}
	public int eval(State s)
	{
		int scorePlayer=0,scoreOpponent=0,scoreb;
//		char pawn=s.getPawn();
		char pawn=initialState.getPlayer();
//		char pawn='X';
//		char opp='O';
		char opp;
		if(pawn=='X')
			opp='O';
		else
			opp='X';
		
		int n=State.getBoardSize();
		int[][] boardValues=State.getBoardScore();
		char[][] board=s.getBoard();
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				if(board[i][j]==pawn)
					scorePlayer+=boardValues[i][j];
				else if(board[i][j]==opp)
					scoreOpponent+=boardValues[i][j];
			}
		
		scoreb=scorePlayer-scoreOpponent;
		return scoreb;
	}
}
