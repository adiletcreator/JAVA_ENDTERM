package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.StoneController;
import kz.aitu.oop.practice.assignment5.data.Assignment5;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.repositories.StonesRepository;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepository;

//main class of the program
public class Main {

    public static void main(String[] args) {
        //database object to connect with postgresdb class
        IDB db = new Assignment5();
        //object to connect with repository
        IStoneRepository repo = new StonesRepository(db);
        //object to connect with controller
        StoneController controller = new StoneController(repo);
        //object to connect with application class
        MyApplication app = new MyApplication(controller);
        //This line starts the code
        app.start();

    }
}
