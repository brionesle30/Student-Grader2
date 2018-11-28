/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;


import java.util.Arrays;
import java.util.*;
/**
 *
 * @author 12051033
 */
public class GradeBook 
{ // start public class GradeBook 
    Record [] gradeBook;
    int nrecords;
    
    //assign constructor
    public GradeBook() {
        this.loadFromTables(); //setting new value for loadFromTable
    }
    //method to search marks by student id 
    public Record find( String sid ) {
        for (int i = 0; i < this.gradeBook.length; i++ ){
            if(this.gradeBook[i].getStundentId().compareTo(sid)==0){
                return this.gradeBook[i];
            }
        }
        return null;
    }
    //method to determine lowestt mark
    public int lowestMark() {
        int lowMark = -1;
        for (Record gradeBook1 : this.gradeBook){
           int t = gradeBook1.getTotal();
            if (lowMark==-1||t < lowMark){
                lowMark = t;
            }
        }
        return lowMark; // return the new value of lowMark
    }
    //method to determine highest mark
    public int highestMark() {
        int highMark = 0;
        for (Record gradeBook1 : this.gradeBook){
           int t = gradeBook1.getTotal();
           if (t > highMark){
               highMark = t;
           }
        }
        return highMark; // return the new value of highMark
    }
    ///method to determine average mark
    public double averageMark() {
        double total = 0;
        for (Record gradeBook1 : this.gradeBook){
           total += gradeBook1.getTotal();
        }
        return total / gradeBook.length; // return the new value of total which is the average
    }
    //constructor to set range of  array for displaying all record based on range
    public  ArrayList<Record> find( int mark1,int mark2 ) {
        ArrayList<Record> alr = new ArrayList<>();
        this.sortById();
        for (Record gradeBook1 : this.gradeBook) {
            double g = gradeBook1.getTotal();
            if (g>=mark1&&g<=mark2) {
                alr.add(gradeBook1);
            }
        }
        return alr;
    }
    //method to sort the array by student id
    private void sortById() {
        Arrays.sort(this.gradeBook); //return method of sorting
    }  
    
    
    private void loadFromTables() { //assigning initial values for the application
        
        String[] students = { // assign values for stundent ID array
            "S10","S20","S30","S40","S50", "S60", 
            "S08","S18","S28","S38","S48", "S58",
            "S06","S16","S26","S36","S46", "S56",
        };
        int[] assignment = { // assign values for assignment array
            0, 10, 20, 30, 30, 40, 
            0, 10, 20, 30, 30, 40, 
            0, 10, 20, 30, 30, 40,
        };
        int[] exam = { // assign values for exam array
            0, 39, 44, 44, 54, 59, 
            1, 40, 45, 45, 55, 60, 
            2, 41, 46, 46, 56, 58, 
        };
        
        // initiate new values for the field variables array
        nrecords = students.length;
        this.gradeBook = new Record[nrecords];
        
        // create looping for the nrecords array 
        for (int ii = 0; ii < nrecords; ii++ ) {
            int t = assignment[ii]+exam[ii]; //  assign and initiate variable t as the total grade
            String g = calculateGrade( t ); // convert total grade to letter grade
            int avg = t /2; // set value for average
            // initiate new value of Record as r
            Record r = new Record( students[ii], assignment[ii], exam[ii], t, g, avg ); //create new value of record
            this.gradeBook[ii] = r; // apply sorthing method for the recosrd based on sid 
        }
    }
    
    private String calculateGrade(int total) { // method to determine grade letter	
        String markLet = ""; //set marklet as null 			
        if (total >=85) markLet = "HD"; // apply the condition for the value of markLet 
        else if (total >=75) markLet = "D"; //if condition satisfied depending on the average  
        else if (total >=65) markLet = "C"; // then mark will be equivalent
        else if (total >=50) markLet = "P"; //to assign letter for the range.
        else if (total >= 1) markLet = "F"; //the average then mark will be equivalent to assign letter for the range.
        else if (total == 0) markLet = "AF"; 
        return markLet; // return the value of markLet depending on the satisfied condition 
    }
}// end public class GradeBook 
 
 