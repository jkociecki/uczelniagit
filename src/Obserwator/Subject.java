package Obserwator;
import uczelnia.Student;

public interface Subject {
    void dodajStudenta(Student student);
    void usunStudenta(Student student);
    void powiadomObserwatorow();
}
