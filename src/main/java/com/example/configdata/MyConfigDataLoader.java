package com.example.configdata;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.springframework.boot.context.config.ConfigData;
import org.springframework.boot.context.config.ConfigDataLoader;
import org.springframework.boot.context.config.ConfigDataLoaderContext;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

public class MyConfigDataLoader implements ConfigDataLoader<MyConfigDataResource> {

	@Override
	public ConfigData load(ConfigDataLoaderContext context, MyConfigDataResource resource)
			throws IOException, ConfigDataResourceNotFoundException {
		PropertySource<?> propertySource = new MapPropertySource("my-" + resource,
				doLoad(resource.getKey1(), resource.getKey2()));
		return new ConfigData(Collections.singleton(propertySource));
	}

	private Map<String, Object> doLoad(String key1, String key2) {
		System.out.println("Would load here using " + key1 + " " + key2);
		return Collections.singletonMap("some", "value");
	}

}
