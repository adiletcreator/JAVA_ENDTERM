package kz.aitu.oop.practice.endterm.repositories.interfaces;

import kz.aitu.oop.practice.endterm.entities.Courses;
import kz.aitu.oop.practice.endterm.entities.Exams;

import java.util.List;

public interface IExamsRepository {
    boolean createExams(Exams exams);
    Exams getExams(int exam_id);
    List<Exams> getAllExams();
    Exams deleteExamsById(int exam_id);
//    List<Exams> getAllExamsDataInfo(int profile_id);
}
