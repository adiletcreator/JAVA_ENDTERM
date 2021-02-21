package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.SpecialistController;
import kz.aitu.oop.practice.assignment4.data.PostgresDB;
import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.repositories.SpecialistRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.ISpecialistRepository;

//main class of the program
public class Main {

    public static void main(String[] args) {
        //database object to connect with postgresdb class
        IDB db = new PostgresDB();
        //object to connect with repository
        ISpecialistRepository repo = new SpecialistRepository(db);
        //object to connect with controller
        SpecialistController controller = new SpecialistController(repo);
        //object to connect with application class
        MyApplication app = new MyApplication(controller);
        //This line starts the code
        app.start();

    }
}
