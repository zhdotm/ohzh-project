package io.github.zhdotm.ohzh.statemachine.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 字符常量
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum CharacterEnum {

    /**
     * 符号
     */
    HASH_TAG("#"),
    EMPTY(""),
    LEFT_SLASH("/"),
    RIGHT_SLASH("\\"),
    ;

    @Getter
    private final String value;

}