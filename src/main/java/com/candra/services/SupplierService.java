package com.candra.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.candra.models.entities.Supplier;
import com.candra.models.repositories.SupplierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;


    public Supplier save(Supplier category){
        return supplierRepo.save(category);
    }

    public Supplier findOne(Long id){
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if(!supplier.isPresent()){
            return null;
        }else{
            return supplier.get();
        }
       
    }

    public Iterable<Supplier> findAll(){
        return supplierRepo.findAll();
    }

    public void removeOne(Long id){
        supplierRepo.deleteById(id);
    }

    public List<Supplier> findByName(String name){
        return supplierRepo.findByNameContains(name);
    }
    
}
