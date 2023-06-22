package com.example.shop.service;

import com.example.shop.repository.ColorRepository;
import com.example.shop.repository.model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorRepository colorRepository;

    @Override
    public Color insertColor(String color) {
        Color newColor = colorRepository.save(new Color(color));
        return newColor;
    }
}
