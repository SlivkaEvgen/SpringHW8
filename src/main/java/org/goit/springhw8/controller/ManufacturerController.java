package org.goit.springhw8.controller;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ManufacturerService manufacturerService;

    // DONE
    @GetMapping("manufacturer")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("manufacturer/manufacturer", model);
    }

    //  DONE
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
        Optional<Manufacturer> optionalManufacturer = manufacturerService.findManufacturerById(Long.parseLong(id));
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
        if (!manufacturerService.findManufacturerById(Long.parseLong(id)).isPresent()) {
            model.addAttribute("error", "Role With ID = " + id + " Is Empty");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("manufacturer/deleteManufacturer", model);
        }
        manufacturerService.deleteManufacturer(id);
//        this.message = "Role With ID = " + id + "\n Removed ";
//        model.addAttribute("error2", message);
        return new ModelAndView("redirect:/role", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(ModelMap model) {
        return new ModelAndView("manufacturer/updateManufacturer", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(Manufacturer manufacturer, ModelMap model) {
        if (!Validator.validId(manufacturer.getId().toString())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("manufacturer/updateManufacturer", model);
        }
        manufacturerService.saveManufacturer(manufacturer);
//        this.message = "User With ID = " + role.getId() + " Updated";
//        model.addAttribute("error", this.message);
        return new ModelAndView("manufacturer/updateManufacturer", model);
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

//    @GetMapping("id")
//    public ModelAndView findById(ModelMap model, String id) {
////        valid(model,id,message);
//        Object valid3 = valid1(model, id);
//        System.out.println(valid3);
//
//        model.addAttribute("manufacturer", manufacturerService.findManufacturerById(Long.parseLong(id)).get());
//        return new ModelAndView("manufacturer/manufacturerById", model);
//    }
//
//    @GetMapping("name")
//    public Optional<ModelAndView> findByName(String name, ModelMap model) {
////       valid(name,model,message, )
//        Object valid3 = valid2(model, name);
//        System.out.println(valid3);
//
//        model.addAttribute("list", manufacturerService.findByManufacturerName(name));
//        return Optional.of(new ModelAndView("manufacturer/manufacturerByName", model));
//    }

//    @GetMapping("delete")
//    public ModelAndView delete(ModelMap model, String id) {
////        valid(id,model,message)
////        Object valid3 = valid4(model, message, id);
////        System.out.println(valid3);
//
//        System.out.println("CONTROLLER MANUFACTURER");
//
//        manufacturerService.deleteManufacturer(id);
////        this.message = "Manufacturer With ID = " + id + "\n Removed ";
////        model.addAttribute("error", this.message);
//        return new ModelAndView("redirect:/manufacturer", model);
//    }
//
//    @GetMapping("new")
//    public ModelAndView addNew(ModelMap model, String id, String name, String message) {
////        valid(name,model,message, id)
//        Object valid3 = valid4(model, message, id);
//        System.out.println(valid3);
//
//        manufacturerService.saveManufacturer(new Manufacturer(Long.parseLong(id), name));
//        model.addAttribute("error", message);
//        return new ModelAndView("manufacturer/newManufacturer", model);
//    }
//
//    @RequestMapping(value = "new", method = RequestMethod.POST)
//    public ModelAndView addNewPost(ModelMap model, Manufacturer manufacturer) {
//////        valid(manufacturer,model,message)
////        Object valid3 = valid3(model, manufacturer);
////        System.out.println(valid3);
//
//        model.addAttribute("manufacturer", manufacturer);
//        manufacturerService.saveManufacturer(manufacturer);
//        return new ModelAndView("manufacturer/manufacturer", model);
//    }
//
//    @GetMapping("update/**")
//    public ModelAndView update(ModelMap model, Manufacturer manufacturer) {
////        valid(manufacturer,model,message)
////        Object valid3 = valid3(model, manufacturer);
////        System.out.println(valid3);
//
//        manufacturerService.saveManufacturer(manufacturer);
//        model.addAttribute("manufacturer", manufacturer);
//        return new ModelAndView("manufacturer/updateManufacturer", model);
//    }
//
//    @RequestMapping(value = "update/**", method = RequestMethod.POST)
//    public ModelAndView updatePost2(ModelMap model, Manufacturer manufacturer) {
//
////        Object valid3 = valid3(model, manufacturer);
////        System.out.println(valid3);
//
//        model.addAttribute("manufacturer", manufacturer);
//        manufacturerService.saveManufacturer(manufacturer);
//        return new ModelAndView("manufacturer/updateManufacturer", model);
//    }

//    public List<Object> validManufacturer(Map<String,Manufacturer> manufacturerMap, ModelAndView modelAndView){
//        if(manufacturerMap.isEmpty()){
//            return (List<Object>) manufacturerMap.put("NO VALID",manufacturerMap);
//        }
//
//    }
//       ++++++++++++++++++++++++++++


//    public Object valid1(ModelMap model, String id) {
//        return valid(model, null, id, null);
//    }
//
//    public Object valid2(ModelMap model, String name) {
//        return valid(model, null, null, name);
//    }
//
//    public Object valid4(ModelMap model, String name, String id) {
//        return valid(model, null, id, name);
//    }
//
//    public Object valid3(ModelMap model, Manufacturer manufacturer) {
//        return valid(model, manufacturer, null, null);
//    }
//
//    public Object valid(ModelMap model, Manufacturer manufacturer, String id, String name) {
//        if (id.isEmpty() || id.equalsIgnoreCase("null")) {
//            model.addAttribute("error", " ID IS EMPTY ");
//            model.addAttribute("error2", " ID IS EMPTY ");
//            return new ModelAndView("manufacturer/manufacturerById", model);
//        }
//        if (name.isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error2", " Please, try again ");
//            return new ModelMap("  NAME  IS EAMPTY ", Optional.of(id));
//        }
//        if (manufacturer.getName().isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error2", " Please, try again ");
//            return new ModelMap("  NAME  IS EAMPTY ", Optional.of(id));
//        }
//
//        if (!Validator.validId(id)) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error2", " Please, try again ");
//            return new ModelAndView("manufacturer/manufacturerById", model);
//        }
//        if (!Validator.validId(manufacturer.getId().toString())) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error2", " Please, try again ");
//            return new ModelMap(" ID NO  VALID ", Optional.of(id));
//        }
//        if (!Validator.validName(name)) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error2", " Please, try again ");
//            return new ModelMap(" NAME NO  VALID ", Optional.of(id));
//        }
//
//        if (Validator.validString(name)) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error2", " Please, try again ");
//            return new ModelMap(" ID NO  VALID ", Optional.of(id));
//        }
//        if (name == null) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error2", " Please, try again ");
//            return Optional.of(new ModelAndView("manufacturer/manufacturerByName", model));
//        }
//        if (!Validator.validName(name)) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error2", " Please, try again ");
//            return Optional.of(new ModelAndView("manufacturer/manufacturerByName", model));
//        }
//
//
//        Optional<Manufacturer> optionalManufacturer = manufacturerService.findManufacturerById(Long.parseLong(id));
//        if (!optionalManufacturer.isPresent()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/manufacturerById", model);
//        }
//        if (model.isEmpty() || id.isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/deleteManufacturer", model);
//        }
//        if (id == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/deleteManufacturer", model);
//        }
//        if (!Validator.validId(id)) {
//            model.addAttribute("error", " ID = NULL ");
//
//            model.addAttribute("error", "Wrong ID");
//            model.addAttribute("error2", "Try again");
//            return new ModelAndView("manufacturer/deleteManufacturer", model);
//        }
//
//        if (!manufacturerService.findManufacturerById(Long.parseLong(id)).isPresent()) {
//            model.addAttribute("error", " ID = NULL ");
//            model.addAttribute("error", "Manufacturer With ID = " + id + " Is Empty");
//            model.addAttribute("error2", "Try again");
//            return new ModelAndView("manufacturer/deleteManufacturer", model);
//        }
//        if (model.isEmpty() || id.isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/deleteManufacturer", model);
//        }
//        if (id == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!Validator.validId(id)) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!Validator.validName(name)) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!manufacturerService.findByManufacturerName(name).isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//
//        if (model.isEmpty() || id.isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/deleteManufacturer", model);
//        }
//        if (id == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!Validator.validId(id)) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!Validator.validName(name)) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!manufacturerService.findByManufacturerName(name).isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//
//        if (model.isEmpty() || manufacturer.getId() == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (manufacturer.getId() == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//
//        if (!Validator.validId(manufacturer.getId().toString())) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!Validator.validName(manufacturer.getName())) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (manufacturerService.findByManufacturerName(manufacturer.getName()).isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (model.isEmpty() || manufacturer.getId() == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (manufacturer.getId() == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//
//        if (!Validator.validId(manufacturer.getId().toString())) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!Validator.validName(manufacturer.getName())) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (manufacturerService.findByManufacturerName(manufacturer.getName()).isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//
//        if (model.isEmpty() || manufacturer.getId() == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (manufacturer.getId() == null) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//
//        if (!Validator.validId(manufacturer.getId().toString())) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (!Validator.validName(manufacturer.getName())) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        if (manufacturerService.findByManufacturerName(manufacturer.getName()).isEmpty()) {
//            model.addAttribute("error", " ID = NULL ");
//            return new ModelAndView("manufacturer/newManufacturer", model);
//        }
//        manufacturerService.saveManufacturer(new Manufacturer(Long.parseLong(id), name));
////        model.addAttribute("error", message);
//        return new ModelAndView("manufacturer/newManufacturer", model);
////        return model;
//    }

}
