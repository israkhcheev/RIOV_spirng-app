package ru.rakhcheev.api.dto;

import lombok.Data;

@Data
public class ShopRegistry {

    private String name;
    private String type;
    private boolean isOnline;

}
