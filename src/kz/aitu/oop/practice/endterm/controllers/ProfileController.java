package kz.aitu.oop.practice.endterm.controllers;

import kz.aitu.oop.practice.endterm.entities.Profile;
import kz.aitu.oop.practice.endterm.repositories.interfaces.IProfileRepository;

import java.util.List;

public class ProfileController {
    private final IProfileRepository repo;

    public ProfileController(IProfileRepository repo) {
        this.repo = repo;
    }

    public String createProfile(int id, String name, String surname, int age, String gender) {//method to create
        //profile in sql table

        Profile profile = new Profile(id, name, surname, age, gender);

        boolean created = repo.createProfile(profile);

        return (created ? "Profile was created!" : "Profile creation was failed!");
    }

    public String getProfile(int id) { //method to get profile by id
        Profile profile = repo.getProfile(id);

        return (profile == null ? "Profile was not found!" : profile.toString());
    }

    public String getAllProfiles() { //method to get all profiles from table
        List<Profile> profile = repo.getAllProfiles();

        return profile.toString();
    }
    public String deleteProfile(int id) {
        Profile profile = repo.deleteProfileById(id);
        return (profile == null ? "User has deleted" : "User was not found!");
    }
}
