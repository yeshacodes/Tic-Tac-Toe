import java.awt.*; //AWT stands for Abstract Window Toolkit - used for creating GUI
import java.awt.event.*;
import java.util.*;
import javax.swing.*; //part of JFC provides GUI components for building desktop applications
public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame(); //represents a window with a border, title bar, etc.
    JPanel title_panel = new JPanel(); //JPanel is a lightweight container that is used to organize other
                                        // components within GUI
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //default close operation
        frame.setSize(800,800); //size
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout((new BorderLayout())); //layout
        frame.setVisible(true); //make JFrame window visible on screen

        textField.setBackground(new Color(25,25,25)); //background
        textField.setForeground(new Color(25,255,0)); //foreground
        textField.setFont(new Font("Ink Free", Font.BOLD, 75)); //font
        textField.setHorizontalAlignment(JLabel.CENTER); //used to set the horizontal alignment of text
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true); //used to set whether the background of the JTextField should be opaque or transparent

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0, 800,100);

//        title_panel.add(textField);
//        frame.add(title_panel, BorderLayout.NORTH);
//        frame.add(button_panel);
//
//        firstTurn();

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();



        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]); //added button array to the panel for organizing and laying out the buttons within a container
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120)); //sets font
            buttons[i].setFocusable(false);// This line sets whether the button can gain focus when
                                            // navigated using the keyboard
            buttons[i].addActionListener(this); //In Java Swing, an action listener is an object that listens for specific types of events, such as button clicks,
            // and performs some action in response to those events.
        }




    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i<9; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textField.setText("O turn");
                        System.out.println("Button " + i + " clicked by X");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("0");
                        player1_turn=true;
                        textField.setText("X turn");
                        System.out.println("Button " + i + " clicked by O");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1_turn = true;
            textField.setText("X turn");
        }
        else{
            player1_turn = false;
            textField.setText("O turn");
        }
    }

    public void check(){

        for (int i = 0; i < 9; i++) {
            System.out.print(buttons[i].getText() + " ");
            if ((i + 1) % 3 == 0)
                System.out.println();
        }



        //check X win conditions
        if((buttons[0].getText().equals("X")) &&
                (buttons[1].getText().equals("X")) &&
                (buttons[2].getText().equals("X"))){
        xWins(0,1,2);
        return;
        }

        if((buttons[3].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[5].getText().equals("X"))){
            xWins(3,4,5);
            return;
        }

        if((buttons[6].getText().equals("X")) &&
                (buttons[7].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))){
            xWins(6,7,8);
            return;
        }
        if((buttons[0].getText().equals("X")) &&
                (buttons[3].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))){
            xWins(0,3,6);
            return;
        }
        if((buttons[1].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[7].getText().equals("X"))){
            xWins(1,4,7);
            return;
        }
        if((buttons[2].getText().equals("X")) &&
                (buttons[5].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))){
            xWins(2,5,8);
            return;
        }
        if((buttons[0].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))){
            xWins(0,4,8);
            return;
        }
        if((buttons[2].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))){
            xWins(2,4,6);
            return;
        }

        //check O win conditions
        if((buttons[0].getText().equals("O")) &&
                (buttons[1].getText().equals("O")) &&
                (buttons[2].getText().equals("O"))){
            oWins(0,1,2);
        }
        //check O win conditions
        if((buttons[3].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[5].getText().equals("O"))){
            oWins(3,4,5);
        }

        if((buttons[6].getText().equals("O")) &&
                (buttons[7].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))){
            oWins(6,7,8);
        }
        if((buttons[0].getText().equals("O")) &&
                (buttons[3].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))){
            oWins(0,3,6);
        }
        if((buttons[1].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[7].getText().equals("O"))){
            oWins(1,4,7);
        }
        if((buttons[2].getText().equals("O")) &&
                (buttons[5].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))){
            oWins(2,5,8);
        }
        if((buttons[0].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))){
            oWins(0,4,8);
        }
        if((buttons[2].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))){
            oWins(2,4,6);
        }

        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                draw = false;
                break;
            }
        }
        if (draw) {
            textField.setText("It's a draw");
            disableButtons(); // Disable buttons in case of a draw
        }
    }

    private void disableButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");

    }

}
