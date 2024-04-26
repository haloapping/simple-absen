import java.util.Scanner;

public class Employee implements AuthInterface, AbsenceInterface {
    private String username;
    private String password;
    private String status;
    private String date;
    private String projectName;
    private String clientName;
    private String activity;
    private String hour;
    private String remarks;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getClientName() {
        return clientName;
    }
    
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    
    public String getHour() {
        return hour;
    }
    
    public void setHour(String hour) {
        this.hour = hour;
    }
    
    public String getRemarks() {
        return remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public void loginForm(Scanner scanner) {
        System.out.print("Username : ");
        setUsername(scanner.nextLine());

        System.out.print("Password : ");
        setPassword(scanner.nextLine());
    }

    @Override
    public Boolean isLogin(String[][] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (getUsername().equals(employees[i][1]) && getPassword().equals(employees[i][2])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isLogout() {
        return true;
    }

    @Override
    public void fillFormAbsence(Scanner scanner) {
        System.out.println("FORM ABSENCE");

        System.out.print("Status       : ");
        setStatus(scanner.nextLine());

        System.out.print("Date         : ");
        setDate(scanner.nextLine());

        System.out.print("Project Name : ");
        setProjectName(scanner.nextLine());

        System.out.print("Client Name  : ");
        setClientName(scanner.nextLine());

        System.out.print("Activity     : ");
        setActivity(scanner.nextLine());

        System.out.print("Hour         : ");
        setHour(scanner.nextLine());

        System.out.print("Remarks      : ");
        setRemarks(scanner.nextLine());
    }
    
    @Override
    public void saveAbsence(String[][] absences) {
        for (int i = 0; i < absences.length; i++) {
            if (absences[i][1] == null) {
                absences[i][1] = getStatus();
                absences[i][2] = getDate();
                absences[i][3] = getProjectName();
                absences[i][4] = getClientName();
                absences[i][5] = getActivity();
                absences[i][6] = getHour();
                absences[i][7] = getRemarks();
                absences[i][8] = "NOT APPROVED";
                break;
            }
        }
        System.out.println("Absence is inserted.");
    }

    @Override
    public void showAbsence(String[][] absences) {
        System.out.println("|\t ID \t|\t Status \t|\t Date \t|\t Project Name \t|\t Client Name \t|\t Activity \t|\t Hour \t|\t Remarks \t|\t Approval \t|");
        for (int i = 0; i < absences.length; i++) {
            System.out.println("|\t" + absences[i][0] + "\t|\t" + absences[i][1] + "\t|\t" + absences[i][2] + "\t|\t" + absences[i][3] + "\t|\t" + absences[i][4] + "\t|\t" + absences[i][5] + "\t|\t" + absences[i][6] + "\t|\t" + absences[i][7] + "\t|\t" + absences[i][8] + "\t|");
        }
    }
}
