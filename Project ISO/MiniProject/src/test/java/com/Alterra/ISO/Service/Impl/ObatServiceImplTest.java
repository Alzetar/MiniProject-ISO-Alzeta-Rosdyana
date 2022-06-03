package com.Alterra.ISO.Service.Impl;

import com.Alterra.ISO.DTO.AddToObatDto;
import com.Alterra.ISO.Model.Obat;
import com.Alterra.ISO.Repository.ObatRepository;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = ObatServiceImpl.class)
class ObatServiceImplTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Integer id;

    @Mock
    private ObatRepository obatRepository;

    @InjectMocks
    private ObatServiceImpl obatService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextInt();
    }

    @Test
    void create() {
        Obat obat = easyRandom.nextObject(Obat.class);
        AddToObatDto addToObatDto = new AddToObatDto();
        obat.setNamaObat(addToObatDto.getNamaObat());
        obat.setIndikasi(addToObatDto.getIndikasi());
        obat.setKontraIndikasi(addToObatDto.getKontraIndikasi());
        obat.setEfekSamping(addToObatDto.getEfekSamping());
        obat.setDosis(addToObatDto.getDosis());
        when(obatRepository.save(obat)).thenReturn(obat);
        Obat result = obatService.create(addToObatDto);
        assertEquals(obat, result);
    }

    @Test
    void findAll() {
        List<Obat> obatList = new ArrayList<>();
        obatList.add(new Obat());

        given(obatRepository.findAll()).willReturn(obatList);

        List<Obat> expected = obatService.findAll();

        assertEquals(expected, obatList);
        verify(obatRepository).findAll();
    }

    @Test
    void findById() {
        Obat obat = easyRandom.nextObject(Obat.class);
        when(obatRepository.findById(id)).thenReturn(Optional.ofNullable(obat));
        Obat result = obatService.findById(id);
        assertEquals(obat, result);

    }

    @Test
    void update() {
        Obat obat = new Obat();
        obat.setId(id);
        obat.setNamaObat("Test Obat");
        obat.setIndikasi("Test Indikasi");

        Obat newObat = new Obat();
        obat.setNamaObat("New Name");
        obat.setIndikasi("New Indikasi");

        given(obatRepository.findById(obat.getId())).willReturn(Optional.of(obat));
        obatService.update(obat.getId(), newObat);

        verify(obatRepository).save(newObat);
        verify(obatRepository).findById(obat.getId());
    }

    @Test
    void delete() {
        obatService.delete(id);
        verify(obatRepository, times(1)).deleteById(id);
        Obat obat = new Obat();
        obat.setNamaObat("Test Name");
        obat.setId(id);

        when(obatService.findById(obat.getId()));

        obatService.delete(obat.getId());
        verify(obatRepository).deleteById(obat.getId());
    }
}