package com.example.shop.service;

import com.example.shop.repository.model.Color;
import com.example.shop.ui.model.ColorModel;

import java.util.List;


public interface ColorService {
    Color insertColor(String color);

    List<Color> getColors();

    Integer deleteColor(Integer colorId);

    Color updateColor( ColorModel colorModel);

    Color getColor(Integer colorId);
}
