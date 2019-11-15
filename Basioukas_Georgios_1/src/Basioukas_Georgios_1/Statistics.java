package Basioukas_Georgios_1;

class Statistics {

    void initializeStatistics(int games, int wins, int losses) {
        //handling grammar mistakes(if you played 1 time then it is "1 game" not "1 games". Similar to win and loses.
        String g = games == 1 ? " game" : " games";
        String t1 = wins == 1 ? " time" : " times";
        String t2 = losses == 1 ? " time" : " times";
        System.out.println("You have played so far " + games + g + ". You won " + wins + t1 + " and lost " + losses + t2);

        MainMenu menu = new MainMenu(games,wins,losses);
        menu.initializeMenu();
    }
}
