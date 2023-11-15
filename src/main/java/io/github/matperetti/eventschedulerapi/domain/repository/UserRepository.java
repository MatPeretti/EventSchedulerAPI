package io.github.matperetti.eventschedulerapi.domain.repository;

import io.github.matperetti.eventschedulerapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}


