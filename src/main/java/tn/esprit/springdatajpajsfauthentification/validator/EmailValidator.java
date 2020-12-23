package tn.esprit.springdatajpajsfauthentification.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("tn.esprit.springdatajpajsfauthentification.validator.EmailValidator")
public class EmailValidator implements Validator {
    private static final String EMAIL_PATTERN = ".+@.+\\..+";
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(value.toString());
        if(!matcher.matches()){
            FacesMessage msg = new FacesMessage("Invalid E-mail format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
