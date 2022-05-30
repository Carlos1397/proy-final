package com.afp.proyfinal.controller;


import com.afp.proyfinal.dto.LinkClientResponse;
import com.afp.proyfinal.dto.RemovalAfpResponse;
import com.afp.proyfinal.entity.AFP;
import com.afp.proyfinal.entity.Association;
import com.afp.proyfinal.entity.RemovalAfp;
import com.afp.proyfinal.service.IAfpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "afp")
@Slf4j
public class AfpController {
    @Autowired
    private IAfpService iAfpService;

    @GetMapping(value = "all")
    public ResponseEntity<List<AFP>> getAllAfp(){
        List<AFP> listAfp = iAfpService.findAllAfp();
        log.info("list all afp");
        return  new ResponseEntity<List<AFP>>(listAfp, HttpStatus.OK);
    }

    @PostMapping(value = "create")
    public ResponseEntity<AFP> createAfp(@Valid @RequestBody AFP afp){
        AFP afpResponse = iAfpService.createAfp(afp);
        log.info("create one afp");
        return new ResponseEntity<AFP>(afpResponse,HttpStatus.CREATED);
    }
    @GetMapping(value = "")
    public ResponseEntity<AFP> getOneAfp(@RequestParam Long id){
        AFP afp = iAfpService.findByIdAfp(id);
        log.info("return one type afp");
        return new ResponseEntity<AFP>(afp, HttpStatus.OK);
    }

    @PutMapping(value = "update")
    public ResponseEntity<AFP> updateAfp(@Valid @RequestBody AFP afp){
        AFP afpResponse = iAfpService.updateAfp(afp);
        return new ResponseEntity<AFP>(afpResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAfp(@PathVariable("id") long id){

        AFP afp = iAfpService.findByIdAfp(id);
        log.info(afp.getId().toString());
        if(afp.getId() == 0){
            log.error("ID NO FOUND");
        }
        iAfpService.deleteAfp(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "linkClient")
    public ResponseEntity<LinkClientResponse> linkClient(@Valid @RequestBody Association association){
        LinkClientResponse linkClientResponse = iAfpService.linkClient(association);
        return new ResponseEntity<LinkClientResponse>(linkClientResponse,HttpStatus.CREATED);
    }
    @PostMapping(value = "removalAfp")
    public ResponseEntity<RemovalAfpResponse> removalAfp(@Valid @RequestBody RemovalAfp removalAfp){
        RemovalAfpResponse removalAfpResponse = iAfpService.removalAfp(removalAfp);
        return new ResponseEntity<RemovalAfpResponse>(removalAfpResponse,HttpStatus.CREATED);
    }

}
