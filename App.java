import java.time.LocalDate;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Hello, World!");

        AssignMent a1 = new AssignMent(
            "Math",
            "Exercise 10",
            LocalDate.of(2025, 3, 4),
            2.0,
            false
        );

        AssignMent a2 = new AssignMent(
            "Computer Science",
            "Java Project",
            LocalDate.of(2025, 3, 10),
            5.5,
            false
        );

        AssignMent.printAllAssignments();

        if(a1.isOverdue()) {
            System.out.println("This assignment is overdue!");
        }
    }
}
