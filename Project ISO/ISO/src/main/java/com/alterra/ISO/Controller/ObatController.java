package com.alterra.ISO.Controller;


import com.alterra.ISO.Model.Obat;
import com.alterra.ISO.Model.SubEfekTerapi;
import com.alterra.ISO.Service.ObatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Obat")
public class ObatController {
    @Autowired
    private ObatService obatService;

    @PostMapping
    public ResponseEntity<?> createObat(@RequestBody Obat obat){
        Obat obatCreate = obatService.create(obat);
        return ResponseEntity.ok(obatCreate);
    }

    @GetMapping
    public ResponseEntity<?> listObat(){
        List<Obat> obatList = obatService.findAll();
        return ResponseEntity.ok(obatList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obatFindById(@PathVariable("id") Integer id_obat){
        try {
            Obat obat = obatService.findById(id_obat);
            return ResponseEntity.ok(obat);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateObat(@PathVariable("id") Integer id_obat, @RequestBody Obat obat){
        try {
            Obat obatUpdate = obatService.update(id_obat, obat);
            return ResponseEntity.ok(obatUpdate);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteObat(@PathVariable("id") Integer id_obat){
        try {
            obatService.delete(id_obat);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
