package com.education.backend.models;

import jakarta.persistence.*;

import java.util.Objects;


// "name" field is used when table or columns names are different
// from the model class -- >"Professors" & "ProfessorDTO"
@Entity
@Table(name = "professors")
public class ProfessorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int professorId;
    //    @Id refers to the primary key of the current entity
    //    The @GeneratedValue annotation is to configure the way of increment
    //    of the specified column(field). For example when using Mysql, you may specify
    //    auto_increment in the definition of table to make it self-incremental, and then
    //    use @GeneratedValue(strategy = GenerationType.IDENTITY) ---> Indicates that the
    //    persistence provider must assign primary keys for the entity using a database
    //    identity column.


    //    Define each variable as Column by using the annotation @Column.

    @Column(name = "professorusername")
    private String professorUsername;
    @Column(name = "professordepartment")
    private String professorDepartment;
    @Column(name = "professorpassword")
    private String professorPassword;
    @Column(name = "professorsalary")
    private long professorSalary;

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getProfessorUsername() {
        return professorUsername;
    }

    public void setProfessorUsername(String professorUsername) {
        this.professorUsername = professorUsername;
    }

    public String getProfessorDepartment() {
        return professorDepartment;
    }

    public void setProfessorDepartment(String professorDepartment) {
        this.professorDepartment = professorDepartment;
    }

    public String getProfessorPassword() {
        return professorPassword;
    }

    public void setProfessorPassword(String professorPassword) {
        this.professorPassword = professorPassword;
    }

    public long getProfessorSalary() {
        return professorSalary;
    }

    public void setProfessorSalary(long professorSalary) {
        this.professorSalary = professorSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorDTO that = (ProfessorDTO) o;
        return professorId == that.professorId && professorSalary == that.professorSalary && Objects.equals(professorUsername, that.professorUsername) && Objects.equals(professorDepartment, that.professorDepartment) && Objects.equals(professorPassword, that.professorPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, professorUsername, professorDepartment, professorPassword, professorSalary);
    }

    public ProfessorDTO(int professorId, String professorUsername, String professorDepartment, String professorPassword, long professorSalary) {
        this.professorId = professorId;
        this.professorUsername = professorUsername;
        this.professorDepartment = professorDepartment;
        this.professorPassword = professorPassword;
        this.professorSalary = professorSalary;
    }

    public ProfessorDTO() {
    }

    @Override
    public String toString() {
        return "ProfessorDTO{" +
                "professorId=" + professorId +
                ", professorUsername='" + professorUsername + '\'' +
                ", professorDepartment='" + professorDepartment + '\'' +
                ", professorPassword='" + professorPassword + '\'' +
                ", professorSalary=" + professorSalary +
                '}';
    }
}
