import java.util.ArrayList;

public class Alphabeta1
{
	private Problem p;
	private final int mininf=(int)Double.NEGATIVE_INFINITY;
	private final int posinf=(int)Double.POSITIVE_INFINITY;
	Alphabeta1(Problem p)
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
		{
		wp.write("No ","Legal Move", nextBoard, n);
		System.out.println("No legal move");
		}
	}

	
	public Action ALPHA_BETA_SEARCH(State s, int depth)
	{
		Pair p=MAX_VALUE(s,mininf,posinf,depth);
		return p.getAction();
	}
	
	public Pair MAX_VALUE(State s,int alpha,int beta,int depth)
	{
		if(p.cutoff_test(s, depth))
			return new Pair(null,p.eval(s));
		int v=(int)mininf;
		Pair temp;
		Action best=null;
		ArrayList<Action> acts=p.Actions(s);
		if(acts!=null)
		{
			for(Action a:acts)
			{
				temp=MIN_VALUE(p.Result(s, a),alpha,beta,depth-1);
				int t=temp.getScore();
				if(t>v)
				{
					v=t;
					best=a;
				}
				else if(t==v)
				{
					if(a.getMove()=="Stake" && best.getMove()=="Raid")
						best=a;
				}
				if(v>=beta)
					return new Pair(best,v);
				alpha=Math.max(alpha, v);
			}
		}
		return new Pair(best,v);
	}
	
	
	
	public Pair MIN_VALUE(State s,int alpha, int beta, int depth)
	{
		if(p.cutoff_test(s, depth))
			return new Pair(null,p.eval(s));
		int v=(int)posinf;
		Pair temp;
		Action best=null;
		ArrayList<Action> acts=p.Actions(s);
		if(acts!=null)
		{
			for(Action a:acts)
			{
				temp=MAX_VALUE(p.Result(s, a),alpha,beta,depth-1);
				int t=temp.getScore();
				if(t<v)
				{
					v=t;
					best=a;
				}
				if(v<=alpha)
					return new Pair(best,v);
				beta=Math.min(beta, v);
			}
		}
		return new Pair(best,v);
	}
	

}
