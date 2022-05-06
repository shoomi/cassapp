package com.example.cassapp.service;

import com.datastax.driver.core.utils.UUIDs;
import com.example.cassapp.entity.Invoice;
import com.example.cassapp.entity.User;
import com.example.cassapp.repository.InvoiceRepository;
import com.example.cassapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Order(1)
@Component
public class SaveOrInsertOperationRunner implements CommandLineRunner {

    @Autowired
    InvoiceRepository repo;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        //saving one record into Cassandra DB using save() method
        Invoice inv = new Invoice(1, "Inv1", "POS34523", 295.74);
        repo.save(inv);

        //saving multiple records into Cassandra DB using saveAll() method
        repo.saveAll(List.of(
                        new Invoice(2, "Inv2", "POS34522", 292.00),
                        new Invoice(3, "Inv3", "QOS34523", 293.75),
                        new Invoice(4, "Inv4", "ROS34524", 294.34),
                        new Invoice(5, "Inv5", "SOS34525", 295.95),
                        new Invoice(6, "Inv6", "TOS34526", 296.54),
                        new Invoice(8, "Inv4", "WQS34528", 247.45)
                )
        );

        //saving one record into Cassandra DB using insert() method
        repo.insert(new Invoice(7, "Inv7", "VOS34527", 297.65));

        Map<String, String> userAccounts = new HashMap<>();
        userAccounts.put("PNP", "NJKNJK^KJ");
        userAccounts.put("MONOBANK", "NJKN$KJ");
        User user = new User(UUIDs.timeBased(), "John Vain", userAccounts);
        userRepository.save(user);
    }
}
