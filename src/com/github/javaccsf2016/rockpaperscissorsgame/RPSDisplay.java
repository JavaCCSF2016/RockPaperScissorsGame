package com.github.javaccsf2016.rockpaperscissorsgame;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

public class RPSDisplay extends JFrame {
	
	public static final Font Meiryo20 = new Font("Meiryo UI", 0, 20);

	// buttons for the user to enter their move
	private JButton rockButton, paperButton, scissorsButton;

	// labels to display the number of wins/losses/ties
	private JLabel statusC, statusU, statusT, balance;

	// images and labels to display the computer and user's moves and the outcome of a match-up
	private ImageIcon rockImage, paperImage, scissorsImage;
	private JLabel compPlay, userPlay;
	private JLabel outcome;
	
	// the game object
	private RPSGame game;

	public RPSDisplay(int result) {

		// initializes the window
		super("Rock, Paper, Scissors, Go!");
		setSize(600, 460);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.black);
		setResizable(false);

		// creates the game object
		// 	NOTE: IF COMPLETING THE EXTRA CREDIT, YOU WILL NEED TO ADD A PARAMETER TO REPRESENT THE BET AMOUNT
		game = new RPSGame();


		// creates the labels for displaying the computer and user's move;
		// the images for the moves and the outcome of a match-up will be displayed
		// in a single panel
		rockImage = new ImageIcon("img/rock.jpg");
		paperImage = new ImageIcon("img/paper.jpg");
		scissorsImage = new ImageIcon("img/scissors.jpg");

		compPlay = new JLabel();
		compPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		compPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		compPlay.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		compPlay.setForeground(Color.cyan);
		compPlay.setFont(Meiryo20);
		compPlay.setText("Computer\'s move");
		userPlay = new JLabel();
		userPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		userPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		userPlay.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		userPlay.setForeground(Color.cyan);
		userPlay.setFont(Meiryo20);
		userPlay.setText("User\'s move");
		
		outcome = new JLabel();
		outcome.setHorizontalTextPosition(SwingConstants.CENTER);
		outcome.setForeground(Color.pink);
		outcome.setFont(Meiryo20);
		
		JPanel imageOutcomePanel = new JPanel();
		imageOutcomePanel.setBackground(Color.BLUE);
		imageOutcomePanel.setLayout(new BorderLayout());
		imageOutcomePanel.add(compPlay, BorderLayout.EAST);
		imageOutcomePanel.add(userPlay, BorderLayout.WEST);
		imageOutcomePanel.add(outcome, BorderLayout.SOUTH);
		
		
		// creates the labels for the status of the game (number of wins, losses, and ties);
		// the status labels will be displayed in a single panel
		statusC = new JLabel("Computer Wins:" + game.getLoses());
		statusU = new JLabel("  User Wins:" + game.getWins());
		statusT = new JLabel("  Ties:" + game.getTies());
		balance = new JLabel("  Balance: " + game.getBalance());
		statusC.setForeground(Color.white);
		statusC.setFont(Meiryo20);
		statusU.setForeground(Color.white);
		statusU.setFont(Meiryo20);
		statusT.setForeground(Color.white);
		statusT.setFont(Meiryo20);
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(Color.BLACK);
		statusPanel.add(statusC);
		statusPanel.add(statusU);
		statusPanel.add(statusT);
		if(result == JOptionPane.YES_OPTION) {
			balance.setForeground(Color.white);
			balance.setFont(Meiryo20);
			statusPanel.add(balance);
		}

		// the play and status panels are nested in a single panel
		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(800, 600));
		gamePanel.setBackground(Color.black);
		gamePanel.add(imageOutcomePanel);
		gamePanel.add(statusPanel);
		
		// creates the buttons and displays them in a control panel;
		// one listener is used for all three buttons
		rockButton = new JButton("Play Rock");
		rockButton.setFont(Meiryo20);
		rockButton.addActionListener(new GameListener());
		paperButton = new JButton("Play Paper");
		paperButton.setFont(Meiryo20);
		paperButton.addActionListener(new GameListener());
		scissorsButton = new JButton("Play Scissors");
		scissorsButton.setFont(Meiryo20);
		scissorsButton.addActionListener(new GameListener());

		JPanel controlPanel = new JPanel();
		controlPanel.add(rockButton);
		controlPanel.add(paperButton);
		controlPanel.add(scissorsButton);
		controlPanel.setBackground(Color.black);

		// the gaming and control panel are added to the window
		contentPane.add(gamePanel, BorderLayout.CENTER);
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	/* determines which button was clicked and updates the game accordingly */
	private class GameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == rockButton) {
				play(RPSGame.ROCK);
			}
			else if(event.getSource() == paperButton) {
				play(RPSGame.PAPER);
            }
            else if(event.getSource() == scissorsButton){
            	play(RPSGame.SCISSOR);
            }
           
		}
	}
	
	public void play(int move) {
		game.generateComputerPlay();
		int result = game.findWinner(move);
		if ( result == RPSGame.LOSE ){
			statusC.setText("Computer Wins: " + game.getLoses());
			outcome.setText("You Lost!");
		} else if ( result == RPSGame.TIE ){
			statusT.setText("Ties: " + game.getTies());
			outcome.setText("Tie Game!");
		} else if ( result == RPSGame.WIN ){
        	statusU.setText("User Wins: " + game.getWins());
        	outcome.setText("You Won!");
		}
		balance.setText("Balance: " + game.getBalance());
		updateCompPlayIcon(game.getCompMove());
		updateUserPlayIcon(move);
	}
	
	public void updateCompPlayIcon(int move) {
		switch (move) {
		case 0 : 
			compPlay.setIcon(rockImage);
			break;
		case 1 :
			compPlay.setIcon(paperImage);
			break;
		case 2 :
			compPlay.setIcon(scissorsImage);
		}
	}
	
	public void updateUserPlayIcon(int move) {
		switch (move) {
		case 0 : 
			userPlay.setIcon(rockImage);
			break;
		case 1 :
			userPlay.setIcon(paperImage);
			break;
		case 2 :
			userPlay.setIcon(scissorsImage);
		}
	}
	
	
	
	public static void main(String args[]) {
		// create an object of your class
<<<<<<< HEAD
		double bettingAmount = 0.0;
=======
		int bettingAmount = 0;
>>>>>>> origin/master
		int result = JOptionPane.showConfirmDialog(null,"Are you going to bet",
				"Comfirm",JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			do {
			bettingAmount = ( Integer.parseInt(JOptionPane.showInputDialog(null,
<<<<<<< HEAD
					"Enter how much you want to bet( Must greater than 0! ) : " )));
			  } while(!(bettingAmount > RPSGame.INITIAL));
=======
					"Enter how much you want to bet (0 - " + RPSGame.INITIAL_MONEY + "): ")));
			  } while(!(bettingAmount >= 0 && bettingAmount <= RPSGame.INITIAL_MONEY));
>>>>>>> origin/master
		}
		RPSDisplay frame = new RPSDisplay(result);
		frame.game.setBettingAmount(bettingAmount);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}