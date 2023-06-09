/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import javax.swing.JOptionPane;

/**
 * @author Fungho Baloyi - ST10405022
 *
 */
public class TestLogin {
    public static void main(String[] args){
        String userN;
        String passW;
        String firstN;
        String lastN;
        int select = 0;
        Login myLogin = new Login();
        boolean log;
        //option = JOptionPane.showInputDialog(null,"Do you want to register(1) or login(2)","Create an account",JOptionPane.QUESTION_MESSAGE);
        firstN = JOptionPane.showInputDialog(null,"What is your First Name?","Create an account",JOptionPane.QUESTION_MESSAGE);
        lastN = JOptionPane.showInputDialog(null,"What is your Last Name?","Create an account",JOptionPane.QUESTION_MESSAGE);
        userN = JOptionPane.showInputDialog(null,"Enter a Username:");
        myLogin.setFirst(firstN);
        myLogin.setLast(lastN);
        myLogin.setUser(userN);
        if(myLogin.checkUserName() == true)
        {
            passW = JOptionPane.showInputDialog(null,"Enter a password:");
            myLogin.setPass(passW);

            if(myLogin.checkPasswordComplexity() == true)
            {
            JOptionPane.showMessageDialog(null,myLogin.registerUser()+"\nUser has been registered successfully."); 
            }
            else
            {
            JOptionPane.showMessageDialog(null,myLogin.registerUser()); 
            }
        }
        else
            JOptionPane.showMessageDialog(null,myLogin.registerUser()); 
        JOptionPane.showMessageDialog(null,"Welcome "+ myLogin.getFirst() + " ,"+myLogin.getLast()+" it is great to see you.");
        select = JOptionPane.showConfirmDialog(null,"Do you wish to login?", "Login Page", JOptionPane.YES_NO_OPTION);
        if(select ==  JOptionPane.YES_OPTION)
            log = (select ==  JOptionPane.YES_OPTION);//(Farrell, 2022)
        else
        {
            
            return;
        }
        userN = JOptionPane.showInputDialog(null,"Enter your Username:");
        myLogin.setUser(userN);
        passW = JOptionPane.showInputDialog(null,"Enter your password:");
        myLogin.setPass(passW);
        myLogin.loginUser();
        JOptionPane.showMessageDialog(null,myLogin.returnLoginStatus());
        // Get the number of tasks to enter
        
        if (myLogin.loginUser())
        {
            
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            int numTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of tasks to enter:"));
            // create array of Task objects
            Task[] tasks;//(Farrell, 2022)
            String[] taskStatuses = {"To Do", "Done", "Doing"};
            String menu = "Task Manager\n\n" +
                "1. Add tasks\n" +
                "2. Show report\n" +
                "3. Quit";
            int choice = 0;
            while (choice != 3)
            {
                String choiceString = JOptionPane.showInputDialog(null, menu, "Task Manager", JOptionPane.PLAIN_MESSAGE);
                try //(Farrell,2022)
                {
                    choice = Integer.parseInt(choiceString);//(Farrell, 2022)

                    switch (choice) //(Farrell, 2022)
                    {
                        case 1:
                            tasks = new Task[numTasks];//Assign number of tasks as size of array of objects
                            // Prompt the user to enter task details for each Task object
                            for (int i = 0; i < numTasks; i++)
                            {
                                String taskName = JOptionPane.showInputDialog(null, "Enter task name "+ i, "Add Task", JOptionPane.PLAIN_MESSAGE);
                                 String taskDescription = JOptionPane.showInputDialog(null, "Enter the task description:");
                                String developerDetails = JOptionPane.showInputDialog(null, "Enter the developer details:");
                                int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the task duration in hours:"));
                                String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Add Task", JOptionPane.PLAIN_MESSAGE, null, taskStatuses, taskStatuses[0]); //(Farrell, 2022)
                                // Add your logic to handle the task addition
                                Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
                                tasks[i] = task;
                                // Check if the task description is valid
                                if (task.checkTaskDescription()) 
                                {
                                    JOptionPane.showMessageDialog(null, "Task successfully captured", "Success", JOptionPane.INFORMATION_MESSAGE);
                                } 
                                else 
                                {
                                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                // Display the details of each task
                                JOptionPane.showMessageDialog(null, task.printTaskDetails(),"Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                            
                            // Calculate and display the total task duration in hours
                            int totalHours = Task.returnTotalHours(tasks);
                            JOptionPane.showMessageDialog(null, "Total Hours: " + totalHours);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Coming Soon", "Feature in Development", JOptionPane.PLAIN_MESSAGE);
                            break;
                        case 3:
                            // Exit the application
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                }
                catch (NumberFormatException e) //(Farrell,2022)
                {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

/**
 *
 * @reference list
 * Farrell, J. 2022. Java Programming. Boston: Cengage Learning.
 */
