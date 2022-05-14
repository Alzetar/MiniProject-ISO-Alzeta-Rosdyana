package com.Alterra.ISO.Controller;

import com.Alterra.ISO.Model.GolonganObat;
import com.Alterra.ISO.Service.GolonganObatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GolonganObat")
public class GolonganObatController {
    @Autowired
    private GolonganObatService golonganObatService;

    @PostMapping
    public ResponseEntity<?> createGolonganObat(@RequestBody GolonganObat golonganObat){
        GolonganObat golonganObatCreated = golonganObatService.createGolongan(golonganObat);
        return ResponseEntity.ok(golonganObatCreated);
    }

    @GetMapping
    public ResponseEntity<?> listGolongan(){
        List<GolonganObat> golonganObatList = golonganObatService.findAllGolObat();
        return ResponseEntity.ok(golonganObatList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> golonganById(@PathVariable("id") Integer id){
        try {
            GolonganObat golonganObat = golonganObatService.findByIdGolObat(id);
            return ResponseEntity.ok(golonganObat);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateGolObat(@PathVariable("id") Integer id, @RequestBody GolonganObat golonganObat){
        try {
            GolonganObat golonganObatUpdated = golonganObatService.updateGolObat(id, golonganObat);
            return ResponseEntity.ok(golonganObatUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGolonganObat(@PathVariable("id") Integer id) {
        try {
            golonganObatService.deleteGolObat(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
