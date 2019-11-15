package Basioukas_Georgios_1;

import java.util.Scanner;

class MainMenu {
    private int games;                                //values to keep the number of all games played,won and lost
    private int wins;
    private int losses;

    //constructor
    MainMenu(int newGame, int newWin, int newLose) {
        this.games = newGame;
        this.wins = newWin;
        this.losses = newLose;
    }

    void initializeMenu() {
        boolean bool;
        String userChoice;

        do {
            menu();                                   //calls menu
            userChoice = inputChoice();               //calls function to read user's choice
            bool = checkChoice(userChoice);           //validates choice
        } while (!bool);

        initializePages(userChoice);                  //moves to next state
    }

    private void menu() {
        System.out.println("MAIN MENU \n\t- Start a new Game (N) \n\t- Statistics (S) \n\t- Exit (E) \n Please enter your choice: ");  //show menu
    }

    private String inputChoice() {
        Scanner read = new Scanner(System.in);
        return read.nextLine();                        //read choice
    }

    private boolean checkChoice(String userChoice) {
        String upperUserChoice = userChoice.toUpperCase();   //convert the choice to upper case for lower case inputs
        boolean bool1 = userChoice.length() == 1;            //check the length of the string
        boolean bool2 = upperUserChoice.contains("N") || upperUserChoice.contains("S") || upperUserChoice.contains("E");  //check the string only containing these letters
        if(!(bool1 & bool2)) wrongInput();                   //"raise error"
        return bool1 & bool2;
    }

    private void wrongInput() {
        System.out.println("\nWrong Input. Please try again with letters N, S, E only!\n"); //show error message
    }

    private void initializePages(String userChoice) {
        String upperUserChoice = userChoice.toUpperCase();
        switch (upperUserChoice) {
            case "N":
                Game game = new Game(games,wins,losses);   //create a new game with previous stats
                game.initializeGame();
                break;
            case "S":
                Statistics stats = new Statistics();        //show stats
                stats.initializeStatistics(games,wins,losses);
                break;
            case "E":
                Exit exit = new Exit();                    //exit program
                exit.exitProgram();
                break;
        }
    }
}
