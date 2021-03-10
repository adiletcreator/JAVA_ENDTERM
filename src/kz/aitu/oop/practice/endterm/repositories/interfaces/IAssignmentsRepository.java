package kz.aitu.oop.practice.endterm.repositories.interfaces;

import kz.aitu.oop.practice.endterm.entities.Assignments;
import kz.aitu.oop.practice.endterm.entities.Profile;

import java.util.List;

public interface IAssignmentsRepository {
    boolean createAssignments(Assignments assignments);
    Assignments getAssignments(int asg_id);
    List<Assignments> getAllAssignments();
    Assignments deleteAssignmentById(int asg_id);
}
