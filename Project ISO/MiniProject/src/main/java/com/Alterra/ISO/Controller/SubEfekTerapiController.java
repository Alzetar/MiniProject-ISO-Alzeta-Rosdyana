package com.Alterra.ISO.Controller;

import com.Alterra.ISO.Model.SubEfekTerapi;
import com.Alterra.ISO.Service.SubEfekTerapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SubTerapi")
public class SubEfekTerapiController {
    @Autowired
    private SubEfekTerapiService subEfekTerapiService;

    @PostMapping
    public ResponseEntity<?> createSubEfekTerapi(@RequestBody SubEfekTerapi subEfekTerapi){
        SubEfekTerapi subTerapiCreated = subEfekTerapiService.createSubEfekTerapi(subEfekTerapi);
        return ResponseEntity.ok(subTerapiCreated);
    }

    @GetMapping
    public ResponseEntity<?> listSubEfekTerapi(){
        List<SubEfekTerapi> subEfekTerapiList = subEfekTerapiService.findAllSubTerapi();
        return ResponseEntity.ok(subEfekTerapiList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> subEfekTerapiById(@PathVariable("id") Integer id){
        try {
            SubEfekTerapi subEfekTerapi = subEfekTerapiService.findByIdSubTerapi(id);
            return ResponseEntity.ok(subEfekTerapi);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateSubEfekTerapi(@PathVariable("id") Integer id, @RequestBody SubEfekTerapi subEfekTerapi){
        try {
            SubEfekTerapi subEfekTerapiUpdated = subEfekTerapiService.updateSubTerapi(id, subEfekTerapi);
            return ResponseEntity.ok(subEfekTerapiUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubEfekTerapi(@PathVariable("id") Integer id){
        try {
            subEfekTerapiService.deleteSubTerapi(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
