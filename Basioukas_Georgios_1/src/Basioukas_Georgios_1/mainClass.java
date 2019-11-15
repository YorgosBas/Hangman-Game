package Basioukas_Georgios_1;

public class mainClass {
    //               .__                                      __
    //__  _  __ ____ |  |   ____  ____   _____   ____       _/  |_  ____
    //\ \/ \/ // __ \|  | _/ ___\/  _ \ /     \_/ __ \      \   __\/  _ \
    // \     /\  ___/|  |_\  \__(  <_> )  Y Y  \  ___/       |  | (  <_> )
    //  \/\_/  \___  >____/\___  >____/|__|_|  /\___  >      |__|  \____/
    //
    //          _
    //         | |
    //         | |__   __ _ _ __   __ _ _ __ ___   __ _ _ __
    //         | '_ \ / _` | '_ \ / _` | '_ ` _ \ / _` | '_ \
    //         | | | | (_| | | | | (_| | | | | | | (_| | | | |
    //         |_| |_|\__,_|_| |_|\__, |_| |_| |_|\__,_|_| |_|
    //                            __ / |
    //                            |___/
    //      --HANGMAN TERMINAL GAME BY GEORGIOS BASIOUKAS(dai19174)---
    //      ------for the purpose of 1st assignment in OOP class------

    public static void main(String [] args) {
        //initialize hangman game with games,wins and losses(0 because its the first game)
        MainMenu menu = new MainMenu(0, 0, 0);
        menu.initializeMenu();
    }
}
