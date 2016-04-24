package com.github.javaccsf2016.rockpaperscissorsgame;

import java.util.Random;

public class RPSGame {
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSOR = 2;
	
	public static final int LOSE = 0;
	public static final int TIE = 1;
	public static final int WIN = 2;
	
	public static final int INITIAL = 0;
	
	private int numberOfTies, numberOfWins, numberOfLoses, compMove;
	private double betMoney, balance;
	
	public RPSGame() {
		numberOfTies = INITIAL;
		numberOfWins = INITIAL;
		numberOfLoses = INITIAL;
		balance = INITIAL;
	}
	
	public void generateComputerPlay() {
		Random rand = new Random();
		this.compMove = rand.nextInt(3);
	}
	

	public boolean setBettingAmount(double money) {
		if(money > INITIAL) { 

			this.betMoney = money;
			return true;
		} else {
			return false;
		}
	}
	
	public int findWinner(int userMove) {
		if (userMove >= ROCK && userMove <= SCISSOR) {
			if (userMove == this.compMove) {
				this.numberOfTies++;
				return TIE;
			} else if(userMove - this.compMove == 1 || userMove - this.compMove == -2) {
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
		return this.compMove;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getBettingAmount() {
		return this.betMoney;
	}
	
	public String toString() {
		String info = ("[STATS] Wins: " + this.getWins() +
				   " | Ties: " + this.getTies() + 
				   " | Loses: " + this.getLoses());
		if (this.getBettingAmount() != 0) {
			info += ("========================================\n" +
					"Remaing Balance: " + this.getBalance());
		}
		return info;
	}

	
}
