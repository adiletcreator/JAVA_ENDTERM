package kz.aitu.oop.practice.endterm.entities;

//class with all variables in the table(private type for encapsulation)
public class Profile {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String gender;

    //Constructor
    public Profile() { }

    public Profile(int id, String name, String surname, int age, String gender) {
        setId(id);
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
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

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }


    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' + '}'+'\n';
    }
}
