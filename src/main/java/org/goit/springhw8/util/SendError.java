package org.goit.springhw8.util;

import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class SendError {

    private final static String ERROR = "error";
    private final static String ERROR2 = "error2";
    private final static String ERROR2MESSAGE = "Please,Try Again";
    protected final static String SUCCESSFULLY = "SUCCESSFULLY";
    private static String viewName = "";

    @Bean
    public SendError getSendError(){
        return new SendError();
    }

    public ModelAndView customModelUserStandard(String viewName, ModelMap model, Object errorMessage) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute(ERROR, errorMessage).addAttribute(ERROR2, ERROR2MESSAGE));
        }
        return new ModelAndView();
    }

    public ModelAndView customModelUser(String viewName, ModelMap model, Object object, Object message) {
        if (model != null) {
            model.addAttribute("SUCCESSFULLY", SUCCESSFULLY);
            return new ModelAndView(viewName, model.addAttribute(object.toString(), object).addAttribute(ERROR, message).addAttribute(ERROR2, ERROR2MESSAGE));
        }
        return new ModelAndView();
    }

}
