import java.util.Scanner;

class Task 
{
    private static int taskCounter = 0;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private double taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String developerFirstName, String developerLastName, double taskDuration, String taskStatus) 
    {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = generateTaskID();
    }

    private String generateTaskID() 
    {
        String firstTwoLetters = taskName.substring(0, 2).toUpperCase();
        String lastThreeLetters = developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }

    public static boolean validateTaskDescription(String taskDescription) 
    {
        return taskDescription.length() <= 50;
    }

    @Override
    public String toString() 
    {
        return "Task Name: " + taskName + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Developer: " + developerFirstName + " " + developerLastName + "\n" +
               "Task Duration: " + taskDuration + " hours\n" +
               "Task ID: " + taskID + "\n" +
               "Task Status: " + taskStatus;
    }
}

public class TaskManager 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Task Name: ");
        String taskName = scanner.nextLine();

        System.out.println("Enter the Task Description: ");
        String taskDescription = scanner.nextLine();

        if (!Task.validateTaskDescription(taskDescription)) 
        {
            System.out.println("Please enter a task description of less than 50 characters");
            return;
        }

        System.out.println("Enter Developer First Name: ");
        String developerFirstName = scanner.nextLine();

        System.out.println("Enter Developer Last Name: ");
        String developerLastName = scanner.nextLine();

        System.out.println("Enter Task Duration in hours: ");
        double taskDuration = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Select Task Status (To Do, Done, Doing): ");
        String taskStatus = scanner.nextLine();

        Task task = new Task(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);

        System.out.println("Task successfully captured");
        System.out.println(task);
    }
}
