package com.education.backend.models;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "students")
public class StudentDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int studentId;
	@Column(name = "studentname")
	private String studentName;
	@Column(name = "studentdepartment")
	private String studentDepartment;
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(studentDepartment, studentId, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDTO other = (StudentDTO) obj;
		return Objects.equals(studentDepartment, other.studentDepartment) && studentId == other.studentId
				&& Objects.equals(studentName, other.studentName);
	}
	
	public StudentDTO() {}
	
	public StudentDTO(int studentId, String studentName, String studentDepartment) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDepartment = studentDepartment;
	}

	@Override
	public String toString() {
		return "StudentDTO{" +
				"studentId=" + studentId +
				", studentName='" + studentName + '\'' +
				", studentDepartment='" + studentDepartment +
				'}';
				
	}
}
