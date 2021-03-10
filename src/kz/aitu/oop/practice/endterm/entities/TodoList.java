package kz.aitu.oop.practice.endterm.entities;


public class TodoList {
    private int list_id;
    private String task_name;
    private String task_deadline;
    private int profile_id;

    public TodoList() { }

    public TodoList(int list_id, String task_name, String task_deadline, int profile_id) {
        setList_id(list_id);
        setTask_name(task_name);
        setTask_deadline(task_deadline);
        setProfile_id(profile_id);
    }

    public int getList_id() { return list_id; }
    public void setList_id(int list_id) { this.list_id = list_id; }

    public String getTask_name() { return task_name; }
    public void setTask_name(String task_name) { this.task_name = task_name; }

    public String getTask_deadline() { return task_deadline; }
    public void setTask_deadline(String task_deadline) { this.task_deadline = task_deadline; }

    public int getProfile_id() { return profile_id; }
    public void setProfile_id(int profile_id) { this.profile_id = profile_id; }

    @Override
    public String toString() {
        return "TodoList{" +
                "id='" + list_id + '\'' +
                ", task_name='" + task_name + '\'' +
                ", task_deadline='" + task_deadline + '\'' +
                ", profile_id='" + profile_id + '\'' + '}'+'\n';
    }
}



