package HoaDon;

import java.util.Arrays;
import java.util.Scanner;

final class DanhSachHoaDon {
	private HoaDon dsHoaDon[];
	private int tongHoaDon;
	
	//constructor
	public DanhSachHoaDon(int max) {
		dsHoaDon = new HoaDon[max];
		tongHoaDon = 0;
	}
	public DanhSachHoaDon(HoaDon dsHoaDon[], int tongHoaDon) {
		this.dsHoaDon = dsHoaDon;
		this.tongHoaDon = tongHoaDon;
	}
	public DanhSachHoaDon(DanhSachHoaDon a) {
		this.dsHoaDon = a.dsHoaDon;
		this.tongHoaDon = a.tongHoaDon;
	}
	
	
	// get/set
	public HoaDon[] getDsHoaDon() {
		return dsHoaDon;
	}
	public void setDsHoaDon(HoaDon[] dsHoaDon) {
		this.dsHoaDon = dsHoaDon;
	}
	public int gettongHoaDon() {
		return tongHoaDon;
	}
	public void settongHoaDon(int tongHoaDon) {
		this.tongHoaDon = tongHoaDon;
	}
	
	// methods 
	public void them() {
		System.out.println("----- Them hoa don -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Ban muon them bao nhieu hoa don: ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			HoaDon HoaDon = null;
			HoaDon = new HoaDon();
			dsHoaDon[this.tongHoaDon] = HoaDon;
			HoaDon.nhap();  
			this.tongHoaDon++;
		}
		System.out.println("");
	}
	public void xemds() {
		System.out.println("----- Danh sach hoa don -----");
		System.out.println("Tong hoa don: " + this.tongHoaDon);
		for(HoaDon hoaDon : dsHoaDon) {
			if(hoaDon != null) {
				hoaDon.xuat();
				System.out.println("");
			}
		} 
		System.out.println("");
	}
	public void xoa() {
		System.out.println("----- Xoa hoa don -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma hoa don can xoa: ");
		String x = sc.nextLine();
		int delete_point = -1;
		for(int i=0;i<this.tongHoaDon;i++) {
			if(dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(x)) {
				delete_point = i;
				break;
			}
		}
		if(delete_point != -1) {
			for(int i=delete_point;i<this.tongHoaDon-1;i++) {
				dsHoaDon[i] = dsHoaDon[i+1];
			} 
			this.tongHoaDon--;
			dsHoaDon = Arrays.copyOf(dsHoaDon, this.tongHoaDon);
			System.out.println("Da xoa ma hoa don " + x);
		} else {
			System.out.println("Khong tim thay ma hoa don " + x);
		}
		System.out.println("");
	}
	public void timkiem() {
		System.out.println("----- Tim kiem hoa don -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma hoa don can tim kiem: ");
		String x = sc.nextLine(); int m = 1;
		for(int i=0;i<this.tongHoaDon;i++) {
			if(dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(x)) {
				dsHoaDon[i].xuat();
				System.out.println("");
			}
		}
		if(m == 1) {
			System.out.println("Khong tim thay hoa don co ma " + x);
		}
		System.out.println("");
	}
	public void sua() {
		System.out.println("----- Sua hoa don -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma hoa don can sua: ");
		String x = sc.nextLine();
			for(int i=0;i<this.tongHoaDon;i++) {
				if(dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(x)) {
					dsHoaDon[i].nhap();
				}
		}
		System.out.println("");
	}
	public void thongke() {
		System.out.println("...Updating");
	}
}
