package org.heuhaufen.notenerd.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.heuhaufen.notenerd.api.QuizRequestDto;
import org.heuhaufen.notenerd.api.RiddleResponseDto;
import org.heuhaufen.notenerd.api.dto.QuizResponseDto;

@Path("/quiz")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface QuizResource {

    @POST
    QuizResponseDto create(QuizRequestDto quizRequestDto);

    @GET
    @Path("/{uid}/{itemIndex}")
    RiddleResponseDto getRiddle(@PathParam("uid") String uid, @PathParam("itemIndex") int itemNumber);
}