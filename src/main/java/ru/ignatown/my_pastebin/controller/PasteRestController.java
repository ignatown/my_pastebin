package ru.ignatown.my_pastebin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ignatown.my_pastebin.entity.Paste;
import ru.ignatown.my_pastebin.entity.PasteDTO;
import ru.ignatown.my_pastebin.service.PasteService;

import java.util.List;

@RestController
public class PasteRestController {
    private final PasteService pasteService;

    public PasteRestController(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    @PostMapping("/")
    public ResponseEntity<Paste> savePaste(@RequestBody PasteDTO pasteDTO) {
       return new ResponseEntity<>(
               pasteService.savePaste(pasteDTO),
               HttpStatus.CREATED);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Paste> getPaste(@PathVariable String shortUrl) {
        return new ResponseEntity<>(
                pasteService.getPaste(shortUrl),
                HttpStatus.FOUND
        );
    }

    @GetMapping("")
    public ResponseEntity<List<Paste>> getAllPastes() {
        return new ResponseEntity<>(
                pasteService.getLast10Paste(),
                HttpStatus.FOUND
        );
    }
}
