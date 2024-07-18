/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerecordmanagementsystem;
import java.util.*;


public class EmployeeRecordManagementSystem {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        Scanner keyboard=new Scanner(System.in);
        int input;
        System.out.println("\t\t\tWelcom To Employee Record Management System!");
        linkedList newNode=new linkedList();
        
        do{
            
        System.out.println();
        System.out.println("\t\tWe have many servaces Enter the number of the servace you want:");
        System.out.println("\t\t1-Insert employee record\n"+"\t\t2-Delete employee record\n" +
                            "\t\t3-Update employee record\n"+ "\t\t4-Show details of an employee\n" +
                            "\t\t5-Search an employee\n" +
                            "\t\t6-To exit");
        System.out.print("Enter the number of service:");
        input=keyboard.nextInt();
        System.out.println("****************************************************************************************");
       
        
        
            switch(input){
               case 1:{
                    System.out.print("Enter the name of employee: ");
                    keyboard.nextLine();
                    String name=keyboard.nextLine();
                    
                    System.out.print("Enter the ID of employee: ");
                    int id=keyboard.nextInt();
          
                    if(!(newNode.check(id))){
                       System.out.print("Enter the first day of work: ");
                       keyboard.nextLine();
                       String day=keyboard.nextLine();
                       
                       System.out.print("Enter the phone number of the employee: ");
                       String phoneNumber=keyboard.nextLine();
                       System.out.print("Enter the Address of the employee: ");
                      
                       String adress=keyboard.nextLine();
                 
                       System.out.print("Enter the Work hours: (Hint: it have to be 32 and above) ");
                       double workHours=keyboard.nextDouble();
                       
                       while(workHours<32){
                       System.out.println("Not excptable number:"); 
                       System.out.println("Enter the Work hours:(Hint: it have to be 32 and above) ");
                       workHours=keyboard.nextInt();
                       }
                       
                       System.out.print("Enter the Salary: ");
                       double salary=keyboard.nextDouble();
                       
                       newNode.sortedInsert(id, name,day, phoneNumber ,adress, workHours,salary);
                       System.out.println();
                       }
                    else{
                       System.out.println("Student with this record Already Exists");
                    }
                     break;
                   }
            case 2:{
                    System.out.print("Enter the number of employee`s id that you want to delete: ");
                    int id=keyboard.nextInt();
                    newNode.deleteNode(id);
                    break;
                }
            case 3:{
                  System.out.print("Enter the number of employee`s id that you would like to update: ");
                  int id=keyboard.nextInt(); 
                  newNode.updateNode(id); 
                  break;
               }
            case 4:{
                  System.out.println();
                  newNode.showRecord(); 
                  break;
               }
            case 5:{
                  System.out.print("Enter the number of employee`s id that you would like to search: ");
                  int id=keyboard.nextInt(); 
                  newNode.searchRecord(id);
                  break;
                 }
            case 6:{
                 break;
                 }
            default:
                        System.out.println("Wrong choice");
            }
        
        
            
         }while(input !=6);      
         }
         }