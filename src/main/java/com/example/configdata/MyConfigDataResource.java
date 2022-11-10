package com.example.configdata;

import java.util.Objects;

import org.springframework.boot.context.config.ConfigDataResource;

class MyConfigDataResource extends ConfigDataResource {

	private final String location;

	private final String key1;

	private final String key2;

	MyConfigDataResource(String location, String key1, String key2) {
		this.location = location;
		this.key1 = key1;
		this.key2 = key2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.key1, this.key2, this.location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		MyConfigDataResource other = (MyConfigDataResource) obj;
		return Objects.equals(this.key1, other.key1) && Objects.equals(this.key2, other.key2)
				&& Objects.equals(this.location, other.location);
	}

	@Override
	public String toString() {
		return this.location;
	}

	public String getKey1() {
		return this.key1;
	}

	public String getKey2() {
		return this.key2;
	}

}
