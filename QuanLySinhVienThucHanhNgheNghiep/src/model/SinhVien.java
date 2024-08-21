package model;

public class SinhVien {
	private String id;
	private String name;
	public SinhVien() {
		super();
	}
	public SinhVien(String id) {
		super();
		this.id = id;
	}
	public SinhVien(String id, String name) {
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
		return "SinhVien [id=" + id + ", name=" + name + "]";
	}
	
}
