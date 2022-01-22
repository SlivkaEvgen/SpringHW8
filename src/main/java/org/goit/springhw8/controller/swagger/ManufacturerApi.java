package org.goit.springhw8.controller.swagger;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "api/manufacturer")
public class ManufacturerApi {

    private final ManufacturerService manufacturerService;

    @Operation(summary = "Show All Manufacturers", description = " All Manufacturers")
    @GetMapping("list")
    @ResponseBody
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getAll();
    }

    @Operation(summary = "Find Manufacturer by ID", description = "Show Manufacturer by ID")
    @GetMapping("id")
    @ResponseBody
    public Optional<Manufacturer> getManufacturerById(@ApiParam(required = true, value = " Example : 1 ") String id) {
        return manufacturerService.getById(id);
    }

    @Operation(summary = "Find Manufacturers by Name", description = " Show Manufacturers by Name ")
    @GetMapping("name")
    @ResponseBody
    public List<Manufacturer> getManufacturerByName(@ApiParam(required = true, value = " Example : Apple ") String name) {
        return manufacturerService.findByName(name);
    }

    @Operation(summary = "Delete Manufacturer", description = "Delete Manufacturer")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteManufacturerById(@ApiParam(required = true, value = " Example : 4 ") @PathVariable String id) {
        manufacturerService.deleteById(id);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    @ResponseBody
    @Operation(summary = "New Manufacturer", description = "Create the New Manufacturer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Manufacturer.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Manufacturer not found by id specified in the request",
                    content = @Content)})
    public void addNewManufacturerGet(@PathVariable(value = "ID") @ApiParam(value = " Example : 12 ") String id, @PathVariable(value = "Name") @ApiParam(value = " Example : Iphone ") String name) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);
        manufacturer.setName(name);
        manufacturerService.saveEntity(manufacturer);
    }

    @Operation(summary = "Update Manufacturer ", description = "Update Manufacturer")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateManufacturerGet(@PathVariable(value = "ID") @ApiParam(value = " Example : 12 ") String id,
                                 @PathVariable(value = "Name") @ApiParam(value = " Example : Iphone ") String name) {
        Optional<Manufacturer> manufacturerOptional = manufacturerService.getById(id);
        if (manufacturerOptional.isPresent()) {
            Manufacturer manufacturer = manufacturerOptional.get();
            manufacturer.setId(id);
            manufacturer.setName(name);
            manufacturerService.saveEntity(manufacturer);
        }
    }
}
