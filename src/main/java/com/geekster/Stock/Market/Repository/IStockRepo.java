package com.geekster.Stock.Market.Repository;

import com.geekster.Stock.Market.model.StockTypes;
import com.geekster.Stock.Market.model.Stocks;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IStockRepo extends CrudRepository<Stocks,Integer> {
    public List<Stocks> findByStockType(StockTypes stockType);
    public List<Stocks> findByStockPriceGreaterThanAndStockBirthTimeStampLessThan(Double stockPrice, LocalDateTime stockBirthTimeStamp);

    @Query(value = "select * from stocks where stock_market_cap > :cap",nativeQuery = true)
    public List<Stocks> getstocksabovemarketcap(Double cap);
    @Modifying
    @Query(value = "update stocks set stock_market_cap= :cap where stock_id=:id",nativeQuery = true)
    public void updatemarketcapbyid(Double cap,Integer id);

    @Modifying
    @Query(value = "delete from stocks where stock_owner_count< :ownercount",nativeQuery = true)
    public void deletestockbyownercount(Integer ownercount);
    @Modifying
    @Query(value = "update stocks set stock_type= :mystock where stock_id= :id",nativeQuery = true)
    public void modifystocktypebyid(String mystock,Integer id);
}
