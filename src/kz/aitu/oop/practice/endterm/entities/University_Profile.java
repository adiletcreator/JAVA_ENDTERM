package kz.aitu.oop.practice.endterm.entities;

public class University_Profile {
    private int unipr_id;
    private String fullname;
    private String phoneNumb;
    private String email;
    private int studyYear;
    private String universityName;
    private int profile_id;

    public University_Profile() { }

    public University_Profile(int unipr_id, String fullname, String phoneNumb, String email, int studyYear,
                              String universityName, int profile_id) {
        setUnipr_id(unipr_id);
        setFullname(fullname);
        setPhoneNumb(phoneNumb);
        setEmail(email);
        setStudyYear(studyYear);
        setUniversityName(universityName);
        setProfile_id(profile_id);
    }

    public int getUnipr_id() { return unipr_id; }
    public void setUnipr_id(int unipr_id) { this.unipr_id = unipr_id; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getPhoneNumb() { return phoneNumb; }
    public void setPhoneNumb(String phoneNumb) { this.phoneNumb = phoneNumb; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getStudyYear() { return studyYear; }
    public void setStudyYear(int studyYear) { this.studyYear = studyYear; }

    public String getUniversityName() { return universityName; }
    public void setUniversityName(String universityName) { this.universityName = universityName; }

    public int getProfile_id() { return profile_id; }
    public void setProfile_id(int profile_id) { this.profile_id = profile_id; }

    @Override
    public String toString() {
        return "University_Profile{" +
                "id='" + unipr_id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phoneNumber='" + phoneNumb + '\'' +
                ", email='" + email + '\'' +
                ", studyYear='" + studyYear + '\'' +
                ", universityName='" + universityName + '\'' +
                ", profile_id='" + profile_id + '\'' + '}'+'\n';
    }
}
