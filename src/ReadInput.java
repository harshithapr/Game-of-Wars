import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInput 
{
	String filename;
	ReadInput(String filename)
	{
		this.filename=filename;
	}
	public Input read()
	{
		Input ip;
		
		int size;
		String algo;
		String player;
		int depth;
		int[][] boardValues;
		char[][] boardState;
		try 
		{
			File fp=new File(filename);
			Scanner s=new Scanner(fp);
			size=s.nextInt();
			algo=s.next().trim().toUpperCase();			
			player=s.next().trim().toUpperCase();
			char playerc=player.toCharArray()[0];
			depth=s.nextInt();
			boardValues=new int[size][size];
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					boardValues[i][j]=s.nextInt();
				}
			}
			boardState=new char[size][size];
			char[] line;
			for(int i=0;i<size;i++)
			{
				String str=s.next().trim().toUpperCase();
				line=str.toCharArray();
				for(int j=0;j<size;j++)
				{
					boardState[i][j]=line[j];
				}
			}
			ip=new Input(size,algo,playerc,depth,boardValues,boardState);
			s.close();
			return ip;
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace();
		}
		return null;
	}
}
