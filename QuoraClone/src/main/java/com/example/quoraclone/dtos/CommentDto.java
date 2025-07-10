package com.example.quoraclone.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String content;

    private Long answerId;
    private Long parentCommentId;
}
