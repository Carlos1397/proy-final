package com.afp.proyfinal.dto;

import com.afp.proyfinal.entity.AFP;
import com.afp.proyfinal.entity.Client;
import lombok.Data;

@Data
public class LinkClientRequest {

    private Client client;

    private AFP  afp;

}
