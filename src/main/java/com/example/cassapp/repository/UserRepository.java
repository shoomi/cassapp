package com.example.cassapp.repository;

import com.example.cassapp.entity.User;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface UserRepository extends CassandraRepository<User, Integer> {

    @AllowFiltering
    List<User> findByName(String name);
}
