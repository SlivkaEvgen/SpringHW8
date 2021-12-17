package org.goit.springhw8.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class SendErrorMessage {

    private final String ERROR = "error";
    private final String ERROR2 = "error2";
    private final static String SUCCESSFULLY = " SUCCESSFULLY ";
    private final static String TRY_AGAIN = " Please, Try Again ";

    @Bean
    public SendErrorMessage getSendError() {
        return new SendErrorMessage();
    }

    public ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute(ERROR, errorMessage).addAttribute(ERROR2,  TRY_AGAIN));
        }
        return new ModelAndView();
    }

    public ModelAndView customModelOK(String viewName, ModelMap model, Object errorMessage) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute(ERROR, errorMessage).addAttribute(ERROR2, SUCCESSFULLY));
        }
        return new ModelAndView();
    }
}
