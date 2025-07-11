package com.example.quoraclone.services;

import com.example.quoraclone.Repositories.AnswerRepository;
import com.example.quoraclone.Repositories.CommentRepository;
import com.example.quoraclone.Repositories.UserRepository;
import com.example.quoraclone.dtos.CommentDto;
import com.example.quoraclone.models.Answer;
import com.example.quoraclone.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final AnswerRepository answerRepository;


    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, AnswerRepository answerRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }

    public List<Comment> getCommentsByAnswerId(Long answerId,int offset,int limit) {
        return commentRepository.findByAnswerId(answerId,  PageRequest.of(offset,limit)).getContent();
    }

    public List<Comment> getRepliesByCommentId(Long commentId,int offset,int limit) {
        return commentRepository.findByParentCommentId(commentId, PageRequest.of(offset,limit)).getContent();
    }

    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public Comment createComment(CommentDto commentDto) {

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        Optional<Answer> answer = answerRepository.findById(commentDto.getAnswerId());
        answer.ifPresent(comment::setAnswer);
        if(commentDto.getParentCommentId()!=null) {
            Optional<Comment> parentComment = commentRepository.findById(commentDto.getParentCommentId());
            parentComment.ifPresent(comment::setParentComment);
        }
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
