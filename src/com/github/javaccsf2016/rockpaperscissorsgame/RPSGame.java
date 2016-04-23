package com.github.javaccsf2016.rockpaperscissorsgame;

import java.util.Random;

public class RPSGame {
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSOR = 2;
	
	public static final int LOSE = 0;
	public static final int TIE = 1;
	public static final int WIN = 2;
	
	public static final int INITIAL_MONEY = 1000;
	
	private int numberOfTies;
	private int numberOfWins;
	private int numberOfLoses;
	private int move;
	private int betMoney;
	private int balance;
	
	public static void main(String args[]) {
		RPSCommandLineGame.commandLineGame();
	}
	
	public RPSGame() {
		numberOfTies = 0;
		numberOfWins = 0;
		numberOfLoses = 0;
		balance = INITIAL_MONEY;
	}
	
	public void generateComputerPlay() {
		Random rand = new Random();
		this.move = rand.nextInt(3);
	}
	
	public boolean setBettingAmount(int money) {
		if(money >= 0 && money <= this.balance) { 
			this.betMoney = money;
			return true;
		} else {
			return false;
		}
	}
	
	public int findWinner(int userMove) {
		if (userMove >= ROCK && userMove <= SCISSOR) {
			if (userMove == this.move) {
				this.numberOfTies++;
				return TIE;
			} else if(userMove - this.move == 1 || userMove - this.move == -2) {
				this.numberOfWins++;
				this.balance += betMoney;
				return WIN;
			} else {
				this.numberOfLoses++;
				this.balance -= betMoney;
				return LOSE;
			} 
		} else {
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
	
	public int getCompMove() {
		return this.move;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getBettingAmount() {
		return this.betMoney;
	}
	
}
