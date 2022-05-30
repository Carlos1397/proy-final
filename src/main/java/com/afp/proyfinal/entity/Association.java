package com.afp.proyfinal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "association")
@Data
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "afp", referencedColumnName = "id")
    private AFP afp;

    @Column(name = "availableamount", nullable = false)
    private double availableAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "datewithdrawal", nullable = false, length = 30)
    private Date dateWithdrawal;

    @Column(name = "accountnumber", nullable = false, length = 30)
    private String  accountNumber;

}
