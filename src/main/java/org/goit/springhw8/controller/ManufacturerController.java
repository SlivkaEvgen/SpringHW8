package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.util.SendError;
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
    private final SendError sendError;
    private String viewName = "";

    public ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        return sendError.customModelUser(viewName, model, errorMessage, errorMessage);
    }

    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendError.customModelUserOK(viewName, model, errorMessage);
    }

    /**
     * Instantiates a new Manufacturer controller.
     *
     * @param manufacturerService the manufacturer service
     */
    public ManufacturerController(ManufacturerService manufacturerService, SendError sendError) {
        this.manufacturerService = manufacturerService;
        this.sendError = sendError;
    }
//OK

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
//OK

    /**
     * Gets all manufacturers.
     *
     * @param model the model
     * @return the all manufacturers
     */
    @GetMapping("list")
    public ModelAndView getAllManufacturers(@ModelAttribute("list") ModelMap model) {
        return new ModelAndView("manufacturer/list", model.addAttribute("list", manufacturerService.getAll()));
    }
//OK

    /**
     * Gets by manufacturer name.
     *
     * @param name  the name
     * @param model the model
     * @return the by manufacturer name
     */
    @GetMapping("name")
    public ModelAndView getByManufacturerName(String name, ModelMap model) {
        viewName = "manufacturer/manufacturerByName";
        if (name == null) {
            return new ModelAndView(viewName, model);
        }
        if (name.isEmpty()) {
            return customModel(viewName, model.addAttribute("name", name), "Name Is Empty");
        }
        if (name.length() > 25) {
            return customModel(viewName, model.addAttribute("name", name), "Wrong Name Length");
        }
        if (!Validator.validName(name)) {
            return customModel(viewName, model.addAttribute("name", name), "Invalid Name Value");
        }
        if (manufacturerService.findByName(name).isEmpty()) {
            return customModel(viewName, model, "Could Not Find By Name " + name);
        }
        return customModelOk(viewName, model.addAttribute("list", manufacturerService.findByName(name)), "");
    }
//OK

    /**
     * Gets by manufacturer id.
     *
     * @param id    the id
     * @param model the model
     * @return the by manufacturer id
     */
    @GetMapping("id")
    public ModelAndView getByManufacturerId(String id, ModelMap model) {
        viewName = "manufacturer/manufacturerById";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (id.isEmpty()) {
            return customModel(viewName, model, "Wrong Empty ID");
        }
        if (!Validator.validId(id)) {
            return customModel(viewName, model, "Invalid ID Value");
        }
        if (!manufacturerService.getById(id).isPresent()) {
            return customModel(viewName, model, "Could Not Find By ID " + id);
        }
        return customModelOk(viewName, model.addAttribute("list", manufacturerService.findListByEntityId(id)), "");
    }
//OK

    /**
     * Delete manufacturer by id model and view.
     *
     * @param id    the id
     * @param model the model
     * @return the model and view
     */
    @GetMapping("delete")
    public ModelAndView deleteManufacturerById(String id, ModelMap model) {
        viewName = "manufacturer/deleteManufacturer";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!Validator.validId(id)) {
            return customModel(viewName, model, "Invalid ID Value");
        }
        if (!manufacturerService.getById(id).isPresent()) {
            return customModel(viewName, model, "Manufacturer With ID = " + id + " Not Found");
        }
        manufacturerService.deleteById(id);
        return customModelOk("manufacturer/manufacturer", model, "Manufacturer Deleted");
    }
//OK

    /**
     * Update manufacturer get model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @GetMapping("update/**")
    public ModelAndView updateManufacturerGet(@Valid Manufacturer manufacturer, ModelMap model) {
        return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("manufacturer", manufacturer));
    }
//OK
    /**
     * Update manufacturer post model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateManufacturerPost(@Valid Manufacturer manufacturer, ModelMap model) {
        viewName = "manufacturer/updateManufacturer";
        if (manufacturer == null) {
            return new ModelAndView(viewName);
        }
        if (manufacturer.getId() == null) {
            return customModel(viewName, model, "Manufacturer ID Is Null");
        }
        if (manufacturer.getName() == null) {
            return customModel(viewName, model, "Manufacturer Name Is Null");
        }
        if (manufacturer.getId().isEmpty()) {
            return customModel(viewName, model, "Manufacturer ID Is Empty");
        }
        if (manufacturer.getName().isEmpty()) {
            return customModel(viewName, model, "Manufacturer Name Is Empty");
        }
        if (manufacturer.getName().equalsIgnoreCase("null")) {
            return customModel(viewName, model, "Manufacturer Name Is Null");
        }
        if (!Validator.validId(String.valueOf(manufacturer.getId()))) {
            return customModel(viewName, model, "Invalid Manufacturer ID Value");
        }
        if (!Validator.validName(manufacturer.getName())) {
            return customModel(viewName, model, "Invalid Manufacturer Name Value");
        }
        if (!manufacturerService.getById(manufacturer.getId()).isPresent()) {
            return customModel(viewName, model, "Manufacturer With ID = " + manufacturer.getId() + " Not Found");
        }
        manufacturer.setName(manufacturer.getName().toUpperCase());
        manufacturerService.saveEntity(manufacturer);
        return customModelOk("manufacturer/manufacturer", model, "Manufacturer Updated");
    }
//OK

    /**
     * Add new manufacturer get model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @GetMapping("new")
    public ModelAndView addNewManufacturerGet(@Valid Manufacturer manufacturer, ModelMap model) {
        return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("manufacturer", manufacturer));
    }
//OK
    /**
     * Add new manufacturer post model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewManufacturerPost(@Valid Manufacturer manufacturer, ModelMap model) {
        viewName = "manufacturer/newManufacturer";

        if (manufacturer == null) {
            return new ModelAndView(viewName);
        }
        if (manufacturer.getId() == null) {
            return customModel(viewName, model, "Manufacturer ID Is Null");
        }
        if (manufacturer.getName() == null) {
            return customModel(viewName, model, "Manufacturer Name Is Null");
        }
        if (manufacturer.getId().isEmpty()) {
            return customModel(viewName, model, "Manufacturer ID Is Empty");
        }
        if (manufacturer.getName().isEmpty()) {
            return customModel(viewName, model, "Manufacturer Name Is Empty");
        }
        if (manufacturer.getName().equalsIgnoreCase("null")) {
            return customModel(viewName, model, "Manufacturer Name Is Null");
        }
        if (!Validator.validId(String.valueOf(manufacturer.getId()))) {
            return customModel(viewName, model, "Invalid Manufacturer ID Value");
        }
        if (!Validator.validName(manufacturer.getName())) {
            return customModel(viewName, model, "Invalid Manufacturer Name Value");
        }
        if (manufacturerService.getById(manufacturer.getId()).isPresent()) {
            return customModel(viewName, model, "Manufacturer With ID = " + manufacturer.getId() + " Is Used");
        }

        manufacturer.setName(manufacturer.getName().toUpperCase());
        manufacturerService.saveEntity(manufacturer);
        return customModelOk(viewName, model, "New Manufacturer Added");
    }
}
