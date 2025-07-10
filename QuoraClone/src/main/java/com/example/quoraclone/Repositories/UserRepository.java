package com.example.quoraclone.Repositories;

import com.example.quoraclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
