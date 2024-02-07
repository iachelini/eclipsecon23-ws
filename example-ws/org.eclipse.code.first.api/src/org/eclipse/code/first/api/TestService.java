package org.eclipse.code.first.api;

import org.eclipse.code.first.api.dto.TestDTO;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.util.promise.Promise;

@ProviderType
public interface TestService {

	public Promise<String> doSomething();
	
	public TestDTO getDTO();
}
