package com.afp.proyfinal.dao;

import com.afp.proyfinal.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDao extends JpaRepository<Client, Long> {

    Client findByDni(String dni);


}
