package kz.aitu.oop.practice.assignment5.entities;

//class with all variables in the table(private type for encapsulation)
public class Stones {
    private int id;
    private int cost;
    private int weight;
    private String name;

    //Constructor
    public Stones() {

    }

    public Stones(int cost, int weight, String name) {
        setCost(cost);
        setWeight(weight);
        setName(name);
    }

    public Stones(int id, int cost, int weight, String name) {
        setId(id);
        setCost(cost);
        setWeight(weight);
        setName(name);
    }

    //getter and setters to access private
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Stones{" +
                "id=" + id +
                ", cost='" + cost + '\'' +
                ", weight='" + weight + '\'' +
                ", name='" + name + '\'' + '}'+'\n';
    }
}
