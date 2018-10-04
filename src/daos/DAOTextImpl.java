package daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Swipe;
import model.VisitorSwipe;
import repositories.Repository;

/**
 * @author Azeite
 */
public class DAOTextImpl implements DAOInterface {
    
   static int indexTracker = 0;
    
   public Repository load(String filename){
           Repository repository = new Repository();
           File loaderdFile = new File(filename);
           Swipe swipe = null;
           VisitorSwipe visitorSwipe = null;
           ArrayList<Swipe> List = new ArrayList<>();
           Scanner read;
           String data;
           Calendar calendar = null;
        try {
            read = new Scanner(loaderdFile);
             while(read.hasNextLine()){
                 data = read.nextLine();
                 if(data.equals(""));
                 else if(data.split(",").length <= 4){
                     calendar = Calendar.getInstance();
                     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                     dateFormat.parse(data.split(",")[3].replace("\"", ""));
                     calendar = dateFormat.getCalendar();
                     swipe = new Swipe(Integer.parseInt(data.split(",")[0]), data.split(",")[1].replaceAll("\"", ""), data.split(",")[2].replaceAll("\"", ""), calendar); List.add(swipe); }
                 else if(data.split(",").length >= 4) { 
                     calendar = Calendar.getInstance();
                     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                     dateFormat.parse(data.split(",")[3].replace("\"", ""));
                     calendar = dateFormat.getCalendar();
                     visitorSwipe = new VisitorSwipe(Integer.parseInt(data.split(",")[0]), data.split(",")[1].replaceAll("\"", ""), data.split(",")[2].replaceAll("\"", ""), calendar, data.split(",")[4].replaceAll("\"", ""), data.split(",")[5].replaceAll("\"", "")); List.add(visitorSwipe); }
               }
              repository.setItems(List);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (ParseException ex) 
        {
           Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repository;
       }
   
       public void store(String filename, Repository repository)
       {
           try 
           {
            FileWriter writeInFile = new FileWriter(filename, true);
            for(int i = indexTracker; i < repository.getItems().size(); ++i) { // Search for track index
                if(repository.getItems().get(i).toString(',').equals(""));
                else{ ++indexTracker; writeInFile.write(repository.getItems().get(i).toString(',')); }
            }
            writeInFile.close();
            } 
           catch 
                   (IOException e) 
            {
                e.printStackTrace();
            }
       }
    //Using try-catch, implemented a filewriter which takes a file as a paramenter and a true value for boolean
    //A for loop that initializes a variable to track index
       //LondiWhat is happening with this method
       
       //it opens a imputstram and writes to a file 
       // it takes a file name 
       //loads a the repository data as an argument 
       
       
       
}
