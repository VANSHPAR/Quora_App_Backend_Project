package com.example.quoraclone.Repositories;

import com.example.quoraclone.models.Answer;
import com.example.quoraclone.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
