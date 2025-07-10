package com.example.quoraclone.Repositories;

import com.example.quoraclone.models.Question;
import com.example.quoraclone.models.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Query("SELECT q from Question q join q.tags t where t.id in :tagIds")
    Page<Question> findQuestionByTags(Set<Long> tagIds, Pageable pageable);
}
