package KhachHang;

import java.util.Arrays;
import java.util.Scanner;

final class DanhSachKhachHang {
	private KhachHang dsKhachHang[];
	private int tongKhachHang;
	
	//constructor
	public DanhSachKhachHang(int max) {
		dsKhachHang = new KhachHang[max];
		tongKhachHang = 0;
	}
	public DanhSachKhachHang(KhachHang dsKhachHang[], int tongKhachHang) {
		this.dsKhachHang = dsKhachHang;
		this.tongKhachHang = tongKhachHang;
	}
	public DanhSachKhachHang(DanhSachKhachHang a) {
		this.dsKhachHang = a.dsKhachHang;
		this.tongKhachHang = a.tongKhachHang;
	}
	
	
	// get/set
	public KhachHang[] getDsKhachHang() {
		return dsKhachHang;
	}
	public void setDsKhachHang(KhachHang[] dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}
	public int gettongKhachHang() {
		return tongKhachHang;
	}
	public void settongKhachHang(int tongKhachHang) {
		this.tongKhachHang = tongKhachHang;
	}
	
	// methods 
	public void them() {
		System.out.println("----- Them khach hang -----");
		KhachHang KhachHang = null;
		KhachHang = new KhachHang();
		dsKhachHang[this.tongKhachHang] = KhachHang;
		KhachHang.nhap();  
	}
	public void xemds() {
		System.out.println("----- Danh sach khach hang -----");
		System.out.println("Tong khach hang: " + this.tongKhachHang);
		for(KhachHang khachhang : dsKhachHang) {
			if(khachhang != null) {
				khachhang.xuat();
				System.out.println("");
			}
		} 
		System.out.println("");
	}
	public void xoa() {
		System.out.println("----- Xoa khach hang -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma khach hang can xoa: ");
		String x = sc.nextLine();
		int delete_point = -1;
		for(int i=0;i<this.tongKhachHang;i++) {
			if(dsKhachHang[i].getMaKhachHang().equalsIgnoreCase(x)) {
				delete_point = i;
				break;
			}
		}
		if(delete_point != -1) {
			for(int i=delete_point;i<this.tongKhachHang-1;i++) {
				dsKhachHang[i] = dsKhachHang[i+1];
			} 
			this.tongKhachHang--;
			dsKhachHang = Arrays.copyOf(dsKhachHang, this.tongKhachHang);
			System.out.println("Da xoa ma khach hang " + x);
		} else {
			System.out.println("Khong tim thay ma khach hang " + x);
		}
		System.out.println("");
	}
	public void timkiem() {
		System.out.println("----- Tim kiem khach hang -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma khach hang can tim kiem: ");
		String x = sc.nextLine(); int m = 1;
		for(int i=0;i<this.tongKhachHang;i++) {
			if(dsKhachHang[i].getMaKhachHang().equalsIgnoreCase(x)) {
				dsKhachHang[i].xuat();
				System.out.println("");
			}
		}
		if(m == 1) {
			System.out.println("Khong tim thay khach hang co ma " + x);
		}
		System.out.println("");
	}
	public void sua() {
		System.out.println("----- Sua khach hang -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma khach hang can sua: ");
		String x = sc.nextLine();
			for(int i=0;i<this.tongKhachHang;i++) {
				if(dsKhachHang[i].getMaKhachHang().equalsIgnoreCase(x)) {
					dsKhachHang[i].nhap();
				}
		}
		System.out.println("");
	}
	public void thongke() {
		System.out.println("...Updating");
	}
}
