package org.jsp.merchantbootapp.controller;

import java.net.http.HttpResponse;
import java.util.Optional;

import org.jsp.merchantbootapp.dao.MerchantDao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class MerchantController {
	
	@Autowired
	private MerchantService service;
	
	
	
	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant m) {
		return service.saveMerchant(m);
	}
	
	
	
	@PutMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant m) {
		return service.updateMerchant(m);
	}
	
	
	
	
	
	
	@GetMapping("/merchants/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	
	
	
	
	@DeleteMapping("/merchants/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id)
	{
		return service.deleteById(id);
	}
	
		
	
	
	@PostMapping("/merchants/verify-by-phone")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam long phone,@RequestParam String password) {
		return service.verifyMerchant(phone, password);
	}
	
	
	
	
	@PostMapping("/merchants/verify-by-email-and-password")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchantByEmailAndPassword(@RequestParam String email,@RequestParam String password){
		return service.verifyMerchantByEmailAndPassword(email, password);
	}

	
}
