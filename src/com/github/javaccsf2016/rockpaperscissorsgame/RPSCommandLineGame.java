package com.github.javaccsf2016.rockpaperscissorsgame;

import java.util.Scanner;

public class RPSCommandLineGame {
	public static void commandLineGame() {
		RPSGame cliGame = new RPSGame();
		displayCommandLineGameHeader();
		boolean keepPlaying = true;
		betting(cliGame);
		while (keepPlaying) {
			displayCommandLineMenu();
			keepPlaying = displayCommandLineGame(cliGame);
		}
	}
	
	public static void betting(RPSGame cliGame) {
		System.out.println("Your balance is" + cliGame.getBalance());
		Scanner scan = new Scanner(System.in);
		boolean valid = false;
		while (valid == false) {
			System.out.println("Enter the amount of money you want to bet. Enter 0 to disable betting: ");
			int money = scan.nextInt();
			valid = cliGame.setBettingAmount(money);
			valid = true;
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
	
	public static void printStats(RPSGame cliGame) {
		System.out.println("[STATS] Wins: " + cliGame.getWins() +
				   " | Ties: " + cliGame.getTies() + 
				   " | Loses: " + cliGame.getLoses());
		if (cliGame.getBettingAmount() != 0) {
			System.out.println("Remaing Balance: " + cliGame.getBalance());
		}
	}
	
	public static boolean displayCommandLineGame(RPSGame cliGame) {
		Scanner scan = new Scanner(System.in);
		int userInput = scan.nextInt();
		cliGame.generateComputerPlay();
		switch (cliGame.findWinner(userInput)) {
		case 0: 
			System.out.println("=== Computer won ===");
			printStats(cliGame);
			return true;
		case 1: 
			System.out.println("=== Tie ===");
			printStats(cliGame);
			return true;
		case 2:
			System.out.println("=== You won! ===");
			printStats(cliGame);
			return true;
		default:
			System.out.println("Quit");
			return false;
		}
	}
}
