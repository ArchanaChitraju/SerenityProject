package com.studentapp.junit.studentsinfo;

import com.studentApp.mdel.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import java.util.ArrayList;
import java.util.HashMap;
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDtest extends TestBase {

    static String firstName="Smokeuserfirst"+TestUtils.getRandomValue();
    static String lastName="Smokeuserlast"+TestUtils.getRandomValue();
    static String programme="ComuterScience";
    static String email= TestUtils.getRandomValue()+"xyzabc@gmail.com";
    static int studentId;
    @Title("This will create a new student")
    @Test
    public void Test001()
    {
        ArrayList<String> courses=new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");
        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setlastName(lastName);
        student.setProgramme(programme);
        student.setEmail(email);
        student.setCourses(courses);
        RestAssured.given().contentType(ContentType.JSON).log().all().when().body(student).post().then().log().all().statusCode(201);
    }

    @Title("Verify if the student was added to the application")
    @Test
    public void Test002()
    {
        String p1="findAll{it.firstName=='";
        String p2="'}.get(0)";

        HashMap<String,Object> value=
                RestAssured.given().when().get("/list").then().log().all().statusCode(200).extract().path(p1+firstName+p2);
        System.out.println(value);

       assertThat(value,hasValue(firstName));
        studentId=(int)value.get("id");
        System.out.println(studentId);
    }

    @Title("Update the user information and verify the user information")
    @Test
    public void Test003(){

        String p1="findAll{it.firstName=='";
        String p2="'}.get(0)";

        ArrayList<String> courses=new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");
        firstName=firstName+"_updated";
        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setlastName(lastName);
        student.setProgramme(programme);
        student.setEmail(email);
        student.setCourses(courses);
        RestAssured.given().contentType(ContentType.JSON).log().all().when().body(student).put("/"+studentId).then().log().all();


        HashMap<String,Object> value=
                RestAssured.given().when().get("/list").then().log().all().statusCode(200).extract().path(p1+firstName+p2);
        System.out.println(value);

        assertThat(value,hasValue(firstName));

    }

    @Title("Delete the user information and verify if it is deleted")
    @Test
    public void Test004()
    {
        RestAssured.given().when().delete("/"+studentId);

        RestAssured.given().when().get("/"+studentId).then().log().all().statusCode(404);
    }
}
