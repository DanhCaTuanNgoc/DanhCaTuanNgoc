package TuyenBay;
import java.util.Scanner;

public class QuanLyDSTB {
	private DanhSachTuyenBay ds = new DanhSachTuyenBay(9999);
	
	//constructor
	public QuanLyDSTB () {
		ds = new DanhSachTuyenBay(9999);
	}
	public QuanLyDSTB(DanhSachTuyenBay a) {
		this.ds = a;
	}
	public QuanLyDSTB(QuanLyDSTB a) {
		this.ds = a.ds;
	}
	// get/set
	public DanhSachTuyenBay getDs() {
		return ds;
	}
	public void setDs(DanhSachTuyenBay ds) {
		this.ds = ds;
	}
	
	// methods
	public void menu() {
		System.out.println("----- Menu -----");
		System.out.println("1. Them tuyen bay.");
		System.out.println("2. Xem danh sach tuyen bay.");
		System.out.println("3. Tim kiem tuyen bay.");
		System.out.println("4. Sua tuyen bay.");
		System.out.println("5. Xoa tuyen bay.");
		System.out.println("6. Thong ke.");
		System.out.println("7. Thoat.");
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
				ds.thongke();
				menu();
				break;
			case 7:
				break;
			default: 
				System.out.println("Lua chon kh hop le. Hay thu lai!!!");
                break;
		}
	}
}
