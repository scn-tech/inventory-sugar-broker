package com.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock_dtl")
@EntityListeners(AuditingEntityListener.class)
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "factoryId")
    private Factory factoryId;

    @ManyToOne
    @JoinColumn(name = "partyId")
    private Party partyId;

    private String factoryName;
     private String season;
    private String tenderDate;
    private String purchaseDate;
    private String grade;
    private String liftingDate;
    private Integer purchaseQuantity;
    private Integer soldQuantity = 0;
    private Double rate;
    private Double millRate;
    private String notes;
    
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private LocalDateTime createdOn;
	
	@LastModifiedBy
	private String updatedBy;
	@LastModifiedDate
	private LocalDateTime updatedOn;
}
