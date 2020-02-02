public class app {
    public static void main(String[] args){

        ReadingFromFile passwordList = new ReadingFromFile("/home/ubuntuwanderer/java_adventure/hangman_in_java/countries_and_capitals.txt");
        boolean restart = true;
        while(restart){
            Hangman hangman = new Hangman(passwordList.getCountries(), passwordList.getCapitals());
            System.out.println();
            System.out.println(hangman.getPassword());
            System.out.println();
            System.out.println();
            
            Integer hp = hangman.getHealthPoints();
            while( (!hangman.getLettersToGuess().isEmpty()) && (hp > 0)){
                System.out.println("HEALTH POINTS: " + hp);
                System.out.println(hangman.getLettersToGuess());
                System.out.println(hangman.getLettersGuessed());
                System.out.println("The capital city of " + hangman.getHint() + " is:");
                System.out.println();

                hangman.showUser();
                System.out.println();
                
                
                
                String userInput = hangman.getInput().toLowerCase();
                
                
                
                if(userInput.length()==1 && hangman.getLettersGuessed().contains(userInput.toLowerCase().charAt(0))){
                    System.out.println("You've already tried this letter dummy :)");
                    System.out.println(hangman.getLettersGuessed().contains(userInput.toLowerCase().charAt(0)));
                }else{
                    if(hangman.isInPassword(userInput)){
                        hangman.letterFound(userInput);
                    }else{
                        
                        System.out.println("Letter missed!");
                        hangman.setHealthPoints(hp-1);
                        hp = hangman.getHealthPoints();
                    } 

                }

            } 
        System.out.println("The capital of " +hangman.getHint() + " is " + hangman.getPassword());
        System.out.println("Would you like to restart the game? Press Y for yes or N for No");
        String restartCommand = hangman.getInput().toLowerCase();
        if(restartCommand.equals("n")){
            restart = false;
        }

        }

        
        

        

        
    }
}