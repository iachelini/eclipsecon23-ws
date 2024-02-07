package org.eclipse.code.first.consumer;

import org.eclipse.code.first.api.TestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.promise.Promise;

@Component
public class TestConsumer {
	
	@Reference
	private TestService testService;
	
	public void activate() {
		Promise<String> promise = testService.doSomething();
		promise.onSuccess(System.out::println);
	}
	
}
