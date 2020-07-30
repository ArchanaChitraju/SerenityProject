package com.studentApp.mdel;

public class CustomerClass {

    private String FirstName;
    private String LastName;
    private String UserName;
    private String Password;
    private String Email;
    private String email;
    private String first_name;
    private String last_name;
    private String gender;

    public String getFirstName()    {
        return FirstName;
    }
    public void setFirstName(String firstName)    {
        this.FirstName=firstName;
    }
    public String getlastName() {
        return LastName;
    }
    public void setlastName(String lastName){
        this.LastName=lastName;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_Name(String first_name){
        this.first_name=first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name){
        this.last_name=last_name;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email=email;
    }
    public String getUserName()
    {
        return UserName;
    }
    public void setUserName(String userName)
    {
        this.UserName=userName;
    }
    public String getPassWord()
    {
        return Password;
    }
    public void setPassWord(String passWord)
    {
        this.Password=passWord;
    }
    public String getEmail()
    {
        return Email;
    }
    public void setEmail(String email)
    {
        this.Email=email;
    }

}
