package com.tp.admin.entity.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * Created by TP on 2018/4/27.
 */
public enum SexEnum implements IEnum {
    MALE(0, "男"),
    FEMALE(1, "女");

    private int value;
    private String desc;

    SexEnum(final int value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.value;
    }
}

