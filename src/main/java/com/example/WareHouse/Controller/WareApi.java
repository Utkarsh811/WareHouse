package com.example.WareHouse.Controller;

import com.example.WareHouse.Service.wareService;
import com.example.WareHouse.model.whose;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wareapi")
public class WareApi {

  private wareService wService;

  @Autowired //Constructor Injection
  public WareApi(wareService wService) {
    this.wService = wService;
  }

  //should be able to create and add new restaurant, Request  body comes from user contains body
  @PostMapping("create")
  public ResponseEntity<whose> postrestaurant(@RequestBody whose wh) {
    //controller class talks to service class which is responsible for processing
    try {
      return new ResponseEntity<>(wService.create(wh), HttpStatus.CREATED);
    } catch (Exception e) {
      // TODO: handle exception
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("getvendorProducts/{vendor}")
  public ResponseEntity<List<Object>> GetvendorProducts(
    @PathVariable("vendor") String vendor
  ) {
    try {
      return new ResponseEntity<>(wService.getprdcts(vendor), HttpStatus.FOUND);
    } catch (Exception e) {
      // TODO: handle exception
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  //UPDATING PRODUCT PRICE AND STOCK, Request Body will contain price abd stock and id

  @PutMapping("/update")
  public ResponseEntity<whose> updatepriceAndstock(
    @RequestParam(value = "price", required = false) int price,
    @RequestParam(value = "stock", required = false) int stock,
    @RequestParam(value = "id", required = false) int id
  ) {
    try {
      return new ResponseEntity<>(
        wService.updatepriceAndstockByid(price, stock, id),
        HttpStatus.ACCEPTED
      );
    } catch (Exception e) {
      // TODO: handle exception
      return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
  }
  //UPDATING THE PRODUCT WITH RESPECT TO WHOLE REQUEST BODY

}
