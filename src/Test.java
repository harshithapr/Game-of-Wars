import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		File dir=new File("output");
		String[] files=dir.list();
		try 
		{
			FileWriter fw=new FileWriter("Amatch.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			
			FileWriter fw1=new FileWriter("AMismatch.txt");
			BufferedWriter bw1=new BufferedWriter(fw1);
		
		for(String fname:files)
		{
		try
		{
		File fp1=new File("output/"+fname);
		FileReader  in1=new FileReader(fp1);
		BufferedReader br1=new BufferedReader(in1);
		
		File fp2=new File(fname);
		FileReader  in2=new FileReader(fp2);
		BufferedReader br2=new BufferedReader(in2);
		
		String line1,line2;
		int comp,flag=1;
		while((line1=br1.readLine())!=null && (line2=br2.readLine())!=null)
		{
			comp=line1.compareTo(line2);
				if(comp!=0)
					flag=0;
		}
		if(flag==1)
		{
			bw.write(fname+" matches");
			bw.write("\n");
		}
		else
		{
			System.out.println("Hi");
			System.out.println(fname+" mismatches");
			bw1.write(fname+" mismatches");
			bw1.write("\n");
		}
		br1.close();
		br2.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Input file doesn't exists:"+fname);
		}
		catch(IOException e)
		{
			System.out.println("Error while reading data from file");
		}
		}
		bw.close();
		bw1.close();
		}
		catch (IOException e1) 
		{

			e1.printStackTrace();
		}
	}
}

