package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.Main;
import kz.aitu.oop.practice.assignment5.entities.Stones;
import kz.aitu.oop.practice.assignment5.repositories.StonesRepository;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepository;

import java.util.List;

public class StoneController {
    private final IStoneRepository repo;

    public StoneController(IStoneRepository repo) {
        this.repo = repo;
    }

    public String createStone(int cost, int weight, String name) {//method to create
        //stones in sql table

        Stones stones = new Stones(cost, weight, name);

        boolean created = repo.createStone(stones);

        return (created ? "Stone was created!" : "Stone creation was failed!");
    }

    public String getStone(int id) { //method to get stones by id
        Stones stones = repo.getStone(id);

        return (stones == null ? "Stone was not found!" : stones.toString());
    }

    public String getAllStones() { //method to get all stones from table
        List<Stones> stones = repo.getAllStones();

        return stones.toString();
    }

    public int necklaceTotalCost() { //method to calculate total cost
        int counter = repo.necklaceTotalCost();
        return counter;
    }

    public int necklaceTotalWeight() { //method to calculate total weight
        int counter = repo.necklaceTotalWeight();
        return counter*5;
    }

    public int neckPrice() {
        int counter = repo.operate();
        return counter;
    }
}
