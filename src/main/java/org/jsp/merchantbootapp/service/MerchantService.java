package org.jsp.merchantbootapp.service;

import java.util.Optional;

import org.jsp.merchantbootapp.dao.MerchantDao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.exception.IdNotFoundException;
import org.jsp.merchantbootapp.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MerchantService {
	
	@Autowired
	private MerchantDao dao;
	
	
	
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant m) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		m = dao.saveMerchant(m);
		structure.setMessage("Merchant Registered Successfully");
		structure.setData(m);
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.CREATED);
	}
	
	
	
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant m) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		m = dao.updateMerchant(m);
		structure.setMessage("Merchant updated Successfully");
		structure.setData(m);
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	public ResponseEntity<ResponseStructure<Merchant>> findById(int id)
	{
		Optional<Merchant> recievedMerchant = dao.findById(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if(recievedMerchant.isPresent()) {
			structure.setMessage("Merchant Found!");
			structure.setData(recievedMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		}
		
		throw new IdNotFoundException();
	}
	
	
	
	
	
	public ResponseEntity<ResponseStructure<String>> deleteById(int id)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		boolean deleted = dao.deleteById(id);
		if (deleted) {
			structure.setMessage("merchant found");
			structure.setData("merchant deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		structure.setMessage("invalid merchant id");
		structure.setData("merchant not deleted");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
		
	
	
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(long phone,String password) {
		Optional<Merchant> recievedMerchant = dao.verifyMerchant(phone, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if(recievedMerchant.isPresent()) {
			structure.setMessage("merchant verified");
			structure.setData(recievedMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		}
		
		throw new InvalidCredentialsException();
	}
	
	
	
	
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchantByEmailAndPassword(String email,String password){
		Optional<Merchant> recievedMerchant = dao.verifyMerchantByEmailAndPassword(email, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if(recievedMerchant.isPresent()) {
			structure.setMessage("merchant verified");
			structure.setData(recievedMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		}
		
		throw new InvalidCredentialsException();
	}

}
