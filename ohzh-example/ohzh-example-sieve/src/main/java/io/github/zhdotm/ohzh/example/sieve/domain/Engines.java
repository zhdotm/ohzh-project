package io.github.zhdotm.ohzh.example.sieve.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ENGINES
 */
@Data
public class Engines implements Serializable {

    private String engine;

    private String support;

    private String comment;

    private String transactions;

    private String xa;

    private String savepoints;
    
}