package kz.aitu.oop.practice.endterm.repositories.interfaces;

import kz.aitu.oop.practice.endterm.entities.Profile;

import java.util.List;
    //interface from which the class repository inherits the interface
public interface IProfileRepository {
    boolean createProfile(Profile profile);
    Profile getProfile(int id);
    List<Profile> getAllProfiles();
    Profile deleteProfileById(int id);
    }
