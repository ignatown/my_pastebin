package ru.ignatown.my_pastebin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ignatown.my_pastebin.entity.Paste;

import java.util.List;

@Repository
public interface PasteRepository extends CrudRepository<Paste, Integer> {
    Paste findByShortUrl(String shortUrl);
    List<Paste> findAll();

}
