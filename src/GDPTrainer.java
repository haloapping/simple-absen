import java.util.Scanner;

public class GDPTrainer extends Employee implements ApprovalInterface {
    private String dateSubmit;
    private String approval;

    public String getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(String dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    @Override
    public void setApprovalForm(Scanner scanner) {
        System.out.println("Approval Form");
        System.out.print("Date: ");
        setDateSubmit(scanner.nextLine());
    }

    @Override
    public void saveApproval(String[][] absences) {
        for (int i = 0; i < absences.length; i++) {
            if (absences[i][2].equals(getDateSubmit())) {
                setApproval("APPROVED");
                absences[i][8] = getApproval();
                System.out.println("GDP Employee is approved.");
                break;             
            }
        }
    }
}
