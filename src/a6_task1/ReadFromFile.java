/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class has readFile() method, which is used to read the lines in a file and put it into a String.
 * @author VinayaSaiD
 */
public class ReadFromFile {
 
    public static String readFile() throws Exception
    {
       
        String content;
        content = "";
        String line;
        Scanner sc = new Scanner( System.in );
        boolean error=true;
        while(error==true)
        {   error = false;
            // taking the filename as input from the user
            System.out.println( "Please enter File Path:" );
            String fileName = sc.nextLine();
            // using FileReader and BufferedReader
            try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {
                // Read data from a file line by line
                while ((line = br.readLine()) != null) {
                    content = content + line;
                }
            }
            catch (Exception e)
            {   error = true;
                System.out.println(e.getMessage());
                System.out.println("Wrong file path entered. Please enter a valid one.\n\n");
            }
        }
        return content;
    }
}

