package controllers;

import helpers.InputHelper;
import java.util.Scanner;
import model.Swipe;
import model.VisitorSwipe;
import repositories.Repository;

/**
 *
 * @author Azeite 
 */
public class AttendanceController_increment3 {
    private final Repository repository;
    
    public AttendanceController_increment3() {
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
//        Scanner input = new Scanner(System.in);
//        String choice = input.nextLine();        
//        String myData  = "";       
//        char swipeType = new InputHelper().readCharacter("Would you like to add visitorSwipe[y/n]");
//        if(swipeType == 'Y' || swipeType == 'y')
//        {
//            choice = input.nextLine();
//        }
//        else if(swipeType == 'N' || swipeType == 'n')
//            choice = input.nextLine();
//        
        
 
Scanner input = new Scanner(System.in);
        
        //Modify this to pront the user for a yes and no question 
        String temp  = "";
        System.out.print("1. Swipe \n");
        System.out.print("2. Visitor swipe: ");
        String option = input.nextLine();
        switch(option){
            case "1":
                Swipe swipe = new Swipe();
                System.out.print("Enter card Id: ");
                temp = input.nextLine();
                swipe.setCardId(temp);
                System.out.print("Enter room: ");
                temp = input.nextLine();
                swipe.setRoom(temp);
                this.repository.add(swipe);
            break;
            case "2":
                VisitorSwipe visitorSwipe = new VisitorSwipe();
                System.out.print("Enter card Id: ");
                visitorSwipe.setCardId(input.nextLine());
                System.out.print("Enter room: ");
                visitorSwipe.setRoom(input.nextLine());
                System.out.print("Enter Name: ");
                visitorSwipe.setVisitorName(input.nextLine());
                System.out.print("Enter Company name: ");
                visitorSwipe.setVisitorCompany(input.nextLine());
                 this.repository.add(visitorSwipe);
            break;
            default:
                System.out.println("Invalid option, please try again!");
            break;
        }
        this.repository.store("swipes.txt");
    }
    
    private void listSwipes() 
    {
        System.out.format("\033[31m%s\033[0m%n", "Swipes");
        System.out.format("\033[31m%s\033[0m%n", "======");  
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
      

    private void listSwipesByCardIdOrderedByDateTime() 
    {         
        System.out.format("\033[31m%s\033[0m%n", "Swipes By Card Id");
        System.out.format("\033[31m%s\033[0m%n", "=================");
        String temp = new InputHelper().readString("Enter card Id");
        for(int i = this.repository.getItems().size() - 1; i > -1; i--)
        {
            if(this.repository.getItems().get(i).getCardId().equals(temp)) 
                System.out.println(this.repository.getItems().get(i).toString());
        }
    }    
    
    
    private void listSwipeStatistics() 
    {
        System.out.format("\033[31m%s\033[0m%n", "Swipe Statistics for room");
        System.out.format("\033[31m%s\033[0m%n", "=========================");
    } }
         

 