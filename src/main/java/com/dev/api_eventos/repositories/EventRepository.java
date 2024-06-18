package com.dev.api_eventos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.api_eventos.domain.event.Event;

public interface EventRepository extends JpaRepository<Event, UUID>{

}
