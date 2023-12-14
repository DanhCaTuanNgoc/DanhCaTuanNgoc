package Main;

import NhanVien.QuanLyDSNV;
import KhachHang.QuanLyDSKH;
import SanBay.QuanLyDSSB;
import HoaDon.QuanLyDSHD;
import ChuyenBay.QuanLyDSCB;
import TEST.DanhSachVe;
import HoaDon.QuanLyDSHD;
import ChiTietHoaDon.QuanLyDSCTHD;
import MayBay.QuanLyDSMB;
import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		while(true) {
			System.out.println(" ====================================================");
			System.out.println(" !        ----- Ung dung ban ve may bay -----       !");
			System.out.println(" !             1. Quan ly ve.                       !");
			System.out.println(" !             2. Quan ly khach hang.               !");
			System.out.println(" !             3. Quan ly chuyen bay.               !");
			System.out.println(" !             4. Quan ly san bay.                  !");
			System.out.println(" !             5. Quan ly may bay.                  !");
			System.out.println(" !             6. Quan ly nhan vien.                !");
			System.out.println(" !             7. Quan ly hoa don.                  !");
			System.out.println(" !             8. Quan ly chi tiet hoa don.         !");
			System.out.println(" !             0. Thoat.                            !");
			System.out.println(" ====================================================");			
			Scanner sc = new Scanner(System.in);
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
				DanhSachVe dsVe = new DanhSachVe();
		        dsVe.ThaoTac();
				break;
			case 8:
				QuanLyDSCTHD cthd = new QuanLyDSCTHD();
				cthd.menu();
				break;
			case 5: 
				QuanLyDSMB mb = new QuanLyDSMB();
				mb.menu();
				break;
			default :
				return;
			}
		}	
	}
}	
