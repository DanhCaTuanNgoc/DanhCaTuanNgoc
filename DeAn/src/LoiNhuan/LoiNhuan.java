package LoiNhuan;

public class LoiNhuan {
	private String Tong;
	// constructor
	public LoiNhuan() {
		Tong = "";
	}
	public LoiNhuan(String tong) {
		tong = this.Tong;
	}
	public LoiNhuan(LoiNhuan a) {
		a.Tong = this.Tong;
    }

	// get/set
	public String getTong() {
		return Tong;
	}
	public void setTong(String tong) {
		Tong = tong;
	}
	
	// methods
}