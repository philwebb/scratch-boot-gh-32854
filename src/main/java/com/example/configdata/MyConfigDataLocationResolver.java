package com.example.configdata;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.config.ConfigDataLocation;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.boot.context.config.ConfigDataLocationResolver;
import org.springframework.boot.context.config.ConfigDataLocationResolverContext;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.context.properties.bind.Bindable;

public class MyConfigDataLocationResolver implements ConfigDataLocationResolver<MyConfigDataResource> {

	private static final String PREFIX = "my:";

	@Override
	public boolean isResolvable(ConfigDataLocationResolverContext context, ConfigDataLocation location) {
		return location.hasPrefix(PREFIX);
	}

	@Override
	public List<MyConfigDataResource> resolve(ConfigDataLocationResolverContext context, ConfigDataLocation location)
			throws ConfigDataLocationNotFoundException, ConfigDataResourceNotFoundException {
		Map<String, String> keys = context.getBinder().bind("my", Bindable.mapOf(String.class, String.class))
				.orElse(Collections.emptyMap());
		String key1 = keys.get("key1");
		String key2 = keys.get("key2");
		return Collections.singletonList(new MyConfigDataResource(location.getNonPrefixedValue(PREFIX), key1, key2));
	}

}
