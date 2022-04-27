package com.alterra.ISO.Controller;


import com.alterra.ISO.Model.GolonganObat;
import com.alterra.ISO.Model.SubEfekTerapi;
import com.alterra.ISO.Service.GolonganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GolonganObat")
public class GolonganController {
    @Autowired
    private GolonganService golonganService;

    @PostMapping
    public ResponseEntity<?> createGolonganObat(@RequestBody GolonganObat golonganObat){
        GolonganObat golonganObatCreated = golonganService.createGolongan(golonganObat);
        return ResponseEntity.ok(golonganObatCreated);
    }

    @GetMapping
    public ResponseEntity<?> listGolongan(){
        List<GolonganObat> golonganObatList = golonganService.findAllGolObat();
        return ResponseEntity.ok(golonganObatList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> golonganById(@PathVariable("id") Integer id_golongan){
        try {
            GolonganObat golonganObat = golonganService.findByIdGolObat(id_golongan);
            return ResponseEntity.ok(golonganObat);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateGolObat(@PathVariable("id") Integer id_golongan, @RequestBody GolonganObat golonganObat){
        try {
            GolonganObat golonganObatUpdated = golonganService.updateGolObat(id_golongan, golonganObat);
            return ResponseEntity.ok(golonganObatUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGolonganObat(@PathVariable("id") Integer id_golongan){
        try {
            golonganService.deleteGolObat(id_golongan);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
