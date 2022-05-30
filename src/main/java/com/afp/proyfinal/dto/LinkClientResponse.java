package com.afp.proyfinal.dto;

import com.afp.proyfinal.entity.Association;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LinkClientResponse {

    @NonNull
    private String message;

    private Association association;

}
