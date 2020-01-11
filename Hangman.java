import java.util.ArrayList;
import java.util.Random;

public class hangman {

    private String password;
    private String hint;
    
    public hangman(ArrayList<String> country, ArrayList<String> capital){
        Random random = new Random();
        random.setSeed(1234567890);
        rand = random.nextInt(country.size());
        this.password = capital.get(rand);
        this.hint = country.get(rand);
    }

    public String getPassword() {
        return password;
    }

    public String getHint() {
        return hint;
    }


}