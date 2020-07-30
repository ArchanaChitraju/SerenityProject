package SenerityRestassignmets;

import com.studentApp.mdel.CustomerClass;
import com.studentapp.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

public class Assignment4 {

    static String firstName= TestUtils.getRandomValue()+"abec12";
    static String lastName="xyz";
    static String gender="male";
    static String emailId= TestUtils.getRandomValue()+"acrch@gmail.com";
    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI="https://gorest.co.in/public-api/users";

    }

    @Test
    public void Test01()
    {
        CustomerClass customer=new CustomerClass();
        customer.setemail(emailId);
        customer.setFirst_Name(firstName);
        customer.setLast_name(lastName);
       customer.setGender(gender);
        RestAssured.given().redirects().follow(false).redirects().max(100).auth().oauth2("LwNuUF5EzNmdi2SiTRpgrMPuOvajzuN4h0Vi").
                contentType(ContentType.JSON).log().all()
                .when().body(customer).post().then().log().all().statusCode(302);

        RestAssured.given().contentType(ContentType.JSON).log().all()
                .when().body(customer).post().then().log().all().statusCode(200);

    //    RestAssured.given().auth().preemptive().oauth2("LwNuUF5EzNmdi2SiTRpgrMPuOvajzuN4h0Vi").when().get().then().log().all().statusCode(200);


    }

}






