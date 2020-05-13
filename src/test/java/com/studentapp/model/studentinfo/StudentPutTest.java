package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Mitul
 */
public class StudentPutTest extends TestBase {


    @Test
     /*
     updating students details with put method.
         */
    public void updatedStudentById() {

        List<String> course = new ArrayList<>();

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Prem");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("prempatel@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .put("/109");
        response.then().statusCode(200);
        response.prettyPrint();


    }


}
