import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class LabExamQ1 extends JFrame implements ActionListener {

	// gui components
	private JButton submitButton;
	private JTextField guessTextField;
	private JLabel countDownLabel;
	private JLabel guessResponseLabel;

	// int to define countdown start time
	public int countDown = 30;

	// will generate a random integer every time the program is run
	public int randomInt = (int) (Math.random() * 50);

	//instance of the countdown class.
	private Countdown begin = new Countdown();

	public LabExamQ1() {

		// lay out gui components: upper JPanel with a textfield and submit
		// button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Higher/Lower Game");
		setSize(400, 100);
		setVisible(true);
		JPanel top = new JPanel();
		guessTextField = new JTextField(10);
		top.add(guessTextField);
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		top.add(submitButton);
		add(top, BorderLayout.NORTH);

		// add to lower Jpanel a countdown label and the response label
		JPanel bottom = new JPanel();
		countDownLabel = new JLabel("" + countDown);
		guessResponseLabel = new JLabel();
		bottom.add(countDownLabel);
		bottom.add(guessResponseLabel);
		add(bottom, BorderLayout.CENTER);

		// this executes the swingworker thread when the GUI initialises.
		begin.execute();

		// this will print the randomInt to console for testing purposes:
		System.out.println(randomInt);
	}

	// swingworker thread class, counts down from 30. When it reaches zero it
	// prints GAME OVER in console
	private class Countdown extends SwingWorker<Void, Integer> {
		public Void doInBackground() {
			try {
				while (countDown >= 0) {

					countDownLabel.setText("" + countDown);
					publish(countDown--);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {

			}
			System.out.println("game over !");
			begin.cancel(true); // close thread as the game is over
			return null;
		}

		// process method processes what was published in the swingworker above,
		// sets the countdown to appear in the label.
		public void process(ArrayList<Integer> counter) {
			int currentValue = counter.get(counter.size() - 1);

			countDownLabel.setText("" + currentValue + "  seconds left");
		}
	}

	@Override
	/*
	 * action performed method, parses the string user input to int and compares
	 * with the random int. if matching, the swingWorker in stopped by the
	 * cancel() method and a message appears saying they have one. if not, tells
	 * user to guess higher or lower.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submitButton) {
			int playerGuess = Integer.parseInt(guessTextField.getText());

			if (playerGuess == randomInt) {
				guessResponseLabel.setText("congrats you win");
				begin.cancel(true);
				System.out.println("well done you have won");
			} else if (playerGuess > randomInt) {
				guessResponseLabel.setText("nope try lower");
			} else if (playerGuess < randomInt) {
				guessResponseLabel.setText("nope try higher");
			}
		}

	}

	// main method including the run method for the swingworker.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LabExamQ1();
			}
		});
	}
}
