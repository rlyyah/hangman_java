import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

class ReadingFromFile{

    private String fileName;
    private ArrayList<String> readFromFile;
    private ArrayList<String> countries;
    private ArrayList<String> capitals;

    public  ReadingFromFile(String fileName){
        
        readFromFile = new ArrayList<>();

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr); 
            String line = null;
            

            while((line = br.readLine())!=null){
                readFromFile.add(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{

            System.out.println("FILE HAS BEEN LOADED");

        }

        formatFile(readFromFile);


    }

    private void formatFile(ArrayList<String> unformattedFile){

        String[] splitted = null;
        Integer country = 0;
        Integer capital = 1;

        countries = new ArrayList<>();
        capitals = new ArrayList<>();

        for(String pair: unformattedFile){
            
            splitted = pair.trim().split("\\|");
            countries.add(splitted[0]);
            capitals.add(splitted[1]);
            
        }
    }

    

    public ArrayList<String> getReadFromFile() {
        return readFromFile;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public ArrayList<String> getCapitals() {
        return capitals;
    }

    
}