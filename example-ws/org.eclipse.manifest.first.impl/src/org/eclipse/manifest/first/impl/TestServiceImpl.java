package org.eclipse.manifest.first.impl;

import java.util.concurrent.Executors;

import org.eclipse.manifest.first.api.dto.TestDTO;
import org.eclipse.manifest.first.api.TestService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;

@Component
public class TestServiceImpl implements TestService {

	private PromiseFactory promiseFactory;
	
	@Activate
	public void activate() {
		promiseFactory = new PromiseFactory(Executors.newSingleThreadExecutor());
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
