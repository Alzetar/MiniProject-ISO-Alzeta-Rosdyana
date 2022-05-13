package com.Alterra.ISO.Controller;

import com.Alterra.ISO.Model.EfekTerapi;
import com.Alterra.ISO.Service.EfekTerapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EfekTerapi")
public class EfekTerapiController {
    @Autowired
    private EfekTerapiService efekTerapiService;

    @PostMapping
    public ResponseEntity<?> createEfekTerapi(@RequestBody EfekTerapi efekTerapi){
        EfekTerapi terapiCreated = efekTerapiService.create(efekTerapi);
        return ResponseEntity.ok(terapiCreated);
    }

    @GetMapping
    public ResponseEntity<?> listEfekTerapi(){
        List<EfekTerapi> efekTerapisList = efekTerapiService.findAll();
        return ResponseEntity.ok(efekTerapisList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> efekTerapiById(@PathVariable("id") Integer id){
        try {
            EfekTerapi efekTerapi = efekTerapiService.findById(id);
            return ResponseEntity.ok(efekTerapi);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEfekTerapi(@PathVariable("id") Integer id, @RequestBody EfekTerapi efekTerapi){
        try {
            EfekTerapi efekTerapiUpdated = efekTerapiService.update(id, efekTerapi);
            return ResponseEntity.ok(efekTerapiUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEfekTerapi(@PathVariable("id") Integer id){
        try {
            efekTerapiService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
