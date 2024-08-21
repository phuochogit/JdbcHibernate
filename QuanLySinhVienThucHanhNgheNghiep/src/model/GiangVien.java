package model;

public class GiangVien {
	private String id;
	private String name;
	public GiangVien() {
		super();
	}
	
	public GiangVien(String id) {
		super();
		this.id = id;
	}

	public GiangVien(String id, String name) {
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
		return "GiangVien [id=" + id + ", name=" + name + "]";
	}
	
}
