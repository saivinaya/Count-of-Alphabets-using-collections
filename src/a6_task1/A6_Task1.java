/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task1;

import static a6_task1.ReadFromFile.readFile;
import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class calls the readFile() method which will take the input(filename) from the user and reads the contents of the file,
 * then it prints the frequency of the alphabets present in that file.
 * @author VinayaSaiD
 */
public class A6_Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        String userInput = readFile();
        
        // convert all to lower case
        userInput = userInput.toLowerCase();
        // Remove any non words
        userInput = userInput.replaceAll( "\\W", " " );
        // remove any double spaces including the ones created from removing out non words
        userInput = userInput.replaceAll( "  ", " " );  
        // words in the entire text
        String[] words = userInput.split( " " );
        // remove all empty spaces
        userInput = userInput.replaceAll( " ", "" );  
        // each character in the entire text
        char[] chars = userInput.toCharArray();
        //System.out.println( userInput );
        System.out.println();
        TreeMap<Character, Integer> characterMap = new TreeMap<Character, Integer>();
         
        for (Character c : chars) 
        {   if (characterMap.containsKey(c)) 
            {   // getting the value and adding 1 to it
                characterMap.put(c, characterMap.get(c) + 1);
            } 
            else 
            {   // that alphabet is not present and we need to create it and add a value to it
                characterMap.put(c, 1);
            }
        }
        
        double sum = 0;
        for (int f : characterMap.values()) {
             sum += f;
        }
        
        // printing the values in the TreeMap
        System.out.println("The file has following number of respective numbers and alphabets:\n");
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) 
        {   double percentage = (double) ((entry.getValue())/sum);
            //System.out.println(entry.getKey() + ": " + percentage);
            System.out.format("%s %s %.4f\n", entry.getKey(), ":", percentage);
        }
    }
}
