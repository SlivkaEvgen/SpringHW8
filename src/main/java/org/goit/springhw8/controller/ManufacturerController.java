package org.goit.springhw8.controller;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.util.SendErrorMessage;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final SendErrorMessage sendErrorMessage;

    private String viewName = "";

    /**
     * Custom model model and view.
     *
     * @param viewName     the view name
     * @param model        the model
     * @param errorMessage the error message
     * @return the model and view
     */
    public ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModel(viewName, model, errorMessage);
    }

    /**
     * Custom model ok model and view.
     *
     * @param viewName     the view name
     * @param model        the model
     * @param errorMessage the error message
     * @return the model and view
     */
    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelOk(viewName, model, errorMessage);
    }

    /**
     * Instantiates a new Manufacturer controller.
     *
     * @param manufacturerService the manufacturer service
     * @param sendErrorMessage    the send error message
     */
    public ManufacturerController(ManufacturerService manufacturerService, SendErrorMessage sendErrorMessage) {
        this.manufacturerService = manufacturerService;
        this.sendErrorMessage = sendErrorMessage;
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
     * @return the all manufacturers
     */
    @GetMapping("list")
    public ModelAndView getAllManufacturers() {
        return new ModelAndView("manufacturer/list", "list", manufacturerService.getAll());
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
        model.addAttribute("list", manufacturerService.findListByEntityId(id));
        if (!manufacturerService.getById(id).isPresent()) {
            return customModel(viewName, model, "Manufacturer With The ID = " + id + ",\n Is Not Found");
        }
        return customModelOk(viewName, model, "");
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
        model.addAttribute("list", manufacturerService.findListByEntityId(name));
        if (manufacturerService.findByName(name).isEmpty()) {
            return customModel(viewName, model, "Manufacturer With The Name = " + name + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", manufacturerService.findByName(name)), "");
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
        if (!manufacturerService.getById(id).isPresent()) {
            return customModel(viewName, model, "Manufacturer With The ID = " + id + ",\n Is Not Found");
        }
        manufacturerService.deleteById(id);
        return customModelOk("manufacturer/manufacturer", model, "Manufacturer Deleted");
    }

    /**
     * Add new manufacturer get model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @GetMapping("new")
    public ModelAndView addNewManufacturerGet(Manufacturer manufacturer, ModelMap model) {
        return new ModelAndView("manufacturer/newManufacturer", String.valueOf(model), manufacturer);
    }

    /**
     * Update manufacturer get model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @GetMapping("update/**")
    public ModelAndView updateManufacturerGet(Manufacturer manufacturer, ModelMap model) {
        return new ModelAndView("manufacturer/updateManufacturer", String.valueOf(model), manufacturer);
    }

    /**
     * Add new manufacturer post model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewManufacturerPost(Manufacturer manufacturer, ModelMap model) {
        viewName = "manufacturer/newManufacturer";
        if (manufacturer == null) {
            return new ModelAndView(viewName);
        }
        if (!Validator.validId(manufacturer.getId())) {
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

    /**
     * Update manufacturer post model and view.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateManufacturerPost(Manufacturer manufacturer, ModelMap model) {
        viewName = "manufacturer/updateManufacturer";
        if (manufacturer == null) {
            return new ModelAndView(viewName);
        }
        if (!Validator.validId(manufacturer.getId())) {
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
}
