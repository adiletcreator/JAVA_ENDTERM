package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.StoneController;
import kz.aitu.oop.practice.assignment5.repositories.StonesRepository;

import java.util.InputMismatchException;
import java.util.Scanner;
    //application class with which the basic functions of the program are performed
public class MyApplication {
    private final StoneController controller;
    private final Scanner scanner;

    public MyApplication(StoneController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) { //We use the while loop to execute the program many times till user does not stop it
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:"); //all options or functions of this program
            System.out.println("1. Get all stones");
            System.out.println("2. Get stones by id");
            System.out.println("3. Create stone");
            System.out.println("4. Get total cost of the necklace");
            System.out.println("5. Get total weight of the necklace");
            System.out.println("6. Get total price of the necklace for sales");
            System.out.println("0. Exit");
            System.out.println();
            try { //try catch to catch errors if they are exists
                System.out.print("Enter option (1-6): "); //This line outputs string
                int option = scanner.nextInt(); //With this line user selects one of the options
                if (option == 1) { //if, else if operators to run selected options
                    getAllStonesMenu();
                } else if (option == 2) {
                    getStoneByIdMenu();
                } else if (option == 3) {
                    createStonesMenu();
                } else if (option == 4) {
                    necklaceTotalCostMenu();
                } else if (option == 5) {
                    necklaceTotalWeightMenu();
                }else if (option == 6) {
                    priceCalc();
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

    public void getAllStonesMenu() { //first option that outputs all stones
        String response = controller.getAllStones();
        System.out.println(response);
    }

    public void getStoneByIdMenu() { //second option that output stones by id
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getStone(id);
        System.out.println(response);
    }

    public void createStonesMenu() { //option that creates new stone

        System.out.println("Please enter cost in tenge");
        int cost = scanner.nextInt();
        System.out.println("Please enter weight in grams");
        int weight = scanner.nextInt();
        System.out.println("Please enter name of the stone");
        String name = scanner.next();

        String response = controller.createStone(cost, weight, name);
        System.out.println(response);
    }

    public void necklaceTotalCostMenu() { //option to output total cost
        System.out.println("Total cost of the necklace:");
        int response = controller.necklaceTotalCost();
        System.out.println(response + " tenge");
    }

        public void necklaceTotalWeightMenu() { //option to output total cost
            System.out.println("Total weight of the necklace in carats:");
            int response = controller.necklaceTotalWeight();
            System.out.println(response + " carats");
        }
        public void priceCalc() { //option to output total cost with assembly
            System.out.println("Total price of the necklace for sales:");
            System.out.println(controller.neckPrice());

        }

    }
