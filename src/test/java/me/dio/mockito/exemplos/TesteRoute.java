package me.dio.mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.restassured.RestAssured.*;

@ExtendWith(MockitoExtension.class)
public class TesteRoute {

  @Test
  void testExternalApiSuccess() {
    given()
            .when()
            .get("http://dummyjson.com/test")
            .then()
            .assertThat()
            .statusCode(200);
  }

  @Test
  void testExternalApiContentType() {
    given()
            .when()
            .get("http://dummyjson.com/test")
            .then()
            .assertThat()
            .contentType("application/json");
  }

  @Test
  void testExternalApiInvalidEndpoint() {
    given()
            .when()
            .get("http://dummyjson.com/invalid")
            .then()
            .assertThat()
            .statusCode(404);
  }
}
