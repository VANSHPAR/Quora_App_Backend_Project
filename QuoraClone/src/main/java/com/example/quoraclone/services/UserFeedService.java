package com.example.quoraclone.services;

import com.example.quoraclone.Repositories.QuestionRepository;
import com.example.quoraclone.Repositories.UserRepository;
import com.example.quoraclone.models.Question;
import com.example.quoraclone.models.Tag;
import com.example.quoraclone.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserFeedService {

    private final UserRepository userRepository;

    private final QuestionRepository questionRepository;

    public UserFeedService(UserRepository userRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    public List<Question> getUserFeed(Long userId,int page,int size){
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));

        Set<Long> tagIds=user.getFollowedTags().stream().map(Tag::getId).collect(Collectors.toSet());
        return questionRepository.findQuestionByTags(tagIds, PageRequest.of(page,size)).getContent();
    }
}
