package SenerityRestassignmets;

import com.studentApp.mdel.CustomerClass;
import com.studentApp.mdel.StudentClass;
import com.studentapp.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasValue;

public class Assignment3 {

    static String firstName="SMOKEUSER";
    static String lastName="SMOKELAST";
    static String userName=TestUtils.getRandomValue()+"firstuser1";
    static String passWord="password@12";
    static String emailId= TestUtils.getRandomValue()+"abc@test.com";

    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/customer/register";
    }

	 @Test
    public void Test01()
    {
       CustomerClass customer=new CustomerClass();
        customer.setFirstName(firstName);
        customer.setlastName(lastName);
        customer.setUserName(userName);
        customer.setPassWord(passWord);
        customer.setEmail(emailId);
        HashMap<String,Object> value=RestAssured.given().contentType(ContentType.JSON).log().all().when().body(customer).post().then().log().all().statusCode(201).extract().path("");
        System.out.println(value);
        String expectedMsg=value.get("SuccessCode").toString();
        assertThat(value,hasValue("Operation completed successfully"));
        assertTrue(expectedMsg.equalsIgnoreCase("OPERATION_SUCCESS"));
        System.out.println("SuccessCode is verified sucessfully");
        HashMap<String,Object> value1=RestAssured.given().contentType(ContentType.JSON).log().all().when().body(customer).post().then().log().all().statusCode(200).extract().path("");
        System.out.println(value1);
        String expectedFaultMsg=value1.get("fault").toString();
        assertTrue(expectedFaultMsg.equalsIgnoreCase("FAULT_USER_ALREADY_EXISTS"));
        System.out.println("fault SuccessCode is verified sucessfully");
    }


}
