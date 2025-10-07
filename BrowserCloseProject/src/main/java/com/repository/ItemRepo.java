package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.ItemMaster;

@Repository 
public interface ItemRepo extends JpaRepository<ItemMaster,Integer> {
   public List<ItemMaster>findByShopno(int shopno);
   public ItemMaster findByItemdesc(String itemdesc);
}
