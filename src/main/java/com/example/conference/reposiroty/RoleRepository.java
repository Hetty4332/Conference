package com.example.conference.reposiroty;

import com.example.conference.model.Role;
import com.example.conference.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
