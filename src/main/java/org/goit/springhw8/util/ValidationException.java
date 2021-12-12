//package org.goit.springhw8.util;
//
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//@Validated
//@RestController
//public class ValidationException {
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ModelAndView onConstraintValidationException(ConstraintViolationException e, Model model) {
//        List<String> error = new ArrayList<>();
//        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//        for (ConstraintViolation<?> violation : violations) {
//            error.add(violation.getMessage());
//        }
//        model.addAttribute("message", error);
//
//        if (model.containsAttribute("author")) {
//            return new ModelAndView("noteError");
//        }
//        if (model.containsAttribute("username")) {
//            return new ModelAndView("errorUser");
//        }
//        return new ModelAndView("/register");
//    }
//
//}
