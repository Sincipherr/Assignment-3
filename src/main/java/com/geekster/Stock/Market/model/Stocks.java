package com.geekster.Stock.Market.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;
    @Column(unique = true)
    @Pattern(regexp = "\\b[A-Z]\\w*\\b")
    //^[A-z][A-Z][a-z]*+$
    private String stockName;
    private Double stockPrice;
    private Integer stockOwnerCount;
    @Enumerated(EnumType.STRING)
    private StockTypes stockType;//can only be number 0,1,2,3
    private Double stockMarketCap;
    private LocalDateTime stockBirthTimeStamp;
}
