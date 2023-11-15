package io.github.matperetti.eventschedulerapi.domain.repository;

import io.github.matperetti.eventschedulerapi.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
