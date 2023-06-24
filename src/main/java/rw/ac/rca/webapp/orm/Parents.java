package rw.ac.rca.webapp.orm;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parents")
public class Parents extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    private Student student;
}
