package com.example.cassapp.service;

import com.example.cassapp.entity.Invoice;
import com.example.cassapp.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class UpdateOperationRunner implements CommandLineRunner {

    @Autowired
    InvoiceRepository repo;

    @Override
    public void run(String... args) throws Exception {

        //Update Invoice Number from 'Inv1' to 'Inv01' using save() where id=1
        repo.save(new Invoice(1, "Inv01", "POS34523", 295.74));

        //Update Invoice Amount from '294.34' to '395.24' using insert() where id=4
        repo.insert(new Invoice(4, "Inv4", "ROS34524", 395.24));
    }
}
