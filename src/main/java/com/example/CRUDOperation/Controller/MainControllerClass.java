package com.example.CRUDOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDOperation.Model.ModelClass;
import com.example.CRUDOperation.Repository.InfoRepository;

@RestController
@RequestMapping("/Students/Api")
public class MainControllerClass {
 
//	@GetMapping("hello")
//	public String ShowIndexPage() {
//		return "This is Index Page"; 
//	}
	
	@Autowired
	private InfoRepository InfoRepo;
	
	// CREATE
	@PostMapping
	public ModelClass AddData(@RequestBody ModelClass model) {
		return InfoRepo.save(model);
	}
	// GET ALL DATA
	@GetMapping
	public List<ModelClass> ShowAllData(){
		return InfoRepo.findAll();
	}
	
	// GET DATA BY ID
	@GetMapping("/{id}")
	public ModelClass ShowDataByID(@PathVariable long id) {
		return InfoRepo.findById(id).get();
	}
	
	// UPDATE DATA 
	@PatchMapping("/{id}")
	public ModelClass UpdateData(@PathVariable long id, @RequestBody ModelClass newData) {
		ModelClass existingData = InfoRepo.findById(id).get();
		if(newData != null) {
			existingData.setName(newData.getName());
			existingData.setAddress(newData.getAddress());
            existingData.setCollegeName(newData.getCollegeName());			
            existingData.setDepartment(newData.getDepartment());
            existingData.setFee(newData.getFee());
            existingData.setRollNumber(newData.getRollNumber());    
		}
		
         return InfoRepo.save(existingData);
	}
	
	@DeleteMapping("/{id}")
	public String DeleteDataById(@PathVariable long id) {
		InfoRepo.deleteById(id);
		return "Deleted Successfully";
	}
	
	@DeleteMapping("/DeleteAll")
	public String DeleteAll() {
		InfoRepo.deleteAll();
		return "Deleted All Data Successfully";
	}
}
