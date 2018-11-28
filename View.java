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

import java.util.*;


public class View { //start public class View
    
    View(GradeBook gb) {  } // used Gradebook as new object for method referencing
    
    //method do display set of instruction
    public void help(){
      System.out.printf("The following commands are recognised\n"+
            "\tDisplay this message                                   > 0\n"+
            "\tDisplay a specific student record:                     > 1 studentID\n"+
            "\tDisplay records for all student records within a range > 2 mark1 mark2\n"+
            "\tDisplay statistics (minimum, maximum and average marks)> 3\n"+
            "\tExit the application                                   > 9\n");                  
	
    } 
    //method to use for menu option
    public void commandLoop(){
	int menuOption;
        GradeBook gb = new GradeBook(); // create new object for GradeBook class
          // set object for input
        Scanner input=new Scanner(System.in);  
       //set diplay where the user can input numbers or intigers
    System.out.print("Selection: ");
  for (;;) {
         if (!input.hasNextInt()) { // if user input is not integer
  System.out.println("Letters/words are not a valid input. Please enter a valid input!!!"); // this message will display
  System.out.println("The number you enter is not in the option. Please select between 0, 1, 2, 3 and 9!");
  System.out.print("Selection: "); // message beside the selected number
  input.next(); // waiting for input
  continue; // continue until condition is not satified
  }
    
        menuOption=input.nextInt();
        // set looping with condition to determine the selected option
        switch(menuOption){
            case 0: // to display intruction
                help();
                break;
            case 1: // to display record based on specific student id
                String id = input.nextLine().trim(); // set variable of user input
                Record student = gb.find(id);// call method of find and search for id that user enter
                if(student != null){ // set condition
                    //print student record if condition satisfied or the stundentid entry found in the record
                    System.out.println("Student ID " + "\t\t"+"Assignment"+ "\t\t"+ "Exam"+"\t\t"+"Average"+"\t\t"+"Grade");
                    System.out.println( student.getStundentId()+"\t\t\t"+student.getAssignment()+"\t\t\t"+student.getExam()+"\t\t"+student.getTotal()+"\t\t"+student.getGrade());
                }else 
                    //Elsse the record not found and print error message
                    System.out.println("This \""+id+"\" is not a valid studentID! Please take note that the studenID is compose of capital letter and number without space.");
                    System.out.println("Enter 2 0 100 to see the whole record."); 
                break;
            case 2: // to display records with specific range of from mark1 to mark3
                    int f1=input.nextInt();
                    int f2=input.nextInt();
                    ArrayList<Record> records = gb.find(f1,f2);
                    if ((f1 >= 0 && f2 <= 100)){
                    System.out.println("Student ID " + "\t\t"+"Assignment"+ "\t\t"+ "Exam"+"\t\t"+"Average"+"\t\t"+"Grade");
                    records.forEach((record) -> {
			System.out.println( record.getStundentId()+"\t\t\t"+record.getAssignment()+"\t\t\t"+record.getExam()+"\t\t"+record.getTotal()+"\t\t"+record.getGrade());
                    });
                    //error handling check if f1 valid and and f2 is invalid >= 101  
                    }else if ((f1 <= 100 && f2 >=101)){
                    System.out.println("The duration is not on the range. Valid is 0 up to 100 only.");
                    // if f1 is invalid <= -1 and f2 valid
                    }else if((f1 <= -1 && f2 >=0)){
                    System.out.println("The duration is not on the range. Valid is 0 up to 100 only.");
                    
                    //if f1 and f2 are both invalid <= -1
                    }else if((f1 <= -1 && f2 <=-1)){
                    System.out.println("The duration is not on the range. Valid is 0 up to 100 only.");
                    //if f1 and f2 are both invalid >=101
                    }else if((f1 >= 101 && f2 >=101)){
                    System.out.println("The duration is not on the range. Valid is 0 up to 100 only.");
                    }
                break;
            case 3: //to dispaly summary of records with lowest mark, highest mark and average mark listed upon initiating the option 3 
                int l = gb.lowestMark();
                int h = gb.highestMark();
                double a = gb.averageMark();
                System.out.println("Lowest  mark is " + l); // print the value of lowest mark
                System.out.println("Highest mark is " + h); // print the value of highest mark
                System.out.println("Average mark is " + a); // print the value of average mark
                break;
            case 9: // to exit on the application
                System.out.println("Thank you for using GradeBook. GoodBye!!!"); // print exit message
                System.exit(0); //stop running the application
            default: //
                // when user enter wrong option or not found in the menu this message will print.
            System.out.println("The number you enter is not in the option. Please select between 0, 1, 2, 3 and 9!");

        }
        commandLoop();
    }
}} //end of public class View
    
    
    
    