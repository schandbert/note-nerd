package org.heuhaufen.notenerd.api.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.heuhaufen.notenerd.api.ConstraintDto;
import org.heuhaufen.notenerd.api.QuizRequestDto;
import org.heuhaufen.notenerd.api.dto.QuizResponseDto;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;

/**
 * @author schandbert on 2020-07-12
 */
@QuarkusTest
@Slf4j
class QuizResourceTest {

    @Test
    void getRiddle() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        var quizRequestDto = new QuizRequestDto();
        quizRequestDto.setConstraint(new ConstraintDto());
        Response response = given()
            .body("{}")
            .contentType(ContentType.JSON)
            .when().post("api/v1/quiz");
        response.then().statusCode(200);
        ResponseBody body = response.getBody();
        var quizResponseDto = body.as(QuizResponseDto.class);
        var uuid = quizResponseDto.getUuid();
        log.info("uuid: {}", uuid);
        given()
            .when().get(String.format("api/v1/quiz/%s/0", uuid))
            .then()
            .statusCode(200)
            .body("answers", notNullValue());
    }
}