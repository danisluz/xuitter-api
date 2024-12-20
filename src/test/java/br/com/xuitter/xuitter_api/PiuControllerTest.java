package br.com.xuitter.xuitter_api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PiuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should piu")
    void x1() throws Exception {

        mockMvc.perform(get("/piu"))
                .andExpect(status().isOk())
                .andExpect(content().string("\uD83D\uDC26"));
    }
}
