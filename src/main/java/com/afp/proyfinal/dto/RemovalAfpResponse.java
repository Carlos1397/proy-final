package com.afp.proyfinal.dto;
import com.afp.proyfinal.entity.RemovalAfp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RemovalAfpResponse {
    @NonNull
    private String message;

    private RemovalAfp removalAfp;

}
