package org.jsp.merchantbootapp.dao;

import java.util.Optional;

import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	
	@Autowired
	private MerchantRepository repository;
	
	public Merchant saveMerchant(Merchant m) {
		return repository.save(m);
	}
	
	public Merchant updateMerchant(Merchant m) {
		return repository.save(m);
	}
	
	public Optional<Merchant> findById(int id){
		return repository.findById(id);
	}
	
	public boolean deleteById(int id)
	{
		Optional<Merchant> recievedMerchant = findById(id);
		if(recievedMerchant.isPresent()) {
			//repository.delete(recievedMerchant.get());
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Optional<Merchant> verifyMerchant(long phone, String password){
		return repository.verifyMerchant(phone, password);
	}
	
	
	public Optional<Merchant> verifyMerchantByEmailAndPassword(String email, String password){
		return repository.verifyMerchantByEmailAndPassword(email, password);
	}
	
}
