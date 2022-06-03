package com.Alterra.ISO.Service.Impl;

import com.Alterra.ISO.Model.GolonganObat;
import com.Alterra.ISO.Repository.GolonganObatRepository;
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
@SpringBootTest(classes = GolonganObatServiceImpl.class)
class GolonganObatServiceImplTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Integer id;

    @Mock
    private GolonganObatRepository golonganObatRepository;

    @InjectMocks
    private GolonganObatServiceImpl golonganObatService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextInt();
    }

    @Test
    void createGolongan() {
        GolonganObat golonganObat = easyRandom.nextObject(GolonganObat.class);
        when(golonganObatRepository.save(golonganObat)).thenReturn(golonganObat);
        GolonganObat result = golonganObatService.createGolongan(golonganObat);
        assertEquals(golonganObat, result);
    }

    @Test
    void findAllGolObat() {
        List<GolonganObat> golonganObatList = new ArrayList<>();
        golonganObatList.add(new GolonganObat());

        given(golonganObatRepository.findAll()).willReturn(golonganObatList);

        List<GolonganObat> expected = golonganObatService.findAllGolObat();

        assertEquals(expected, golonganObatList);
        verify(golonganObatRepository).findAll();
    }

    @Test
    void findByIdGolObat() {
        GolonganObat golonganObat = easyRandom.nextObject(GolonganObat.class);
        when(golonganObatRepository.findById(id)).thenReturn(Optional.ofNullable(golonganObat));
        GolonganObat result = golonganObatService.findByIdGolObat(id);
        assertEquals(golonganObat, result);
    }

    @Test
    void updateGolObat() {
        GolonganObat golonganObat = new GolonganObat();
        golonganObat.setId(id);
        golonganObat.setNamaGolongan("Test Name");
        golonganObat.setDeskripsiGolongan("Test Deskripsi");

        GolonganObat newGolonganObat = new GolonganObat();
        golonganObat.setNamaGolongan("New Name");
        golonganObat.setDeskripsiGolongan("New Deskripsi");

        given(golonganObatRepository.findById(golonganObat.getId())).willReturn(Optional.of(golonganObat));
        golonganObatService.updateGolObat(golonganObat.getId(), newGolonganObat);

        verify(golonganObatRepository).save(newGolonganObat);
        verify(golonganObatRepository).findById(golonganObat.getId());
    }

    @Test
    void deleteGolObat() {
        golonganObatService.deleteGolObat(id);
        verify(golonganObatRepository, times(1)).deleteById(id);
        GolonganObat golonganObat = new GolonganObat();
        golonganObat.setNamaGolongan("Test Name");
        golonganObat.setDeskripsiGolongan("Test Deskripsi");
        golonganObat.setId(id);

        when(golonganObatService.findByIdGolObat(golonganObat.getId()));

        golonganObatService.deleteGolObat(golonganObat.getId());
        verify(golonganObatRepository).deleteById(golonganObat.getId());
    }
}