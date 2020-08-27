package org.heuhaufen.notenerd.model;

import lombok.Getter;

/**
 * @author schandbert on 2020-06-28
 */
@Getter
public enum Accidental {
    FLAT("♭"), NONE(""), SHARP("♯");

    private final String symbol;

    Accidental(String symbol) {
        this.symbol = symbol;
    }
}
