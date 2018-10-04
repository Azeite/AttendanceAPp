 
package attendanceapp;

import controllers.AttendanceController;

 
public class AttendanceApp {

    public static void run() 
    {        
        System.out.println("Attendance App\n" + "==============\n\n");
        AttendanceController attendanceController = new AttendanceController();
        attendanceController.run();
        System.out.println("Thank you for using Attendance App. Good bye.\n");        
    }
    
     
    public static void main(String[] args) 
    {
        AttendanceApp attendanceApp = new AttendanceApp();
        attendanceApp.run();
    }
    
}
