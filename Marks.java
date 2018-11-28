/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
/**
 *
 * @author 12051033
 */
public class Marks { //start public class Marks
    // main method
    public static void main( String args[] ) {
        // print welcome message as user option 
    System.out.printf("The following commands are recognised\n"+
         "\tDisplay this message                                    > 0\n"+
         "\tDisplay a specific student record:                      > 1 studentID\n"+
         "\tDisplay records for all student records within a range  > 2 mark1 mark2\n"+
         "\tDisplay statistics (minimum, maximum and average marks) > 3\n"+
         "\tExit the application                                    > 9\n");  
    GradeBook gb = new GradeBook(); // set new object
    View v = new View( gb ); //initiate new object as class view 
    v.commandLoop(); // call method commadloop in public class view
   }
   
} //end of public class Marks
