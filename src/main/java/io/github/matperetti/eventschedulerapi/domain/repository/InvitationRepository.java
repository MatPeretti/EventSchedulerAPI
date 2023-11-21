package io.github.matperetti.eventschedulerapi.domain.repository;

import io.github.matperetti.eventschedulerapi.domain.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    List<Invitation> findByInvitedUserId(Long userId);
}
