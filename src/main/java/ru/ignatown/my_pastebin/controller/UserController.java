package ru.ignatown.my_pastebin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.ignatown.my_pastebin.entity.Author;
import ru.ignatown.my_pastebin.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/a")
public class UserController {

    private AuthorService authorService;
    private BCryptPasswordEncoder encoder;

    public UserController(AuthorService authorService, BCryptPasswordEncoder encoder) {
        this.authorService = authorService;
        this.encoder = encoder;
    }

    @PostMapping("/reg")
    public ResponseEntity<Author> signUp(@RequestBody Author author) {
        author.setPassword(encoder.encode(author.getPassword()));
        return new ResponseEntity<>(authorService.save(author),
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Author> findAll() {
        return authorService.findAllAuthors();
    }
}
