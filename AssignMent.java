import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AssignMent
{
    private String subject;
    private String task;
    private LocalDate dueDate;
    private double duration;
    private boolean completed;

    // Master list storing every assignment created
    private static ArrayList<AssignMent> masterList = new ArrayList<>();

    // Date formatter (example: 14 Feb 2025)
    private static final DateTimeFormatter FORMATTER = 
            DateTimeFormatter.ofPattern("dd MMM yyyy");

    // -------- Constructor --------
    public AssignMent(String subject_i, String task_i, LocalDate dueDate_i, 
                      double duration_i, boolean completed_i)
    {
        this.subject = subject_i;
        this.task = task_i;
        this.dueDate = dueDate_i;
        this.duration = duration_i;
        this.completed = completed_i;

        // add to master list
        masterList.add(this);
    }

    // ---------- Getters & Setters ----------

    public String getTask() { return task; }
    public void setTask(String newTask) { task = newTask; }

    public String getSubject() { return subject; }
    public void setSubject(String newSubject) { subject = newSubject; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate newDueDate) { dueDate = newDueDate; }

    public double getDuration() { return duration; }
    public void setDuration(double newDuration) { duration = newDuration; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean newCompleted) { completed = newCompleted; }

    // ---------- Additional Helpful Methods ----------

    // Returns formatted due date string
    public String getFormattedDueDate() {
        return dueDate.format(FORMATTER);
    }

    // Checks if the assignment is overdue
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && !completed;
    }

    // Static method to get master list
    public static ArrayList<AssignMent> getAllAssignments() {
        return masterList;
    }

    // Print all assignments
    public static void printAllAssignments() {
        for (AssignMent a : masterList) {
            System.out.println(a + "\n");
        }
    }

    // ---------- toString() ----------
    @Override
    public String toString()
    {
        return "Subject: " + subject +
               "\nAssignment: " + task +
               "\nDue Date: " + getFormattedDueDate() +
               "\nDuration (hours): " + duration +
               "\nCompleted: " + completed +
               (isOverdue() ? " (OVERDUE)" : "");
    }
}
