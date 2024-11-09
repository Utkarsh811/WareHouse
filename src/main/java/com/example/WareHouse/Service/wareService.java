package com.example.WareHouse.Service;

import com.example.WareHouse.Repository.warerepo;
import com.example.WareHouse.model.whose;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class wareService {

  private warerepo waredb;

  @Autowired //Constructor Injection
  public wareService(warerepo waredb) {
    this.waredb = waredb;
  }

  public whose create(whose wh) {
    //creating the new restaurant require user to send the new resurant attribute and attach the same in the JSON
    //saving the new json in the db by using JPA
    // SERVICE LAYER TALKS WITH THE REPOSITORY LAYER TO DO SO

    return waredb.save(wh); // if this row is not present in the db then adds if it present then it update by first searching by the primary key
  }

  public List<Object> getprdcts(String vendor) {
    return waredb.findByVendor(vendor);
  }

  public whose updatepriceAndstockByid(int price, int stock, int id) {
    waredb.update(price, stock, id); //as update cannot return whose objject
    return waredb.findById(id); // so using findbyid to do so
  }
}
