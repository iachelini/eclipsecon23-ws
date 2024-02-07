package org.eclipse.code.first.extra;

import java.util.concurrent.Executors;

import org.eclipse.code.first.api.TestService;
import org.eclipse.code.first.api.dto.TestDTO;
import org.eclipse.code.first.extra.annotation.ComponentPropertyTypeExample;
import org.osgi.annotation.bundle.Header;
import org.osgi.annotation.bundle.Referenced;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.annotations.RequireConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;

@Component
@ComponentPropertyTypeExample(additional = "bla")
@Designate(ocd = ComponentPropertyTypeExample.class)
@Header(name = "Class-Manifest-Header", value = "${@class}")
@Referenced({BundleContext.class,RequireConfigurationAdmin.class})
@RequireConfigurationAdmin
public class TestServiceExtraImpl implements TestService {

	private PromiseFactory promiseFactory;
	private Class<?> loadClass;

	@Activate
	public TestServiceExtraImpl(ComponentPropertyTypeExample props) {
		promiseFactory = new PromiseFactory(Executors.newSingleThreadExecutor());
		try {
			loadClass = getClass().getClassLoader().loadClass("org.osgi.framework.BundleContext");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Promise<String> doSomething() {
		return promiseFactory.resolved("Hello World!");
	}

	@Override
	public TestDTO getDTO() {
		return new TestDTO();
	}
	
}
