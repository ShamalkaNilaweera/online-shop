package com.example.shop.service;

import com.example.shop.repository.ColorRepository;
import com.example.shop.repository.model.Color;
import com.example.shop.ui.model.ColorModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorRepository colorRepository;

    ModelMapper modelMapper;

    public ColorServiceImpl(){
        modelMapper =  new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true);
  }
    @Override
    public Color insertColor(String color) {
        Color newColor = colorRepository.save(new Color(color));
        return newColor;
    }

    @Override
    public List<Color> getColors() {
        List<Color> colors = colorRepository.findAll();
        return colors;
    }

    @Override
    public Integer deleteColor(Integer colorId) {
        Optional<Color> color = colorRepository.findById(colorId);
        color.ifPresent(value -> colorRepository.delete(value));
        return colorId;
    }

    @Override
    public Color updateColor(ColorModel colorModel) {
        Optional<Color> color = colorRepository.findById(colorModel.getColorId());
        if (color.isPresent()){
            color.get().setColor(colorModel.getColor());
            return colorRepository.save(color.get());
        }else{
            //TODO
            return new Color();
        }
    }

    @Override
    public Color getColor(Integer colorId) {
        Optional<Color> color = colorRepository.findById(colorId);
        if (color.isPresent()){
            return color.get();
        }else {
            //TODO
            return null;
        }
    }
}
