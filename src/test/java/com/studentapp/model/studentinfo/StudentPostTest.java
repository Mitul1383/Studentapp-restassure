package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.given;

/**
 * Created by Mitul
 */
public class StudentPostTest extends TestBase {
/*
      this is using randomdata */

    String email = "mittulpattel" + getRandomString(4) + "@gmail.com";

    @Test
    /*
     create new student in data base with giving all necessary details.
    after successful student added we are getting 201 status code successfully.
     */
    public void createNewStudent() {
        List<String> course = new ArrayList<>();

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Prem");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
     /*
     create new student in data base with giving all necessary  details but without first name.
    after successful student added we are getting 201 status code successfully.
     */
    public void createNewStudentWithoutFirstName() {

        List<String> course = new ArrayList<>();


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(" ");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
     /*
     create new student in data base with giving all necessary details but without last name.
    after successful student added we are getting 201 status code successfully.
     */
    public void createNewStudentWithoutLastName() {

        List<String> course = new ArrayList<>();

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Megh");
        studentPojo.setLastName(" ");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test
     /*
     create new student in data base with giving all necessary details but here we are giving duplicate email id.
    system showing getting error 500 status code.
     */
    public void StudentDuplicateEmailError() {

        List<String> course = new ArrayList<>();

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Brijesh");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("brij@gmail.com");
        studentPojo.setProgramme("Testing");
        studentPojo.setCourses(course);

        course.add("selenium");
        course.add("java");
        course.add("API Testing");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(500);
        response.prettyPrint();


    }
}
