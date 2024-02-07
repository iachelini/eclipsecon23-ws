package org.eclipse.code.first.consumer;

import org.eclipse.code.first.api.TestService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.promise.Promise;

@Component
public class TestConsumerExtra {
	
	private TestService testService;
	
	@Activate
	public TestConsumerExtra(@Reference TestService testService) {
		this.testService = testService;
		
		Promise<String> promise = testService.doSomething();
		promise.onSuccess(System.out::println);
	}
	
}
