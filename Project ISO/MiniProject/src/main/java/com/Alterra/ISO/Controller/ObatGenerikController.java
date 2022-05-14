package com.Alterra.ISO.Controller;

import com.Alterra.ISO.Model.ObatGenerik;
import com.Alterra.ISO.Service.ObatGenerikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ObatGenerik")
public class ObatGenerikController {
    @Autowired
    private ObatGenerikService generikService;

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

    public List<ObatGenerik> generikById(@RequestParam (required = false) Integer id) {
        if (id == null){
            return generikService.findAllObatGenerik();
        }
        List<ObatGenerik> foundGenerik = new ArrayList<>();
        ObatGenerik obatGenerik = generikService.findByIdGenerik(id);
        foundGenerik.add(obatGenerik);
        return foundGenerik;
    }


//    @GetMapping
//    public ResponseEntity<?> generikById(@PathVariable("id") Integer id) {
//        try {
//            ObatGenerik obatGenerik = generikService.findByIdGenerik(id);
//            return ResponseEntity.ok(obatGenerik);
//        } catch (Exception e) {
//            InternalError internalError = new InternalError(e.getMessage());
//            return ResponseEntity.internalServerError().body(internalError);
//        }
//    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateObatGenerik(@PathVariable("id") Integer id, @RequestBody ObatGenerik obatGenerik){
        try {
            ObatGenerik obatGenerikUpdated = generikService.updateObatGenerik(id, obatGenerik);
            return ResponseEntity.ok(obatGenerikUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteObatGenerik(@PathVariable("id") Integer id){
        try {
            generikService.deleteObatGenerik(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
