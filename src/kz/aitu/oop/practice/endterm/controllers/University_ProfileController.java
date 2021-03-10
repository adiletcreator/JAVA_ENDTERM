package kz.aitu.oop.practice.endterm.controllers;

import kz.aitu.oop.practice.endterm.entities.University_Profile;
import kz.aitu.oop.practice.endterm.repositories.interfaces.IUniverity_ProfileRepository;

import java.util.List;

public class University_ProfileController {
    private final IUniverity_ProfileRepository repo;

    public University_ProfileController(IUniverity_ProfileRepository repo) { this.repo = repo; }

    public String createUniversity_Profile(int unipr_id, String fullname, String phoneNumb, String email,
                                           int studyYear, String universityName, int profile_id ) {//method to create
        //university_profile in sql table

        University_Profile university_profile = new University_Profile(unipr_id, fullname, phoneNumb, email,
                studyYear, universityName,  profile_id);

        boolean created = repo.createUniversity_Profile(university_profile);

        return (created ? "University_Profile was created!" : "University_Profile creation was failed!");
    }

    public String getUniversity_Profile(int unipr_id) { //method to get University_Profile by id
        University_Profile university_profile = repo.getUniversity_Profile(unipr_id);

        return (university_profile == null ? "University_Profile was not found!" : university_profile.toString());
    }

    public String getAllUniversity_Profile() { //method to get all University_Profile from table
        List<University_Profile> university_profile = repo.getAllUniversity_Profile();

        return university_profile.toString();
    }

    public String deleteUniversity_profile(int unipr_id) {
        University_Profile university_profile = repo.deleteUniversity_ProfileById(unipr_id);
        return (university_profile == null ? "University profile has deleted" : "University profile was not found!");
    }
}
