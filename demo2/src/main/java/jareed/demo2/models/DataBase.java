package jareed.demo2.models;

import java.util.ArrayList;

public interface DataBase {
    boolean addStudent( ArrayList<Student> estudiantes);
    void saveStudent(Student student);
    void updateStudent(Student student);
}