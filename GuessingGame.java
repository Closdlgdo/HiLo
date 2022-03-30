import javax.swing.JFrame;//this will allow our program to use the GUI capabilities of Swing's set of packages.
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;//awt stands for abstract window toolkit
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = " ";
		try { // this will try to do something that we know might cause an exception. 1.where the exception might occur and wrap the code inside a try block.
			int guess = Integer.parseInt(guessText); //this line declares guess to be an integer variable. Then, it searches/parses for an integer from the text the user entered.
			if (guess < theNumber)
				message  = guess + " is too low. Try again.";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else {
				message = guess + 
						" is correct! Not too shabby! Lets play agan!";
				newGame();
			}
		} catch (Exception e) { // this is the second part of "try". this will catch/handle the exception that might occur rather than allowing it to break the program.
			//2. What we want to do if there is an exception. put that in a catch block. 
			message = "Enter a whole number between 1 and 100."; //this only happens when an exception happens.
		} finally { //this block will always execute if it is provided. 3. and what we want to do after either the try or catch block finishes. 
			lblOutput.setText(message); // this will show the message to the user by changing the text property of the jlabel called lbloutput to the correct string variable message.
			txtGuess.requestFocus(); //this will request that the cursor be placed back in the text field every time the user guesses again.
			txtGuess.selectAll(); // this will select all the text from the users previous guess so that their new guess will replace the old one automatically.
		}
	}	
	public void newGame() { //we want to tell the computer to pick a new secret random number whenever the new round of guessing game starts.
		theNumber = (int)(Math.random()*100 + 1);

	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Carlos's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblCarlossHiloGuessing = new JLabel("Carlos's Hi-Lo Guessing Game");
		lblCarlossHiloGuessing.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCarlossHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarlossHiloGuessing.setBounds(6, 39, 438, 16);
		getContentPane().add(lblCarlossHiloGuessing);

		JLabel lblNewLabel = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(35, 94, 274, 16);
		getContentPane().add(lblNewLabel);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {//this block of code will allow the user to press ENTER to submit their guess. 
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(321, 89, 50, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {//this is the event listener code. 
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(166, 149, 117, 29);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setBounds(99, 214, 251, 16);
		getContentPane().add(lblOutput);
	} //we use a new coding superpower; the "extends" keyword.

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame(); //this creates a new guessing game called the game. 
		theGame.newGame(); //this line will start the guessing game with a new random number.
		theGame.setSize(new Dimension(450,300));//this creates the size of the frame for the application. width and height in pixels. 
		theGame.setVisible(true);//makes the app visible on the screen. Guessing game extended the class JFrame. theGame is a descendant of the JFrame parent class.
	}
}
