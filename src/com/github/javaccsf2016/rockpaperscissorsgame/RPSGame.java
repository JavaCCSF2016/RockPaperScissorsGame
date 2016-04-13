package com.github.javaccsf2016.rockpaperscissorsgame;

import java.util.Random;

public class RPSGame {
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSOR = 2;
	
	private int numberOfTies;
	private int numberOfWins;
	private int numberOfLoses;
	private int move;
	
	public RPSGame() {
		numberOfTies = 0;
		numberOfWins = 0;
		numberOfLoses = 0;
	}
	
	public void generateComputerPlay() {
		Random rand = new Random();
		this.move = rand.nextInt(3);
	}
	
	public int findWinner(int userMove) {
		if (userMove == this.move) {
			this.numberOfTies++;
			return 0;
		} else if(userMove - this.move == 1 || userMove - this.move == -2) {
			this.numberOfWins++;
			return 1;
		} else {
			this.numberOfLoses++;
			return -1;
		}
	}

	public int getLoses() {
		return this.numberOfLoses;
	}

	public int getWins() {
		return this.numberOfWins;
	}

	public int getTies() {
		return this.numberOfTies;
	}
	
}
