package com.martins.code.codeblog_backend.authentication.repositories;

import com.martins.code.codeblog_backend.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
