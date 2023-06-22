package com.example.shop.ui.controller;

import com.example.shop.repository.model.Color;
import com.example.shop.service.ColorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/api/v1/colors")
public class ColorController {
    @Autowired
    private ColorService colorService;

    @Operation(summary = "Create new color")
    @ApiResponse(responseCode = "200", description = "Saved new color successfully")
    @PostMapping("/{color_Name}")
    public ResponseEntity<?> insertColor (@PathVariable("color_Name") String  colorName){
        try {
            Color color = colorService.insertColor(colorName);
            return ResponseEntity.status(HttpStatus.OK).body(color);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }
}
