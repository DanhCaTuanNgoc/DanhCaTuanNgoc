package Main;

import NhanVien.QuanLyDSNV;
import KhachHang.QuanLyDSKH;
import SanBay.QuanLyDSSB;
import HoaDon.QuanLyDSHD;
import ChuyenBay.QuanLyDSCB;
import TEST.DanhSachVe;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		while(true) {
			System.out.print(" 1. NV | 2. KH | 3. SB | 4.HD | 5.CB | 6.Ve : ");
			Scanner sc = new Scanner(System.in);
			int action = sc.nextInt();
			switch(action) {
			case 1:
				QuanLyDSNV nv = new QuanLyDSNV();
				nv.menu();
				break;
			case 2:
				QuanLyDSKH kh = new QuanLyDSKH();
				kh.menu();
				break;
			case 3:
				QuanLyDSSB sb = new QuanLyDSSB();
				sb.menu();
				break;
			case 4: 
				QuanLyDSHD hd = new QuanLyDSHD();
				hd.menu();
				break;
			case 5: 
				QuanLyDSCB cb = new QuanLyDSCB();
				cb.menu();
				break;
			case 6: 
				DanhSachVe dsVe = new DanhSachVe();
		        dsVe.NhapDanhSach();
		        dsVe.DocFileJava("Ve.txt");
		        dsVe.XuatDanhSach();
		        dsVe.ThaoTac();

				break;
			default :
				return;
			}
		}	
	}
}	
