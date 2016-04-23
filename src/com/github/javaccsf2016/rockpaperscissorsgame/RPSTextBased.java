package com.github.javaccsf2016.rockpaperscissorsgame;

import java.util.Scanner;

public class RPSTextBased {
	public static void main(String[] args) {
		RPSGame cliGame = new RPSGame();
		displayCommandLineGameHeader();
		boolean keepPlaying = true;
		while (keepPlaying) {
			displayCommandLineMenu();
			keepPlaying = displayCommandLineGame(cliGame);
		}
	}
	
	public static void displayCommandLineGameHeader() {
		System.out.println("RPS Game in command line");
	}
	
	public static void displayCommandLineMenu() {
		System.out.print(   "========================================\n" +
							"0: Rock | 1: Paper | 2: Scissor  \n" +
							"Type any other number to quit.\n"    +
							"Your move: ");
	}
	
	public static boolean displayCommandLineGame(RPSGame cliGame) {
		Scanner scan = new Scanner(System.in);
		int userInput = scan.nextInt();
		cliGame.generateComputerPlay();
		switch (cliGame.findWinner(userInput)) {
		case 0: 
			System.out.println("=== Computer won ===");
			System.out.println("[STATS] Wins: " + cliGame.getWins() +
							   " | Ties: " + cliGame.getTies() + 
							   " | Loses: " + cliGame.getLoses());
			return true;
		case 1: 
			System.out.println("=== Tie ===");
			System.out.println("[STATS] Wins: " + cliGame.getWins() +
					   " | Ties: " + cliGame.getTies() + 
					   " | Loses: " + cliGame.getLoses());
			return true;
		case 2:
			System.out.println("=== You won! ===");
			System.out.println("[STATS] Wins: " + cliGame.getWins() +
					   " | Ties: " + cliGame.getTies() + 
					   " | Loses: " + cliGame.getLoses());
			return true;
		default:
			System.out.println("Quit");
			return false;
		}
	}
}