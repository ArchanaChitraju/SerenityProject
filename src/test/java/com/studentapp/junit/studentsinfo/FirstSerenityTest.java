package com.studentapp.junit.studentsinfo;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI="http://localhost:8080/student";
    }

    @Test
    public void getAllStudents()
    {
        SerenityRest.given().when().get("/list").then().log().all().statusCode(200);
    }

    @Test
    public  void thisIsaFailing()
    {
        SerenityRest.given().when().get("/list").then().
                statusCode(500);
    }

    @Pending
    @Test
    public void thisIsaPending()
    {

    }

    @Ignore
    @Test
    public void thisIsaskippedtest()
    {

    }

    @Manual
    @Test
    public void thisIsaManualtest()
    {

    }



}
