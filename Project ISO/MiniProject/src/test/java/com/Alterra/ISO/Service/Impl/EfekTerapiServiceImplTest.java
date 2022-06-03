package com.Alterra.ISO.Service.Impl;

import com.Alterra.ISO.Model.EfekTerapi;
import com.Alterra.ISO.Repository.EfekTerapiRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = EfekTerapiServiceImpl.class)
class EfekTerapiServiceImplTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Integer id;

    @Mock
    private EfekTerapiRepository efekTerapiRepository;

    @InjectMocks
    private EfekTerapiServiceImpl efekTerapiService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextInt();
    }

    @Test
    void create() {
        EfekTerapi terapi = easyRandom.nextObject(EfekTerapi.class);
        terapi.setNamaEfekTerapi(terapi.getNamaEfekTerapi());
        terapi.setDeskripsiEfekTerapi(terapi.getDeskripsiEfekTerapi());
        when(efekTerapiRepository.save(terapi)).thenReturn(terapi);
        EfekTerapi result = efekTerapiService.create(terapi);
        assertEquals(terapi, result);
    }

    @Test
    void findAll() {
        List<EfekTerapi> terapiList = new ArrayList<>();
        terapiList.add(new EfekTerapi());

        given(efekTerapiRepository.findAll()).willReturn(terapiList);

        List<EfekTerapi> expected = efekTerapiService.findAll();

        assertEquals(expected, terapiList);
        verify(efekTerapiRepository).findAll();
    }

    @Test
    void findById() {
        EfekTerapi terapi = easyRandom.nextObject(EfekTerapi.class);
        when(efekTerapiRepository.findById(id)).thenReturn(Optional.ofNullable(terapi));
        EfekTerapi result = efekTerapiService.findById(id);
        assertEquals(terapi, result);
    }

    @Test
    void update() {
        EfekTerapi efekTerapi = new EfekTerapi();
        efekTerapi.setId(id);
        efekTerapi.setNamaEfekTerapi("Test Name");
        efekTerapi.setDeskripsiEfekTerapi("Test Deskripsi");

        EfekTerapi newEfekTerapi = new EfekTerapi();
        efekTerapi.setNamaEfekTerapi("New Name");
        efekTerapi.setDeskripsiEfekTerapi("New Deskripsi");

        given(efekTerapiRepository.findById(efekTerapi.getId())).willReturn(Optional.of(efekTerapi));
        efekTerapiService.update(efekTerapi.getId(), newEfekTerapi);

        verify(efekTerapiRepository).save(newEfekTerapi);
        verify(efekTerapiRepository).findById(efekTerapi.getId());
    }

    @Test
    void delete() {
        efekTerapiService.delete(id);
        verify(efekTerapiRepository, times(1)).deleteById(id);
        EfekTerapi efekTerapi = new EfekTerapi();
        efekTerapi.setNamaEfekTerapi("Test Name");
        efekTerapi.setDeskripsiEfekTerapi("Test deskripsi");
        efekTerapi.setId(id);

        when(efekTerapiService.findById(efekTerapi.getId()));

        efekTerapiService.delete(efekTerapi.getId());
        verify(efekTerapiRepository).deleteById(efekTerapi.getId());
    }
}