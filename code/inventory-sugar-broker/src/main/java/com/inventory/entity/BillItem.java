package com.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill_item_dtl")
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "billId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Bill bill;
    @JoinColumn(name = "stockId")
    @ManyToOne
    private Stock stock;
    private String grade;
    private Double rate;
    private Integer billQuantity;
    private Integer deliverQuantity=0;
    private Double purchaseRate;


}
