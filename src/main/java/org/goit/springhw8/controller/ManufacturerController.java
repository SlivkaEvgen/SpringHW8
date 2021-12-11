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

    private final static String ERROR = "error";
    private final static String ERROR2 = "error2";
    private final static String ERROR2MESSAGE = "Please,Try Again";
    private final static String ERROR2SUCCESSFULLY = "SUCCESSFULLY";
    // "Name Is Empty"/"Wrong Name Length"/"Wrong NAME"/"Could Not Find By Name "
    //String errorMessage="error"; // "Name Is Empty"/"Wrong Name Length"/"Wrong NAME"/"Could Not Find By Name "
    private String viewName = "";

    private final ManufacturerService manufacturerService;

    public ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        return new ModelAndView(viewName, model.addAttribute(ERROR, errorMessage).addAttribute(ERROR2, ERROR2MESSAGE));
    }

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
        if (model == null) {
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
        viewName = "manufacturer/manufacturerByName";
        if (name == null) {
            return new ModelAndView(viewName, model);
        }
        if (name.isEmpty()) {
            return customModel(viewName, model, "Name Is Empty");
        }
        if (name.length() > 25) {
            return customModel(viewName, model, "Wrong Name Length");
        }
        if (!Validator.validName(name)) {
            return customModel(viewName, model, "Invalid Name Value");
        }
        if (manufacturerService.findByName(name).isEmpty()) {
            return customModel(viewName, model, "Could Not Find By Name " + name);
        }
        return new ModelAndView(viewName, model.addAttribute(ERROR2, ERROR2SUCCESSFULLY).addAttribute("list", manufacturerService.findByName(name)));
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
        return new ModelAndView(viewName, model.addAttribute("list", manufacturerService.findListByEntityId(id)).addAttribute(ERROR2, ERROR2SUCCESSFULLY));
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
        return new ModelAndView(viewName, model.addAttribute(ERROR, "Manufacturer Deleted").addAttribute(ERROR2, ERROR2SUCCESSFULLY));
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
        if (model == null) {
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
        viewName = "manufacturer/updateManufacturer";
        model.addAttribute(addAndUpdateValidator(manufacturer, model, viewName));
        if (!manufacturerService.getById(manufacturer.getId()).isPresent()) {
            return customModel(viewName, model, "Manufacturer With ID = " + manufacturer.getId() + " Not Found");
        }
        manufacturerService.saveEntity(manufacturer);
        return new ModelAndView(viewName, model.addAttribute(ERROR2, "Manufacturer Updated"));
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
        if (model == null) {
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
        viewName = "manufacturer/newManufacturer";
        model.addAttribute(addAndUpdateValidator(manufacturer, model, viewName));
        if (manufacturerService.getById(manufacturer.getId()).isPresent()) {
            return customModel(viewName, model, "Manufacturer With ID = " + manufacturer.getId() + " Is Used");
        }
        manufacturerService.saveEntity(manufacturer);
        return new ModelAndView(viewName, model.addAttribute(ERROR, "New Manufacturer Added"));
    }

    public ModelAndView addAndUpdateValidator(Manufacturer manufacturer, ModelMap model, String viewName) {
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
        manufacturer.setName(manufacturer.getName().toUpperCase());
        return new ModelAndView(viewName, model.addAttribute("manufacturer", manufacturer).addAttribute(ERROR2, ERROR2SUCCESSFULLY));
    }
}
