package KhachHang;

import java.util.Scanner;

public class KhachHang {
	private String maKhachHang;
	private String ho;
	private String ten;
	private String cccd;
	private String diaChi;
    private String sdt;
    private int deleted = 0;
	// constructor
	public KhachHang() {
		maKhachHang = "";
		ho = "";
		ten = "";
		cccd = "";
		diaChi = "";
        sdt = "";
        deleted = 0;
	}
	public KhachHang(String makhachhang, String ho, String ten, String cccd, String diachi, String sdt, int deleted) {
		this.maKhachHang = makhachhang;
		this.ho = ho;
		this.ten = ten;
		this.cccd = cccd;
		this.diaChi = diachi;
        this.sdt = sdt;
        this.deleted = deleted;
	}
	public KhachHang(KhachHang a) {
		this.maKhachHang = a.maKhachHang;
		this.ho = a.ho;
		this.ten = a.ten;
		this.diaChi = a.diaChi;
		this.sdt = a.sdt;
		this.deleted = a.deleted;
	}
	
	//get/set
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleleted(int deleted) {
		this.deleted = deleted;
	}
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma khach hang: ");
		this.maKhachHang = sc.nextLine();
		System.out.print("Nhap ho: ");
		this.ho = sc.nextLine();
		System.out.print("Nhap ten: ");
		this.ten = sc.nextLine();
		System.out.print("Nhap can cuoc cong dan: ");
		this.cccd = sc.nextLine();	
		System.out.print("Nhap dia chi: ");
		this.diaChi = sc.nextLine();
		System.out.print("Nhap sdt: ");
		this.sdt = sc.nextLine();
	}
	
	public void xuat() {
		System.out.print(maKhachHang + "\t" + ho + "\t" + ten + "\t" + ho + "\t" + diaChi + "\t" + sdt);
	}
}
	