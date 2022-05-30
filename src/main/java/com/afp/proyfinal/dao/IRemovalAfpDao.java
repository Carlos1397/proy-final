package com.afp.proyfinal.dao;

import com.afp.proyfinal.entity.RemovalAfp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRemovalAfpDao extends JpaRepository<RemovalAfp, Long> {

    RemovalAfp save(RemovalAfp removalAfp);

}
