package com.afp.proyfinal.service;

import com.afp.proyfinal.dto.LinkClientRequest;
import com.afp.proyfinal.dto.LinkClientResponse;
import com.afp.proyfinal.dto.RemovalAfpResponse;
import com.afp.proyfinal.entity.AFP;
import com.afp.proyfinal.entity.Association;
import com.afp.proyfinal.entity.RemovalAfp;

import java.util.List;

public interface IAfpService {

    LinkClientResponse linkClient(Association association);

    RemovalAfpResponse removalAfp(RemovalAfp removalAfp);
    AFP createAfp(AFP afp);
    List<AFP> findAllAfp();
    AFP findByIdAfp(Long id);
    AFP updateAfp(AFP afp);
    void  deleteAfp(Long id);

}
