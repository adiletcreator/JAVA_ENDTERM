package kz.aitu.oop.practice.endterm;

import kz.aitu.oop.practice.endterm.controllers.*;
import kz.aitu.oop.practice.endterm.data.StudentMS;
import kz.aitu.oop.practice.endterm.data.interfaces.IDB;
import kz.aitu.oop.practice.endterm.repositories.*;
import kz.aitu.oop.practice.endterm.repositories.interfaces.*;

//main class of the program
public class Main {

    public static void main(String[] args) {
        //database object to connect with postgresdb class
        IDB db = new StudentMS();
        //object to connect with repository
        IProfileRepository repo1 = new ProfileRepository(db);
        ICoursesRepository repo2 = new CoursesRepository(db);
        IUniverity_ProfileRepository repo3 = new University_ProfileRepository(db);
        IAssignmentsRepository repo4 = new AssignmentsRepository(db);
        IExamsRepository repo5 = new ExamsRepository(db);
        ITodoListRepository repo6 = new TodoListRepository(db);
        //object to connect with controller
        ProfileController controller1 = new ProfileController(repo1);
        CoursesController controller2 = new CoursesController(repo2);
        University_ProfileController controller3 = new University_ProfileController(repo3);
        AssignmentsController controller4 = new AssignmentsController(repo4);
        ExamsController controller5 = new ExamsController(repo5);
        TodoListController controller6 = new TodoListController(repo6);
        //object to connect with application class
        MyApplication app = new MyApplication(controller1, controller2, controller3, controller4,
                controller5, controller6);
        //This line starts the code
        app.start();

    }
}
