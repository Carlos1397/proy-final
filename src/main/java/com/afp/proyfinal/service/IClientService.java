package com.afp.proyfinal.service;

import com.afp.proyfinal.entity.Client;

import java.util.List;

public interface IClientService {

    Client createClient(Client client);
    List<Client> findAllClient();
    Client findClient(String dni);

    Client findById(long id);
    Client updateClient(Client client);
    void  deleteClient(Long id);

}
