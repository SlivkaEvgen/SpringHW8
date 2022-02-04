package org.goit.springhw8.controller;

import org.goit.springhw8.service.NoteService;
import org.goit.springhw8.util.SendErrorMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "notes")
public class NoteController {

    private final SendErrorMessage sendErrorMessage;

    private final NoteService noteService;

    public NoteController(SendErrorMessage sendErrorMessage,NoteService noteService){
        this.sendErrorMessage=sendErrorMessage;
        this.noteService=noteService;
    }

    public ModelAndView customModel(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModel(viewName, model, message);
    }

    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelOK(viewName, model, errorMessage);
    }

    @GetMapping("notes")
    public ModelAndView entityNote(ModelMap model) {
        return new ModelAndView("note/note", model);
    }

    @GetMapping("list")
    public ModelAndView getAllUsers(ModelMap model) {
        return new ModelAndView("note/noteList", String.valueOf(model), model.addAttribute("list", noteService.getAll()));
    }

}
