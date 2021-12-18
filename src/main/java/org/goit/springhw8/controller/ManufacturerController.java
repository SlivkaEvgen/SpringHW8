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

@RequestMapping("manufacturer")
@Controller
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    private final SendErrorMessage sendErrorMessage;

    private String viewName = "";

    public ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModel(viewName, model, errorMessage);
    }

    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelOK(viewName, model, errorMessage);
    }

    public ManufacturerController(ManufacturerService manufacturerService, SendErrorMessage sendErrorMessage) {
        this.manufacturerService = manufacturerService;
        this.sendErrorMessage = sendErrorMessage;
    }

    @GetMapping("manufacturer")
    public ModelAndView entityManufacturer(ModelMap model) {
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    @GetMapping("list")
    public ModelAndView getAllManufacturers() {
        return new ModelAndView("manufacturer/list", "list", manufacturerService.getAll());
    }

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

    @GetMapping("new")
    public ModelAndView addNewManufacturerGet(Manufacturer manufacturer, ModelMap model) {
        return new ModelAndView("manufacturer/newManufacturer", String.valueOf(model), manufacturer);
    }

    @GetMapping("update/**")
    public ModelAndView updateManufacturerGet(Manufacturer manufacturer, ModelMap model) {
        return new ModelAndView("manufacturer/updateManufacturer", String.valueOf(model), manufacturer);
    }

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
