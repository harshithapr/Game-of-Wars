
public class homework {

	public static void main(String[] args) 
	{
		long startTime=System.currentTimeMillis();
//		ReadInput r=new ReadInput("input/"+"input2.txt");
		ReadInput r=new ReadInput("input3.txt");
		Input inp=r.read();
//		inp.display();
		State.setBoardScore(inp.getBoardValues());
		State.setBoardSize(inp.getSize());
		State initial=new State(inp.getBoardState(),inp.getPlayer(),' ');
//		initial.display();
		Problem prob=new Problem(initial,inp.getDepth());
		switch(inp.getAlgo())
		{
			case "MINIMAX":
				Minimax m=new Minimax(prob);
				m.playGame("output.txt");
				break;
			case "ALPHABETA":
				Alphabeta ab=new Alphabeta(prob);
				ab.playGame("output.txt");
				break;
			default:
				System.out.println("Invalid Algorithm");	
		}
		long stopTime=System.currentTimeMillis();
		long timeElapsed=stopTime-startTime;
		System.out.println("Time consumed="+timeElapsed);
	}
}
