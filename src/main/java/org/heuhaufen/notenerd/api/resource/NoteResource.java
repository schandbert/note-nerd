package org.heuhaufen.notenerd.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.heuhaufen.notenerd.api.NoteEnum;
import org.heuhaufen.notenerd.api.dto.NoteResponseDto;

@Path("/note")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface NoteResource {

    @GET
    @Path("/{id}")
    NoteResponseDto getNote(@PathParam("id") NoteEnum id);

}