package com.rh.validators;

import javax.faces.application.FacesMessage;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.validator.FacesValidator;

@FacesValidator("validadorCedula")
public class ValidadorCedula implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String cedula = (String) value;
        if (!validaCedula(cedula)) {
            FacesMessage message = new FacesMessage("La cédula no es válida.");
            throw new ValidatorException(message);
        }
    }

    public static boolean validaCedula(String pCedula) {
        int vnTotal = 0;
        String vcCedula = pCedula.replace("-", "");
        int pLongCed = vcCedula.trim().length();
        int[] digitoMult = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1 };

        if (pLongCed != 11)
            return false;

        for (int vDig = 1; vDig <= pLongCed; vDig++) {
            int vCalculo = Integer.parseInt(vcCedula.substring(vDig - 1, vDig)) * digitoMult[vDig - 1];
            if (vCalculo < 10)
                vnTotal += vCalculo;
            else
                vnTotal += Integer.parseInt(String.valueOf(vCalculo).substring(0, 1))
                        + Integer.parseInt(String.valueOf(vCalculo).substring(1, 2));
        }

        return vnTotal % 10 == 0;
    }
}