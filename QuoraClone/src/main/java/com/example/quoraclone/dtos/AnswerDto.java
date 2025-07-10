package com.example.quoraclone.dtos;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private Long id;

    private String content;

    private Long questionId;

    private Long userId;


}
