package com.candra.controllers;

import javax.validation.Valid;

import com.candra.dto.CategoryData;
import com.candra.dto.ResponseData;
import com.candra.models.entities.Category;
import com.candra.services.CategoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired 
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Category>> create(@Valid @RequestBody CategoryData categoryData, Errors errors){

        ResponseData<Category> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }

            responseData.setStatus(false);
            responseData.setData(null);
            responseData.setCode(HttpStatus.BAD_REQUEST.value());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }else{

            // Supplier supplier = new Supplier();
            // supplier.setName(supplierData.getName());
            // supplier.setEmail(supplierData.getEmail());
            // supplier.setAddress(supplierData.getAddress());

            //diganti modelmapper di pom
            Category category = modelMapper.map(categoryData, Category.class);

            responseData.setStatus(true);
            responseData.setData(categoryService.save(category));
            responseData.setCode(HttpStatus.ACCEPTED.value());
            return ResponseEntity.ok(responseData);
        }

    }

    @GetMapping
    public Iterable<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable("id")Long id){
        return categoryService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Category>> update(@Valid @RequestBody CategoryData categoryData, Errors errors){

        ResponseData<Category> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }

            responseData.setStatus(false);
            responseData.setData(null);
            responseData.setCode(HttpStatus.BAD_REQUEST.value());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }else{

            // Supplier supplier = new Supplier();
            // supplier.setName(supplierData.getName());
            // supplier.setEmail(supplierData.getEmail());
            // supplier.setAddress(supplierData.getAddress());

            //diganti modelmapper di pom
            Category category = modelMapper.map(categoryData, Category.class);

            responseData.setStatus(true);
            responseData.setData(categoryService.save(category));
            responseData.setCode(HttpStatus.ACCEPTED.value());
            return ResponseEntity.ok(responseData);
        }

    }
    
    
}
