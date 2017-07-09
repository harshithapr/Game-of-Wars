import java.util.ArrayList;

public class Alphabeta 
{
	private Problem p;
	private final int mininf=(int)Double.NEGATIVE_INFINITY;
	private final int posinf=(int)Double.POSITIVE_INFINITY;
	Alphabeta(Problem p)
	{
		this.p=p;
	}
	public void playGame(String fname)
	{
		State s=p.getinitialState();
		Integer n=State.getBoardSize();
		char[][] nextBoard=s.getBoard();
		Action best=ALPHA_BETA_SEARCH(s, p.getDepth());
		WriteOutput wp=new WriteOutput(fname);
		if(best!=null)
		{
		Integer pr=best.getRow();
		Integer pc=best.getCol();
		String move=best.getMove();
		char player=s.getPlayer();
		char opp;
		if(player=='X')
			opp='O';
		else
			opp='X';
		if(move=="Raid")
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
		
		wp.write(nextMove, move, nextBoard, n);
		System.out.println(nextMove+" "+move);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(nextBoard[i][j]);
			}
			System.out.print("\n");
		}
		}
		else
		wp.write("No ","Legal Move", nextBoard, n);
	}
	
	public Action ALPHA_BETA_SEARCH(State s, int depth)
	{
		Action bestAction = null;
		if(depth>0)
		{
//			depth=depth-1;
			ArrayList<Action> acts=p.Actions(s);
			if(acts!=null)
			{
				int big=(int)mininf;
				int v;
//				System.out.println("From Alpha beta search");
				for(Action a:acts)
				{
					State sd=p.Result(s, a);
					v=MIN_VALUE(sd,mininf,posinf,depth-1);
					if(v>big)
					{
						big=v;
						bestAction=a;
					}
					else if(v==big)
					{
						if(a.getMove()=="Stake" && bestAction.getMove()=="Raid")
							bestAction=a;
					}
//					System.out.println(a.getRow()+" "+a.getCol()+" "+a.getMove()+" "+v);
				}
			}
		}
		return bestAction;
	}
	

	
	public int MAX_VALUE(State s,int alpha,int beta,int depth)
	{
		if(p.cutoff_test(s, depth))
			return p.eval(s);
		int v=(int)mininf;
		ArrayList<Action> acts=p.Actions(s);
		if(acts!=null)
		{
//			System.out.println("From Max");
			for(Action a:acts)
			{
				v=Math.max(v, MIN_VALUE(p.Result(s, a),alpha,beta,depth-1));
//				System.out.println(a.getRow()+" "+a.getCol()+" "+a.getMove()+" "+v);
				if(v>=beta)
					return v;
				alpha=Math.max(alpha, v);
			}
		}
		return v;
	}
	

	
	public int MIN_VALUE(State s,int alpha, int beta, int depth)
	{
		if(p.cutoff_test(s, depth))
			return p.eval(s);
		int v=(int)posinf;
		ArrayList<Action> acts=p.Actions(s);
		if(acts!=null)
		{
//			System.out.println("From Min");
			for(Action a:acts)
			{
				
				v=Math.min(v, MAX_VALUE(p.Result(s, a),alpha, beta, depth-1));
//				System.out.println(a.getRow()+" "+a.getCol()+" "+a.getMove()+" "+v);
				if(v<=alpha)
					return v;
				beta=Math.min(beta, v);
			}
		}
		return v;
	}
	

}
