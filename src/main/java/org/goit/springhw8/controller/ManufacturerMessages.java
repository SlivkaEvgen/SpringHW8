package org.goit.springhw8.controller;

import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class ManufacturerMessages {

    private final ManufacturerService manufacturerService;

//            return new ModelAndView("manufacturer/manufacturer", model);
//            return new ModelAndView("manufacturer/list", model.addAttribute("list", manufacturerService.getAll()));
//                return new ModelAndView("manufacturer/deleteManufacturer", model);
    public ModelAndView id(String id,ModelMap model){
        if (id==null){
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        if (id.isEmpty()){
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        if (!Validator.validId(id)){
            return new ModelAndView("manufacturer/manufacturerById", model);
        }
        model.addAttribute("error2", "successfully".toUpperCase());
        return new ModelAndView("manufacturer/manufacturerById", model);
    }

    public ModelAndView name(String name, ModelMap model){
        if (name==null){
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        if (name.isEmpty()){
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        if (!Validator.validName(name)){
            return new ModelAndView("manufacturer/manufacturerByName", model);
        }
        model.addAttribute("error2", "successfully".toUpperCase());
        return new ModelAndView("manufacturer/manufacturerByName", model);
    }

    public ModelAndView newManufacturer(String id,Manufacturer manufacturer,ModelMap model){

        if (manufacturer==null){
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer.equals("")){
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (!Validator.validId(String.valueOf(manufacturer.getId()))){
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (!Validator.validName(manufacturer.getName())){
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        if (manufacturer == null) {
            return new ModelAndView("manufacturer/newManufacturer", model);
        }

        if (id == null || id.isEmpty()) {
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
        if (manufacturerService.findById(manufacturer.getId()).isPresent()){
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID. Manufacturer With ID = "+ manufacturer.getId()+" Is Used");
            return new ModelAndView("manufacturer/newManufacturer", model);
        }
        model.addAttribute("error2", "successfully".toUpperCase());
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    public ModelAndView updateManufacturer(Manufacturer manufacturer,ModelMap model){
        if (manufacturer==null){
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (manufacturer.equals("")){
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (!Validator.validId(String.valueOf(manufacturer.getId()))){
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        if (!Validator.validName(manufacturer.getName())){
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        model.addAttribute("error2", "successfully".toUpperCase());
        return new ModelAndView("manufacturer/manufacturer",model);
    }


}
