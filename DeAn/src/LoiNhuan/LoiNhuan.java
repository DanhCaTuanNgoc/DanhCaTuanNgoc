package LoiNhuan;
import HoaDon.DanhSachHoaDon;
import Ve.DanhSachVe;

public class LoiNhuan {
	final static double thue = 0.15; // thue doanh nghiep
	private String Tong;
	DanhSachVe dsve=new DanhSachVe(100);
	DanhSachHoaDon dshd=new DanhSachHoaDon(100);
	
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
	public int Sotienchi(){
		return dsve.tongtien();
	}
	public int Sotienban(){
		return dshd.tongtien();
	}
	public int LoiNhuanbd(){
		return Sotienban()-Sotienchi();
	}
	public int Loinhuansc(){
		return (int)(LoiNhuanbd()-(LoiNhuanbd()*thue));
	}
	public void saoke(){
		LoiNhuan ln = new LoiNhuan();
		System.out.println("\n\t & Loi nhuan &");
		System.out.println(" + Tong chi : " + ln.Sotienchi());
		System.out.println(" + Tong ban : " + ln.Sotienban());
		System.out.println(" + Tong thu truoc thue ( thue doanh nghiep ) :" + ln.LoiNhuanbd());
		System.out.println(" + Tong thu sau thue ( thue doanh nghiep ) : " + ln.Loinhuansc());
	}
}