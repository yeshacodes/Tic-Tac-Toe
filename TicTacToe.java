import java.awt.*; //AWT stands for Abstract Window Toolkit - used for creating GUI
import java.awt.event.*;
import java.util.*;
import javax.swing.*; //part of JFC provides GUI components for building desktop applications

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    boolean player1_is_X;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        choosePlayer();
    }

    private void choosePlayer() {
        String[] options = {"X", "O"};
        int choice = JOptionPane.showOptionDialog(frame, "Player 1, choose your symbol:", "Choose Symbol",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            player1_is_X = true;
            textField.setText("Player 1 is X. X's turn");
        } else {
            player1_is_X = false;
            textField.setText("Player 1 is O. O's turn");
        }

        player1_turn = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O's turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X's turn");
                        check();
                    }
                }
            }
        }
    }

    public void check() {
        // Check X win conditions
        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
            return;
        }
        if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
            return;
        }
        if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
            return;
        }
        if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
            return;
        }
        if ((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
            xWins(1, 4, 7);
            return;
        }
        if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
            return;
        }
        if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
            return;
        }
        if ((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(2, 4, 6);
            return;
        }

        // Check O win conditions
        if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
            return;
        }
        if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
            return;
        }
        if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
            return;
        }
        if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
            return;
        }
        if ((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
            oWins(1, 4, 7);
            return;
        }
        if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
            return;
        }
        if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
            return;
        }
        if ((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(2, 4, 6);
            return;
        }

        // Check for a draw
        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                draw = false;
                break;
            }
        }
        if (draw) {
            textField.setText("It's a draw");
            disableButtons();
        }
    }

    private void disableButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
