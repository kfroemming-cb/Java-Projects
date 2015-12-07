package tictactoe1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TicTacToe1 extends JFrame implements ActionListener // extends class only one //actionListener interface
{

    //JButton attribute
    private static JButton[] button = new JButton[9];

    //declare two players and cat class attributes
    private static Player player1;
    private static Player player2;
    private static int catGame = 0;

    //keep track of who's turn it is...attribute
    private static boolean xTurn = true;

    //array of winning combinations. Decimal values will be compared bitwise to player click
    private static final int[] winsArray
            = {
                7, 56, 448, 73, 146, 292, 273, 84
            };

    private JTextField _Player1ScoreTF = new JTextField(2);
    private JTextField _Player2ScoreTF = new JTextField(2);
    private JTextField _CatTF = new JTextField(2);
      class SplashWindow3 extends JWindow
{
    public SplashWindow3(String TicTacToe, Frame f, int waitTime)
    {
        super(f);
        JLabel l = new JLabel(new ImageIcon(TicTacToe));
        getContentPane().add(l, BorderLayout.CENTER);
        pack();
        Dimension screenSize =
          Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));
        addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent e)
                {
                    setVisible(false);
                    dispose();
                }
            });
        final int pause = waitTime;
        final Runnable closerRunner = new Runnable()
            {
                public void run()
                {
                    setVisible(false);
                    dispose();
                }
            };
        Runnable waitRunner = new Runnable()
            {
                public void run()
                {
                    try
                        {
                            Thread.sleep(pause);
                            SwingUtilities.invokeAndWait(closerRunner);
                        }
                    catch(Exception e)
                        {
                            e.printStackTrace();
                            // can catch InvocationTargetException
                            // can catch InterruptedException
                        }
                }
            };
        setVisible(true);
        Thread splashThread = new Thread(waitRunner, "SplashThread");
        splashThread.start();
    }
}

    //contructor
    public TicTacToe1() {

        //create players - HARD CODED VALUES NEED TO BE REPLACED
        player1 = new Player(utility.userInputsPlayerName(" One's "));
        player2 = new Player(utility.userInputsPlayerName(" Two's "));

        player1.setPlayerMarker('X');
        player2.setPlayerMarker('O');

        JButton convertResetBtn = new JButton("Reset");
        JButton convertNewGame = new JButton("New Game?");

        convertResetBtn.addActionListener(new convertResetBtn());
        convertNewGame.addActionListener(new convertNewGame());

        _Player1ScoreTF.setEditable(false);
        _Player2ScoreTF.setEditable(false);
        _CatTF.setEditable(false);

        //System.out.println("p1: " + player1.getPlayerMarker() + " " + player1.getPlayerName());
        //System.out.println("p2: " + player2.getPlayerMarker() + " " + player2.getPlayerName());
        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(7, 3, 2, 2));

        int myBinary = 1;//first binary number to assign

        //load buttons into array
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton("");
            //add listener to "this" button in the array
            button[i].addActionListener(this);
            //set button atrribute to binary number cast to a string
            button[i].setActionCommand("" + myBinary);
            //add button to game board
            gameBoard.add(button[i]);
            //test number on button
            //* button[i].setText("" + myBinary);
            //calc next binary number
            myBinary = myBinary * 2;
        }
