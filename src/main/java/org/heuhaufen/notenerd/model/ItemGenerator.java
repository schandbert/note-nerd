package org.heuhaufen.notenerd.model;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import lombok.NoArgsConstructor;

/**
 * @author schandbert on 2020-06-28
 */
@ApplicationScoped
@NoArgsConstructor
public class ItemGenerator {

    public Item generate(List<Note> possibleNotes) {
        Collections.shuffle(possibleNotes);
        List<Note> randomNotes = possibleNotes.subList(0, 4);
        return Item.builder().value(randomNotes.get((0))).distractors(randomNotes.subList(1, 4)).build();
    }

}
