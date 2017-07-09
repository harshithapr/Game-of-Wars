import java.io.File;
import java.util.StringTokenizer;

public class hw_script 
{

	public static void main(String[] args) 
	{
		File dir=new File("input");
		String[] files=dir.list();
		for(String fname:files)
		{
		ReadInput r = new ReadInput("input/"+fname);
		StringTokenizer st=new StringTokenizer(fname, ".");
		String out=st.nextToken()+"."+"out";
		System.out.println(out);
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
				m.playGame(out);
				break;
			case "ALPHABETA":
				Alphabeta ab=new Alphabeta(prob);
				ab.playGame(out);
				break;
			default:
				System.out.println("Invalid Algorithm");	
		}
		}
	}
}
