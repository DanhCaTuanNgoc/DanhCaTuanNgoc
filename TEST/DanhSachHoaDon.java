package TEST;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class DanhSachHoaDon {
	ChiTietHoaDon[] hd;
	private int n, a = 0;
	Scanner sc = new Scanner(System.in);
	
	//CONSTRUCTOR
	public DanhSachHoaDon() {
		
	}
	//CÁC HÀM NHẬP XUẤT DANH SÁCH
	public void NhapDanhSach() {
		System.out.print("Nhap so luong hoa don: ");
		n = sc.nextInt();
		sc.nextLine();
		hd = new ChiTietHoaDon[n];
		for(int i = 0; i < n; i++) {
			System.out.print("\n\t\t\t\t\tHoa don thu " + (i + 1) + "\n");
			System.err.println("\nNhap ma hoa don toi thieu 3 va toi da 4 ki tu");
			hd[i] = new ChiTietHoaDon();
			hd[i].Nhap();
			GhiFileJava("HoaDon.txt");
			if(i > 0) {
				ThayDoiMHD(i);
			}
		}
	}
	public void XuatDanhSach(){
		System.out.println("\t\t\t\t\t\t\t\t=====DANH SÁCH HOÁ ĐƠN=====");
		System.out.println("\n================================================================================================================================================================================================================");
		System.out.format("|| %4s | %10s | %10s | %30s | %25s | %15s | %15s | %15s | %15s  ||\n", "STT", "MA HOA DON", "MA KHACH HANG", "HO TEN KHACH HANG", "NHAN VIEN PHU TRACH", "MA VE", "SO LUONG", "GIA", "THANH TIEN");
		try {
			for(int i = 0; i < n; i++) {
				System.out.format("|| %4s |", (i + 1));
				hd[i].Xuat();
			}
		}catch(NullPointerException npe) {
			
		}
		System.out.println("================================================================================================================================================================================================================");
		
	}
	
	//CÁC THAO TÁC TRÊN DANH SÁCH
	public void ThayDoiMHD(int i) {
		String hoadon, maHoaDon;
		maHoaDon = hd[i].getMaHoaDon();
		do {
			if(KiemTraMHD(maHoaDon, i)) {
				XuatDanhSach();
				System.err.println();
				System.err.format("\nHoa don " + (i + 1) + " co ma " + maHoaDon + " bi trung. An enter de tiep tuc!!!");
				sc.nextLine();
				System.err.println("Nhap lai ma hoa don: ");
				hoadon = sc.nextLine();
				hd[i].setMaHoaDon(hoadon);
				GhiFileJava("HoaDon.txt");
				maHoaDon = hd[i].getMaHoaDon();
			}
		}while(KiemTraMHD(maHoaDon, i));
	}
	public boolean KiemTraMHD(String maHoaDon, int k) {
		DocFileJava("HoaDon.txt");
		for(int i = a - 1; i >= 0; i--) {
			if(hd[i].getMaHoaDon().indexOf(maHoaDon) != -1 && i != k) {
				return true;
			}
		}
		return false;
	}
	
	public void them(int sl) {
		hd = Arrays.copyOf(hd, n + sl);
		int j = n + sl;
		j -= sl;
		n += sl;
		for(int i = j; i < n; i++) {
			hd[i] = new ChiTietHoaDon();
			System.out.print("\t\t\t\t\tHoa Don thu " + (i + 1) + "\n");
			hd[i].Nhap();
			GhiFileJava("HoaDon.txt");
			ThayDoiMHD(i);
		}
		XuatDanhSach();
	}
        
	public void xoa(String maHoaDon) {
		boolean flag = false;
		int j = 0;
		for(int i = 0; i < n; i++) {
			if(hd[i].getMaHoaDon().indexOf(maHoaDon) != -1) {
				flag = true;
				j = i;
				break;
			}
		}
		for(int i = j; i < n - 1; i++) {
			hd[i] = hd[i + 1];
		} 
		n--;
		GhiFileJava("HoaDon.txt");
		if(flag)
			System.out.println("\nXoa thanh cong");
		else 
			System.err.println("\nKhong tim thay!!!");
	}
        
	public void sua(String maHoaDon) {
		int select = 0;
		do {
			System.out.println("\t\t\t\t\t======BANG LUA CHON======");
			System.out.println("\t\t\t\t\t1.Sua chi tiet HD");
			System.out.println("\t\t\t\t\t2.thoat");
			System.out.print("Lua chon: ");
			select = sc.nextInt();
			sc.nextLine();
			
			if(select < 1 || select > 2)
				System.err.println("\nBan nhap sai moi nhap lai");
		}while(select < 1 || select > 2);
		for(int i = 0; i < n; i++) {
			if(hd[i].getMaHoaDon().indexOf(maHoaDon) != -1) {
				if(select == 1) {
					System.out.print("\nSua thong tin hoa don thu " + (i + 1) + "\n");
					System.out.println("\t\t\t\t\t\t\t=====SUA THONG TIN======");
					System.out.println("\n================================================================================================================================================================================================================");					
					System.out.format("|| %4s | %10s | %10s | %30s | %25s | %15s | %15s | %15s | %15s  ||\n", "STT", "MA HOA DON", "MA KHACH HANG", "HO TEN KHACH HANG", "NHAN VIEN PHU TRACH", "MA VE", "SO LUONG", "GIA", "THANH TIEN");
                                        System.out.format("|| %4s |", (i + 1));
					hd[i].Xuat();
					System.out.println("================================================================================================================================================================================================================");					
					hd[i] = new ChiTietHoaDon();
					hd[i].Nhap();
					GhiFileJava("HoaDon.txt");
					ThayDoiMHD(i);
					XuatDanhSach();
					return;
				}
				else
					return;
				
			}
		}
	}
	
	public void timKiem_MHD(String maHoaDon) {
		System.out.println("\n================================================================================================================================================================================================================");		
		System.out.format("|| %4s | %10s | %10s | %30s | %25s | %15s | %15s | %15s | %15s  ||\n", "STT", "MA HOA DON", "MA KHACH HANG", "HO TEN KHACH HANG", "NHAN VIEN PHU TRACH", "MA VE", "SO LUONG", "GIA", "THANH TIEN");
                for(int i = 0; i < n; i++) {
			if(hd[i].getMaHoaDon().indexOf(maHoaDon) != -1) {
				System.out.format("|| %4s |", i + 1);
				hd[i].Xuat();
				
				break;
			}
		}
		System.out.println("================================================================================================================================================================================================================");
	}
	public void timKiem_MKH(String maKhachHang) {
		System.out.println("\n================================================================================================================================================================================================================");		
		System.out.format("|| %4s | %10s | %10s | %30s | %25s | %15s | %15s | %15s | %15s | %15s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "NGÀY LẬP HĐ", "MÃ SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "GIẢM GIÁ SP", "THÀNH TIỀN");
		for(int i = 0; i < n; i++) {
			if(hd[i].getMaKhachHang().indexOf(maKhachHang) != -1) {
				System.out.format("|| %4s |", i + 1);
				hd[i].Xuat();
				break;
			}
		}
		System.out.println("================================================================================================================================================================================================================");
	}
	
	public void timKiem_HO(String ho) {
		System.out.println("\t\t\t\t\t\t\t\t======KET QUA=====");
		System.out.println("\n================================================================================================================================================================================================================");		
		System.out.format("|| %4s | %10s | %10s | %30s | %25s | %15s | %15s | %15s | %15s | %15s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "NGÀY LẬP HĐ", "MÃ SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "GIẢM GIÁ SP", "THÀNH TIỀN");
                for(int i = 0; i < n; i++) {
			if(hd[i].getMaNhanVien().indexOf(ho) != -1) {
				System.out.format("|| %4s |", i + 1);
				hd[i].Xuat();
			}
		}
		System.out.println("================================================================================================================================================================================================================");
	}
	
	public void timKiem_MV(String maVe) {
		System.out.println("\t\t\t\t\t\t\t\t======KẾT QUẢ======");
		System.out.println("\n================================================================================================================================================================================================================");
		System.out.format("|| %4s | %10s | %10s | %30s | %25s | %15s | %15s | %15s | %15s | %15s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "NGÀY LẬP HĐ", "MÃ SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "GIẢM GIÁ SP", "THÀNH TIỀN");
                for(int i = 0; i < n; i++) {
			if(hd[i].getMaVe().indexOf(maVe) != -1) {
				System.out.format("|| %4s |", i + 1);
				hd[i].Xuat();
				break;
			}
		}
		System.out.println("================================================================================================================================================================================================================");
	}
	
	public void timKiem() {
		int select = 0;
		while(true) {
			System.out.println("\t\t\t\t\t======BANG LUA CHON======");
			System.out.println("\t\t\t\t\t1.Tim kiem hoa don theo ma");
			System.out.println("\t\t\t\t\t2.Tim kiem nhan vien");
			System.out.println("\t\t\t\t\t3.Tim kiem ma khach hang");
			System.out.println("\t\t\t\t\t4.Thoat");
			System.out.println("\nLua chon: ");
			select = sc.nextInt();
			sc.nextLine();
			switch(select) {
				case 1:
					System.out.print("Nhap ma hoa don: ");
					String maHoaDon = sc.nextLine();
					timKiem_MHD(maHoaDon);
					break;
				case 2:
					System.out.print("nhap ho cua nhan vien: ");
					String ho = sc.nextLine();
					timKiem_HO(ho);
					break;
				case 3:
					System.out.print("Nhap ma khach hang: ");
					String maKhachHang = sc.nextLine();
					timKiem_MKH(maKhachHang);
					break;
				case 4: 
					return;
				default:
					System.err.println("Nhap sai vui long nhap lai!!!");
					break;
			}
		}
		
	}
	public void ThaoTac() {
		int select = 0;
		String maHoaDon = "";
		loop:
			while(true) {
				System.out.println("\t\t\t\t\t======Bang Lua Chon======");
				System.out.println("\t\t\t\t\t1.Them HD");
				System.out.println("\t\t\t\t\t2.Xoa HD");
				System.out.println("\t\t\t\t\t3.Sua HD");
				System.out.println("\t\t\t\t\t4.Tim kiem HD");
				System.out.println("\t\t\t\t\t5.Xuat HD");
				System.out.println("\t\t\t\t\t6.Thoat");
				System.out.print("\nLua chon: ");
				select = sc.nextInt();
				sc.nextLine();
				switch(select) {
					case 1:
						System.out.print("Nhap so luong hoa don can them: ");
						int sl = sc.nextInt();
						them(sl);
						break;
					case 2:
						System.out.print("Nhap ma hoa don can xoa: ");
						maHoaDon = sc.nextLine();
						xoa(maHoaDon);
						XuatDanhSach();
						break;
					case 3:
						System.out.print("Nhap ma hoa don can sua: ");
						maHoaDon = sc.nextLine();
						sua(maHoaDon);
						break;
					case 4:
						timKiem();
						break;
					case 5: 
						XuatDanhSach();
						break;
					case 6:
						break loop;
					default:
						System.err.println("Nhap sai moi nhap lai");
						break;
				}
			}
	}
	// THONG KE........
	//ĐỌC FILE GHI FILE
//	@Override
//	public void GhiFileJava(String filename) {
//		int j = n;
//		try {
//			DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
//			dos.writeInt(j);
//			try {
//				for(int i = 0; i < j; i++) {
//					hd[i].GhiFile(filename);
//				}
//			}catch(NullPointerException npe) {
//					
//			}
//			dos.close();
//		}catch(IOException e) {}
//	}
//	@Override
//	public void DocFileJava(String filename) {
//		int i = 0;
//		try {
//			DataInputStream dis = new DataInputStream(new FileInputStream(filename));
//			n = dis.readInt();
//			hd = new ChiTietHoaDon[n];
//			try {
//				while(true) {
//					String mahd = dis.readUTF();
//					String makh = dis.readUTF();
//					String tenkh = dis.readUTF();
//					String nhanvien = dis.readUTF();
//					String ngaylaphoadon = dis.readUTF();
//					String masp = dis.readUTF();
//					int sl = dis.readInt();
//					float dongia = dis.readFloat();
//					int giamgia = dis.readInt();
//					double thanhtien = dis.readDouble();
//					hd[i] = new ChiTietHoaDon(mahd, makh, tenkh, nhanvien, ngaylaphoadon, masp, sl, dongia, giamgia, thanhtien);
//					i++;
//				}
//			}catch(EOFException e) {}
//			finally {
//				a = i;
//				dis.close();
//			}
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
}
