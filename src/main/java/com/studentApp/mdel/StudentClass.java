package com.studentApp.mdel;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }

    public String getlastName()
    {
        return lastName;
    }
    public void setlastName(String lastName)
    {
        this.lastName=lastName;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getProgramme()
    {
        return programme;
    }
    public void setProgramme(String programme)
    {
        this.programme=programme;
    }
    public List<String> getCourses()
    {
        return courses;
    }
    public void setCourses(List<String> courses)
    {
        this.courses=new ArrayList<String>();
        this.courses.addAll(courses);
    }

}


