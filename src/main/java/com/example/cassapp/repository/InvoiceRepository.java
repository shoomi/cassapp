package com.example.cassapp.repository;

import com.example.cassapp.entity.Invoice;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface InvoiceRepository extends CassandraRepository<Invoice, Integer> {

    //Like other Database Repositories, some commonly used methods are already provided by CassandraRepository.
    //Hence, we don't need to write those here. We can write custom methods.
    //For example, below method is a custom method.
    @AllowFiltering
    List<Invoice> findByName(String name);
}
