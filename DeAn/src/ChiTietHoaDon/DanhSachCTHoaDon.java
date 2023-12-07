package ChiTietHoaDon;

import java.util.Arrays;
import java.util.Scanner;

final class DanhSachCTCTHoaDon {
	private CTHoaDon dsCTHoaDon[];
	private int tongCTHoaDon;
	
	//constructor
	public DanhSachCTCTHoaDon(int max) {
		dsCTHoaDon = new CTHoaDon[max];
		tongCTHoaDon = 0;
	}
	public DanhSachCTCTHoaDon(CTHoaDon dsCTHoaDon[], int tongCTHoaDon) {
		this.dsCTHoaDon = dsCTHoaDon;
		this.tongCTHoaDon = tongCTHoaDon;
	}
	public DanhSachCTCTHoaDon(DanhSachCTCTHoaDon a) {
		this.dsCTHoaDon = a.dsCTHoaDon;
		this.tongCTHoaDon = a.tongCTHoaDon;
	}
	
	
	// get/set
	public CTHoaDon[] getDsCTHoaDon() {
		return dsCTHoaDon;
	}
	public void setDsCTHoaDon(CTHoaDon[] dsCTHoaDon) {
		this.dsCTHoaDon = dsCTHoaDon;
	}
	public int gettongCTHoaDon() {
		return tongCTHoaDon;
	}
	public void settongCTHoaDon(int tongCTHoaDon) {
		this.tongCTHoaDon = tongCTHoaDon;
	}
	
	// methods 
	public void them() {
		System.out.println("----- Them chi tiet hoa don -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Ban muon them bao nhieu chi tiet hoa don: ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			CTHoaDon CTHoaDon = null;
			CTHoaDon = new CTHoaDon();
			dsCTHoaDon[this.tongCTHoaDon] = CTHoaDon;
			CTHoaDon.nhap();  
			this.tongCTHoaDon++;
		}
		System.out.println("");
	}
	public void xemds() {
		System.out.println("----- Danh sach chi tiet hoa don -----");
		System.out.println("Tong chi tiet hoa don: " + this.tongCTHoaDon);
		for(CTHoaDon ct : dsCTHoaDon) {
			if(ct != null) {
				ct.xuat();
				System.out.println("");
			}
		} 
		System.out.println("");
	}
	public void xoa() {
		System.out.println("----- Xoa chi tiet hoa don -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma chi tiet hoa don can xoa: ");
		String x = sc.nextLine();
		int delete_point = -1;
		for(int i=0;i<this.tongCTHoaDon;i++) {
			if(dsCTHoaDon[i].getMaHoaDon().equalsIgnoreCase(x)) {
				delete_point = i;
				break;
			}
		}
		if(delete_point != -1) {
			for(int i=delete_point;i<this.tongCTHoaDon-1;i++) {
				dsCTHoaDon[i] = dsCTHoaDon[i+1];
			} 
			this.tongCTHoaDon--;
			dsCTHoaDon = Arrays.copyOf(dsCTHoaDon, this.tongCTHoaDon);
			System.out.println("Da xoa ma chi tiet hoa don " + x);
		} else {
			System.out.println("Khong tim thay ma chi tiet hoa don " + x);
		}
		System.out.println("");
	}
	public void timkiem() {
		System.out.println("----- Tim kiem chi tiet hoa don -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma chi tiet hoa don can tim kiem: ");
		String x = sc.nextLine(); int m = 1;
		for(int i=0;i<this.tongCTHoaDon;i++) {
			if(dsCTHoaDon[i].getMaHoaDon().equalsIgnoreCase(x)) {
				dsCTHoaDon[i].xuat();
				System.out.println("");
			}
		}
		if(m == 1) {
			System.out.println("Khong tim thay chi tiet hoa don co ma " + x);
		}
		System.out.println("");
	}
	public void sua() {
		System.out.println("----- Sua chi tiet hoa don -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma chi tiet hoa don can sua: ");
		String x = sc.nextLine();
			for(int i=0;i<this.tongCTHoaDon;i++) {
				if(dsCTHoaDon[i].getMaHoaDon().equalsIgnoreCase(x)) {
					dsCTHoaDon[i].nhap();
				}
		}
		System.out.println("");
	}
	public void thongke() {
		System.out.println("...Updating");
	}
}
