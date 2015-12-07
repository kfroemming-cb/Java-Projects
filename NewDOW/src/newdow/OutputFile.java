package newdow;

import java.io.*;
import java.text.DecimalFormat;
public class OutputFile extends Keyboard
{
    private String fn;
    private OutputStreamWriter out;

    public OutputFile(String fn) //constructor
    {
        try
        {
           out = new OutputStreamWriter(new FileOutputStream(fn));
        }    catch( Exception e )
        {
          System.out.println( "Can't open output file '" + fn + "'" );
          Keyboard standardInput = new Keyboard();
          System.out.print( "Enter new file name or press enter to end program: " );
          fn = standardInput.readLine( );
          if( fn.length() == 0 )
              System.exit( 1 );
        }
    }

    public void close()
    {
        try
        {
            out.close();
        }catch (IOException e){error("close");}
    }


    public void writeEOL()
    {
        try
        {
            out.write("\n");
        }catch(IOException e){error("writeInt");}
    }


    public void writeInt(int i)
    {
       try
       {
           String s = "";
           out.write(s.valueOf(i) + " ");
       }catch(IOException e){error("writeInt");}
    }


    public void writeDouble(double d)
    {
       try
       {
        DecimalFormat df = new DecimalFormat("0.0 ");
        out.write(df.format(d));
       }catch(IOException e){error("writeDouble");}
    }

    public void writeString(String s)
    {
       try
       {
        out.write('"' + s + '"' + " ");
       }catch(IOException e){error("writeString");}
    }

    public void writeWord(String s)
    {
       try
       {
        out.write( s + " ");
       }catch(IOException e){error("writeWord");}
    }

    public void writeChar(char c)
    {
       try
       {
        out.write(c + " ");
       }catch(IOException e){error("writeString");}
    }
}