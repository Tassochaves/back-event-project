package com.dev.api_eventos.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.api_eventos.domain.event.Event;
import com.dev.api_eventos.domain.event.EventRequestDTO;
import com.dev.api_eventos.domain.event.EventResponseDTO;
import com.dev.api_eventos.repositories.EventRepository;

@Service
public class EventService {

    @Value("${app.path.arquivos}")
    private String pathArquivos;

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(EventRequestDTO data){

        String imgUrl = null;

        if(data.image() != null){
            imgUrl = this.uploadImg(data.image());
        }

        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setImgUrl(imgUrl);
        newEvent.setRemote(data.remote());

        eventRepository.save(newEvent);

        return newEvent;
    }

    private String uploadImg(MultipartFile multipartFile) {
        String fileName = pathArquivos + UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try {
            //File file = this.convertMultipartToFile(multipartFile);
            Files.copy(multipartFile.getInputStream(), Path.of(fileName), StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (Exception e) {
            System.out.println("Erro ao subir arquivo!");
            return "";
        }
    }

    public List<EventResponseDTO> findUpcomingEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Event> eventsPage = this.eventRepository.findUpcomingEvents(new Date(), pageable);

        return eventsPage.map(event -> new EventResponseDTO(event.getId(), event.getTitle(), event.getDescription(), event.getDate(), "", "", event.getRemote(), event.getEventUrl(), event.getImgUrl())).stream().toList();
    }
}
