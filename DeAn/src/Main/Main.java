package Main;

import NhanVien.QuanLyDSNV;
import KhachHang.QuanLyDSKH;
import SanBay.QuanLyDSSB;
import HoaDon.QuanLyDSHD;
import ChuyenBay.QuanLyDSCB;
import Ve.QuanLyDSV;
import HoaDon.QuanLyDSHD;
import ChiTietHoaDon.QuanLyDSCTHD;
import MayBay.QuanLyDSMB;
import java.util.Scanner;

import HoaDon.DanhSachHoaDon;
import Ve.DanhSachVe;
import NhanVien.DanhSachNhanVien;
import ChuyenBay.DanhSachChuyenBay;
import SanBay.DanhSachSanBay;
import MayBay.DanhSachMayBay;
import KhachHang.DanhSachKhachHang;
import LoiNhuan.LoiNhuan;

public class Main {
	
	static DanhSachHoaDon dshd = new DanhSachHoaDon(100);
	static DanhSachVe dsve = new DanhSachVe(100);
	static DanhSachNhanVien dsnv = new DanhSachNhanVien(100);
	static DanhSachSanBay dssb = new DanhSachSanBay(100);
	static DanhSachMayBay dsmb = new DanhSachMayBay(100);
	static DanhSachKhachHang dskh = new DanhSachKhachHang(100);
	static DanhSachChuyenBay dscb = new DanhSachChuyenBay(100);
	static LoiNhuan ln = new LoiNhuan(); 
	
	public static void main(String[]args) {
		dshd.docfile();
		dsve.docfile();
		dsnv.docfile();
		dssb.docfile();
		dsmb.docfile();
		dskh.docfile();
		dscb.docfile();
		while(true) {
			System.out.println("");
			System.out.println("");
			System.out.println("	===================================================");
			System.out.println("	!        ----- Ung dung ban ve may bay -----      !");
			System.out.println("	!             1. Quan ly ve.                      !");
			System.out.println("	!             2. Quan ly khach hang.              !");
			System.out.println("	!             3. Quan ly chuyen bay.              !");
			System.out.println("	!             4. Quan ly san bay.                 !");
			System.out.println("	!             5. Quan ly may bay.                 !");
			System.out.println("	!             6. Quan ly nhan vien.               !");
			System.out.println("	!             7. Quan ly hoa don.                 !");
			System.out.println("	!             8. Quan ly chi tiet hoa don.        !");
			System.out.println("   	!             9. Thong ke                         !");
			System.out.println("	!             0. Thoat.                           !");
			System.out.println("	===================================================");			
			Scanner sc = new Scanner(System.in);
			System.out.println("");
			System.out.print(" - Chon hanh dong: ");
			int action = sc.nextInt();
			System.out.println("");
			switch(action) {
			case 6:
				QuanLyDSNV nv = new QuanLyDSNV();
				nv.menu();
				break;
			case 2:
				QuanLyDSKH kh = new QuanLyDSKH();
				kh.menu();
				break;
			case 4:
				QuanLyDSSB sb = new QuanLyDSSB();
				sb.menu();
				break;
			case 7: 
				QuanLyDSHD hd = new QuanLyDSHD();
				hd.menu();
				break;
			case 3: 
				QuanLyDSCB cb = new QuanLyDSCB();
				cb.menu();
				break;
			case 1: 
				QuanLyDSV ve = new QuanLyDSV();
		        ve.menu();
				break;
			case 8:
				QuanLyDSCTHD cthd = new QuanLyDSCTHD();
				cthd.menu();
				break;
			case 5: 
				QuanLyDSMB mb = new QuanLyDSMB();
				mb.menu();
				break;
			case 9: 
				System.out.println(" ------------ Thong ke ------------");
				dsve.thongke();
				dscb.thongke();
				dsmb.thongke();
				dssb.thongke();
				dshd.thongke();
				dsnv.thongke();
				dskh.thongke();
				ln.saoke();
				System.out.println("");
				sc.nextLine();
				System.out.print("Thoat (phim bat ky): ");
				sc.nextLine();
				break;
			case 0:
				System.out.println(" Hen gap lai :> ");
				return;
			default :
				System.out.println(" Vui long nhap lai !!!");
				break;
			}
		}	
	}
}	
