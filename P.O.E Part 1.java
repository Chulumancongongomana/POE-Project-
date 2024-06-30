public class Task 
{

    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int duration;
    private String taskID;
    private String taskStatus;

    public static final int MAX_DESCRIPTION_LENGTH = 50;

    public Task(String taskName, String taskDescription, String developerDetails, int duration, String taskStatus) 
    {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.duration = duration;
        this.taskStatus = taskStatus;
        this.taskID = generateTaskID();
    }

    public boolean checkTaskDescription() 
    {
        return taskDescription.length() <= MAX_DESCRIPTION_LENGTH;
    }

    public String createTaskID() 
    {
        return generateTaskID();
    }

    private String generateTaskID() 
    {
        
        static int counter = 0;
        String projectCode = "AD"; 
        return String.format("%s:%d:%s", projectCode, counter++, developerDetails.substring(0, 3).toUpperCase());
    }

    public String printTaskDetails() 
    {
        return String.format("Task Name: %s\nTask Description: %s\nDeveloper Details: %s\nDuration: %d hours\nTask ID: %s\nTask Status: %s\n",
                taskName, taskDescription, developerDetails, duration, taskID, taskStatus);
    }

    public int returnTotalHours() 
    {
        return duration;
    }
}
