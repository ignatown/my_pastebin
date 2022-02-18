package ru.ignatown.my_pastebin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ignatown.my_pastebin.entity.Author;
import ru.ignatown.my_pastebin.repository.AuthorRepository;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private static final Logger logger = LoggerFactory.getLogger(
            AuthorService.class);

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        authorRepository.save(author);
        logger.info("IN AuthorService save new author: " + author.getUsername());
        return author;
    }

    public Author findByUsername(String username) {
        logger.info("IN findByUsername find author by username: " + username);
        return authorRepository.findAuthorByUsername(username);
    }

    public boolean nameVerification(String username) {
            if (authorRepository.existsAuthorByUsername(username)) {
                throw new IllegalArgumentException("There is already an author with the same username in the database");
            }
        return authorRepository.existsAuthorByUsername(username);
    }
}
