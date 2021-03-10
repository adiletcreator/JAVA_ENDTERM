package kz.aitu.oop.practice.endterm.repositories.interfaces;

import kz.aitu.oop.practice.endterm.entities.TodoList;
import kz.aitu.oop.practice.endterm.entities.University_Profile;

import java.util.List;

public interface IUniverity_ProfileRepository {
    boolean createUniversity_Profile(University_Profile university_profile);
    University_Profile getUniversity_Profile(int unipr_id);
    List<University_Profile> getAllUniversity_Profile();
    University_Profile deleteUniversity_ProfileById(int unipr_id);
//    List<University_Profile> getAllUniversity_ProfileDataInfo(int profile_id);
}
