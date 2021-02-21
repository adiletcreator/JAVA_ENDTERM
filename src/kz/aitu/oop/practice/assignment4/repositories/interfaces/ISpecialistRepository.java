package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Specialist;

import java.util.List;
    //interface from which the class repository inherits the interface
public interface ISpecialistRepository {
    boolean createSpecialist(Specialist specialist);
    Specialist getSpecialist(int id);
    List<Specialist> getAllSpecialists();
    int projectTotalCost();
    int getHPspecialist();
}
