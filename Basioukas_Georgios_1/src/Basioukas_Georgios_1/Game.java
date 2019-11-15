package Basioukas_Georgios_1;

import java.util.Random;
import java.util.Scanner;

class Game {
    private StringBuilder hiddenWord = new StringBuilder();  //the word with the dashes
    private String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  //string to check if user entered the same letter by manipulating it
    private int right = 0;  //right guesses
    private int wrong = 0;  //wrong guesses
    private int games;      //all games played,wins and loses
    private int wins;
    private int losses;

    //constructor
    Game(int newGame, int newWin, int newLose) {
        this.games = newGame;
        this.wins = newWin;
        this.losses = newLose;
    }

    void initializeGame() {
        int currentLose = 0;                         //specific game stats
        int currentWin = 0;
        int currentGame = 0;
        String upperCaseGuess;

        String word = getRandomWord();              //initialize random word
        //System.out.println("THE WORD IS: " + word);
        initializeDashes(word);                     //convert word to dashes

        int numOfGuesses = 8;
        while(numOfGuesses > 0 & !(hiddenWord.toString().equals(word))) {  //convert string builder to string for equals to work
            wordOutput();                           //how the word is shown in terminal(first with dashes)
            countGuesses(numOfGuesses);             //show how many guesses left
            String guess = getGuess();              //read the guess

            upperCaseGuess = guess.toUpperCase();   //convert to upper case letters for lower case inputs
            if(checkGuess(word, upperCaseGuess)) {
                System.out.println("The guess " + upperCaseGuess + " is correct!");
                right++;
            }
            else {
                System.out.println("There are no " + upperCaseGuess + "'s in the word.");
                wrong++;
                numOfGuesses--;
            }
        }

        if(endGameResults(numOfGuesses)){
            System.out.println("Congratulations! You guessed the word: " + word);
            currentWin++;
        }
        else {
            System.out.println("You lost. The word was: " + word);
            currentLose++;
        }
        gameGuessesOutput();
        currentGame++;

        MainMenu menu = new MainMenu(games + currentGame,wins + currentWin,losses + currentLose);  //creates a new menu with stats from previous and current games
        menu.initializeMenu();
    }

    private String getRandomWord() {
        Random rand = new Random();             //no seed in parenthesis
        int index = rand.nextInt(20);   // 0-19 random indexes, not in a sequence because no seed is declared

        Dictionary dictionary = new Dictionary();
        return dictionary.getWord(index);
    }

    private void initializeDashes(String word) {
        for(char ignored : word.toCharArray()) {
            hiddenWord.append("-");
        }
    }

    private void wordOutput() {
        System.out.println("The random word is now: " + hiddenWord);
    }

    private void countGuesses(int numOfGuesses) {
        System.out.println("You have " + numOfGuesses + " guesses left.");
    }

    private String getGuess() {
        String guess;
        Scanner read = new Scanner(System.in);
        System.out.println("Your guess: ");
        guess = read.nextLine();
        if(validateGuess(guess)){
            return guess;
        }
        else {
            System.out.println("'\nWrong input. Please enter one different alphabetic character each time\n");
            return getGuess();      //recursion to get a right letter
        }
    }

    private boolean checkGuess(String word, String guess) {
        char c = guess.charAt(0);                       //turn guessed string into a char
        int init = 0;                                   //check if the method worked
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == c) {                   //if both chars match
                dashesToLetters(i, word.charAt(i));     //unveil the letter to the hidden word
                init++;                                 //method worked
            }
        }
        return !(0 == init);
    }

    private void dashesToLetters(int location, char c){
        hiddenWord.setCharAt(location, c);  //unveil the guessed letter to the right location in the hidden word
    }

    private boolean validateGuess(String guess) {
        return isOneLetter(guess) && isStringInAlphabet(guess) && !(hasAlreadyGuessedThisLetter(guess));
    }

    private boolean isStringInAlphabet(String str) {
        return ((!str.equals("")) & (str.matches("^[a-zA-Z]*$")));   //isLetter()
    }

    private boolean isOneLetter(String str) {
        return str.length() == 1;
    }

    private  boolean hasAlreadyGuessedThisLetter(String str) {
        String upperStr = str.toUpperCase();                        //converts string to upper case
        if(Alphabet.contains(upperStr)) {                           //if the guess is in the alphabet
            Alphabet = Alphabet.replace(upperStr, "-"); //replace it with a non letter
            return false;
        }
        else {
            return true;
        }
    }

    private boolean endGameResults(int numOfGuesses) {
        return (0 < numOfGuesses);
    }

    private void gameGuessesOutput() {
        //handling grammar mistakes(if you played one time then it is "1 game" not "1 games". Similar to guess and guesses.
        String r1 = correctGuesses() == 1 ? " guess" : " guesses";
        String r2 = wrongGuesses() == 1 ? " guess" : " guesses";
        System.out.println("You made " + correctGuesses() + " correct" + r1 + " and " + wrongGuesses() + " wrong" + r2);
    }

    private int correctGuesses() {
        return right;
    }

    private int wrongGuesses() {
        return wrong;
    }
}
