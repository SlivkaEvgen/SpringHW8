package org.goit.springhw8.controller;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
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

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("manufacturer")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    @GetMapping("list")
    public ModelAndView getAllManufacturers(ModelMap model) {
        return new ModelAndView("manufacturer/list", model.addAttribute("list", manufacturerService.getAllManufacturers()));
    }

    @GetMapping("name")
    public ModelAndView findByManufacturerName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        model.addAttribute("list", manufacturerService.findByManufacturerName(name));
        return new ModelAndView("manufacturer/manufacturerByName", model);
    }

    @GetMapping("id")
    public ModelAndView findById(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        Optional<Manufacturer> optionalManufacturer = manufacturerService.findManufacturerById(id);
        if (!optionalManufacturer.isPresent()) {
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
        if (!manufacturerService.findManufacturerById(id).isPresent()) {
            model.addAttribute("error", "Role With ID = " + id + " Is Empty");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        manufacturerService.deleteManufacturer(id);
        return new ModelAndView("redirect:/role", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(ModelMap model, Manufacturer manufacturer) {
        model.addAttribute("manufacturer", manufacturer);
        return new ModelAndView("manufacturer/updateManufacturer", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(Manufacturer manufacturer, ModelMap model) {
        if (!Validator.validId(manufacturer.getId().toString())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("manufacturer/manufacturer", model);
        }
        manufacturerService.saveManufacturer(manufacturer);
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    @GetMapping("new")
    public ModelAndView addNew(ModelMap model, String id, String name) {
        if (id == null) {
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        manufacturerService.saveManufacturer(new Manufacturer(Long.parseLong(id), name));
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(ModelMap model, Manufacturer manufacturer) {
        if (manufacturer == null) {
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        model.addAttribute("manufacturer", manufacturer);
        manufacturerService.saveManufacturer(manufacturer);
        return new ModelAndView("manufacturer/manufacturer", model);
    }
}
