package ru.ignatown.my_pastebin.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.ignatown.my_pastebin.MyPastebinApplication;
import ru.ignatown.my_pastebin.repository.PasteRepository;
import ru.ignatown.my_pastebin.service.PasteService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(classes = MyPastebinApplication.class)
@AutoConfigureMockMvc
class PasteRestControllerTest {

    @MockBean
    private PasteService pasteService;

    @MockBean
    private PasteRepository pasteRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void getAllPastes() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    @WithMockUser
    void getSomePaste() throws Exception {
        this.mockMvc.perform(get("/someUrl"))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    @WithMockUser
    public void postNewPaste() throws Exception {
        this.mockMvc.perform(post("/")
                .param("text","test1")
                .param("expirationTime","600")
                .param("publicType","public"))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}