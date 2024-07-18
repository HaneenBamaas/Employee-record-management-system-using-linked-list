/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerecordmanagementsystem;
import java.util.Scanner;
/**
 *
 * @author lenovo
 */
public class linkedList {
   private Node head;
   
    public linkedList() {
       head=null;
    }
    
   public boolean check(int x) {
       if (head == null){
          return false;}
       
       Node temp = new Node();
       temp = head;
    
       while (temp != null) {
           if (temp.id == x)
             return true;
         temp = temp.next;
        }
    return false;
    }
   
   
   
   public void sortedInsert(int id, String name,String day,String phoneNumber ,String adress,
           double workHours,double salary){
          if ((check(id))) {
            System.out.println("Employee with this record Already Exists");
            return;
            
         }
          
       Node newNode = new Node(id, name,day, phoneNumber ,adress, workHours,salary);
       
       if(head==null|| head.id>=newNode.id ){
           newNode.next=head;
           head=newNode;   
           }
      else{
           Node current=head;
           while(current.next!=null&& current.next.id< newNode.id){
               current=current.next;
           }
           newNode.next=current.next;
           current.next=newNode;        
       }
       updateSalary(newNode.id);
        System.out.println();
        System.out.println("inserted record Successfully");
    }
    
    
    
    public int deleteNode(int id){
      Node temp = head;
      Node current = null;

      if (temp != null && temp.id == id) {
        head = temp.next;
        temp = null;
        System.out.println("Record Deleted Successfully");
        return 0;
         }

     while (temp != null && temp.id != id) {
        current = temp;
        temp = temp.next;
        }
     
     if (temp == null) {
        System.out.println("Record does not Exist");
        return -1;
    }
     
      current.next = temp.next;
      temp = null;
      System.out.println("Record Deleted Successfully");
      return 0;
    }
    
    
   public void updateNode(int id){
       
      Node temp = head;
      while (temp != null) {
         if (temp.id == id) {
            Scanner keyboard=new Scanner(System.in);
            System.out.println("Enter the number of information that you want to update:");
            System.out.println("\n\t\t1-Name"
                    + "\n\t\t2-First day of work"
                    + "\n\t\t3-Phone number of the employee"
                    + "\n\t\t4-Address"
                    + "\n\t\t5-Work hours"
                    + "\n\t\t6-Salary"); 
            
            int input=keyboard.nextInt();
            switch(input){
                case 1:{
                    System.out.print("Enter the new name that you would like to update:");
                    keyboard.nextLine();
                    String name=keyboard.nextLine();
                    temp.Name=name;
                    break;
                }
                case 2:{
                    System.out.print("Enter the new First day of work that you would like to update:");
                    keyboard.nextLine();
                    String day=keyboard.nextLine();
                    temp.First_day_work=day;  
                    break;
                }
                case 3: {
                    System.out.print("Enter the new Phone number of the employee that you would like to update:");
                    keyboard.nextLine();
                    String phone=keyboard.nextLine();
                    temp.phoneNumber=phone; 
                    break;
                }
                case 4: {
                    System.out.print("Enter the new Address of the employee that you would like to update:");
                    keyboard.nextLine();
                    String Address=keyboard.nextLine();
                    temp.adress=Address;
                  break;
                }
                 case 5: {
                    System.out.println("Enter the new Work hours of the employee that you would like to update:");
                    double Work_hours=keyboard.nextDouble();
                    while(Work_hours<32){
                       System.out.println(); 
                       System.out.println("Not excptable number"); 
                       System.out.println("Enter the Work hours:(Hint: it have to be 32 and above) ");
                       Work_hours=keyboard.nextInt();
                       }
                    double total=temp.salary/(1+(0.02*(temp.workHours-32)));
                    temp.salary=total;
                    temp.workHours=Work_hours; 
                    
                    updateSalary(temp.id);
                  break;  }
                case 6: {
                    System.out.println("Enter the new Salary of the employee that you would like to update:");
                    double Salary=keyboard.nextDouble();
                    temp.salary=Salary; 
                  break;
                } }
              System.out.println("Recrde updated suscsfully");
              System.out.println();
            return;
         }
          temp = temp.next;        }
          if (temp == null)
          System.out.println("No such Record Available");}
   

   
   
    public void showRecord() {
        Node temp = head;
        if (temp == null) {
           System.out.println("No Record Available");
         }
        else {
           System.out.println("ID\t\tName\t\tFirst day work\t\tphoneNumber\t\tadress\t\tWork Hours\t\tsalary");
 
        
        while (temp != null) {
           System.out.println(temp.id + "\t\t" + temp.Name + "\t\t" + temp.First_day_work + "\t\t\t" + temp.phoneNumber+"\t\t" + temp.adress+"\t\t"+ temp.workHours+"\t\t"+ temp.salary); 

           temp = temp.next;
        }
        
        System.out.println();
        }
      }
    
    
    public void searchRecord(int id)  {
        
      Node temp = head;
      while (temp != null) {
         if (temp.id == id) {
            System.out.println();
            System.out.println("ID Number\t" + temp.id);
            System.out.println("Name\t\t" + temp.Name);
            System.out.println("First day work\t" + temp.First_day_work);
            System.out.println("phoneNumber\t" + temp.phoneNumber);
            System.out.println("adress\t\t" + temp.adress);
            System.out.println("Work Hours\t" + temp.workHours);
            System.out.println("salary\t\t" + temp.salary);
            return;
         }
        temp = temp.next;
      }
    
      if (temp == null)
        System.out.println("No such Record Available");
       }
    
    
    
    public void updateSalary(int id){
        Node temp = head;
        while (temp != null) {
            if (temp.id == id) {
            
            double total=temp.salary+((temp.salary*0.02)*(temp.workHours-32));
            temp.salary= total;
            System.out.println();
            System.out.println("Salary updated automatically!");
            System.out.println("with "+(temp.workHours-32)+ " Extra hours... The new salary is: "+temp.salary);
            return;         
        }
        temp = temp.next;
      }
        if (temp == null)
        System.out.println("No such Record Available");    
      }
    }
    

class Node {
     Node next;
     int id;
     String Name;
     String First_day_work;
     String phoneNumber;
     String adress;
     double workHours;
     double salary;

      public Node(){ //empty constructure 
    }

    public Node(int id, String Name,String First_day_work, String phoneNumber , String adress,
       double workHours,double salary){
       this.id = id;
       this.First_day_work=First_day_work;
       this.Name=Name;
       this.phoneNumber=phoneNumber;
       this.adress=adress;
       this.workHours=workHours;
       this.salary=salary;
       this.next = null;    
    }
}