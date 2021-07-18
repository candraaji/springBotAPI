package com.candra.controllers;

import javax.validation.Valid;

import com.candra.dto.ResponseData;
import com.candra.dto.SupplierData;
import com.candra.models.entities.Supplier;
import com.candra.services.SupplierService;

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
@RequestMapping("/api/suppliers")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;

    @Autowired 
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Supplier>> create(@Valid @RequestBody SupplierData supplierData, Errors errors){

        ResponseData<Supplier> responseData = new ResponseData<>();
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
            Supplier supplier = modelMapper.map(supplierData, Supplier.class);

            responseData.setStatus(true);
            responseData.setData(supplierService.save(supplier));
            responseData.setCode(HttpStatus.ACCEPTED.value());
            return ResponseEntity.ok(responseData);
        }

    }

    @GetMapping
    public Iterable<Supplier> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier findOne(@PathVariable("id")Long id){
        return supplierService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Supplier>> update(@Valid @RequestBody SupplierData supplierData, Errors errors){

        ResponseData<Supplier> responseData = new ResponseData<>();
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
            Supplier supplier = modelMapper.map(supplierData, Supplier.class);

            responseData.setStatus(true);
            responseData.setData(supplierService.save(supplier));
            responseData.setCode(HttpStatus.ACCEPTED.value());
            return ResponseEntity.ok(responseData);
        }

    }


}
