package SenerityRestassignmets;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectAssignment {

    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI="https://restcountries.eu/rest/v2";
    }

    @Test
    public void CountryCode()
    {
        RestAssured.given().when().get("/name/eesti").then().log().all().statusCode(200);
    }
}
