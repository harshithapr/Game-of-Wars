import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOutput 
{
	String filename;
	WriteOutput(String filename)
	{
		this.filename=filename;
	}
	
	public void write(String move, String action, char[][] board,int n)
	{
		FileWriter fw;
		BufferedWriter bw;
		try
		{
			fw=new FileWriter(filename);
			bw=new BufferedWriter(fw);
			bw.write(move+" "+action);
			bw.write("\n");
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					bw.write(board[i][j]);
				}
				bw.write("\n");
			}
		bw.close();
		}
		catch(IOException e)
		{
			System.out.println("Error in writing data to a file");
		}

	}
}


