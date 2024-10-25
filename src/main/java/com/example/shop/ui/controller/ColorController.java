package com.example.shop.ui.controller;

import com.example.shop.repository.model.Color;
import com.example.shop.service.ColorService;
import com.example.shop.ui.model.ColorModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "Get all colors")
    @ApiResponse(responseCode = "200", description = "Retrieved all colors successfully")
    @GetMapping()
    public ResponseEntity<?> getColors (){
        try {
            List<Color> colors = colorService.getColors();
            return ResponseEntity.status(HttpStatus.OK).body(colors);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @Operation(summary = "Delete a color")
    @ApiResponse(responseCode = "200", description = "Deleted a color successfully")
    @DeleteMapping(path = "/deleteColor/{colorId}")
    public ResponseEntity<?> deleteColor (@PathVariable Integer colorId){
        try {
            Integer color = colorService.deleteColor(colorId);
            return ResponseEntity.status(HttpStatus.OK).body(color);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @Operation(summary = "Get a color")
    @ApiResponse(responseCode = "200", description = "Retrieved a color successfully")
    @GetMapping(path = "/{colorId}")
    public ResponseEntity<?> getColor (@PathVariable Integer colorId){
        try {
            Color color = colorService.getColor(colorId);
            return ResponseEntity.status(HttpStatus.OK).body(color);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @Operation(summary = "Update a color")
    @ApiResponse(responseCode = "200", description = "Updated a color successfully")
    @PutMapping(path = "/updateColor")
    public ResponseEntity<?> updateColor (@RequestBody ColorModel colorModel){
        try {
            Color color = colorService.updateColor(colorModel);
            return ResponseEntity.status(HttpStatus.OK).body(color);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }
}
