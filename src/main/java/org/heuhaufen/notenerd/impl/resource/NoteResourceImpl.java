package org.heuhaufen.notenerd.impl.resource;

import javax.enterprise.context.ApplicationScoped;

import org.heuhaufen.notenerd.api.NoteEnum;
import org.heuhaufen.notenerd.api.dto.NoteResponseDto;
import org.heuhaufen.notenerd.api.resource.NoteResource;

/**
 * @author schandbert on 2020-06-27
 */
@ApplicationScoped
public class NoteResourceImpl implements NoteResource {

    @Override
    public NoteResponseDto getNote(NoteEnum id) {
        return NoteResponseDto.builder().id(id).build();
    }

}
