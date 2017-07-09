import java.util.ArrayList;

public class Minimax1
{
	private Problem p;
	private final double mininf=Double.NEGATIVE_INFINITY;
	private final double posinf=Double.POSITIVE_INFINITY;
	Minimax1(Problem p)
	{
		this.p=p;
	}
	public void playGame(String fname)
	{
		State s=p.getinitialState();
		Integer n=State.getBoardSize();
		char[][] nextBoard=s.getBoard();
		Action best=MINIMAX_DECISION(s, p.getDepth());
		Integer pr=best.getRow();
		Integer pc=best.getCol();
		String move=best.getMove();
		char player=s.getPlayer();
		char opp;
		if(player=='X')
			opp='O';
		else
			opp='X';
		if(move=="RAID")
		{
			nextBoard[pr][pc]=player;
			if(pr-1>=0 && nextBoard[pr-1][pc]==opp)
				nextBoard[pr-1][pc]=player;
			if(pr+1<n && nextBoard[pr+1][pc]==opp)
				nextBoard[pr+1][pc]=player;
			if(pc-1>=0 && nextBoard[pr][pc-1]==opp)
				nextBoard[pr][pc-1]=player;
			if(pc+1<n && nextBoard[pr][pc+1]==opp)
				nextBoard[pr][pc+1]=player;
		}
		else
			nextBoard[pr][pc]=s.getPlayer();
		
		Integer pr1=pr+1;
		String nextMove=(char)(pc+65)+(pr1).toString();
		WriteOutput wp=new WriteOutput(fname);
		wp.write(nextMove, move, nextBoard, n);
//		System.out.println(nextMove+" "+move);
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<n;j++)
//			{
//				System.out.print(nextBoard[i][j]);
//			}
//			System.out.print("\n");
//		}
	}
	public Action MINIMAX_DECISION(State s, int depth)
	{
		Action bestAction = null;
		if(depth>0)
		{
			ArrayList<Action> acts=p.Actions(s);
			if(acts!=null)
			{
				int v;
				v=MAX_VALUE(s,depth);
				for(Action a:acts)
				{
					State sd=p.Result(s, a);
					if(v==p.eval(sd))
					{
						bestAction=a;
						System.out.println(bestAction.getRow()+" "+bestAction.getCol()+" "+bestAction.getMove());
						return bestAction;
					}
				}
			}
		}
		return bestAction;
	}
	
	public int MAX_VALUE(State s,int depth)
	{
		if(p.cutoff_test(s, depth))
			return p.eval(s);
		int v=(int)mininf;
		ArrayList<Action> acts=p.Actions(s);
		if(acts!=null)
		{
			for(Action a:acts)
			{
				v=Math.max(v, MIN_VALUE(p.Result(s, a),depth-1));
			}
		}
		return v;
	}
	
	public int MIN_VALUE(State s,int depth)
	{
		if(p.cutoff_test(s, depth))
			return p.eval(s);
		int v=(int)posinf;
		ArrayList<Action> acts=p.Actions(s);
		if(acts!=null)
		{
			for(Action a:acts)
			{
				v=Math.min(v, MAX_VALUE(p.Result(s, a),depth-1));
			}
		}
		return v;
	}
	

}
