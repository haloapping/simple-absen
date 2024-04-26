import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String[][] employees = {
            { "1", "appang@gdp", "passwordmasokk" },
            { "2", "apping@gdp", "passwordmasokk" },
            { "3", "appung@gdp", "passwordmasokk" },
            { "4", "appeng@gdp", "passwordmasokk" },
            { "5", "appong@gdp", "passwordmasokk" },
            { "6", "ikan@mgr", "passwordmasokk" },
            { "7", "ikin@mgr", "passwordmasokk" },
            { "8", "ikun@mgr", "passwordmasokk" },
            { "9", "iken@mgr", "passwordmasokk" },
            { "10", "ikon@mgr", "passwordmasokk" },
        };

        String[][] absences = {
            { "1", "Present", "25-04-2024", "AAA", "BBB", "CCC", "8", "DDD", "NOT APPROVED" },
            { "2", null, null, null, null, null, null, null, null },
            { "3", null, null, null, null, null, null, null, null },
            { "4", null, null, null, null, null, null, null, null },
            { "5", null, null, null, null, null, null, null, null },
            { "6", null, null, null, null, null, null, null, null },
            { "7", null, null, null, null, null, null, null, null },
        };

        Scanner scanner = new Scanner(System.in);
        String loginAs;
        String userMenuAgainSelected;
        String menuSelected;

        do {
            System.out.println("LOGIN AS");
            System.out.println("Select login as");
            System.out.println("1. GDP Trainer");
            System.out.println("2. GDP Trainee");
            System.out.print("Login As (1/2): ");
            loginAs = scanner.nextLine();

            if (loginAs.equals("1")) {
                System.out.println("\nLOGIN AS GDP TRAINER, INPUT USERNAME AND PASSWORD");
                GDPTrainer gdpTrainer = new GDPTrainer();
                gdpTrainer.loginForm(scanner);
                Boolean isLoginValid = gdpTrainer.isLogin(employees);
                do {
                    if (isLoginValid) {
                        System.out.println("\nLOGIN AS GDP TRAINER SUCCESS");
                        do {
                            System.out.println("1. Set Approval");
                            System.out.println("2. Logout");
                            System.out.print("Select menu: ");
                            menuSelected = scanner.nextLine();

                            if (menuSelected.equals("1")) {
                                gdpTrainer.setApprovalForm(scanner);
                                gdpTrainer.saveApproval(absences);
                            } else if (menuSelected.equals("2")) {
                                System.out.println("You are logout");
                                break;
                            }

                            System.out.print("Select menu again(Y/N): ");
                            userMenuAgainSelected = scanner.nextLine();

                            if (userMenuAgainSelected.equals("N")) {
                                System.out.println("Thank You! :)");
                                break;
                            }
                        } while (userMenuAgainSelected.equals("Y"));
                    } else {
                        System.out.println("Username and password invalid");
                    }
                } while (!isLoginValid);
            } else if (loginAs.equals("2")) {
                System.out.println("\nLOGIN AS GDP TRAINEE, INPUT USERNAME AND PASSWORD");
                GDPTrainee gdpTrainee = new GDPTrainee();
                gdpTrainee.loginForm(scanner);
                Boolean isLoginValid = gdpTrainee.isLogin(employees);
                do {
                    if (isLoginValid) {
                        System.out.println("\nLOGIN AS GDP TRAINEE SUCCESS");
                        do {
                            System.out.println("1. Fill Absence");
                            System.out.println("2. Show Absence");
                            System.out.println("3. Logout");
                            System.out.print("Select menu: ");
                            menuSelected = scanner.nextLine();

                            if (menuSelected.equals("1")) {
                                gdpTrainee.fillFormAbsence(scanner);
                                gdpTrainee.saveAbsence(absences);
                            } else if (menuSelected.equals("2")) {
                                gdpTrainee.showAbsence(absences);
                            } else if (menuSelected.equals("3")) {
                                System.out.println("You are logout");
                                break;
                            }

                            System.out.print("Select menu again(Y/N): ");
                            userMenuAgainSelected = scanner.nextLine();

                            if (userMenuAgainSelected.equals("N")) {
                                System.out.println("Thank You! :)");
                                break;
                            }
                        } while (userMenuAgainSelected.equals("Y"));
                        
                    } else {
                        System.out.println("Username and password invalid");
                    }
                } while (!isLoginValid);
            }
            if (!loginAs.equals("1") || !loginAs.equals("2")) {
                System.out.println("Login option is unavailable, choose (1/2).");
            }
        } while (!loginAs.equals("1") || !loginAs.equals("2"));
        scanner.close();
    }
}
