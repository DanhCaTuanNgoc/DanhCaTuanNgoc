package ChiTietHoaDon;

import java.util.Scanner;
import HoaDon.DanhSachHoaDon;
import Ve.DanhSachVe;


public class CTHoaDon {
	private String maHoaDon;
	private String maVe;
	private int khuyenmai;
	private int giaTien;
	private int deleted;
	DanhSachVe ve=new DanhSachVe(100);
	DanhSachHoaDon hd = new DanhSachHoaDon(100);
	DanhSachCTHoaDon cthdd=new DanhSachCTHoaDon(100);
	// constructor
	public CTHoaDon() {
		maHoaDon = "";
		maVe = "";
		giaTien = 0;
		khuyenmai=0;
		deleted = 0;
	}
	public CTHoaDon(String mahoadon, String mave, int giatien,int khuyenmai, int deleted) {
		this.maHoaDon = mahoadon;
		this.maVe = mave;
		this.giaTien = giatien;
		this.khuyenmai=khuyenmai;
		this.deleted = deleted;
	}
	public CTHoaDon(CTHoaDon a) {
		this.maHoaDon = a.maHoaDon;
		this.maVe = a.maVe;
		this.giaTien = a.giaTien;
		this.khuyenmai=a.khuyenmai;
		this.deleted = a.deleted;
	}
	
	// get/set
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public int getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getKhuyenmai() {
		return khuyenmai;
	}
	public void setKhuyenmai(int khuyenmai) {
		this.khuyenmai = khuyenmai;
	}
	
	// methods
	
	public void nhap() {
		ve.docfile();
		hd.docfile();
		cthdd.docfile();
		Scanner sc = new Scanner(System.in);
		while(true) {
				System.out.print(" - Nhap ma hoa don: ");
				this.maHoaDon = sc.nextLine();
				if(hd.Check_Available(this.maHoaDon)) {
					break;
				} else {
					System.out.println("\t !! Ma hoa don khong ton tai !!");
				}
		}
		boolean fk=true;
		while(fk){
			System.out.print(" - Nhap ma ve: ");
			this.maVe = sc.nextLine();
			if(ve.Check_Available(maVe)){
				if (cthdd.Check_Available(maVe)) {
					System.out.println("\t !! Ve da duoc dat, chon ma ve khac !!");
				}else {
					fk=false;
				}
			}else{
				System.out.println("\t !! Ma ve khong ton tai !!");	
			}
		}
		System.out.print(" - Nhap khuyen mai (%): ");
		this.khuyenmai=sc.nextInt();
		this.giaTien=ve.tinhgiamgia(maVe, khuyenmai);
		System.out.println(" - Thanh tien: "+this.giaTien);
	}
	
	public void xuat() {
		System.out.printf("| %-10s | %-10s | %-15s | %-10s",maHoaDon, maVe, giaTien,khuyenmai);
	}
}
