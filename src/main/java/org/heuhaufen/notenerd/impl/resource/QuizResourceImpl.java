package org.heuhaufen.notenerd.impl.resource;

import java.util.UUID;

import javax.inject.Inject;

import org.heuhaufen.notenerd.api.QuizRequestDto;
import org.heuhaufen.notenerd.api.RiddleResponseDto;
import org.heuhaufen.notenerd.api.dto.QuizResponseDto;
import org.heuhaufen.notenerd.api.resource.QuizResource;
import org.heuhaufen.notenerd.impl.QuizService;
import org.heuhaufen.notenerd.model.Quiz;

/**
 * @author schandbert on 2020-06-28
 */
public class QuizResourceImpl implements QuizResource {

    @Inject
    QuizService quizService;

    @Override
    public QuizResponseDto create(QuizRequestDto quizRequestDto) {
        Quiz quiz = quizService.createQuiz();
        var quizResponseDto = new QuizResponseDto();
        quizResponseDto.setUuid(quiz.getUuid());
        return quizResponseDto;
    }

    @Override
    public RiddleResponseDto getRiddle(String uid, int itemNumber) {
        return quizService.getRiddle(UUID.fromString(uid), itemNumber);
    }

}
