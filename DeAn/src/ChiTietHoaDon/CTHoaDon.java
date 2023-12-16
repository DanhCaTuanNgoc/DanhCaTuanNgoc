package ChiTietHoaDon;

import java.util.Scanner;
import HoaDon.DanhSachHoaDon;
import Ve.DanhSachVe;

import java.util.InputMismatchException;

public class CTHoaDon {
	private String maHoaDon;
	private String maVe;
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
		deleted = 0;
	}
	public CTHoaDon(String mahoadon, String mave, int giatien, int deleted) {
		this.maHoaDon = mahoadon;
		this.maVe = mave;
		this.giaTien = giatien;
		this.deleted = deleted;
	}
	public CTHoaDon(CTHoaDon a) {
		this.maHoaDon = a.maHoaDon;
		this.maVe = a.maVe;
		this.giaTien = a.giaTien;
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
	// methods
	
	public void nhap() {
		hd.docfile();
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(" - Nhap ma hoa don: ");
				this.maHoaDon = sc.nextLine();
				if(hd.Check_Available(this.maHoaDon)) {
					System.err.println("\nMa hoa don da ton tai !!!");
				} else {
					break;
				}
			} catch(InputMismatchException in){System.out.println("LOI! VUI LONG NHAP LAI!");sc.nextLine();}
		}
		boolean fk=true;
		while(fk){
			System.out.print(" - Nhap ma ve: ");
			this.maVe = sc.nextLine();
			if(ve.Check_Available(maVe)){
				if (cthdd.Check_Available(maVe)) {
					System.err.println(" Ve da duoc dat ! Vui long chon ma ve khac !");
				}else {
					fk=false;
				}
			}else{
				System.out.println(" Ma ve khong ton tai ! Vui long chon ma ve khac !");	
			}
		}
		System.out.print(" - Nhap gia tien: ");
		this.giaTien = sc.nextInt();	
	}
	
	public void xuat() {
		System.out.printf("| %-10s | %-10s | %-15s ",maHoaDon, maVe, giaTien);
	}
}
