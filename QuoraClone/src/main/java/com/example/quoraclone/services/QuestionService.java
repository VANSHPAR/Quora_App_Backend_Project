package com.example.quoraclone.services;

import com.example.quoraclone.Repositories.QuestionRepository;
import com.example.quoraclone.Repositories.TagRepository;
import com.example.quoraclone.Repositories.UserRepository;
import com.example.quoraclone.dtos.QuestionDto;
import com.example.quoraclone.models.Question;
import com.example.quoraclone.models.Tag;
import com.example.quoraclone.models.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    public QuestionService(QuestionRepository questionRepository, UserRepository userRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }
   public List<Question> getQuestions(int page,int size){
        return questionRepository.findAll(PageRequest.of(page,size)).getContent();
   }
    public Optional<Question> getQuestionById(Long id){
        return questionRepository.findById(id);
    }
    public Question createQuestion(QuestionDto questionDto){
        Question question=new Question();
        question.setTitle(questionDto.getTitle());
        question.setContent(questionDto.getContent());
        Optional<User> user=userRepository.findById(questionDto.getUserId());

        Set<Long> tags=new  HashSet<>();
        Set<Long> s=questionDto.getTagIds();
        for(Long x:s){
            tags.add(x);
        }
        return questionRepository.save(question);
    }
}
