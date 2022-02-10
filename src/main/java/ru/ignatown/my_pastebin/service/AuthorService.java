package ru.ignatown.my_pastebin.service;

import org.springframework.stereotype.Service;
import ru.ignatown.my_pastebin.entity.Author;
import ru.ignatown.my_pastebin.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        authorRepository.save(author);
        return author;
    }

    public Author findByUsername(String username) {
        return authorRepository.findAuthorByUsername(username);
    }

    public boolean nameVerification(String username) {
            if (authorRepository.existsAuthorByUsername(username)) {
                throw new IllegalArgumentException("There is already an author with the same username in the database");
            }
        return authorRepository.existsAuthorByUsername(username);
    }
}
