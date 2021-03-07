package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Stones;

import java.util.List;
    //interface from which the class repository inherits the interface
public interface IStoneRepository {
    boolean createStone(Stones stones);
    Stones getStone(int id);
    List<Stones> getAllStones();
    int necklaceTotalCost();
    int necklaceTotalWeight();
    int operate();
    }
