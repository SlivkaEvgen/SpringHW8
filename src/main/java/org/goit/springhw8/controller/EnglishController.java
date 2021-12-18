package org.goit.springhw8.controller;

import org.goit.springhw8.service.EnglishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("english")
public class EnglishController {

    private final EnglishService englishService;

    public EnglishController(EnglishService englishService){
        this.englishService=englishService;
    }

    @GetMapping
    public ModelAndView getByEnglish(String name, ModelMap model){
        System.out.println(name);
        if (name==null||name.isEmpty()){
            return new ModelAndView("translate/byEnglishName",model);
        }
        model.addAttribute("list2",englishService.findByUkrainianNameContainingIgnoreCase(name));
        return new ModelAndView("translate/byEnglishName",model.addAttribute("list",englishService.findByName(name)));
    }
}
