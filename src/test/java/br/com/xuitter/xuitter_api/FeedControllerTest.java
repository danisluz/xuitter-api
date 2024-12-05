package br.com.xuitter.xuitter_api;

import br.com.xuitter.xuitter_api.entities.User;
import br.com.xuitter.xuitter_api.entities.Xuit;
import br.com.xuitter.xuitter_api.repositories.UserRepository;
import br.com.xuitter.xuitter_api.repositories.XuitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") // Garante o uso do perfil de teste
public class FeedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private XuitRepository xuitRepository;

    @Test
    @DisplayName("should return a feed of xuits")
    void t1() throws Exception {
        // Limpa os dados existentes
        xuitRepository.deleteAll();
        userRepository.deleteAll();

        // Cria e salva um usuário
        User daniel = new User("daniel");
        userRepository.save(daniel);

        // Cria e salva xuits associados ao usuário
        xuitRepository.saveAll(List.of(
                new Xuit("Primeiro Xuit", Xuit.XuitType.ORIGINAL, daniel),
                new Xuit("Segundo Xuit", Xuit.XuitType.REXUIT, daniel)
        ));

        // Realiza o teste no endpoint /feed
        mockMvc.perform(get("/feed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].content").value("Primeiro Xuit"))
                .andExpect(jsonPath("$[0].authorUsername").value("daniel"))
                .andExpect(jsonPath("$[0].type").value("ORIGINAL"))

                .andExpect(jsonPath("$[1].content").value("Segundo Xuit"))
                .andExpect(jsonPath("$[1].authorUsername").value("daniel"))
                .andExpect(jsonPath("$[1].type").value("REXUIT"));
    }
}
