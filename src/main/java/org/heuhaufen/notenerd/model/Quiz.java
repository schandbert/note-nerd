package org.heuhaufen.notenerd.model;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Getter;

/**
 * @author schandbert on 2020-06-28
 */
@Getter
public class Quiz {

    private ItemGenerator itemGenerator = new ItemGenerator();

    private UUID uuid;

    private List<Note> possibleNotes;

    private List<Item> items;

    public Quiz(UUID uuid, List<Note> possibleNotes) {
        this.uuid = uuid;
        this.possibleNotes = possibleNotes;
        items = IntStream.range(0, 10).mapToObj(ignored -> itemGenerator.generate(possibleNotes))
            .collect(Collectors.toList());
    }

    public boolean answerItem(int itemIndex, Note answer) {
        Note value = items.get(itemIndex).getValue();
        return value.equals(answer);
    }

}
