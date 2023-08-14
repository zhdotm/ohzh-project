package io.github.zhdotm.ohzh.example.sieve.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
public class SimpleInnodbTablestatsDTO {

    private Long tableId;

    private String name;

    private Integer flag;

    private Integer nCols;

    private Long space;

    private String statsInitialized;

    private Long numRows;
}
