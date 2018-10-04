package controllers;

import helpers.InputHelper;
import java.util.Scanner;
import repositories.Repository;

/**
 *
 * @author Azeite 
 */
public class AttendanceController_increment1 {
    private final Repository repository;
    
    public AttendanceController_increment1() {
        Scanner scan = new Scanner(System.in);
        char eFile = new InputHelper().readCharacter("Load data from the already existing Attendance file [y/n]");
        if(eFile == 'Y' || eFile == 'y')
        {
            String fileName = new InputHelper().readString("Enter the file name");
            this.repository = new Repository(fileName);
        }
        else
        {
            this.repository = new Repository();
      }
    }
    
    
    public void run() {
        boolean finished = false;
        
        do {
            char choice = displayAttendanceMenu();
            switch (choice) {
                case 'A': 
                    addSwipe();
                    break;
                case 'B':  
                    listSwipes();
                    break;
                case 'C': 
                    listSwipesByCardIdOrderedByDateTime(); 
                    break;                    
                case 'D': 
                    listSwipeStatistics();
                    break;
                case 'Q': 
                    finished = true;
            }
        } 
        while (!finished);
        // can we add an if statement for the user to try again at least 3 times 
 
    }
            
    
    private char displayAttendanceMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Swipe");
        System.out.print("\tB. List Swipes");        
        System.out.print("\tC. List Swipes In Date Time Order");
        System.out.print("\tD. List Swipes Which Match Card Id");       
        System.out.print("\tQ. Quit\n");         
        return inputHelper.readCharacter("Enter choice", "ABCDQ");
    }    
    
      private void addSwipe() {
        System.out.format("\033[31m%s\033[0m%n", "Add Swipe");
        System.out.format("\033[31m%s\033[0m%n", "=========");       
    }
      
    private void listSwipes() 
    {
        if(this.repository.getItems().size() <= 3)
        { 
            System.out.println(this.repository.getItems().toString().replace("[","").replace("]",""));
        }
        else if(this.repository.getItems().size() <= 3){}
        else 
        {
            System.out.println(this.repository.getItems().toString().replace("[","").replace("]",""));
        }
    }      
      
    private void listSwipesByCardIdOrderedByDateTime() {        
        System.out.format("\033[31m%s\033[0m%n", "Swipes By Card Id");
        System.out.format("\033[31m%s\033[0m%n", "=================");
    }    
    
    private void listSwipeStatistics() {
        System.out.format("\033[31m%s\033[0m%n", "Swipe Statistics for room");
        System.out.format("\033[31m%s\033[0m%n", "========================="); 
    }
}

 