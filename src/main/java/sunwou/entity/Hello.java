package sunwou.entity;

import org.mongodb.morphia.annotations.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Hello {

	private String name;
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Hello [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
