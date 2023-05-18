package com.geekster.Stock.Market.controller;

import com.geekster.Stock.Market.model.StockTypes;
import com.geekster.Stock.Market.model.Stocks;
import com.geekster.Stock.Market.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class StockController {
    @Autowired
    StockService ss;

    @GetMapping(value = "/stocktype/{stockType}")
    public List<Stocks> getstockbytype(@PathVariable StockTypes stockType){
        return ss.getstockbytype(stockType);
    }
    @GetMapping(value = "/pricelowerdate/{price}/{date}")
    public List<Stocks> pricelowerdate(@PathVariable Double price, @PathVariable String date){
        return ss.pricelowerdate(price,date);
    }
    @GetMapping(value = "/getbycap/{marketcap}")
    public List<Stocks> getbycap(@PathVariable Double marketcap){
        return ss.getbycap(marketcap);
    }
    @PostMapping(value = "/addstock")
    public String addstock(@RequestBody List<Stocks> stockList){
        return ss.addstock(stockList);
    }
    @PutMapping(value = "/update/{cap}/{id}")
    public void updatecap(@PathVariable Double cap,@PathVariable Integer id){
        ss.updatecap(cap,id);
    }
    @DeleteMapping(value = "/delete/{ownercount}")
    public void deletestocks(@PathVariable Integer ownercount){
        ss.deletestocks(ownercount);
    }

    @PutMapping(value = "/updatetype/{stocktype}/{id}")
    public void updatetype(@PathVariable String stocktype,@PathVariable Integer id){
        ss.updatetype(stocktype,id);
    }
}
