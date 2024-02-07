package org.eclipse.manifest.first.api;

import org.eclipse.manifest.first.api.dto.TestDTO;
import org.osgi.util.promise.Promise;

public interface TestService {

	public Promise<String> doSomething();
	
	public TestDTO getDTO();
}
