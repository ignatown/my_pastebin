package ru.ignatown.my_pastebin.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ignatown.my_pastebin.entity.Author;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AuthorService authorService;

    public UserDetailsServiceImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author = authorService.findByUsername(username);
        if (author == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(author.getUsername(), author.getPassword(), emptyList());
    }
}