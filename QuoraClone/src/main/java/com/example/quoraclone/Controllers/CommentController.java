package com.example.quoraclone.Controllers;

import com.example.quoraclone.dtos.CommentDto;
import com.example.quoraclone.models.Comment;
import com.example.quoraclone.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/answer/{answerId}")
    public List<Comment> getCommentsByAnswerId(@PathVariable Long answerId, @RequestParam int page, @RequestParam int size){
        return commentService.getCommentsByAnswerId(answerId, page, size);
    }

    @GetMapping("/{commentId}")
    public Optional<Comment> getCommentsByCommentId(@PathVariable Long commentId ){
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/comment/{commentId}")
    public List<Comment> getRepliesByCommentId(@PathVariable Long commentId,@RequestParam int page, @RequestParam int size){
        return commentService.getRepliesByCommentId(commentId, page, size);

    }

    @PostMapping
    public Comment createComment(@RequestBody CommentDto comment){
        return commentService.createComment(comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }
}
