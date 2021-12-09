package org.goit.springhw8.controller;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.util.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("manufacturer")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    @GetMapping("list")
    public ModelAndView getAllManufacturers(@NotNull ModelMap model) {
        return new ModelAndView("manufacturer/list", model.addAttribute("list", manufacturerService.getList()));
    }

    @GetMapping("name")
    public ModelAndView findByManufacturerName(String name, ModelMap model) {
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
        List<Manufacturer> byName = manufacturerService.getByName(name);
        if (byName.isEmpty()) {
            return new ModelAndView("manufacturer/manufacturerByName", model.addAttribute("error", "Could Not Find By Name " + name).addAttribute("error2", "Try Again"));
        }
        return new ModelAndView("manufacturer/manufacturerByName", model.addAttribute("list", byName).addAttribute("error2", "SUCCESSFULLY"));
    }

    @GetMapping("id")
    public ModelAndView findById(String id, ModelMap model) {
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
        return new ModelAndView("manufacturer/manufacturerById", model.addAttribute("list", manufacturerService.findListById(id)).addAttribute("error2", "SUCCESSFULLY"));
    }

    @GetMapping("delete")
    public ModelAndView delete(String id, ModelMap model) {
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
        return new ModelAndView("redirect:/manufacturer", model.addAttribute("error2", "Manufacturer Deleted").addAttribute("error", "SUCCESSFULLY"));
    }

    @GetMapping("update/**")
    public ModelAndView update(Manufacturer manufacturer, @NotNull ModelMap model) {
        return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("manufacturer", manufacturer));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(Manufacturer manufacturer, ModelMap model) {
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

    @GetMapping("new")
    public ModelAndView addNew(Manufacturer manufacturer, @NotNull ModelMap model) {
        return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("manufacturer", manufacturer));
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(@NotNull Manufacturer manufacturer, ModelMap model) {
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
