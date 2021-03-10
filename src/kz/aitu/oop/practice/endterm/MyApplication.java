package kz.aitu.oop.practice.endterm;

import kz.aitu.oop.practice.endterm.controllers.*;
import java.util.InputMismatchException;
import java.util.Scanner;
    //application class with which the basic functions of the program are performed
public class MyApplication {
    private final ProfileController controller1;
    private final CoursesController controller2;
    private final University_ProfileController controller3;
    private final AssignmentsController controller4;
    private final ExamsController controller5;
    private final TodoListController controller6;
    private final Scanner scanner;

    public MyApplication(ProfileController controller1, CoursesController controller2,
                         University_ProfileController controller3, AssignmentsController controller4,
                         ExamsController controller5, TodoListController controller6) {
        this.controller1 = controller1;
        this.controller2 = controller2;
        this.controller3 = controller3;
        this.controller4 = controller4;
        this.controller5 = controller5;
        this.controller6 = controller6;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) { //We use the while loop to execute the program many times till user does not stop it
            System.out.println();
            System.out.println("Welcome to Student Management System");
            System.out.println("Select option:");//all options or functions of this program
            System.out.println("1. Get all data menu");
            System.out.println("2. Create new data menu");
            System.out.println("3. Get data information by id menu");
            System.out.println("4. Delete data by id menu");
            System.out.println("0. Exit");
            System.out.println();

            try { //try catch to catch errors if they are exists
                System.out.print("Enter option (1-4): "); //This line outputs string
                int option = scanner.nextInt(); //With this line user selects one of the options
                if (option == 1) {
                    while (true) {
                        System.out.println("1. Get all profiles");
                        System.out.println("2. Get all courses");
                        System.out.println("3. Get all university profiles");
                        System.out.println("4. Get all assignments");
                        System.out.println("5. Get all exams");
                        System.out.println("6. Get all TodoList");
                        System.out.println("7. Get credits of courses in tenge");
                        System.out.println("0. Exit");
                        System.out.println();

                        try { //try catch to catch errors if they are exists
                            System.out.print("Enter option (1-6): "); //This line outputs string
                            int option1 = scanner.nextInt(); //With this line user selects one of the options
                            if (option1 == 1) {//if, else if operators to run selected options
                                getAllProfilesMenu();
                            } else if (option1 == 2) {
                                getAllCoursesMenu();
                            } else if (option1 == 3) {
                                getAllUniversity_ProfilesMenu();
                            } else if (option1 == 4) {
                                getAllAssignmentsMenu();
                            } else if (option1 == 5) {
                                getAllExamsMenu();
                            } else if (option1 == 6) {
                                getAllTodoListMenu();
                            }
                            else if (option1 == 7) {
                                getCreditsMenu();
                            }
                            else {
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

                } else if (option == 2) {
                    while (true){
                        System.out.println("1. Create profile");
                        System.out.println("2. Create course");
                        System.out.println("3. Create university profile");
                        System.out.println("4. Create assignment");
                        System.out.println("5. Create exam");
                        System.out.println("6. Create TodoList");
                        System.out.println("0. Exit");
                        System.out.println();

                        try { //try catch to catch errors if they are exists
                            System.out.print("Enter option (1-6): "); //This line outputs string
                            int option2 = scanner.nextInt(); //With this line user selects one of the options
                            if (option2 == 1) { //if, else if operators to run selected options
                                createProfileMenu();
                            } else if (option2 == 2) {
                                createCourseMenu();
                            } else if (option2 == 3) {
                                createUniversity_ProfileMenu();
                            } else if (option2 == 4) {
                                createAssignmentsMenu();
                            } else if (option2 == 5) {
                                createExamsMenu();
                            } else if (option2 == 6) {
                                createTodoListMenu();
                            }
                            else {
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

                } else if (option == 3) {
                    while (true){
                        System.out.println("13. Get profile by id");
                        System.out.println("14. Get course by id");
                        System.out.println("15. Get university_profile by id");
                        System.out.println("16. Get assignment by id");
                        System.out.println("17. Get exam by id");
                        System.out.println("18. Get todoList by id");
                        System.out.println("0. Exit");
                        System.out.println();

                        try { //try catch to catch errors if they are exists
                            System.out.print("Enter option (1-6): "); //This line outputs string
                            int option3 = scanner.nextInt(); //With this line user selects one of the options
                            if (option3 == 1) { //if, else if operators to run selected options
                                getProfileByIdMenu();
                            } else if (option3 == 2) {
                                getCoursesbyIdMenu();
                            } else if (option3 == 3) {
                                getUniversity_ProfilebyIdMenu();
                            } else if (option3 == 4) {
                                getAssignmentsbyIdMenu();
                            } else if (option3 == 5) {
                                getExamsbyIdMenu();
                            } else if (option3 == 6) {
                                getTodoListbyIdMenu();
                            }
                            else {
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
                } else if (option == 4) {
                    while (true) {
                        System.out.println("1. Delete profile by id");
                        System.out.println("2. Delete Course by id");
                        System.out.println("3. Delete University Profile by id");
                        System.out.println("4. Delete Assignment by id");
                        System.out.println("5. Delete exam by id");
                        System.out.println("6.  Delete TodoList by id");
                        System.out.println("0. Exit");
                        System.out.println();

                        try { //try catch to catch errors if they are exists
                            System.out.print("Enter option (1-6): "); //This line outputs string
                            int option4 = scanner.nextInt(); //With this line user selects one of the options
                            if (option4 == 1) {//if, else if operators to run selected options
                                DeleteProfileByIdMenu();
                            } else if (option4 == 2) {
                                DeleteCourseByIdMenu();
                            } else if (option4 == 3) {
                                DeleteUniversity_ProfileByIdMenu();
                            } else if (option4 == 4) {
                                DeleteAssignmentByIdMenu();
                            } else if (option4 == 5) {
                                DeleteExamByIdMenu();
                            } else if (option4 == 6) {
                                DeleteTodoListByIdMenu();
                            }
                            else {
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
                } else {
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

    public void getAllProfilesMenu() { //first option that outputs all profiles
        String response = controller1.getAllProfiles();
        System.out.println(response);
    }

    public void getAllCoursesMenu() {
        String response = controller2.getAllCourses();
        System.out.println(response);
    }
        public void getAllUniversity_ProfilesMenu() {
            String response = controller3.getAllUniversity_Profile();
            System.out.println(response);
        }
        public void getAllAssignmentsMenu() {
            String response = controller4.getAllAssignments();
            System.out.println(response);
        }
        public void getAllExamsMenu() {
            String response = controller5.getAllExams();
            System.out.println(response);
        }
        public void getAllTodoListMenu() {
            String response = controller6.getAllTodoList();
            System.out.println(response);
        }
        public void getCreditsMenu() {
        String response = controller2.getCredits();
            System.out.println(response);
        }



    public void getProfileByIdMenu() { //second option that output profiles by id
        System.out.println("Please enter id of your profile");

        int id = scanner.nextInt();
        String response = controller1.getProfile(id);
        System.out.println(response);
    }

    public void getCoursesbyIdMenu() {
        System.out.println("Please enter id of your course");
        int id = scanner.nextInt();
        String response = controller2.getCourses(id);
        System.out.println(response);
    }
        public void getUniversity_ProfilebyIdMenu() {
            System.out.println("Please enter id of your University_Profile");
            int id = scanner.nextInt();
            String response = controller3.getUniversity_Profile(id);
            System.out.println(response);
        }
        public void getAssignmentsbyIdMenu() {
            System.out.println("Please enter id of your assignment");
            int id = scanner.nextInt();
            String response = controller4.getAssignments(id);
            System.out.println(response);
        }
        public void getExamsbyIdMenu() {
            System.out.println("Please enter id of your exam");
            int id = scanner.nextInt();
            String response = controller5.getExams(id);
            System.out.println(response);
        }
        public void getTodoListbyIdMenu() {
            System.out.println("Please enter id of your todoList");
            int id = scanner.nextInt();
            String response = controller6.getTodoList(id);
            System.out.println(response);
        }

    public void createProfileMenu() { //option that creates new profile

        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        System.out.println("Please enter gender");
        String gender = scanner.next();

        String response = controller1.createProfile(id, name, surname, age, gender);
        System.out.println(response);
    }

    public void createCourseMenu() {

        System.out.println("Please enter id");
        int course_id = scanner.nextInt();
        System.out.println("Please enter course name");
        String course_name = scanner.next();
        System.out.println("Please enter course instructor's name");
        String course_instructor = scanner.next();
        System.out.println("Please enter course credits");
        int course_credits = scanner.nextInt();
        System.out.println("Please enter profile_id");
        int profile_id = scanner.nextInt();

        String response = controller2.createCourses(course_id, course_name, course_instructor, course_credits,
                profile_id);
        System.out.println(response);
    }

        public void createUniversity_ProfileMenu() {

            System.out.println("Please enter id");
            int unipr_id = scanner.nextInt();
            System.out.println("Please enter your fullname");
            String fullname = scanner.next();
            System.out.println("Please enter your phone number");
            String phoneNumb = scanner.next();
            System.out.println("Please enter your email");
            String email = scanner.next();
            System.out.println("Please enter your study year");
            int studyYear = scanner.nextInt();
            System.out.println("Please enter your university's name");
            String universityYear = scanner.next();
            System.out.println("Please enter your profile_id");
            int profile_id = scanner.nextInt();

            String response = controller3.createUniversity_Profile(unipr_id, fullname, phoneNumb, email,
                    studyYear, universityYear, profile_id);
            System.out.println(response);
        }

        public void createAssignmentsMenu() {

            System.out.println("Please enter id");
            int asg_id = scanner.nextInt();
            System.out.println("Please enter the name of your assignment");
            String asg_name = scanner.next();
            System.out.println("Please enter deadline");
            String asg_deadline = scanner.next();
            System.out.println("Please enter course_id");
            int course_id = scanner.nextInt();

            String response = controller4.createAssignments(asg_id, asg_name, asg_deadline, course_id);
            System.out.println(response);
        }

        public void createExamsMenu() {

            System.out.println("Please enter id");
            int exam_id = scanner.nextInt();
            System.out.println("Please enter the name of your exam");
            String exam_name = scanner.next();
            System.out.println("Please enter the name of examinator");
            String exam_examinator = scanner.next();
            System.out.println("Please enter topic names of the exam");
            String exam_topics = scanner.next();
            System.out.println("Please enter the date of the exam");
            String exam_date = scanner.next();
            System.out.println("Please enter course_id");
            int course_id = scanner.nextInt();

            String response = controller5.createExams(exam_id, exam_name, exam_examinator, exam_topics,
                    exam_date, course_id);
            System.out.println(response);
        }

        public void createTodoListMenu() {

            System.out.println("Please enter id");
            int list_id = scanner.nextInt();
            System.out.println("Please enter the name of your task");
            String task_name = scanner.next();
            System.out.println("Please enter deadline");
            String task_deadline = scanner.next();
            System.out.println("Please enter profile_id");
            int profile_id = scanner.nextInt();

            String response = controller6.createTodoList(list_id, task_name, task_deadline, profile_id);
            System.out.println(response);
        }

        public void DeleteProfileByIdMenu() {
            System.out.println("Please enter id");
            int id = scanner.nextInt();
            String response = controller1.deleteProfile(id);
            System.out.println(response);
        }
        public void DeleteCourseByIdMenu() {
            System.out.println("Please enter id");
            int id = scanner.nextInt();
            String response = controller2.deleteCourse(id);
            System.out.println(response);
        }
        public void DeleteUniversity_ProfileByIdMenu() {
            System.out.println("Please enter id");
            int id = scanner.nextInt();
            String response = controller3.deleteUniversity_profile(id);
            System.out.println(response);
        }
        public void DeleteAssignmentByIdMenu() {
            System.out.println("Please enter id");
            int id = scanner.nextInt();
            String response = controller4.deleteAssignment(id);
            System.out.println(response);
        }
        public void DeleteExamByIdMenu() {
            System.out.println("Please enter id");
            int id = scanner.nextInt();
            String response = controller5.deleteExam(id);
            System.out.println(response);
        }
        public void DeleteTodoListByIdMenu() {
            System.out.println("Please enter id");
            int id = scanner.nextInt();
            String response = controller6.deleteTodoList(id);
            System.out.println(response);
        }

    }
