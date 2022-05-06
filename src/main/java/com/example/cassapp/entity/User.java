package com.example.cassapp.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Map;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table //represents that it will map to ‘invoice’ table in Cassandra DB.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @PrimaryKey
    private UUID id;
    private String name;
    private Map<String, String> accounts;
}
