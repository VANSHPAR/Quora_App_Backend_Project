package com.example.quoraclone.services;

import com.example.quoraclone.Repositories.AnswerRepository;
import com.example.quoraclone.Repositories.QuestionRepository;
import com.example.quoraclone.Repositories.UserRepository;
import com.example.quoraclone.dtos.AnswerDto;
import com.example.quoraclone.models.Answer;
import com.example.quoraclone.models.Question;
import com.example.quoraclone.models.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final QuestionRepository questionRepository;

    private final UserRepository userRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, UserRepository userRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    public List<Answer> getAnswersByQuestionId(Long questionId,int page,int pageSize) {
        return answerRepository.findByQuestionId(questionId, (Pageable) PageRequest.of(page,pageSize)).getContent();
    }

    public Answer createAnswer(AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setContent(answerDto.getContent());
        Optional<Question> question = questionRepository.findById(answerDto.getQuestionId());
        question.ifPresent(answer::setQuestion);
        Optional<User> user = userRepository.findById(answerDto.getUserId());
        user.ifPresent(answer::setUser);
        return answerRepository.save(answer);
    }
    public void deleteAnswer(Long answerId) {
        answerRepository.deleteById(answerId);
    }
}
