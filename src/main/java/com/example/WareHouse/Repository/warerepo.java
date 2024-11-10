package com.example.WareHouse.Repository;

import com.example.WareHouse.model.whose;
import jakarta.transaction.Transactional;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // with this extends and interface we can easily use the JPA
public interface warerepo extends JpaRepository<whose, Integer> {
  @Query("select p from whose p where p.vendor = ?1")
  public List<Object> findByVendor(String vendor);

  @Modifying
  @Transactional
  @Query("UPDATE whose p SET p.price=?1 , p.stock=?2 WHERE p.id=?3") // *never use as as alias her as it is JPA QUERY LANGUAGE
  public void update(int price, int stock, int id);

  @Query
  public whose findById(int id);

  public whose deleteById(int id);
}
