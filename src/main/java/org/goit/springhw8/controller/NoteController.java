package org.goit.springhw8.controller;

import org.goit.springhw8.model.Note;
import org.goit.springhw8.model.enums.AccessTypes;
import org.goit.springhw8.service.NoteService;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.goit.springhw8.util.SendErrorMessage;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Note controller.
 */
@Controller
@RequestMapping(value = "notes")
public class NoteController {

    private final SendErrorMessage sendErrorMessage;

    private final NoteService noteService;

    private final UserDetailsServiceImpl userDetailsService;

    private String viewName = "";

    /**
     * Instantiates a new Note controller.
     *
     * @param sendErrorMessage   the send error message
     * @param noteService        the note service
     * @param userDetailsService the user details service
     */
    public NoteController(SendErrorMessage sendErrorMessage, NoteService noteService, UserDetailsServiceImpl userDetailsService) {
        this.sendErrorMessage = sendErrorMessage;
        this.noteService = noteService;
        this.userDetailsService = userDetailsService;
    }

    private ModelAndView customModel(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModel(viewName, model, message);
    }

    private ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelOK(viewName, model, errorMessage);
    }

    /**
     * Entity note model and view.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("")
    public ModelAndView entityNote(ModelMap model) {
        return new ModelAndView("note/note", model);
    }

    /**
     * Gets all notes.
     *
     * @param userName the user name
     * @param model    the model
     * @return the all notes
     */
    @GetMapping("list")
    public ModelAndView getAllNotes(@CurrentSecurityContext(expression = "authentication?.name") String userName, ModelMap model) {
        List<Note> noteList = new ArrayList<>();
        for (Note note : noteService.getAll()) {
            if (!note.getAuthor().getName().equalsIgnoreCase(userName)) {
                if (!note.getAccessType().equals(AccessTypes.PRIVATE)) {
                    noteList.add(note);
                }
            } else
                noteList.add(note);
        }
        return new ModelAndView("note/noteList", String.valueOf(model), model.addAttribute("list", noteList));
    }

    /**
     * Gets note by id.
     *
     * @param id    the id
     * @param model the model
     * @return the note by id
     */
    @GetMapping("id")
    public ModelAndView getNoteById(String id, ModelMap model) {
        viewName = "note/noteByID";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!noteService.getById(id).isPresent()) {
            return customModel(viewName, model.addAttribute("list", noteService.findListByEntityId(id)), "Note With The ID = " + id + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", noteService.findListByEntityId(id)), "");
    }

    /**
     * Delete note by id model and view.
     *
     * @param userName the user name
     * @param id       the id
     * @param model    the model
     * @return the model and view
     */
    @GetMapping("delete")
    public ModelAndView deleteNoteById(@CurrentSecurityContext(expression = "authentication?.name") String userName, String id, ModelMap model) {
        viewName = "note/deleteNote";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!noteService.getById(id).isPresent()) {
            return customModel(viewName, model, "Note With The ID = " + id + ",\n Is Not Found");
        }
        if (!noteService.getById(id).get().getAuthor().getName().equals(userName)) {
            return customModel("note/note", model, "Note With The ID = " + id + ",\n Is Not Your");
        }
        noteService.deleteById(id);
        return new ModelAndView("redirect:/notes/list", model);
    }

    /**
     * Add new note get model and view.
     *
     * @param note  the note
     * @param model the model
     * @return the model and view
     */
    @GetMapping("new/**")
    public ModelAndView addNewNoteGet(Note note, ModelMap model) {
        return new ModelAndView("note/newNote", String.valueOf(model), model.addAttribute("note", note).addAttribute("list2", noteService.getAccessType()));
    }

    /**
     * Add new note post model and view.
     *
     * @param userName the user name
     * @param note     the note
     * @param model    the model
     * @return the model and view
     */
    @RequestMapping(value = "new/**", method = RequestMethod.POST)
    public ModelAndView addNewNotePost(@CurrentSecurityContext(expression = "authentication?.name") String userName, Note note, ModelMap model) {
        viewName = "note/newNote";
        if (model == null) {
            return new ModelAndView("note/newNote");
        }
        return validNote(userName, viewName, note, model.addAttribute("list2", noteService.getAccessType()), true);
    }

    /**
     * Update note get model and view.
     *
     * @param userName the user name
     * @param note     the note
     * @param model    the model
     * @return the model and view
     */
    @GetMapping("update/**")
    public ModelAndView updateNoteGet(@CurrentSecurityContext(expression = "authentication?.name") String userName, Note note, ModelMap model) {
        if (note==null){
            return new ModelAndView("note/updateNote", model.addAttribute("list2", noteService.getAccessType()));
        }
        if (note.getId() == null) {
            return new ModelAndView("note/updateNote", model.addAttribute("list2", noteService.getAccessType()));
        }
        Optional<Note> optionalNote = noteService.getById(note.getId());
        if (optionalNote.isPresent()) {
            note.setName(optionalNote.get().getName());
            note.setMessage(optionalNote.get().getMessage());
        }
        if (!optionalNote.isPresent()) {
            return customModel("note/note", model.addAttribute("note", note).addAttribute("list2", noteService.getAccessType()), "Note With The ID = " + note.getId() + ",\n Not Found");
        }
        if (!optionalNote.get().getAuthor().getName().equals(userName)) {
            return customModel("note/note", model.addAttribute("note", note).addAttribute("list2", noteService.getAccessType()), "Note With The ID = " + note.getId() + ",\n Is Not Your");
        }
        return new ModelAndView("note/updateNote", String.valueOf(model), model.addAttribute("note", note).addAttribute("list2", noteService.getAccessType()));
    }

    /**
     * Update note post model and view.
     *
     * @param userName the user name
     * @param note     the note
     * @param model    the model
     * @return the model and view
     */
    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateNotePost(@CurrentSecurityContext(expression = "authentication?.name") String userName, Note note, ModelMap model) {
        viewName = "note/updateNote";
        if (model == null) {
            return new ModelAndView("note/updateNote");
        }
        model.addAttribute("note", note).addAttribute("list2", noteService.getAccessType());
        return validNote(userName, viewName, note, model, false);
    }

    private ModelAndView validNote(String userName, String viewName, Note note, ModelMap model, boolean isNew) {
        if (note==null){
            return customModel(viewName, model, " Note is Null ");
        }
        if (note.getName().isEmpty()) {
            return customModel(viewName, model, " Invalid  Name ");
        }
        if (note.getMessage().isEmpty()) {
            return customModel(viewName, model, " Invalid  Message ");
        }
        if (note.getAccessType().name().isEmpty()) {
            return customModel(viewName, model, " Invalid  Access Type ");
        }
        note.setAuthor(userDetailsService.findByName(userName).get(0));
        if (isNew) {
            noteService.saveEntity(note);
            return customModelOk("redirect:/notes/list", model, "Note Is Registered.\n Now You Can To Log In");
        }
        Optional<Note> optionalNote = noteService.getById(note.getId());
        if (!optionalNote.isPresent()) {
            return customModel("redirect:/notes/list", model.addAttribute("note", note).addAttribute("list2", noteService.getAccessType()), "Note With The ID = " + note.getId() + ",\n Not Found");
        }
        if (!optionalNote.get().getAuthor().getName().equals(userName)) {
            return customModel("redirect:/notes/list", model, "Note With The ID = " + note.getId() + ",\n Is Not Your");
        }
        noteService.saveEntity(note);
        return customModelOk("redirect:/notes/list", model, "Note Updated");
    }

}
