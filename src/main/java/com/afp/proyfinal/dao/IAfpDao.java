package com.afp.proyfinal.dao;

import com.afp.proyfinal.entity.AFP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAfpDao  extends JpaRepository<AFP, Long>  {
}
