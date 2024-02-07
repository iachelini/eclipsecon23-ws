package org.eclipse.code.first.impl;

import java.util.concurrent.Executors;

import org.eclipse.code.first.api.TestService;
import org.eclipse.code.first.api.dto.TestDTO;
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
