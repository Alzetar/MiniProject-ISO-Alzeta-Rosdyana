package com.Alterra.ISO.Controller;

import com.Alterra.ISO.DTO.AddToObatDto;
import com.Alterra.ISO.Model.Obat;
import com.Alterra.ISO.Service.ObatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Obat")
public class ObatController {
    @Autowired
    private ObatService obatService;

//    @PostMapping
//    public ResponseEntity<?> createObat(@RequestBody Obat obat){
//        Obat obatCreate = obatService.create(obat);
//        return ResponseEntity.ok(obatCreate);
//    }

    @PostMapping
    public ResponseEntity.BodyBuilder createObat(@RequestBody AddToObatDto addToObatDto){
        obatService.create(addToObatDto);
        return ResponseEntity.ok();
    }

    @GetMapping
    public ResponseEntity<?> listObat(){
        List<Obat> obatList = obatService.findAll();
        return ResponseEntity.ok(obatList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obatFindById(@PathVariable("id") Integer id){
        try {
            Obat obat = obatService.findById(id);
            return ResponseEntity.ok(obat);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateObat(@PathVariable("id") Integer id, @RequestBody Obat obat){
        try {
            Obat obatUpdate = obatService.update(id, obat);
            return ResponseEntity.ok(obatUpdate);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteObat(@PathVariable("id") Integer id){
        try {
            obatService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
