package com.example.shop.service;

import com.example.shop.repository.model.Color;

import java.util.List;


public interface ColorService {
    Color insertColor(String color);

    List<Color> getColors();
}
