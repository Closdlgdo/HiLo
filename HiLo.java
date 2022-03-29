import java.util.Scanner;

public class HiLo { //this class is public which means we can run it from the command line or the terminal.

	public static void main(String[] args) { //here the method will run when the class is executed between the curly brackets.

		Scanner scan = new Scanner(System.in);// creates a Scanner object called scan to pull input from the computers keyboard, System.in.

		String playAgain = " ";
		do { //the do while loop does all the steps one full round of play, then it'll repeat itself again from choosing a random number until it declares the winning 
			//guess and asks te user to play again. 
			//create a random number for the user to guess
			int theNumber = (int)(Math.random() * 100+ 1);// math.random() generates a random number between 0.0 and 0.99999.
			//(int) is a type cast that changes the decimal to a whole number.
			int numberOfTries = 0;//creating a new variable 
			//System.out.println(theNumber);

			int guess = 0; //calling the variable that will store the user's guess.
			// this also initializes the guess variable to a starting value of 0. 
			while (guess != theNumber) {
				/*we use the while to let java know we are building the while loop. everything inside the parenthesis
		is the condition. while the value stored in guess is not equal to (!=) the value stored in theNumber, the loop should repeat whatever statement
		follow this line of code. */
				System.out.println("Guess a number between 1 and 100: "); //Now we have to prompt the user to enter a guess.
				guess = scan.nextInt(); //method that is looking for the int value the user inputs from the keyboard.
				numberOfTries = numberOfTries + 1;//this adds to the number of tries every time the guessing loop executes. 
				if (guess < theNumber)//this if statement will select whether to run a block of statement once or not at all based on a condition/expression.
					System.out.println(guess + " is too low. Try again.");
				else if (guess > theNumber) //here we begin the next if statement immediately after the else statement.
					System.out.println(guess + " is too high. Try again.");
				else{		//we don't need a conditional expression for this final else statement. 
					System.out.println(guess + " is correct. You win!");
					System.out.println("It only took you " + numberOfTries + " tries! Not too shabby!");//this outputs the text to let user know how many tries they did.
				//System.out.println("You entered " + guess + ".");// this will output to the user the string and his integer input. this concatenates the Strings and integer(guess). 
			}
		}
			System.out.println("Would you like to play again (y/n)?");
			playAgain = scan.next();
		} while (playAgain.equalsIgnoreCase("y")); //we close the do while with a while condition to check whether the user replied with a yes. 
		System.out.println("Thank you for playing! Adios!");
		scan.close();
	} // at line 36 it closes the block of code that repeats the game with a brace.
}/*the equals method tells you whether a string variable is exactly the same as another string of characters. The equals_ignore_case method tells you whether the 
the strings are equal even if their capitalization is different.*/ 


