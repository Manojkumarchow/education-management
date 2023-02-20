package com.education.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class CourseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "courseid")
    private String courseId;

    @Column(name = "coursename")
    private String courseName;

    @Column(name = "isactive")
    private String isActive;

    public CourseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsActive() {
        return isActive;
    }

    public CourseDTO(int id, String courseId, String courseName, String isActive) {
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
