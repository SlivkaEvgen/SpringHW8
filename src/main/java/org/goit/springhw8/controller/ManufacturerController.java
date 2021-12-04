package org.goit.springhw8.controller;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.service.ServiceI;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService){
        this.manufacturerService=manufacturerService;
    }

    @GetMapping("manufacturer")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    @GetMapping("list")
    public ModelAndView getAllManufacturers(ModelMap model) {
        return new ModelAndView("manufacturer/list", model.addAttribute("list", manufacturerService.getList()));
    }

    @GetMapping("name")
    public ModelAndView findByManufacturerName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        model.addAttribute("list", manufacturerService.getByName(name));
        return new ModelAndView("manufacturer/manufacturerByName", model);
    }

    @GetMapping("id")
    public ModelAndView findById(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        Optional<Manufacturer> optionalManufacturer = manufacturerService.getById(id);
        if (!optionalManufacturer.isPresent()) {
            model.addAttribute("error", "Not Found");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        model.addAttribute("manufacturer", optionalManufacturer.get());
        return new ModelAndView("manufacturer/manufacturerById", model);
    }

    @GetMapping("delete")
    public ModelAndView delete(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        if (!manufacturerService.getById(id).isPresent()) {
            model.addAttribute("error", "Role With ID = " + id + " Is Empty");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        manufacturerService.deleteById(id);
        return new ModelAndView("redirect:/role", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(ModelMap model, Manufacturer manufacturer) {
        model.addAttribute("manufacturer", manufacturer);
        return new ModelAndView("manufacturer/updateManufacturer", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(Manufacturer manufacturer, ModelMap model) {
        if (manufacturer == null) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Manufacturer is Null");
            return new ModelAndView("manufacturer/manufacturer", model);
        }
        if (!Validator.validId(manufacturer.getId())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("manufacturer/manufacturer", model);
        }
        if (!Validator.validName(manufacturer.getName())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong Name");
            return new ModelAndView("manufacturer/manufacturer", model);
        }
        manufacturerService.saveEntity(manufacturer);
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    @GetMapping("new")
    public ModelAndView addNew(ModelMap model) {
        return new ModelAndView("manufacturer/newManufacturer", model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(ModelMap model, Manufacturer manufacturer) {
        System.out.println("ManufacturerController addNewPost " + manufacturer);
        if (manufacturer.getId() == null) {
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer.getName() == null) {
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer.getName().isEmpty()){
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer.getName().equalsIgnoreCase("null")){
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (!Validator.validId(String.valueOf(manufacturer.getId()))) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (!Validator.validName(manufacturer.getName())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong Name");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturerService.getById(manufacturer.getId()).isPresent()){
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID. Manufacturer With ID = "+ manufacturer.getId()+" Is Used");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        model.addAttribute("manufacturer", manufacturer);
        if (!manufacturerService.getById(manufacturer.getId()).isPresent()) {
            manufacturerService.saveEntity(manufacturer);
        }
        return new ModelAndView("manufacturer/manufacturer", model);
    }
}
