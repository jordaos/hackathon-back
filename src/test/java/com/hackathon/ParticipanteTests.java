package com.hackathon;

import static org.junit.Assert.*;

import com.hackathon.entity.Participante;
import com.hackathon.repository.ParticipanteRepository;
import com.hackathon.service.ParticipanteService;
import com.hackathon.service.impl.ParticipanteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ParticipanteTests {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public ParticipanteService participanteService() {
            return new ParticipanteServiceImpl();
        }
    }

    @Autowired
    private ParticipanteService participanteService;

    @MockBean
    private ParticipanteRepository participanteRepository;

    @Before
    public void setUp() {
        Participante alex1 = new Participante(null, "Jordao", "jordao05@hotmail.com", "123", "img.jpg", "P");
        Participante alex2 = new Participante(1, "Jordao", "jordao05@hotmail.com", "123", "img.jpg", "P");

        Mockito.when(participanteRepository.save(alex1)).thenReturn(alex2);
        Mockito.when(participanteRepository.findByEmail(alex1.getEmail())).thenReturn(alex1);
    }

    @Test
    public void testEmail() {
        String email = "jordao05@hotmail.com";
        Participante found = participanteService.findByEmail(email);

        assertEquals(found.getEmail(), email);
    }
}
