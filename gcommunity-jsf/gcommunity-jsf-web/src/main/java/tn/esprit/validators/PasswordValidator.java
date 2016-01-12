package tn.esprit.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;




@FacesValidator(value="passwordValidator")
public class PasswordValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		
		String password =(String)value;
		
		UIInput confirmPass =(UIInput) component.getAttributes().get("confirm");
		
		String confirm=(String) confirmPass.getSubmittedValue();
		
		if(password==null||confirm==null)
		{
			return ;
		}
		
		if(!password.equals(confirm)){
				throw new ValidatorException(new FacesMessage("passwords are not the same"));
			}
		
		
	}

}
