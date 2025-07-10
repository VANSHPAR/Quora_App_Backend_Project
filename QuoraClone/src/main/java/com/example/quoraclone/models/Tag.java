package com.example.quoraclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag extends BaseModel{
    private String name;

    @ManyToMany(mappedBy = "followedTags")
    private Set<User> followers;
}
