package com.afp.proyfinal.entity;

import com.afp.proyfinal.enumerator.TypeAFP;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "afp")
@Data
public class AFP  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private TypeAFP type;

}
