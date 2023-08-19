package edu.miu.frequentrenter.controller;

import edu.miu.entity.CustomerFrequentRenter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CustomerFrequentRenterControllerTests {
    @BeforeClass
    public static void setup() {
        RestAssured.port = 8081;
        RestAssured.baseURI = "http://localhost/api/frequent_rentals";
        RestAssured.basePath = "";
    }

    @Test
    public void testLogin() {
        CustomerFrequentRenter customer = new CustomerFrequentRenter(1234, "user1234", "pass1234");
        given()
                .contentType(ContentType.JSON)
                .body(customer)
                .when()
                .post("/login")
                .then()
                .statusCode(200);

        given()
                .contentType(ContentType.JSON)
                .body(customer)
                .when()
                .post("/login")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("customerId", equalTo(1234));
    }
}
