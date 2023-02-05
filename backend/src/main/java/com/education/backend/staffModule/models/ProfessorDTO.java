package com.education.backend.staffModule.models;

import jakarta.persistence.*;

import java.util.Objects;


// "name" field is used when table or columns names are different
// from the model class -- >"Professors" & "ProfessorDTO"
@Entity
@Table(name = "Professors")
public class ProfessorDTO {
    @Id
    @Column(name = "professor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professor_ID;
    //    @Id refers to the primary key of the current entity
    //    The @GeneratedValue annotation is to configure the way of increment
    //    of the specified column(field). For example when using Mysql, you may specify
    //    auto_increment in the definition of table to make it self-incremental, and then
    //    use @GeneratedValue(strategy = GenerationType.IDENTITY) ---> Indicates that the
    //    persistence provider must assign primary keys for the entity using a database
    //    identity column.


    //    Define each variable as Column by using the annotation @Column.

    @Column(name = "professor_username")
    private String professorUsername;
    @Column(name = "professor_department")
    private String professorDepartment;
    @Column(name = "professor_password")
    private String professorPassword;
    @Column(name = "professor_salary")
    private long professorSalary;

    public int getProfessor_ID() {
        return professor_ID;
    }

    public void setProfessor_ID(int professor_ID) {
        this.professor_ID = professor_ID;
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
    public String toString() {
        return "ProfessorDTO{" +
                "professor_ID=" + professor_ID +
                ", professorUsername='" + professorUsername + '\'' +
                ", professorDepartment='" + professorDepartment + '\'' +
                ", professorPassword='" + professorPassword + '\'' +
                ", professorSalary=" + professorSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorDTO that = (ProfessorDTO) o;
        return professor_ID == that.professor_ID && professorSalary == that.professorSalary && Objects.equals(professorUsername, that.professorUsername) && Objects.equals(professorDepartment, that.professorDepartment) && Objects.equals(professorPassword, that.professorPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professor_ID, professorUsername, professorDepartment, professorPassword, professorSalary);
    }

    public ProfessorDTO() {
    }

    public ProfessorDTO(int professor_ID, String professorUsername, String professorDepartment, String professorPassword, long professorSalary) {
        this.professor_ID = professor_ID;
        this.professorUsername = professorUsername;
        this.professorDepartment = professorDepartment;
        this.professorPassword = professorPassword;
        this.professorSalary = professorSalary;
    }
}
