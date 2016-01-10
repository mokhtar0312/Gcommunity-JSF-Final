package tn.esprit.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import entities.ActiveMember;
import entities.SimpleMember;

@FacesConverter("identifiedUserConverter")
public class IdentifiedUserConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return context.getApplication().evaluateExpressionGet(context,
				"#{identity.identifiedUser}", SimpleMember.class);
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String equivalentString = null;
		if (value instanceof ActiveMember) {
			equivalentString = ((ActiveMember) value).getName();

		} else if (value instanceof SimpleMember) {
			equivalentString = ((SimpleMember) value).getName();
		}
		return equivalentString;
	}

}
