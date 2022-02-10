package ru.ignatown.my_pastebin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ignatown.my_pastebin.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Author findAuthorByUsername(String username);
    boolean existsAuthorByUsername(String name);
}
