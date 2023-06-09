/**
 * @author Fungho Baloyi - ST10405022
 *
 */

package login;
import javax.swing.*;

public class Task {
    private static int taskCount = 0;// Static variable to keep track of the number of tasks (Farrell, 2022)
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    // Default constructor (Farrell, 2022)
    public Task() 
    {
        taskNumber = taskCount++; // Assign the current task count as the task number and increment the count
    }
    
    // Parameterized constructor (Farrell, 2022)
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) 
    {
        this();// Call the default constructor to set the task number
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();// Set the task ID by calling the createTaskID() method
        this.taskStatus = taskStatus;
    }
    
    // Method to check if the task description is not more than 50 characters
    public boolean checkTaskDescription() 
    {
        return taskDescription.length() <= 50;
    }

    // Method to create and return the task ID
    private String createTaskID() 
    {
        String taskID = taskName.substring(0, 2).toUpperCase(); // First two letters of the task name (Farrell, 2022)
        taskID += ":" + taskNumber + ":"; // Task number
        taskID += developerDetails.substring(developerDetails.length() - 3).toUpperCase(); // Last three letters of the developer name (Farrell, 2022)
        return taskID;
    }

    // Method to return the full task details as a formatted string
    public String printTaskDetails() 
    {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + developerDetails +
                "\nTask Number: " + taskNumber +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription +
                "\nTask ID: " + taskID +
                "\nTask Duration: " + taskDuration + " hours";
    }

    // Static method to calculate and return the total combined hours of all entered tasks
    public static int returnTotalHours(Task[] tasks) 
    {
        int totalHours = 0;
        
        //a syntax for a "for-each" loop in Java. It is used to iterate over an array or collection and process each element individually.
        for (Task task : tasks) //(Farrell, 2022)
        {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }
    
    //HELPER FUNCTIONS
    // Getter and setter methods
    public String getTaskName() 
    {
        return taskName;
    }

    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public int getTaskNumber() 
    {
        return taskNumber;
    }

    public String getTaskDescription() 
    {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) 
    {
        this.taskDescription = taskDescription;
    }

    public String getDeveloperDetails() 
    {
        return developerDetails;
    }

    public void setDeveloperDetails(String developerDetails) 
    {
        this.developerDetails = developerDetails;
    }

    public int getTaskDuration() 
    {
        return taskDuration;
    }

    public void setTaskDuration(int taskDuration) 
    {
        this.taskDuration = taskDuration;
    }

    public String getTaskID() 
    {
        return taskID;
    }

    public String getTaskStatus() 
    {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) 
    {
        this.taskStatus = taskStatus;
    }
}

/**
 *
 * @reference list
 * Farrell, J. 2022. Java Programming. Boston: Cengage Learning.
 */