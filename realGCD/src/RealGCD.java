import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main 
{

//the start of the main class function


public static void  main(String [] args)
{
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the first integer:");
    int firstNumber = input.nextInt();
    System.out.println("Please enter the second integer:");
    int secondNumber = input.nextInt();

    System.out.println("The GCD of " + firstNumber + " and " + secondNumber + " is " +  getGcd(secondNumber,firstNumber) + ".");
}


public static int getGcd(int intOne, int intTwo)
{
    int gcd = 1;

    if(intOne>intTwo)
    {
        for(int one = intTwo; one >=1; one--)
        {
            if(intTwo%one==0 && intTwo%one ==0)
            {
                return one;
            }
        }
    }
    else
    {
        for(int two = intOne; two >=1; intOne--)
        {
            if(intOne%two==0 && intOne% two==0)
            {
                return two;
            }
        }
    }   
    return gcd;

}
}