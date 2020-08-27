package org.heuhaufen.notenerd.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.heuhaufen.notenerd.api.NoteEnum;
import org.heuhaufen.notenerd.api.RiddleResponseDto;
import org.heuhaufen.notenerd.model.Accidental;
import org.heuhaufen.notenerd.model.Item;
import org.heuhaufen.notenerd.model.Note;
import org.heuhaufen.notenerd.model.NoteLetter;
import org.heuhaufen.notenerd.model.Quiz;

/**
 * @author schandbert on 2020-06-28
 */
@ApplicationScoped
public class QuizService {

    private final List<Note> defaultNotes = new ArrayList<>();
    private final ConcurrentMap<UUID, Quiz> quizzes = new ConcurrentHashMap<>();

    public QuizService() {
        for (NoteLetter noteLetter : NoteLetter.values()) {
            for (int spn : List.of(2, 3, 4)) {
                for (Accidental accidental : Accidental.values()) {
                    defaultNotes.add(new Note(noteLetter, spn, accidental, null));
                }
            }
        }
        //TODO remove, for testing purposes only
        Quiz quiz = new Quiz(UUID.fromString("00000000-0000-0000-0000-000000000000"), defaultNotes);
        quizzes.putIfAbsent(quiz.getUuid(), quiz);
    }

    public Quiz createQuiz() {
        Quiz quiz = new Quiz(UUID.randomUUID(), defaultNotes);
        quizzes.putIfAbsent(quiz.getUuid(), quiz);
        return quiz;
    }

    public RiddleResponseDto getRiddle(UUID uuid, int idx) {
        Quiz quiz = quizzes.get(uuid);
        Item item = quiz.getItems().get(idx);
        RiddleResponseDto riddleResponseDto = RiddleResponseDto.builder()
            .answers(item.getAnswers().stream().map(NoteEnum::fromNote).collect(Collectors.toList()))
            .build();
        return riddleResponseDto;
    }

    public void answerItem(UUID uuid, int itemIndex, Note note) {
        quizzes.get(uuid).answerItem(itemIndex, note);
    }
}
