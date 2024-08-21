package model;

public class Sach {
	private String id;
	private String tenSach;
	private float giaBan;
	private int namXuatBan;
	public Sach() {
		super();
	} //Tao constructor rong de tao ra doi tuong chua co thong tin gi, vi du nhu Sach s = new Sach();
	public Sach(String id, String tenSach, float giaBan, int namXuatBan) {
		super();
		this.id = id;
		this.tenSach = tenSach;
		this.giaBan = giaBan;
		this.namXuatBan = namXuatBan;
	}//Tao constructor co truyen tham so de truyen tham so cho doi tuong, vi du Sach s = new Sach(1,"Tony Buoi Sang","50000","2000");
	public String getId() {//Tao get de layID() o bat cu dau, boi vi id chi duoc lay thong qua doi tuong s.id.
		return id;
	}
	public void setId(String id) {//Tao set de taoID() o bat cu dau, boi vi id chi duoc tao thong qua doi tuong s.id.
		this.id = id;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	
	
}
