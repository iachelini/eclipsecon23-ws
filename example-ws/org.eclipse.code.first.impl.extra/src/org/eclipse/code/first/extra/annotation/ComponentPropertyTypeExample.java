package org.eclipse.code.first.extra.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.osgi.service.component.annotations.ComponentPropertyType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Retention(CLASS)
@Target(TYPE)
@ComponentPropertyType
@ObjectClassDefinition
public @interface ComponentPropertyTypeExample {

	String PREFIX_ = "example.";
	
	String value() default "true";

	String additional() default "";
}
