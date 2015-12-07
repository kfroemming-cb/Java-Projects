
package newdow;

import java.util.Arrays;

public class NewDOW {
	
	
	public static void main(String[] args)
	{
		int index = 0;
		int myArray[] = new int[8];
		InputFile in = new InputFile("input");
		OutputFile out = new OutputFile("output");
                int [] high = new int[8];
                int [] low  = new int[8];
                int [] counter = new int [8];
                int [] total = new int [8];
                int temperature = 0 ; 
                System.out.println("DOW Temerpature Started Please Wait...");
                
                    for (index = 0; index<8; index++)
                    {
                    high [index]=-999;
                    low [index]=999;
                    counter[index]=0;
                    total[index]=0;
                    }
                    while (!in.eof())
                    {
                    index = in.readInt();
                    temperature = in.readInt();
                    if (temperature>high[index])
                    {
                    high[index]=temperature;
                    
                    }
                    if (temperature<low[index])
                    {
                        low[index]=temperature;
                    }
                    counter[index]=counter[index]+1;
                    total[index]=total[index]+temperature;
                    }
                    for (index = 0; index < 8; index++)
                    {
                    out.writeInt(index);
                    out.writeInt(high[index]);
                    out.writeInt(low[index]);
                    out.writeInt(total[index]/counter[index]);
                    out.writeEOL();
                    
                    

                      
		}
		out.close();
                System.out.println(Arrays.toString(counter));
                System.out.println("Days of the week hasn now ended");
	}
}

