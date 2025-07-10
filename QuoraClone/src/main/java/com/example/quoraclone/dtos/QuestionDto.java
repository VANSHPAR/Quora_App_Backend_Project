package com.example.quoraclone.dtos;

import com.example.quoraclone.models.Tag;
import com.example.quoraclone.models.User;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Long id;

    private String title;

    private String content;

    private Set<Long> tagIds;

    private Long userId;


}
