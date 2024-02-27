import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGuessingGame extends JFrame {
    private int numberToGuess;
    private JTextField guessField;
    private JTextArea infoArea;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setSize(350, 200); // Adjusted size for better spacing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Added spacing between components

        numberToGuess = (int) (Math.random() * 100) + 1;

        JLabel guessLabel = new JLabel("Enter your guess:");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centered the input panel
        inputPanel.add(guessLabel);
        inputPanel.add(guessField);
        inputPanel.add(guessButton);

        infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setMargin(new Insets(10, 10, 10, 10)); // Added margin for better readability

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(infoArea), BorderLayout.CENTER); // Added scroll pane for the info area
    }

    private class GuessButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                int guess = Integer.parseInt(guessField.getText());
                if (guess == numberToGuess) {
                    infoArea.setText("Congratulations! You guessed the number.");
                } else if (guess < numberToGuess) {
                    infoArea.setText("Too low! Try again.");
                } else {
                    infoArea.setText("Too high! Try again.");
                }
            } catch (NumberFormatException e) {
                infoArea.setText("Please enter a valid number.");
            }
            guessField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NumberGuessingGame game = new NumberGuessingGame();
                game.setVisible(true);
            }
        });
    }
}
