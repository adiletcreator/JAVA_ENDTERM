package kz.aitu.oop.practice.endterm.entities;

public class Assignments {
    private int asg_id;
    private String asg_name;
    private String asg_deadline;
    private int course_id;

    //Constructor
    public Assignments() { }

    public Assignments(int asg_id, String asg_name, String asg_deadline, int course_id) {
        setAsg_id(asg_id);
        setAsg_name(asg_name);
        setAsg_deadline(asg_deadline);
        setCourse_id(course_id);
    }

    //getter and setters to access private
    public int getAsg_id() { return asg_id; }
    public void setAsg_id(int asg_id) { this.asg_id = asg_id; }

    public String getAsg_name() { return asg_name; }
    public void setAsg_name(String asg_name) { this.asg_name = asg_name; }

    public String getAsg_deadline() { return asg_deadline; }
    public void setAsg_deadline(String asg_deadline) { this.asg_deadline = asg_deadline; }

    public int getCourse_id() { return course_id; }
    public void setCourse_id(int course_id) { this.course_id = course_id; }

    @Override
    public String toString() {
        return "Assignments{" +
                "assignment_id='" + asg_id + '\'' +
                ", assignment_name='" + asg_name + '\'' +
                ", assignment_deadline='" + asg_deadline + '\'' +
                ", course_id='" + course_id + '\'' + '}'+'\n';
    }
}
