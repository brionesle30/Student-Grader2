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
public class Record implements Comparable<Record>{ //start public class Record
    
    //assigning of variables
    private String stundentId;
    private int assignment;
    private int exam;
    private int total;
    private String grade;
    private double average;
   
    
  //constructor for the attributes  
    public Record(String sid, int a, int e, int t, String g, double avg) {
        //initialize new vaules of field variable  
         this.stundentId = sid;
          this.assignment = a;
          this.exam = e;
          this.total = t;
          this.grade = g;
          this.average = avg;
         
    }
   //getter for stundentId
    public String getStundentId() {
        return stundentId;
    }
    //getter for assignment
    public int getAssignment() {
        return assignment;
    }
    //getter for exam
    public int getExam() {
        return exam;
    }
    //getter for total
    public int getTotal() {
        return total;
    }
    //getter for grade
    public String getGrade() {
        return grade;
    }
    //getter for grade average
    public double getAverage() {
        return average;
    }
     //method for sorting by sid
    @Override
    public int compareTo(Record o) {
        return stundentId.compareTo(o.getStundentId());
    }
    
    
} //end of public class Record

