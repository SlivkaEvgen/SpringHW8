package org.goit.springhw8.controller.swagger;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Manufacturer api.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "api/manufacturer")
public class ManufacturerApi {

    private final ManufacturerService manufacturerService;

    /**
     * Gets all manufacturers.
     *
     * @return the all manufacturers
     */
    @Operation(summary = "Show All Manufacturers", description = " All Manufacturers")
    @GetMapping("list")
    @ResponseBody
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getAll();
    }

    /**
     * Gets manufacturer by id.
     *
     * @param id the id
     * @return the manufacturer by id
     */
    @Operation(summary = "Find Manufacturer by ID", description = "Show Manufacturer by ID")
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Manufacturer> getManufacturerById(@PathVariable @ApiParam(required = true, value = " Example : 1 ") String id) {
        return manufacturerService.getById(id);
    }

    /**
     * Gets manufacturer by name.
     *
     * @param name the name
     * @return the manufacturer by name
     */
    @Operation(summary = "Find Manufacturers by Name", description = " Show Manufacturers by Name ")
    @GetMapping("/name/{name}")
    @ResponseBody
    public List<Manufacturer> getManufacturerByName(@PathVariable @ApiParam(required = true, value = " Example : Apple ") String name) {
        return manufacturerService.findByName(name);
    }

    /**
     * Delete manufacturer by id.
     *
     * @param id the id
     */
    @Operation(summary = "Delete Manufacturer", description = "Delete Manufacturer")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteManufacturerById(@ApiParam(required = true, value = " Example : 4 ") @PathVariable String id) {
        manufacturerService.deleteById(id);
    }

    /**
     * Add new manufacturer get manufacturer.
     *
     * @param name the name
     * @return the manufacturer
     */
    @Operation(summary = "New Manufacturer", description = "Create the New Manufacturer")
    @RequestMapping(value = "/new/{name}", method = RequestMethod.POST)
    @ResponseBody
    public Manufacturer addNewManufacturerGet(@PathVariable(value = "name") @ApiParam(value = " Example : Samsung ") String name) {
        Manufacturer manufacturer = setIntoManufacturer(
                new Manufacturer(),
                name);
        manufacturerService.saveEntity(manufacturer);
        return manufacturer;
    }

    /**
     * Update manufacturer get manufacturer.
     *
     * @param id   the id
     * @param name the name
     * @return the manufacturer
     */
    @Operation(summary = "Update Manufacturer ", description = "Update Manufacturer")
    @RequestMapping(value = "/update/{id}&{name}", method = RequestMethod.PUT)
    @ResponseBody
    public Manufacturer updateManufacturerGet(@PathVariable(value = "id") @ApiParam(value = " Example : 2 ") String id,
                                              @PathVariable(value = "name") @ApiParam(value = " Example : Samsung ") String name) {
        if (getManufacturerById(id).isPresent()) {
            Manufacturer manufacturer = setIntoManufacturer(
                    getManufacturerById(id).get(),
                    name);
            manufacturerService.saveEntity(manufacturer);
            return manufacturer;
        } else return null;
    }

    private Manufacturer setIntoManufacturer(Manufacturer manufacturer, String name) {
        if (name == null) {
            return null;
        }
        manufacturer.setId(manufacturer.getId());
        manufacturer.setName(name.toUpperCase());
        return manufacturer;
    }

}

