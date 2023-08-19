package com.example.CarRentalApplication.acceptance;

import com.example.CarRentalApplication.domain.RentalStatus;
import com.example.CarRentalApplication.service.dto.request.CustomerRequestDto;
import com.example.CarRentalApplication.service.dto.request.RentalRequestDto;
import com.example.CarRentalApplication.service.dto.response.CustomerResponseDto;
import com.example.CarRentalApplication.service.dto.response.RentalEntryResponseDto;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class RentalRestTest {

    @Rule
    public final WireMockRule wireMockRule = new WireMockRule(8083);

    @BeforeClass
    public static void setup() {
        RestAssured.port = 8085;
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void canRentACar() {
        wireMockRule.stubFor(get(urlPathMatching("/api/v1/cars/A"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(
                                        """
                                        {
                                          "licensePlate": "A",
                                          "type": "",
                                          "brand": "Chevrolet",
                                          "price": 100,
                                          "availability": "RESERVED"
                                        }
                                        """
                                )
                )
        );
        RestTemplate restTemplate = new RestTemplate();

        // Make a request to the WireMock server
        String response = restTemplate.getForObject("http://localhost:8085/api/v1/cars/A", String.class);

        // Assertions
        assertEquals("Expected licensePlate", "A", getValueFromJson(response, "licensePlate"));
        assertEquals("Expected type", "", getValueFromJson(response, "type"));
        assertEquals("Expected brand", "Toyota", getValueFromJson(response, "brand"));


//        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Tina", "tina@gmail.com");
//        CustomerResponseDto customerResponseDto = given()
//                .contentType("application/json")
//                .body(customerRequestDto)
//                .when()
//                .post("/customers")
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(CustomerResponseDto.class);
//
//        RentalRequestDto rentalRequestDto = new RentalRequestDto(
//                "12-3456",
//                String.valueOf(customerResponseDto.getCustomerNumber()),
//                LocalDate.now(),
//                null
//        );
//        RentalEntryResponseDto rentalEntryResponseDto = given()
//                .contentType("application/json")
//                .body(rentalRequestDto)
//                .when()
//                .post("/rentals")
//                .then()
//                .statusCode(200)
//                .body("status", equalTo(RentalStatus.AVAILABLE.toString()))
//                .extract()
//                .as(RentalEntryResponseDto.class);
    }

    // A helper method to extract values from JSON response
    private String getValueFromJson(String json, String key) {
        // You would need to implement this method based on your JSON parsing library
        // For simplicity, I'm assuming a basic approach here
        return json.split("\"" + key + "\":")[1].split(",")[0].replace("\"", "");
    }

}
