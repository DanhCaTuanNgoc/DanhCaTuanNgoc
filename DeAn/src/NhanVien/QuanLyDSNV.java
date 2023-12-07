package NhanVien;

import java.util.Scanner;

public class QuanLyDSNV {
	private DanhSachNhanVien ds = new DanhSachNhanVien(100);
	
	//constructor
	public QuanLyDSNV() {
		ds = new DanhSachNhanVien(100);
	}
	public QuanLyDSNV(DanhSachNhanVien a) {
		this.ds = a;
	}
	public QuanLyDSNV(QuanLyDSNV x) {
		this.ds = x.ds;
	}
	
	// get/set
	public DanhSachNhanVien getDs() {
		return ds;
	}
	public void setDs(DanhSachNhanVien x) {
		this.ds = x;
	}
	
	// methods
	public void menu() {
		ds.docfile();
		System.out.println();
		System.out.println("   =========================================");
		System.out.println("   !           ----- Menu -----            !");
		System.out.println("   !        1. Them nhan vien.             !");
		System.out.println("   !        2. Xem danh sach nhan vien.    !");
		System.out.println("   !        3. Tim kiem nhan vien.         !");
		System.out.println("   !        4. Sua nhan vien.              !");
		System.out.println("   !        5. Xoa nhan vien.              !");
		System.out.println("   !        6. Thong ke.                   !");
		System.out.println("   !        7. Thoat.                      !");
		System.out.println("   =========================================");
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.print(" - Chon hanh dong: ");
		int n = sc.nextInt();
		System.out.println("");
		switch(n) {
			case 1:
				ds.them();
				menu();
				break;
			case 2:
				ds.xemds();
				menu();
				break;
			case 3:
				ds.timkiem();
				menu();
				break;
			case 4:
				ds.sua();
				menu();
				break;
			case 5:
				ds.xoa();
				menu();
				break;
			case 6:
				ds.thongke();
				break;
			case 7:
				System.out.println("Hen gap lai !!!");
				ds.ghifile();
				break;
			default: 
				System.out.println(" Lua chon kh hop le. Hay thu lai!!!");
				menu();
                break;
		}
	}
}
