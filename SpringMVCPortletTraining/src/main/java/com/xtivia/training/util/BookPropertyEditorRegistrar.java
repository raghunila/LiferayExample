/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.util;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 *
 * @author rnila
 */
public class BookPropertyEditorRegistrar implements PropertyEditorRegistrar {
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Long.class, new LongNumberPropertyEditor());
	}
}
