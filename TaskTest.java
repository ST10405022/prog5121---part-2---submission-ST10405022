/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Fungho Baloyi - ST10405022
 *
 */

public class TaskTest {
    private Task[] task;
    private Login login;
    
    
    @BeforeEach
    public void setup() {
        login = new Login("_user", "password9!", "John", "Doe");
        task = new Task[2];
        task[0] = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        task[1] = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
    
    }

    @Test
    public void testCheckTaskDescription() {
        boolean result = task[0].checkTaskDescription();
        Assertions.assertTrue(result, "Task Description should not be more than 50 Characters");
    }

    @Test
    public void testCreateTaskID() {
        String expectedTaskID = "LO:0:BYN";
        String actualTaskID = task[0].getTaskID();
        Assertions.assertEquals(expectedTaskID, actualTaskID, "Task ID should be created correctly");
    }

    @Test
    public void testPrintTaskDetails() {
        String expectedDetails = "Task Status: To Do" +
                "\nDeveloper Details: Robyn Harrison" +
                "\nTask Number: 0" +
                "\nTask Name: Login Feature" +
                "\nTask Description: Create Login to authenticate users" +
                "\nTask ID: LO:0:SON" +
                "\nTask Duration: 8 hours";
        String actualDetails = task[0].printTaskDetails();
        Assertions.assertEquals(expectedDetails, actualDetails, "Printed task details should match the expected format");
    }

    @Test
    public void testReturnTotalHours() {
        int expectedTotalHours = 18;
        int actualTotalHours = Task.returnTotalHours(task);
        Assertions.assertEquals(expectedTotalHours, actualTotalHours, "Total hours should be calculated correctly");
    }

    @Test
    public void testGetterAndSetterMethods() {
        task[1].setTaskName("Updated Task Name");
        Assertions.assertEquals("Updated Task Name", task[1].getTaskName(), "Task name should be updated");

        task[1].setTaskDescription("Updated Task Description");
        Assertions.assertEquals("Updated Task Description", task[1].getTaskDescription(), "Task description should be updated");

        task[1].setDeveloperDetails("Updated Developer");
        Assertions.assertEquals("Updated Developer", task[1].getDeveloperDetails(), "Developer details should be updated");

        task[1].setTaskDuration(15);
        Assertions.assertEquals(15, task[1].getTaskDuration(), "Task duration should be updated");

        task[1].setTaskStatus("Doing");
        Assertions.assertEquals("Doing", task[1].getTaskStatus(), "Task status should be updated");
    }
}
