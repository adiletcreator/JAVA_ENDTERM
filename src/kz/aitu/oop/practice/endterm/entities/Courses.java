package kz.aitu.oop.practice.endterm.entities;

public class Courses {
    private int course_id;
    private String course_name;
    private String course_instructor;
    private int course_credits;
    private int profile_id;

    public Courses() { }

    public Courses(int course_id, String course_name, String course_instructor, int course_credits,
                   int profile_id) {
        setCourse_id(course_id);
        setCourse_name(course_name);
        setCourse_instructor(course_instructor);
        setCourse_credits(course_credits);
        setProfile_id(profile_id);
    }

    public int getCourse_id() { return course_id; }
    public void setCourse_id(int course_id) { this.course_id = course_id; }

    public String getCourse_name() { return course_name; }
    public void setCourse_name(String course_name) { this.course_name = course_name; }

    public String getCourse_instructor() { return course_instructor; }
    public void setCourse_instructor(String course_instructor) { this.course_instructor = course_instructor; }

    public int getCourse_credits() { return course_credits; }
    public void setCourse_credits(int course_credits) { this.course_credits = course_credits; }

    public int getProfile_id() { return profile_id; }
    public void setProfile_id(int profile_id) { this.profile_id = profile_id; }

    public String toString() {
        return "Courses{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_instructor='" + course_instructor + '\'' +
                ", course_credits='" + course_credits + '\'' +
                ", profile_id='" + profile_id + '\'' + '}'+'\n';
    }
}
