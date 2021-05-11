package lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        printResults("file.txt");

    }

    public static String rarestWord(String filename) throws IOException{
        HashMap<String, Integer> wordList = new HashMap<>();
        String[] words = getTextFromFile(filename).split("\\s+");
        for(String word: words){
            if (wordList.containsKey(word)){
                wordList.replace(word, wordList.get(word)+1);
            } else {
                wordList.put(word, 1);
            }
        }
        int minNumberOfUsages = wordList.size();
        String rarestWord="";
        for(String word: wordList.keySet()){
            if (wordList.get(word) < minNumberOfUsages){
                minNumberOfUsages = wordList.get(word);
                rarestWord = word;
            }
        }
        return rarestWord;
    }

    public static String getTextFromFile(String filename) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String str;
            StringBuilder text = new StringBuilder("");
            while ((str = br.readLine()) != null) {
                text.append(str);
            }
            return text.toString();
        }
    }

    public static void printResults(String filename){
        try{
            System.out.println("The rarest word in the file " + filename +": " + rarestWord(filename));
        } catch (IOException e){
            System.out.println("Exception! " + e.getMessage());
        }
    }
}
