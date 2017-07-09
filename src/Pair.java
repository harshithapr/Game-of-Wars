
public class Pair 
{
	private Action best;
	private int score;
	Pair(Action a,int score)
	{
		this.best=a;
		this.score=score;
	}
	public Action getAction()
	{
		return best;
	}
	public int getScore()
	{
		return score;
	}
}
