package com.alterra.ISO.Controller;


import com.alterra.ISO.Model.EfekTerapi;
import com.alterra.ISO.Model.SubEfekTerapi;
import com.alterra.ISO.Service.SubTerapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SubTerapi")
public class SubTerapiController {
    @Autowired
    private SubTerapiService subTerapiService;

    @PostMapping
    public ResponseEntity<?> createSubEfekTerapi(@RequestBody SubEfekTerapi subEfekTerapi){
        SubEfekTerapi subTerapiCreated = subTerapiService.createSubEfekTerapi(subEfekTerapi);
        return ResponseEntity.ok(subTerapiCreated);
    }

    @GetMapping
    public ResponseEntity<?> listSubEfekTerapi(){
        List<SubEfekTerapi> subEfekTerapiList = subTerapiService.findAllSubTerapi();
        return ResponseEntity.ok(subEfekTerapiList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> subEfekTerapiById(@PathVariable("id") Integer id_sub_efek){
        try {
            SubEfekTerapi subEfekTerapi = subTerapiService.findByIdSubTerapi(id_sub_efek);
            return ResponseEntity.ok(subEfekTerapi);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateSubEfekTerapi(@PathVariable("id") Integer id_sub_efek, @RequestBody SubEfekTerapi subEfekTerapi){
        try {
            SubEfekTerapi subEfekTerapiUpdated = subTerapiService.updateSubTerapi(id_sub_efek, subEfekTerapi);
            return ResponseEntity.ok(subEfekTerapiUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubEfekTerapi(@PathVariable("id") Integer id_sub_efek){
        try {
            subTerapiService.deleteSubTerapi(id_sub_efek);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
