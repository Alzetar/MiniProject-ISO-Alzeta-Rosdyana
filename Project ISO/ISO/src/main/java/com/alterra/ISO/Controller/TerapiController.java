package com.alterra.ISO.Controller;

import com.alterra.ISO.Model.EfekTerapi;
import com.alterra.ISO.Service.TerapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Terapi")
public class TerapiController {
    @Autowired
    private TerapiService terapiService;

    @PostMapping
    public ResponseEntity<?> createEfekTerapi(@RequestBody EfekTerapi efekTerapi){
        EfekTerapi terapiCreated = terapiService.create(efekTerapi);
        return ResponseEntity.ok(terapiCreated);
    }

    @GetMapping
    public ResponseEntity<?> listEfekTerapi(){
        List<EfekTerapi> efekTerapisList = terapiService.findAll();
        return ResponseEntity.ok(efekTerapisList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> efekTerapiById(@PathVariable("id") Integer id_efek_terapi){
        try {
            EfekTerapi efekTerapi = terapiService.findById(id_efek_terapi);
            return ResponseEntity.ok(efekTerapi);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEfekTerapi(@PathVariable("id") Integer id_efek_terapi, @RequestBody EfekTerapi efekTerapi){
        try {
            EfekTerapi efekTerapiUpdated = terapiService.update(id_efek_terapi, efekTerapi);
            return ResponseEntity.ok(efekTerapiUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEfekTerapi(@PathVariable("id") Integer id_efek_terapi){
        try {
            terapiService.delete(id_efek_terapi);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
