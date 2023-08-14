package io.github.zhdotm.ohzh.example.sieve.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName INNODB_TABLES
 */
@Data
@AllArgsConstructor
public class InnodbTables implements Serializable {

    private Long tableId;

    private String name;

    private Integer flag;

    private Integer nCols;

    private Long space;

    private String rowFormat;

    private Integer zipPageSize;

    private String spaceType;

    private Integer instantCols;

}