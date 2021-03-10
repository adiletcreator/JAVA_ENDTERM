package kz.aitu.oop.practice.endterm.entities;

public class Exams {
    private int exam_id;
    private String exam_name;
    private String exam_examinator;
    private String exam_topics;
    private String exam_day;
    private int course_id;

    public Exams() { }

    public Exams(int exam_id, String exam_name, String exam_examinator, String exam_topics,
                 String exam_day, int course_id){
        setExam_id(exam_id);
        setExam_name(exam_name);
        setExam_examinator(exam_examinator);
        setExam_topics(exam_topics);
        setExam_day(exam_day);
        setCourse_id(course_id);
    }

    public int getExam_id() { return exam_id; }
    public void setExam_id(int exam_id) { this.exam_id = exam_id; }

    public String getExam_name() { return exam_name; }
    public void setExam_name(String exam_name) { this.exam_name = exam_name; }

    public String getExam_examinator() { return exam_examinator; }
    public void setExam_examinator(String exam_examinator) { this.exam_examinator = exam_examinator; }

    public String getExam_topics() { return exam_topics; }
    public void setExam_topics(String exam_topics) { this.exam_topics = exam_topics; }

    public String getExam_day() { return exam_day; }
    public void setExam_day(String exam_date) { this.exam_day = exam_date; }

    public int getCourse_id() { return course_id; }
    public void setCourse_id(int course_id) { this.course_id = course_id; }

    @Override
    public String toString() {
        return "Exams{" +
                "exam_id='" + exam_id + '\'' +
                ", exam_name='" + exam_name + '\'' +
                ", exam_examinator='" + exam_examinator + '\'' +
                ", exam_topics='" + exam_topics + '\'' +
                ", exam_date='" + exam_day + '\'' +
                ", course_id='" + course_id + '\'' + '}'+'\n';
    }
}
