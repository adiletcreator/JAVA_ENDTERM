package kz.aitu.oop.practice.endterm.controllers;

import kz.aitu.oop.practice.endterm.entities.Exams;
import kz.aitu.oop.practice.endterm.repositories.interfaces.IExamsRepository;

import java.util.List;

public class ExamsController {
    private final IExamsRepository repo;

    public ExamsController(IExamsRepository repo) { this.repo = repo; }

    public String createExams(int exam_id, String exam_name, String exam_examinator, String exam_topics,
                                String exam_day, int course_id) {

        Exams exams = new Exams(exam_id, exam_name, exam_examinator, exam_topics, exam_day
                , course_id);

        boolean created = repo.createExams(exams);

        return (created ? "Exam was created" : "Exam creation was failed!");
    }

    public String getExams(int exam_id) {
        Exams exams = repo.getExams(exam_id);

        return (exams == null ? "Exam was not found!" : exams.toString());
    }

    public String getAllExams() { //method to get all exams from table
        List<Exams> exams = repo.getAllExams();

        return exams.toString();
    }
    public String deleteExam(int exam_id) {
        Exams exam = repo.deleteExamsById(exam_id);
        return (exam == null ? "Exam has deleted" : "Exam was not found!");
    }
}
