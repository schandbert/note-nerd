package org.heuhaufen.notenerd.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * @author schandbert on 2020-06-28
 */
@Data
@Builder
public class Item {

    private Note value;
    private List<Note> distractors;
    private List<Note> answers;

    public List<Note> getAnswers() {
        if (answers == null) {
            var notes = new ArrayList(distractors);
            notes.add(value);
            Collections.shuffle(notes);
            answers = notes;
        }
        return Collections.unmodifiableList(answers);
    }
}
