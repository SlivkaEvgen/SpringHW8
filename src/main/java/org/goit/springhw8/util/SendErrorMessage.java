package org.goit.springhw8.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Send error message.
 */
@Service
@RequiredArgsConstructor
public class SendErrorMessage {
    private final static String ERROR = "error";

    private final static String ERROR2 = "error2";

    private final static String ERROR2MESSAGE = "Please,Try Again";

    private final static String SUCCESSFULLY = "SUCCESSFULLY";

    /**
     * Gets send error.
     *
     * @return the send error
     */
    @Bean
    public SendErrorMessage getSendError() {
        return new SendErrorMessage();
    }

    /**
     * Custom model user standard model and view.
     *
     * @param viewName     the view name
     * @param model        the model
     * @param errorMessage the error message
     * @return the model and view
     */
    public ModelAndView customModelUserStandard(String viewName, ModelMap model, Object errorMessage) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute(ERROR, errorMessage).addAttribute(ERROR2, ERROR2MESSAGE));
        }
        return new ModelAndView();
    }

    /**
     * Custom model user model and view.
     *
     * @param viewName the view name
     * @param model    the model
     * @param object   the object
     * @param message  the message
     * @return the model and view
     */
    public ModelAndView customModelUser(String viewName, ModelMap model, Object object, Object message) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute(object.toString(), object).addAttribute(ERROR, message).addAttribute(ERROR2, ERROR2MESSAGE));
        }
        return new ModelAndView();
    }

    /**
     * Custom model user ok model and view.
     *
     * @param viewName     the view name
     * @param model        the model
     * @param errorMessage the error message
     * @return the model and view
     */
    public ModelAndView customModelUserOK(String viewName, ModelMap model, Object errorMessage) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute(ERROR, errorMessage).addAttribute(ERROR2, SUCCESSFULLY));
        }
        return new ModelAndView();
    }
}
