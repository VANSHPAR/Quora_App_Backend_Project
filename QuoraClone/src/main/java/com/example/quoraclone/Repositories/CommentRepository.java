package com.example.quoraclone.Repositories;

import com.example.quoraclone.models.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import java.awt.print.Pageable;

public interface CommentRepository  extends JpaRepository<Comment,Long> {
    Page<Comment> findByAnswerId(Long answerId, Pageable pageable);
    Page<Comment> findByParentCommentId(Long parentCommentId, Pageable pageable);
}
