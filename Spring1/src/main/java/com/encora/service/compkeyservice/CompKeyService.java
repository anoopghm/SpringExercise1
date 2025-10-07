package com.encora.service.compkeyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.model.compkey.CompKey;
import com.encora.model.compkey.ItemTransaction;
import com.encora.repository.CompKeyRepo;

@Service
public class CompKeyService {
	
	@Autowired
	private CompKeyRepo compkeyRepo;
	
	public void insert() {
		CompKey ck=new CompKey();
		ck.setBillno(9001);
		ck.setItemno(104);
		
		ItemTransaction it=new ItemTransaction();
		it.setMykey(ck);
		it.setQty(300);
		
		compkeyRepo.save(it);
	}
}