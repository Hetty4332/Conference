package com.example.conference.reposiroty;

import com.example.conference.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);


        }
