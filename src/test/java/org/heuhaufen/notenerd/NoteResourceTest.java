package org.heuhaufen.notenerd;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class NoteResourceTest {

    @Test
    public void testNoteEndpoint() {
        given()
            .when().get("api/v1/note/C#3")
            .then()
            .statusCode(200)
            .body("id", equalTo("C#3"));
    }

}