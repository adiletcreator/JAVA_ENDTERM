package kz.aitu.oop.practice.assignment4.entities;

//class with all variables in the table(private type for encapsulation)
public class Specialist {
    private int id;
    private String name;
    private String surname;
    private String specialty;
    private int salary;

    //Constructor
    public Specialist() {

    }

    public Specialist(String name, String surname, String specialty, int salary) {
        setName(name);
        setSurname(surname);
        setSpecialty(specialty);
        setSalary(salary);
    }

    public Specialist(int id, String name, String surname, String specialty, int salary) {
        setId(id);
        setName(name);
        setSurname(surname);
        setSpecialty(specialty);
        setSalary(salary);
    }

    //getter and setters to access private
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", specialty='" + specialty + '\'' +
                ", salary='" + salary + '\'' + '}';
    }
}
