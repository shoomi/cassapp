package com.example.cassapp.pojo;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table //represents that it will map to ‘invoice’ table in Cassandra DB.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @PrimaryKey
    private Integer id;
    private String name;
    private String number;
    private Double amount;
}
