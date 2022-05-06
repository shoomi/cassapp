package com.example.cassapp.service;

import com.example.cassapp.entity.Invoice;
import com.example.cassapp.entity.User;
import com.example.cassapp.repository.InvoiceRepository;
import com.example.cassapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FindOperationRunner implements CommandLineRunner {

    @Autowired
    InvoiceRepository repo;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        //Retrive all records using findAll() method
        List<Invoice> invoices = repo.findAll();
        invoices.forEach(System.out::println);

        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);

        //Retrive record by Id using findById() method
        Optional<Invoice> opt= repo.findById(5);
        if(opt.isPresent()) {
            System.out.println(opt.get().getName());;
        }

        //Retrive records by invoice name using findByName() method
        List<Invoice> invoicesByName = repo.findByName("Inv4");
        invoicesByName.forEach(System.out::println);

    }
}
