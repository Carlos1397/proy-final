package com.afp.proyfinal.dao;

import com.afp.proyfinal.entity.Association;
import com.afp.proyfinal.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssociationDao extends JpaRepository<Association, Long>  {

    // Optional<Association> findByIdClient(Client client);
    Boolean existsByClient(Client client);
}
