package com.ltz.my_empl.entity;

public class GraduateEntity {
    /**
     * studentId : 123456
     * gender : 男
     * major : 计算机科学与技术
     * grade : 2020
     * name : 测试名
     * department : 计算机科学与工程学院
     */

    private String studentId;
    private String gender;
    private String major;
    private String grade;
    private String name;
    private String department;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
