package com.example.quoraclone.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question extends BaseModel{

    private String title;
    private String content;

    @ManyToMany
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn("question_id"),
            inverseJoinColumns = @JoinColumn("tag_id")
    )
    private Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
