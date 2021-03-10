package kz.aitu.oop.practice.endterm.controllers;

    import kz.aitu.oop.practice.endterm.entities.Assignments;
    import kz.aitu.oop.practice.endterm.entities.Courses;
    import kz.aitu.oop.practice.endterm.repositories.interfaces.IAssignmentsRepository;

import java.util.List;

public class AssignmentsController {
    private final IAssignmentsRepository repo;

    public AssignmentsController(IAssignmentsRepository repo) { this.repo = repo; }

    public String createAssignments(int asg_id, String asg_name, String asg_deadline,
                                int course_id) {

        Assignments assignments = new Assignments(asg_id, asg_name, asg_deadline, course_id);

        boolean created = repo.createAssignments(assignments);

        return (created ? "Assignment was created" : "Assignment creation was failed!");
    }

    public String getAssignments(int asg_id) {
        Assignments assignments = repo.getAssignments(asg_id);

        return (assignments == null ? "Assignment was not found!" : assignments.toString());
    }

    public String getAllAssignments() { //method to get all assignments from table
        List<Assignments> assignments = repo.getAllAssignments();

        return assignments.toString();
    }
    public String deleteAssignment(int asg_id) {
        Assignments assignments = repo.deleteAssignmentById(asg_id);
        return (assignments == null ? "Assignment has deleted" : "Assignment was not found!");
    }
}
