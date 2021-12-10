package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Manufacturer controller.
 */
@RequestMapping("manufacturer")
@Controller
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    /**
     * Instantiates a new Manufacturer controller.
     *
     * @param manufacturerService the manufacturer service
     */
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    /**
     * Entity manufacturer model and view.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("manufacturer")
    public ModelAndView entityManufacturer(ModelMap model) {
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    /**
     * Gets all manufacturers.
     *
     * @param model the model
     * @return the all manufacturers
     */
    @GetMapping("list")
    public ModelAndView getAllManufacturers(@ModelAttribute("list") ModelMap model) {
        if (model==null){
            return new ModelAndView("manufacturer/list");
        }
        return new ModelAndView("manufacturer/list", model.addAttribute("list", manufacturerService.getAll()));
    }

    /**
     * Gets by manufacturer name.
     *
     * @param name  the name
     * @param model the model
     * @return the by manufacturer name
     */
    @GetMapping("name")
    public ModelAndView getByManufacturerName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        if (name.isEmpty()) {
            return new ModelAndView("manufacturer/manufacturerByName", model.addAttribute("error", "Name Is Empty").addAttribute("error2", "Try Again"));
        }
        if (name.length() > 25) {
            return new ModelAndView("manufacturer/manufacturerByName", model.addAttribute("error", "Wrong Name Length").addAttribute("error2", "Try Again"));
        }
        if (!Validator.validName(name)) {
            return new ModelAndView("manufacturer/manufacturerByName", model.addAttribute("error", "WRONG NAME").addAttribute("error2", "Try Again"));
        }
        if (manufacturerService.findByName(name).isEmpty()){
            return new ModelAndView("manufacturer/manufacturerByName", model.addAttribute("error", "Could Not Find By Name " + name).addAttribute("error2", "Try Again"));
        }
        return new ModelAndView("manufacturer/manufacturerByName", model.addAttribute("list", manufacturerService.findByName(name)).addAttribute("error2", "SUCCESSFULLY"));
    }

    /**
     * Gets by manufacturer id.
     *
     * @param id    the id
     * @param model the model
     * @return the by manufacturer id
     */
    @GetMapping("id")
    public ModelAndView getByManufacturerId(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        if (id.isEmpty()) {
            return new ModelAndView("manufacturer/manufacturerById", model.addAttribute("error", "Wrong Empty ID").addAttribute("error2", "Try again"));
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("manufacturer/manufacturerById", model.addAttribute("error", "Wrong ID").addAttribute("error2", "Try again"));
        }
        if (!manufacturerService.getById(id).isPresent()) {
            return new ModelAndView("manufacturer/manufacturerById", model.addAttribute("error", "Could Not Find By ID " + id).addAttribute("error2", "Try again"));
        }
        return new ModelAndView("manufacturer/manufacturerById", model.addAttribute("list", manufacturerService.findListByEntityId(id)).addAttribute("error2", "SUCCESSFULLY"));
    }

    /**
     * Delete manufacturer by id model and view.
     *
     * @param id    the id
     * @param model the model
     * @return the model and view
     */
    @GetMapping("delete")
    public ModelAndView deleteManufacturerById(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("manufacturer/deleteManufacturer", model.addAttribute("error", "Wrong ID").addAttribute("error2", "Try again"));
        }
        if (!manufacturerService.getById(id).isPresent()) {
            return new ModelAndView("manufacturer/deleteManufacturer", model.addAttribute("error", "Manufacturer With ID = " + id + " Not Found").addAttribute("error2", "Try again"));
        }
        manufacturerService.deleteById(id);
        return new ModelAndView("manufacturer/manufacturer", model.addAttribute("error", "Manufacturer Deleted").addAttribute("error2", "SUCCESSFULLY"));
    }

    /**
     * Update manufacturer get model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @GetMapping("update/**")
    public ModelAndView updateManufacturerGet(@Valid Manufacturer manufacturer, ModelMap model) {
        if (model==null){
            return new ModelAndView("manufacturer/updateManufacturer");
        }
        return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("manufacturer", manufacturer));
    }

    /**
     * Update manufacturer post model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateManufacturerPost(@Valid Manufacturer manufacturer, ModelMap model) {
        if (manufacturer == null) {
            return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("error", "Manufacturer is Null").addAttribute("error2", "Try Again"));
        }
        if (manufacturer.getId() == null) {
            return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("error", "Manufacturer ID Is Null").addAttribute("error2", "Try Again"));
        }
        if (manufacturer.getName() == null) {
            return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("error", "Manufacturer Name Is Null").addAttribute("error2", "Try Again"));
        }
        if (manufacturer.getId().isEmpty()) {
            return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("error", "Manufacturer ID Is Empty").addAttribute("error2", "Try Again"));
        }
        if (manufacturer.getName().isEmpty()) {
            return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("error", "Manufacturer Name Is Empty").addAttribute("error2", "Try Again"));
        }
        if (!Validator.validId(manufacturer.getId())) {
            return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("error", "Wrong ID").addAttribute("error2", "Try Again"));
        }
        if (!Validator.validName(manufacturer.getName())) {
            return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("error", "Wrong Name").addAttribute("error2", "Try Again"));
        }
        if (!manufacturerService.getById(manufacturer.getId()).isPresent()) {
            return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("error", "Manufacturer With ID " + manufacturer.getId() + " Not Found").addAttribute("error2", "Try Again"));
        }
        manufacturer.setName(manufacturer.getName().toUpperCase());
        manufacturerService.saveEntity(manufacturer);
        return new ModelAndView("manufacturer/manufacturer", model.addAttribute("error", "SUCCESSFULLY").addAttribute("error2", "Manufacturer Updated"));
    }

    /**
     * Add new manufacturer get model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @GetMapping("new")
    public ModelAndView addNewManufacturerGet(@Valid Manufacturer manufacturer, ModelMap model) {
        if (model==null){
            return new ModelAndView("manufacturer/newManufacturer");
        }
        return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("manufacturer", manufacturer));
    }

    /**
     * Add new manufacturer post model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewManufacturerPost(@Valid Manufacturer manufacturer, ModelMap model) {
        if (manufacturer==null){
            return new ModelAndView("manufacturer/newManufacturer");
        }
        if (manufacturer.getId() == null) {
            return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("error", "Manufacturer ID Is Null").addAttribute("error2", "Try Again"));
        }
        if (manufacturer.getName() == null) {
            return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("error", "Manufacturer Name Is Null").addAttribute("error2", "Try Again"));
        }
        if (manufacturer.getId().isEmpty()) {
            return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("error", "Manufacturer ID Is Empty").addAttribute("error2", "Try Again"));
        }
        if (manufacturer.getName().isEmpty()) {
            return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("error", "Manufacturer Name Is Empty").addAttribute("error2", "Try Again"));
        }
        if (manufacturer.getName().equalsIgnoreCase("null")) {
            return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("error", "Manufacturer Name Is Null").addAttribute("error2", "Try Again"));
        }
        if (!Validator.validId(String.valueOf(manufacturer.getId()))) {
            return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("error", "Wrong Manufacturer ID").addAttribute("error2", "Try Again"));
        }
        if (!Validator.validName(manufacturer.getName())) {
            return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("error", "Wrong Manufacturer Name").addAttribute("error2", "Try Again"));
        }
        if (manufacturerService.getById(manufacturer.getId()).isPresent()) {
            return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("error", "Wrong ID Manufacturer With ID = " + manufacturer.getId() + " Is Used").addAttribute("error2", "Try Again"));
        }
        manufacturer.setName(manufacturer.getName().toUpperCase());
        manufacturerService.saveEntity(manufacturer);
        return new ModelAndView("manufacturer/manufacturer", model.addAttribute("manufacturer", manufacturer).addAttribute("error", "SUCCESSFULLY").addAttribute("error2", "New Manufacturer Added"));
    }
}
