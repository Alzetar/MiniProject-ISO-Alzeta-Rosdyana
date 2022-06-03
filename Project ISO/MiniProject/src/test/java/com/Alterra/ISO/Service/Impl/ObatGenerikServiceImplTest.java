package com.Alterra.ISO.Service.Impl;

import com.Alterra.ISO.Model.ObatGenerik;
import com.Alterra.ISO.Repository.ObatGenerikRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = ObatGenerikServiceImpl.class)
class ObatGenerikServiceImplTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Integer id;

    @Mock
    private ObatGenerikRepository obatGenerikRepository;

    @InjectMocks
    private ObatGenerikServiceImpl obatGenerikService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextInt();
    }


    @Test
    public void createGenerik() {
        ObatGenerik obatGenerik = easyRandom.nextObject(ObatGenerik.class);
        obatGenerik.setNamaObatGenerik(obatGenerik.getNamaObatGenerik());
        when(obatGenerikRepository.save(obatGenerik)).thenReturn(obatGenerik);
        ObatGenerik result = obatGenerikService.createGenerik(obatGenerik);
        assertEquals(obatGenerik, result);
    }

    @Test
    public void findAllObatGenerik() {
        List<ObatGenerik> obatGeneriks = new ArrayList<>();
        obatGeneriks.add(new ObatGenerik());

        given(obatGenerikRepository.findAll()).willReturn(obatGeneriks);

        List<ObatGenerik> expected = obatGenerikService.findAllObatGenerik();

        assertEquals(expected, obatGeneriks);
        verify(obatGenerikRepository).findAll();
    }

    @Test
    public void findByIdGenerik() {
        ObatGenerik obatGenerik = easyRandom.nextObject(ObatGenerik.class);
        when(obatGenerikRepository.findById(id)).thenReturn(Optional.ofNullable(obatGenerik));
        ObatGenerik result = obatGenerikService.findByIdGenerik(id);
        assertEquals(obatGenerik, result);
    }

    @Test
    public void updateObatGenerik() {
        ObatGenerik obatGenerik = new ObatGenerik();
        obatGenerik.setId(1);
        obatGenerik.setNamaObatGenerik("Test Name");

        ObatGenerik newObatGenerik = new ObatGenerik();
        obatGenerik.setNamaObatGenerik("New Test");

        given(obatGenerikRepository.findById(obatGenerik.getId())).willReturn(Optional.of(obatGenerik));
        obatGenerikService.updateObatGenerik(obatGenerik.getId(), newObatGenerik);

        verify(obatGenerikRepository).save(newObatGenerik);
        verify(obatGenerikRepository).findById(obatGenerik.getId());
    }

    @Test
    void deleteObatGenerik() {
        obatGenerikService.deleteObatGenerik(id);
        verify(obatGenerikRepository, times(1)).deleteById(id);
        ObatGenerik obatGenerik = new ObatGenerik();
        obatGenerik.setNamaObatGenerik("Test");
        obatGenerik.setId(1);

        when(obatGenerikService.findByIdGenerik(obatGenerik.getId()));

        obatGenerikService.deleteObatGenerik(obatGenerik.getId());
        verify(obatGenerikRepository).deleteById(obatGenerik.getId());
    }
}