/*
 Minimum Coins
Karsten Froemming
October 10, 2015
 */
package minimumcoinsproject;
import java.util.Scanner;
public class MinimumCoinsProject {
static public class MinumimCoinsProject//a class is not an object, but a blueprint for an object. It is the building blocks.
{

    }
    public static void main(String[] args) {
        //initialization
        { 
           
            int change = 0;
            int quarters = 0;
            int dimes = 0;
            int nickels = 0;
           
        Scanner in;
        in = new Scanner(System.in);
        System.out.println("Lets calclulate the minimum coins.\n");//prompts the user
        System.out.println("PLease enter amount of change.(1-99)\n\n");//output for the user
        change=in.nextInt(); //asks for the amount of change to calculate

        
        //start of while loop
    while  ( change >= 25) //deducts from the change value to initialize the loop.
    {
        quarters = quarters+1;
        change = change - 25;

    } 
    System.out.printf("Quarters:%d\n",quarters);
    while (change>=10)
    {

        dimes = dimes + 1;
        change = change - 10;


    }
    System.out.printf("Dimes: %d\n", dimes);
    while(change>=5)
    {

        nickels = nickels + 1;            
        change = change - 5;


    }
    System.out.printf("Nickles:%d\n",nickels);
    if ( change>0)
        System.out.printf("Pennies:"+change+"\n");
    }//end of the function and program
}
}

     

