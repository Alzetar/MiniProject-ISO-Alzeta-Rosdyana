package com.alterra.ISO.Controller;


import com.alterra.ISO.Model.GolonganObat;
import com.alterra.ISO.Model.Obat;
import com.alterra.ISO.Model.ObatGenerik;
import com.alterra.ISO.Service.GenerikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ObatGenerik")
public class GenerikController {
    @Autowired
    private GenerikService generikService;

    @PostMapping
    public ResponseEntity<?> createGenerikObat(@RequestBody ObatGenerik obatGenerik){
        ObatGenerik obatGenerikCreated = generikService.createGenerik(obatGenerik);
        return ResponseEntity.ok(obatGenerikCreated);
    }

    @GetMapping
    public ResponseEntity<?> listObatGenerik(){
        List<ObatGenerik> obatGenerikList = generikService.findAllObatGenerik();
        return ResponseEntity.ok(obatGenerikList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> generikById(@PathVariable("id") Integer id_generik){
        try {
            ObatGenerik obatGenerik = generikService.findByIdGenerik(id_generik);
            return ResponseEntity.ok(obatGenerik);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateObatGenerik(@PathVariable("id") Integer id_generik, @RequestBody ObatGenerik obatGenerik){
        try {
            ObatGenerik obatGenerikUpdated = generikService.updateObatGenerik(id_generik, obatGenerik);
            return ResponseEntity.ok(obatGenerikUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteObatGenerik(@PathVariable("id") Integer id_generik){
        try {
            generikService.deleteObatGenerik(id_generik);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
