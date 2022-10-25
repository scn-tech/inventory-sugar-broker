
package com.inventory.repository;

import com.inventory.entity.Stock;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository 
public interface StockRepository extends JpaRepository<Stock,Integer> {

    @Query("SELECT s from Stock s where s.factoryId.id=:factoryId AND s.season=:season AND s.purchaseQuantity>s.soldQuantity")
    List<Stock> getStockByFactoryAndSeason(@Param("factoryId") int factoyId,@Param("season") String season);


    @Transactional(propagation = Propagation.REQUIRED)
    @Modifying
    @Query("update Stock set soldQuantity= (soldQuantity + :qty) where id= :id")
    void updateStockQuantity(@Param("id") int stockId,@Param("qty") int soldQuantity);
}
	