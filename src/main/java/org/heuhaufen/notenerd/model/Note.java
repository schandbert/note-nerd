package org.heuhaufen.notenerd.model;

import lombok.Value;

/**
 * @author schandbert on 2020-06-28
 */
@Value
public class Note {

    private NoteLetter noteLetter;
    private int spnValue;
    private Accidental accidental;
    private String imagePath;

}