//        for (int i = 0; i < 9; i++)
//        {
//            System.out.println(button[i].getActionCommand());
//        }

        gameBoard.add(new JLabel(player1.getPlayerName()));
        gameBoard.add(_Player1ScoreTF);
        gameBoard.add(new JLabel(""));

        gameBoard.add(new JLabel(player2.getPlayerName()));
        gameBoard.add(_Player2ScoreTF);
        gameBoard.add(new JLabel(""));

        gameBoard.add(new JLabel("Cat"));
        gameBoard.add(_CatTF);
        gameBoard.add(new JLabel(""));

        gameBoard.add(convertResetBtn);
        gameBoard.add(new JLabel(""));
        gameBoard.add(convertNewGame);

        //add panel to window
        this.add(gameBoard);
        
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //...set window characteristics
        setLocationRelativeTo(null);
        setTitle("Karstens Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end of constructor

    @Override //implement listener for gameboard
    public void actionPerformed(ActionEvent e) //abstract method:child does work
    {
        // System.out.println("AE: " + e);
        System.out.println("Player1: " + player1.getPlayerName() + ":" + player1.getPlayerMarker());
        System.out.println("Player2: " + player2.getPlayerName() + ":" + player2.getPlayerMarker());

        //create button and cast from ActionEvent
        JButton pressedButton = (JButton) e.getSource();

        //don't allow marker if spot is active
        if (pressedButton.getText() == "") {
            if (xTurn) {//X's turn
                pressedButton.setText("X");
                if (player1.getPlayerMarker() == 'X') {
                    //player1 is currrently 'X', add to player1
                    player1.addPlayerTotal(Integer.parseInt(e.getActionCommand()));

                    //checking for winner after click
                    check4Winner(player1.getPlayerTotal());

                    //debug display needs to be deleted when complete
                    System.out.println("X new total: " + player1.getPlayerTotal());
                    //check if player won
                    if (check4Winner(player1.getPlayerTotal())) {
                        endOfGame(1);
                        return;
                    }

                } else {
                    //player2 is currrently 'X', add to player1
                    player2.addPlayerTotal(Integer.parseInt(e.getActionCommand()));

                    //checking for winner after click
                    check4Winner(player2.getPlayerTotal());

                    //debug display needs to be deleted when complete
                    System.out.println("X new total: " + player2.getPlayerTotal());
                    //check if player won
                    if (check4Winner(player2.getPlayerTotal())) {
                        endOfGame(2);
                        return;
                    }
                }

                //switch
                xTurn = false;
            } else {
                pressedButton.setText("O");
                if (player2.getPlayerMarker() == 'O') {
                    //player1 is currrently 'X', add to player1
                    player2.addPlayerTotal(Integer.parseInt(e.getActionCommand()));

                    //checking for winner
                    check4Winner(player2.getPlayerTotal());

                    //debug display needs to be deleted when complete
                    System.out.println("O new total: " + player2.getPlayerTotal());
                    //check if player won
                    if (check4Winner(player2.getPlayerTotal())) {
                        endOfGame(2);
                        return;
                    }

                } else {
                    //player2 is currrently 'X', add to player1
                    player1.addPlayerTotal(Integer.parseInt(e.getActionCommand()));

                    //chekcing for winner
                    check4Winner(player1.getPlayerTotal());

                    //debug display needs to be deleted when complete
                    System.out.println("O new total: " + player1.getPlayerTotal());
                    //check if player won
                    if (check4Winner(player1.getPlayerTotal())) {
                        endOfGame(1);
                        return;
                    }

                }

                xTurn = true;
            }//xTurn
            if ((player1.getPlayerTotal() + player2.getPlayerTotal()) == 511) {
                System.out.println("cat won");
                    //catGame.addCatGame();

                //clear board
                for (int i = 0; i < 9; i++) {
                    button[i].setText("");
                }
                //clear player total
                player1.setPlayerTotal(0);
                player2.setPlayerTotal(0);

                catGame = catGame + 1;
                System.out.println("" + catGame);

                xTurn = true;

            }
            _Player1ScoreTF.setText("" + player1.getPlayerScore());
            _Player2ScoreTF.setText("" + player2.getPlayerScore());
            _CatTF.setText("" + catGame);

        }//pressedButton.getText()

    }//actionPerformed

    //Check for winner
    public static boolean check4Winner(int total) {
        for (int i = 0; i < winsArray.length; i++) {
            //compare the wins Array occurance bitwise to the 
            if ((winsArray[i] & total) == winsArray[i]) {
                JOptionPane.showMessageDialog(null, "Winner!", "Winners Box", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Winner Found!");
                return true;
            }

        }
        return false;
    }//end of winner

    //Reset
    private static class convertResetBtn implements ActionListener {

        public convertResetBtn() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //clear board
            for (int i = 0; i < 9; i++) {
                button[i].setText("");
            }

            //clear player total
            player1.setPlayerTotal(0);
            player2.setPlayerTotal(0);

            xTurn = true;

        }

    }//end reset

    //New game reset
    private static class convertNewGame implements ActionListener {

        public convertNewGame() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //clear player score
            player1.setPlayerScore(0);
            player2.setPlayerScore(0);

            //clear player total
            player1.setPlayerTotal(0);
            player2.setPlayerTotal(0);

            if (catGame > 0) {
                catGame = 0;
            }

            for (int i = 0; i < 9; i++) {
                button[i].setText("");

            }

            //New game pop up window
            JOptionPane.showMessageDialog(null, "New Game?", "New Game Box", JOptionPane.INFORMATION_MESSAGE);

            xTurn = true;
        }
    }//end new game reset

    public static void endOfGame(int player)//Player is player 1 or 2
    {
        //add player
        if (player == 1) {
            player1.addPlayerScore();
        }
        System.out.println("Player 1 Score: " + player1.getPlayerScore());
        if (player == 2) {
            player2.addPlayerScore();
        }
        System.out.println("Player 2 Score: " + player2.getPlayerScore());

        //clear player total
        player1.setPlayerTotal(0);
        player2.setPlayerTotal(0);

        //switch marker
        if (player1.getPlayerMarker() == 'X') {
            player1.setPlayerMarker('O');
            player2.setPlayerMarker('X');

        } else {
            player1.setPlayerMarker('X');
            player2.setPlayerMarker('O');

        }

        //clear board
        for (int i = 0; i < 9; i++) {
            button[i].setText("");
        }

        //X always goes first for each new game.
        xTurn = true;
    }
  

    public static void main(String[] args) {
        new TicTacToe1().setVisible(true);
        TicTacToe1 window = new TicTacToe1();
        window.setVisible(true);
        
    }//main

}//TicTacToeGUI
