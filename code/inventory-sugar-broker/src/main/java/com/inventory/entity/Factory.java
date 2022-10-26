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
@Table(name = "factory_dtl")
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String factoryName;
    private String aliasName;
    private String factoryAddress;
    private String factoryGstNo;
    private String factoryEmailId;
    private String factoryPhoneNo;
    private boolean deletedFlag;
}
