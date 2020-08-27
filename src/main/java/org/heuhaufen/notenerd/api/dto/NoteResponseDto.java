package org.heuhaufen.notenerd.api.dto;

import org.heuhaufen.notenerd.api.NoteEnum;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoteResponseDto {

    private NoteEnum id;
    private String imgSrc;
}
