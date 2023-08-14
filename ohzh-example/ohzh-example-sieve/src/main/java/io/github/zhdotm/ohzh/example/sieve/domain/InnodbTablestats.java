package io.github.zhdotm.ohzh.example.sieve.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName INNODB_TABLESTATS
 */
@Data
@AllArgsConstructor
public class InnodbTablestats implements Serializable {

    private Long tableId;

    private String name;

    private String statsInitialized;

    private Long numRows;

    private Long clustIndexSize;

    private Long otherIndexSize;

    private Long modifiedCounter;

    private Long autoinc;

    private Integer refCount;

}