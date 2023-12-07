package Ve;

import java.util.Scanner;

final class QuanLyDSV {
	private DanhSachVe ds = new DanhSachVe();
	
	// constructor 
	public void QuanLyDSV() {
		ds = new DanhSachVe();
	} 
	public void QuanLyDSV(DanhSachVe a) {
		this.ds = a;
	}
	public void QuanLyDSV(QuanLyDSV a) {
		ds = a.ds;
	}
	
	// get/set
	public DanhSachVe getDs() {
		return ds;
	}
	public void setDs(DanhSachVe ds) {
		this.ds = ds;
	}
	
	// methods
	public void menu() {
		System.out.println("");
		System.out.println("                 ----- Menu -----");
		System.out.println("                 1. Them ve.");
		System.out.println("                 2. Xem danh sach ve.");
		System.out.println("                 3. Tim kiem ve.");
		System.out.println("                 4. Sua ve.");
		System.out.println("                 5. Xoa ve.");
		System.out.println("                 6. Nang hang ve.");
		System.out.println("                 7. Thong ke.");
		System.out.println("                 8. Thoat.");
		Scanner sc = new Scanner(System.in);
		System.out.print("Chon hanh dong: ");
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
				ds.nanghang();
				menu();
				break;
			case 7:
				ds.thongke();
				menu();
				break;
			case 8:
				break;
			default: 
				System.out.println("Lua chon kh hop le. Hay thu lai!!!");
                break;
		}
	}
}
