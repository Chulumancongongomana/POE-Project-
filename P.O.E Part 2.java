import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EasyKanban 
{
    static class Task 
    {
        String taskName;
        int taskNumber;
        String taskDescription;
        String developerDetails;
        double taskDuration;
        String taskID;
        String taskStatus;

        public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, double taskDuration, String taskStatus) 
        {
            this.taskName = taskName;
            this.taskNumber = taskNumber;
            this.taskDescription = taskDescription;
            this.developerDetails = developerDetails;
            this.taskDuration = taskDuration;
            this.taskStatus = taskStatus;
            this.taskID = generateTaskID(taskName, taskNumber, developerDetails);
        }

        private String generateTaskID(String taskName, int taskNumber, String developerDetails) 
        {
            String devLastThree = developerDetails.length() >= 3 ? developerDetails.substring(developerDetails.length() - 3) : developerDetails;
            return (taskName.substring(0, 2) + ":" + taskNumber + ":" + devLastThree).toUpperCase();
        }

        @Override
        public String toString() 
        {
            return "Task Status: " + taskStatus + "\n" +
                    "Developer Details: " + developerDetails + "\n" +
                    "Task Number: " + taskNumber + "\n" +
                    "Task Name: " + taskName + "\n" +
                    "Task Description: " + taskDescription + "\n" +
                    "Task ID: " + taskID + "\n" +
                    "Task Duration: " + taskDuration + " hours\n";
        }
    }

    private static boolean authenticate() 
    {
        String username = JOptionPane.showInputDialog("Enter Username:");
        String password = JOptionPane.showInputDialog("Enter Password:");

        return "user".equals(username) && "password".equals(password); 
    }

    public static void main(String[] args) 
{
        if (!authenticate()) 
        {
            JOptionPane.showMessageDialog(null, "Invalid login. Exiting.");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        List<Task> tasks = new ArrayList<>();
        double totalDuration = 0;

        while (true) 
    {
            String[] options = {"Add tasks", "Show report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) 
            {
                case 0:
                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));

                    for (int i = 0; i < numTasks; i++) 
                    {
                        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                        String taskDescription;
                        while (true) 
                        {
                            taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                            if (taskDescription.length() <= 50) 
                            {
                                JOptionPane.showMessageDialog(null, "Task successfully captured");
                                break;
                            } 
                            else 
                            {
                                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                            }
                        }
                        String developerDetails = JOptionPane.showInputDialog("Enter Developer's First and Last Name:");
                        double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
                        String[] statuses = {"To Do", "Doing", "Done"};
                        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status",
                                JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

                        Task task = new Task(taskName, tasks.size(), taskDescription, developerDetails, taskDuration, taskStatus);
                        tasks.add(task);
                        totalDuration += task.taskDuration;

                        JOptionPane.showMessageDialog(null, task.toString());
                    }
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Total Task Duration: " + totalDuration + " hours");
                    System.exit(0);
                    break;
            }
        }
    }
}
