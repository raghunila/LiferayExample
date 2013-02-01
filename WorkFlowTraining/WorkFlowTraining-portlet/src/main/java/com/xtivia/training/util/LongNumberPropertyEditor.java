/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.util;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author rnila
 */
public class LongNumberPropertyEditor extends PropertyEditorSupport {
	@Override
	public String getAsText() {
		String returnVal = "";
		if(getValue() instanceof Long) {
			returnVal = String.valueOf((Long)getValue());
		}
		if(getValue() != null && getValue() instanceof String[]) {
			returnVal = ((String[]) getValue())[0];
		}
		return returnVal;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(Long.valueOf(text));
	}
}