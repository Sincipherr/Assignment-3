package com.geekster.Stock.Market.service;

import com.geekster.Stock.Market.Repository.IStockRepo;
import com.geekster.Stock.Market.model.StockTypes;
import com.geekster.Stock.Market.model.Stocks;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class StockService {
    @Autowired
    IStockRepo sr;

    @Autowired
    JdbcTemplate jdbctemplate;

    public List<Stocks> getstockbytype(StockTypes stockType) {
        return sr.findByStockType(stockType);
    }

    public String addstock(List<Stocks> stockList) {
        Iterable<Stocks> List= sr.saveAll(stockList);
        if(List!=null){
            return "Added successfully";
        }
        return "Could not add...!";
    }

    public List<Stocks> pricelowerdate(Double price, String date) {
        LocalDateTime mydate=LocalDateTime.parse(date);
        return sr.findByStockPriceGreaterThanAndStockBirthTimeStampLessThan(price,mydate);
    }

    public List<Stocks> getbycap(Double marketcap) {
        return sr.getstocksabovemarketcap(marketcap);
    }
    @Transactional
    public void updatecap(Double cap, Integer id) {
        sr.updatemarketcapbyid(cap,id);
    }
    @Transactional
    public void deletestocks(Integer ownercount) {
//        sr.deletestockbyownercount(ownercount);
        String sql="delete from stocks where stock_owner_count = ?";
        jdbctemplate.update(sql,ownercount);
    }

    @Transactional
    public void updatetype(String stocktype, Integer id) {
        sr.modifystocktypebyid(stocktype,id);
    }
}
