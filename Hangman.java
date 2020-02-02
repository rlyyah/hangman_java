import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {

    private String password;
    private String hint;
    private Integer healthPoints = 10;
    private Set<Character> lettersToGuess;
    private Set<Character> lettersGuessed;
    private String showToUser;
    // private Set<Character> passwordSet;
    // private Set<String> charSet;
    
    public Hangman(ArrayList<String> country, ArrayList<String> capital){

        Random random = new Random();
        int rand = 0;
        rand = random.nextInt(country.size());

        System.out.println("Country size");
        System.out.println(country.size());
        System.out.println(rand);
        this.password = capital.get(rand);
        this.hint = country.get(rand);

        lettersToGuess = new HashSet<>();
        lettersGuessed = new HashSet<>();
        

        for(int i =0; i<password.length();i++){
            if(!Character.isWhitespace(password.charAt(i))){
                lettersToGuess.add(password.toLowerCase().charAt(i));    
            }
            
        }
        System.out.println(lettersToGuess);
    }

       
    public String getInput(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String input = null;
        boolean askForLetter = true;
        do{
            System.out.println("Please enter an English character or a whole word");

                Scanner in = new Scanner(System.in);
                input = in.nextLine();

            
            for(char c: alphabet){
                if(c==input.charAt(0)){
                    askForLetter = false;
                    break;
                }
            }
        }while(askForLetter);
        System.out.println("Entered: " + input);
        return input;
    }

    public Boolean isInPassword(String character){
        Boolean letterInPassword = false;
        
        if(character.length()>1){
            if(this.password.toLowerCase().compareTo(character.toLowerCase())==0){
                letterInPassword = true;
            }
        } else {
            lettersGuessed.add(character.toLowerCase().charAt(0));
            for(char c: lettersToGuess){
                if(c == character.toLowerCase().charAt(0)){
                    letterInPassword = true;
                }
            }
            
        }

        return letterInPassword;
    }

    public void letterFound(String ch){
        if(ch.length()>1){
            lettersToGuess.clear();
        }else{
            lettersToGuess.remove(ch.charAt(0));
        }
        
    }

    public void showUser(){
        System.out.println();
        for(int i=0;i<this.password.length();i++){
            if(lettersGuessed.contains(this.password.toLowerCase().charAt(i))){
                System.out.print(this.password.charAt(i));
            }else{
                System.out.print("_");
            }
            System.out.print(" ");
            
        }
        System.out.println();
    }


    public String getPassword() {
        return password;
    }

    public String getHint() {
        return hint;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Set<Character> getLettersToGuess() {
        return lettersToGuess;
    }

    public void setLettersToGuess(Set<Character> lettersToGuess) {
        this.lettersToGuess = lettersToGuess;
    }

    public Set<Character> getLettersGuessed() {
        return lettersGuessed;
    }

    public void setLettersGuessed(Set<Character> lettersGuessed) {
        this.lettersGuessed = lettersGuessed;
    }

    public String getShowToUser() {
        return showToUser;
    }

    public void setShowToUser(String showToUser) {
        this.showToUser = showToUser;
    }
    


}