# RockPaperScissorsGame
A Rock, Paper, Scissors Game School Project that allows a user to play RPS against the computer.

## The game works this way: ##
- In a single round:
  - The user clicks a button to make their move (rock, paper, or scissors).
  - The program randomly generates a move for the computer.
  - The moves are displayed as images.
  - The program determines and displays the outcome of this one round.
- The user can play as many rounds as they want.
  - The program keeps track of and displays the number of computer wins, user wins, and ties across all rounds.
    
## Part 1: The RPS Game ##
- [x] Write a class (RPSGame) that represents the game. 
- [x] The RPSGame object is described by three characteristics. These are the instance data variables:
  - [x] number of computer wins
  - [x] number of user wins
  - [x] number of ties
- [x] Include appropriate getters and setters.
- [x] Include constants to represent the possible moves (rock, paper, or scissors) and the possible outcomes of a single round (user win, computer win, or tie).
  - [x] Use these constants to make your code more readable. 
  - [x] For example, if you are using ints to store the moves, it's more clear to test whether userMove==ROCK than userMove==1.
  - [x] You can decide what type of data to use for the constants (String, int, or something else). 
- [x] Write a generateComputerPlay method that generates a random move by the computer.
- [x] Write a findWinner method that takes in two moves as parameters (the user move and the computer move) and determines the outcome (user wins, computer wins, or tie).
  - [x] Determining the winner will require you to compare a lot of possible match-ups through a series of nested conditionals.
  - [x] The method should update the instance data (number of computer wins, number of user wins, and number of ties) depending on the outcome.

## Part 2: The GUI ##
Write the GUI program to interact with the user.
- [x] This class will create an object of type RPSGame and invoke the methods from that class to run the game.
- [x] The constructor sets up the display and create the instance of RPSGame.
- [x] Use the shell file provided by Prof. Masters, and it use as a starting point.
- Code goes inside the listener class:
- [x] The listener classes responds to the user selecting a move, invokes the appropriate methods in the RPS game class, and then updates the display. (Do not write all of the code inside the single listener class method. Write helper methods that are invoked from the listener class to break up and organize the code.)
- Here is some pseudocode for the listener class. It is not required to follow this algorithm.
  - [x] get the move from the user by determining which button was clicked
  - [x] update the display of the user’s move 
  - [x] generate a move by the computer by invoking a method on the RPSGame object
  - [x] update the display of the computer’s move 
  - [x] determine the outcome (the winner) by invoking a method on the RPS object
  - [x] update the display of the outcome
  - [x] get the updated game stats (number of computer wins, number of user wins, and number of ties) by invoking methods on the RPS object
  - [x] update the display of the outcome 

- [x] Add images 
 
## Part 3: Extra Credit A - Betting ##
Add support for betting.
- In RPSGame:
  - [x] Add instance data to represent the amount the user is betting (the same amount on each match) and the user’s balance of money. Write appropriate getters and setters for these instance data. 
  - [x] In the findWinner method, when the number of wins/losses is updated, also update the user’s balance by adding or subtracting their bet amount.
- In the GUI program:
- [x] Use the JOptionPane class to ask the user about betting prior to the game starting. This code should go inside the main method.
- [x] Use the JOptionPane.showConfirmDialog method to determine whether the user wants to bet.
- [x] If the user wants to bet, use the JOptionPane.showInputDialog method to find out how much the user wants to bet.
- [x] Change the RPSGUIGame constructor so that it takes one parameter: the bet amount.
- [x] Create a new JLabel to display the user’s balance. I recommend adding the label to the statusPanel. You can choose another place if you want.
- [x] If the user is betting, when the display of the stats is updated, update the display of the balance. 
- [x] If the user is not betting, no money information should be displayed during the game.

## Part 4: Extra Credit B - Text-Based Program ##
Write a text-based driver program that allows the user to play through the console (instead of through a GUI).
- [x] Use only text input and output.
- [x] Use the same RPSGame class that you used with the GUI- do not have a second, different RPSGame class.
- Here is some pseudocode for the main method. It is not required to follow this algorithm:
  - [x] create an instance of the RPSGame
  - [x] while the user wants to keep playing:
  - [x] read in the move from the user 
  - [x] generate a move by the computer by invoking a method on the RPSGame object
  - [x] determine the outcome (the winner) by invoking a method on the RPS object
  - [x] get the updated game stats (number of computer wins, number of user wins, and number of ties) by invoking methods on the RPS object
  - [x] print out the outcome and game stats to the user
  - [x] find out if the user wants to keep playing
