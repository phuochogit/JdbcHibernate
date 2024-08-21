package model;

public class DoanhNghiep {
	private String id;
	private String name;
	public DoanhNghiep() {
		super();
	}
	
	public DoanhNghiep(String id) {
		super();
		this.id = id;
	}

	public DoanhNghiep(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DoanhNghiep [id=" + id + ", name=" + name + "]";
	}
	
}
