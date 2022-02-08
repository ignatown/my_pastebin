package ru.ignatown.my_pastebin.service;

import org.springframework.stereotype.Service;
import ru.ignatown.my_pastebin.entity.Paste;
import ru.ignatown.my_pastebin.entity.PasteDTO;
import ru.ignatown.my_pastebin.repository.PasteRepository;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasteService {
    private final PasteRepository pasteRepository;

    public PasteService(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    public Paste savePaste(PasteDTO pasteDTO) {
        Paste paste = new Paste();
        paste.setExpirationTime(LocalDateTime.now()
                .plusSeconds(pasteDTO.getExpirationTime()));
        paste.setPublic(pasteDTO.getPublicType().equals("public"));
        paste.setText(pasteDTO.getText());
        paste.setShortUrl(RandomStringUtils.randomAlphabetic(5));
        pasteRepository.save(paste);
        return paste;
    }

    public Paste getPaste(String shorURL) {
        Paste findPaste = pasteRepository.findByShortUrl(shorURL);
        if (findPaste.getExpirationTime().isAfter(LocalDateTime.now())) {
            return findPaste;
        }
        return null;
    }

    public List<Paste> getLast10Paste() {
        return pasteRepository.findAll().stream()
                .filter(p -> p.isPublic())
                .filter(p -> p.getExpirationTime().isAfter(LocalDateTime.now()))
                .limit(10)
                .collect(Collectors.toList());
    }

}
