package com.afp.proyfinal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "removal")
@Data
public class RemovalAfp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "association", referencedColumnName = "id")
    private Association association;

    @Column(name = "withdrawalamount", nullable = false)
    private double withdrawalAmount;
}
