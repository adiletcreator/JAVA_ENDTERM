package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Specialist;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.ISpecialistRepository;

import java.util.List;

public class SpecialistController {
    private final ISpecialistRepository repo;

    public SpecialistController(ISpecialistRepository repo) {
        this.repo = repo;
    }

    public String createSpecialist(String name, String surname, String specialty, int salary) {//method to create
        //specialists in sql table

        Specialist specialist = new Specialist(name, surname, specialty, salary);

        boolean created = repo.createSpecialist(specialist);

        return (created ? "Specialist was created!" : "Specialist creation was failed!");
    }

    public String getSpecialist(int id) { //method to get specialists by id
        Specialist specialist = repo.getSpecialist(id);

        return (specialist == null ? "Specialist was not found!" : specialist.toString());
    }

    public String getAllSpecialists() { //method to get all specialists from table
        List<Specialist> specialists = repo.getAllSpecialists();

        return specialists.toString();
    }

    public int projectTotalCost() { //method to calculate total cost
        int counter = repo.projectTotalCost();
        return counter;
    }

    public int getHPspecialist() { //method to get highest salary
         int specialist = repo.getHPspecialist();
        return specialist;
    }
}
