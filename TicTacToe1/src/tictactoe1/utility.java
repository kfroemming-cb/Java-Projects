package tictactoe1;

import javax.swing.JOptionPane;


public class utility
{
    public static String userInputsPlayerName(String prompt)
    {
        String name = "";
        
        while (name.length() < 1)
        {
            name = JOptionPane.showInputDialog("Enter Player " + prompt + "name.");
        }
        return name;
    }
    
  
}

//
