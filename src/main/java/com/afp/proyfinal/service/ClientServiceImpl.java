package com.afp.proyfinal.service;

import com.afp.proyfinal.dao.IClientDao;
import com.afp.proyfinal.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements  IClientService {

    @Autowired
    private IClientDao iClientDao;

    @Override
    public Client createClient(Client client) {
        return iClientDao.save(client);
    }

    @Override
    public List<Client> findAllClient() {
        return iClientDao.findAll();
    }

    @Override
    public Client findClient(String dni) {
        return iClientDao.findByDni(dni);
    }

    @Override
    public Client findById(long id) {
        Optional<Client> op =  iClientDao.findById(id);
        return op.isPresent() ? op.get() : new Client();
    }

    @Override
    public Client updateClient(Client client) {
       return iClientDao.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        iClientDao.deleteById(id);
    }
}
