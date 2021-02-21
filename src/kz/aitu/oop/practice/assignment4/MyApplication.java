package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.SpecialistController;

import java.util.InputMismatchException;
import java.util.Scanner;
    //application class with which the basic functions of the program are performed
public class MyApplication {
    private final SpecialistController controller;
    private final Scanner scanner;

    public MyApplication(SpecialistController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) { //We use the while loop to execute the program many times till user does not stop it
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:"); //all options or functions of this program
            System.out.println("1. Get all specialists");
            System.out.println("2. Get specialists by id");
            System.out.println("3. Create specialist");
            System.out.println("4. Get total cost of the project");
            System.out.println("5. Get highest paid specialist");
            System.out.println("0. Exit");
            System.out.println();
            try { //try catch to catch errors if they are exists
                System.out.print("Enter option (1-5): "); //This line outputs string
                int option = scanner.nextInt(); //With this line user selects one of the options
                if (option == 1) { //if, else if operators to run selected options
                    getAllSpecialistsMenu();
                } else if (option == 2) {
                    getSpecialistByIdMenu();
                } else if (option == 3) {
                    createSpecialistMenu();
                } else if (option == 4) {
                    projectTotalCostMenu();
                } else if (option == 5) {
                    getHighestPaidSpecialistMenu();
                }else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllSpecialistsMenu() { //first option that outputs all specialists
        String response = controller.getAllSpecialists();
        System.out.println(response);
    }

    public void getSpecialistByIdMenu() { //second option that output specialists by id
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getSpecialist(id);
        System.out.println(response);
    }

    public void createSpecialistMenu() { //option that creates new specialist

        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter specialty");
        String specialty = scanner.next();
        System.out.println("Please enter salary");
        int salary = scanner.nextInt();

        String response = controller.createSpecialist(name, surname, specialty, salary);
        System.out.println(response);
    }

    public void projectTotalCostMenu() { //option to output total cost
        System.out.println("Total cost of the project or salary for all specialists:");
        int response = controller.projectTotalCost();
        System.out.println(response);
    }

    public void getHighestPaidSpecialistMenu() { //option that outputs highest salary
        int  response = controller.getHPspecialist();
        System.out.println(response);
    }
}
