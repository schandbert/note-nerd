package org.heuhaufen.notenerd;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class NoteResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/note")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}