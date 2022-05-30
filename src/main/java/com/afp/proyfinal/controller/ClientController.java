package com.afp.proyfinal.controller;

import com.afp.proyfinal.entity.Client;
import com.afp.proyfinal.service.IAfpService;
import com.afp.proyfinal.service.IClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "client")
@Slf4j
public class ClientController {
    @Autowired
    private IClientService iClientService;

    @GetMapping(value = "all")
    public ResponseEntity<List<Client>> getAllClient(){
        List<Client> listClient = iClientService.findAllClient();
        log.error("get all client");
        return  new ResponseEntity<List<Client>>(listClient, HttpStatus.OK);
    }

    @PostMapping(value = "create")
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client){
        Client clientResponse = iClientService.createClient(client);
        log.error("create one client");
        return new ResponseEntity<Client>(clientResponse,HttpStatus.CREATED);
    }
    @GetMapping(value = "")
    public ResponseEntity<Client> getOneClient(@RequestParam String dni){
        Client client = iClientService.findClient(dni);
        log.error("get dni client");
        return  new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @PutMapping(value = "update")
    public ResponseEntity<Client> updateClient(@Valid @RequestBody Client client){
        Client clientResponse = iClientService.updateClient(client);
        log.error("update");
        return new ResponseEntity<Client>(clientResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){

        Client client = iClientService.findById(id);
        log.info(client.getId().toString());
        if(client.getId() == 0){
            log.error("ID NO FOUND");
        }
        iClientService.deleteClient(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
