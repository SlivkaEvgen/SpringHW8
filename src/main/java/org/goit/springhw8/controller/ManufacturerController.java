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
import java.util.Optional;

@Controller
@RequestMapping("manufacturer") // добавить сообщения об ошибке по длине
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
        if (name.length() < 1 | name.length() > 25) {
            model.addAttribute("error", "Wrong Name Length");
            model.addAttribute("error2", "Try Again");
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        if (!Validator.validName(name)) {
            model.addAttribute("error", "WRONG NAME");
            model.addAttribute("error2", "Try Again");
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        List<Manufacturer> byName = manufacturerService.getByName(name);
        if (byName.isEmpty()) {
            model.addAttribute("error", "Could Not Find By Name " + name);
            model.addAttribute("error2", "Try Again");
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        return new ModelAndView("manufacturer/manufacturerByName", model.addAttribute("list", byName));
    }

    @GetMapping("id")
    public ModelAndView findById(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        if (id.isEmpty()) {
            model.addAttribute("error", "Wrong Empty ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        Optional<Manufacturer> optionalManufacturer = manufacturerService.getById(id);
        if (!optionalManufacturer.isPresent()) {
            model.addAttribute("error", "Could Not Find By ID " + id);
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        return new ModelAndView("manufacturer/manufacturerById", model.addAttribute("list", manufacturerService.findListById(id)));
    }

    @GetMapping("delete")
    public ModelAndView delete(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        if (!manufacturerService.getById(id).isPresent()) {
            model.addAttribute("error", "Manufacturer With ID = " + id + " Not Found");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        model.addAttribute("error2", "Manufacturer Deleted");
        model.addAttribute("error", "SUCCESSFULLY");
        manufacturerService.deleteById(id);
        return new ModelAndView("redirect:/manufacturer", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(Manufacturer manufacturer, @NotNull ModelMap model) {
        return new ModelAndView("manufacturer/updateManufacturer", model.addAttribute("manufacturer", manufacturer));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(Manufacturer manufacturer, ModelMap model) {
        if (manufacturer == null) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer is Null");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (manufacturer.getId() == null) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer ID Is Null");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (manufacturer.getName() == null) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer Name Is Null");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (manufacturer.getId().isEmpty()) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer ID Is Empty");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (manufacturer.getName().isEmpty()) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer Name Is Empty");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (!Validator.validId(manufacturer.getId())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (!Validator.validName(manufacturer.getName())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong Name");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (!manufacturerService.getById(manufacturer.getId()).isPresent()) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer With ID " + manufacturer.getId() + " Not Found");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        model.addAttribute("error2", "Manufacturer Updated");
        model.addAttribute("error", "SUCCESSFULLY");
        manufacturerService.saveEntity(manufacturer);
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    @GetMapping("new")
    public ModelAndView addNew(Manufacturer manufacturer, @NotNull ModelMap model) {
        return new ModelAndView("manufacturer/newManufacturer", model.addAttribute("manufacturer", manufacturer));
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(@NotNull Manufacturer manufacturer, ModelMap model) {
        System.out.println("ManufacturerController addNewPost " + manufacturer);
        if (manufacturer.getId() == null) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer ID Is Null");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer.getName() == null) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer Name Is Null");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer.getId().isEmpty()) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer ID Is Empty");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer.getName().isEmpty()) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer Name Is Empty");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer.getName().equalsIgnoreCase("null")) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer Name Is Null");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (!Validator.validId(String.valueOf(manufacturer.getId()))) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong Manufacturer ID");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (!Validator.validName(manufacturer.getName())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong Manufacturer Name");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturerService.getById(manufacturer.getId()).isPresent()) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID. Manufacturer With ID = " + manufacturer.getId() + " Is Used");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (!manufacturerService.getById(manufacturer.getId()).isPresent()) {
            model.addAttribute("manufacturer", manufacturer);
            model.addAttribute("error2", "New Manufacturer Added");
            model.addAttribute("error", "SUCCESSFULLY");
            manufacturerService.saveEntity(manufacturer);
        }
        return new ModelAndView("manufacturer/manufacturer", model);
    }
}
