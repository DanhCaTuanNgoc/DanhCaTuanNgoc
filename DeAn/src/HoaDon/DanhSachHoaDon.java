package HoaDon;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import ChiTietHoaDon.DanhSachCTHoaDon;
import NhanVien.DanhSachNhanVien;
import KhachHang.DanhSachKhachHang;

public class DanhSachHoaDon {
	private HoaDon dsHoaDon[];
	private int tongHoaDon; 
	DanhSachNhanVien nv = new DanhSachNhanVien(100);
	DanhSachKhachHang kh = new DanhSachKhachHang(100);
	DanhSachCTHoaDon ct = new DanhSachCTHoaDon(100);
	private int soHDHH; // số hóa đơn hiện hữu.
	File d = new File("src/InputOutput/DanhSachHoaDon.txt");
	
	//constructor
	public DanhSachHoaDon(int n) {
		dsHoaDon = new HoaDon[n];
		this.tongHoaDon=0;
		this.soHDHH = 0;
	}
	public DanhSachHoaDon(HoaDon dsHoaDon[], int tongHoaDon, int soHDHH) {
		this.dsHoaDon = dsHoaDon;
		this.tongHoaDon = tongHoaDon;
		this.soHDHH = soHDHH;
	}
	public DanhSachHoaDon(DanhSachHoaDon a) {
		this.dsHoaDon = a.dsHoaDon;
		this.tongHoaDon = a.tongHoaDon;
		this.soHDHH = a.soHDHH;
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
	public void setsoHDHH(int s) {
		this.soHDHH = s;
	}
	public int getsoHDHH () {
		return soHDHH;
	}
	
	// methods 
	Scanner sc = new Scanner(System.in);
	public void them() {
		System.out.println(" ------------ Them hoa don ------------");
		this.tongHoaDon++; this.soHDHH++;
		System.out.println(" 	$ Nhap thong tin hoa don $ ");
		dsHoaDon = Arrays.copyOf(dsHoaDon, this.tongHoaDon);
		dsHoaDon[this.tongHoaDon - 1] = new HoaDon();
		dsHoaDon[this.tongHoaDon - 1].nhap(); 
		System.out.println("");
		System.out.print(" Tiep tuc (1) | Dung lai (phim bat ky): ");
		String n = sc.next();
		System.out.println("");
		if(n.equals("1")) { them(); } 
		else { 
			System.out.println(" -------- Hoan tat thao tac --------");
		}
	}	
	public void docfile() {
		try {
			if(!d.exists()) {
				d.createNewFile();
			}
			FileReader fr = new FileReader(d);
			BufferedReader br = new BufferedReader(fr);
			String lines = br.readLine();
			while(lines != null) {
				String []line = lines.split("/");
				dsHoaDon[tongHoaDon] = new HoaDon(line[0], line[1], line[2], line[3], line[4], Integer.parseInt(line[5]));
				if(line[5].equalsIgnoreCase("0")) {
					this.soHDHH++;
				}
				tongHoaDon++;
				lines = br.readLine();
			}
			br.close();
		} catch(IOException ioe) {
			System.out.println("File Error!");
		}
	}
	public void ghifile() {
		try {
			if(!d.exists()) {
				d.createNewFile();
			}
			FileWriter er = new FileWriter(d);
			BufferedWriter cr = new BufferedWriter(er);
			cr.write("");
			cr.close();
			FileWriter fr = new FileWriter(d, true);
			BufferedWriter br = new BufferedWriter(fr);
			for(HoaDon hd : dsHoaDon) {
				if(hd != null) {
					br.write(hd.getMaHoaDon() + "/" + hd.getMaKhachHang() + "/" + hd.getMaNhanVien() + "/" + hd.getNgayXuat() + "/" + hd.getTongHoaDon() +  "/" + hd.getDeleted() + "\n");
				} else {
					break;
				}
			}
			br.close();
		} catch(IOException ioe) {
			System.out.println("File Error!");
		}
	}
	public void xemds() {
		System.out.println("\t\t\t --------- Danh sach hoa don ---------");
		System.out.printf("| %-15s | %-15s | %-15s | %-12s | %-12s","Ma hoa don","Ma khach hang","Ma nhan vien", "Ngay xuat", "Tong hoa don");
		System.out.println();
		int checkList = -1;
        for(HoaDon hd : dsHoaDon) {
        	if (hd != null && hd.getDeleted() != 1) {
            	hd.xuat(); System.out.println(""); checkList++;
        	}
        }
        if(checkList == -1) {
        	System.out.println("\n\t\t	........Danh sach trong........");
        }
	}
	public void xoa() {
		System.out.println(" ------------ Xoa hoa don ------------");
		System.out.print(" - Hay nhap ma hoa don can xoa | Thoat(0): ");
		String x = sc.next(); int m = 0; int delete_point = -1;
		if(x.equalsIgnoreCase("0")) {
			;
		} else {
			for(int i=0;i<this.tongHoaDon;i++) {
				if(dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(x) && dsHoaDon[i].getDeleted() != 1) {
					m++; 
					dsHoaDon[i].setDeleted(1); this.soHDHH--;
					System.out.println("");
					System.out.println(" -------- Hoan tat thao tac --------");
					break;
					}
				} 
			}
		if(m == 0) {
			System.out.println("\n -------- Khong tim thay ma hoa don --------");
		}	
	}
	public void timkiem(){
		System.out.println(" ------------ Tim kiem ------------");
		System.out.print(" + Ma hoa don ( x de bo qua): ");
		String tk1= sc.next();
		System.out.print(" + Ma khach hang ( x de bo qua): ");
		String tk2= sc.next();
		System.out.print(" + Ma nhan vien ( x de bo qua): ");
		String tk3= sc.next();
		System.out.print(" + Ngay xuat (x de bo qua): ");
		sc.nextLine();
		String tk4 = sc.nextLine();
		System.out.print(" + Tong hoa don (x de bo qua): ");
		String tk5 = sc.nextLine();
		int m = 0;
		System.out.println();
		System.out.printf("| %-15s | %-15s | %-15s | %-12s | %-12s","Ma hoa don","Ma khach hang","Ma nhan vien", "Ngay xuat", "Tong hoa don");
		System.out.println();
		for(int i=0;i<this.tongHoaDon;i++) {
			if((dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(tk1)||tk1.equalsIgnoreCase("x"))
			&&(dsHoaDon[i].getMaKhachHang().equalsIgnoreCase(tk2)||tk2.equalsIgnoreCase("x"))
			&&(dsHoaDon[i].getMaNhanVien().equalsIgnoreCase(tk3)||tk3.equalsIgnoreCase("x"))
			&&(dsHoaDon[i].getNgayXuat().equalsIgnoreCase(tk4) ||tk4.equalsIgnoreCase("x"))
			&&(dsHoaDon[i].getTongHoaDon().equalsIgnoreCase(tk5)||tk5.equalsIgnoreCase("x"))
			&& dsHoaDon[i].getDeleted() != 1){
				dsHoaDon[i].xuat(); m++;
				System.out.println("");
			}
		}
		if(m == 0) {
			System.out.println("\n 	.....Khong tim thay ket qua tim kiem.....");
		}
	}
	public void sua() {
		System.out.println(" ------------ Sua hoa don ------------");
		System.out.print(" - Hay nhap ma hoa don can sua: ");
		String x = sc.next(); int m = 1;
		System.out.println("");
		// Nhap ma hoa don sau do tuy chon cach sua.
		for (int i=0;i<this.tongHoaDon;i++) {
			if(dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(x) && dsHoaDon[i].getDeleted() != 1) {
				System.out.println(" (1) Ma hoa don.");
				System.out.println(" (2) Ma khach hang.");
				System.out.println(" (3) Ma nhan vien.");
				System.out.println(" (4) Ngay xuat.");
				System.out.println(" (5) Tong hoa don.");
				System.out.println(" (6) Tat ca.");
				System.out.println(" (0) Thoat.");
				System.out.print(" - Hay chon gia tri muon sua: ");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.print(" - Sua ma hoa don: ");
						String ma = sc.next();
						dsHoaDon[i].setMaHoaDon(ma);
						break;
					case 2:
						System.out.print(" - Sua ma khach hang: ");
						sc.nextLine();
						String maKh = sc.nextLine();
						dsHoaDon[i].setMaKhachHang(maKh);
						break;
					case 3: 
						System.out.print(" - Sua ma nhan vien: ");
						String maNv = sc.nextLine();
						dsHoaDon[i].setMaNhanVien(maNv);
						break;
					case 4: 
						System.out.println(" - Sua ngay xuat: ");
						String nx = sc.nextLine();
						dsHoaDon[i].setNgayXuat(nx);
					case 5: 
						System.out.print(" - Sua tong hoa don: ");
						String tong = sc.nextLine();
						dsHoaDon[i].setTongHoaDon(tong);
					case 6: 
						dsHoaDon[i].nhap();
						break;
					case 0:
						m = -1;
						break;
					default:
						System.out.println("Lua chon khong hop le, vui long nhap lai !!!");
						sua();
						break;
				}
				break;
			}
		}
		if (m == 1) {
			System.out.println("\n ------ Khong tim thay hoa don ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("\n ----- Hoan tat thao tac -----");
		}
	}
	
	public void thongke() {
		System.out.println(" ------------ Thong ke ------------");
		System.out.println(" - Tong so hoa don: " + this.soHDHH);
	}
	
	
	// Truy xuat du lieu
	
	public void truyXuatNV() {
		System.out.println(" ------------ Truy xuat nhan vien ------------");
		System.out.print(" - Nhap ma hoa don can truy xuat nhan vien | Thoat(0): ");
		String maHd = sc.next(); 
		if(maHd.equalsIgnoreCase("0")) {
			;
		} else {
			nv.docfile();
			System.out.printf("\n| %-15s | %-7s | %-15s | %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
			System.out.println();
			for(int i=0;i<this.tongHoaDon;i++) {
				if(dsHoaDon[i] != null && dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(maHd)) {
					nv.truyXuatNV(dsHoaDon[i].getMaNhanVien());
				}
			}
		}
		System.out.println("");
	}
	
	public void truyXuatKH() {
		System.out.println(" ------------ Truy xuat khach hang ------------");
		System.out.print(" - Nhap ma hoa don can truy xuat khach hang | Thoat(0): ");
		String maHd = sc.next();
		if(maHd.equals("0")) {
			;
		} else {
			kh.docfile();
			for(int i=0;i<this.tongHoaDon;i++) {
				if(dsHoaDon[i] != null && dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(maHd)) {
					kh.truyXuatKH(dsHoaDon[i].getMaKhachHang());
				}
			}
		}
		System.out.println("");
	}
	
	public void truyXuatCTHD() {
		System.out.println(" ------------ Truy xuat CT hoa don ------------");
		System.out.print(" - Nhap ma hoa don can truy xuat CT hoa don | Thoat(0): ");
		String maHd = sc.next();
		if(maHd.equals("0")) {
			;
		} else {
			ct.docfile();
			System.out.printf("\n| %-10s | %-10s | %-15s ","Ma hoa don","Ma ve","Gia tien");
			System.out.println();
			for(int i=0;i<this.tongHoaDon;i++) {
				if(dsHoaDon[i] != null && dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(maHd)) {
					ct.truyXuatCTHD(dsHoaDon[i].getMaHoaDon());
				}
			}
		}
		System.out.println("");
	}
	
	//Kiem tra ton tai
	public boolean Check_Available(String mahoadon) {
		for(int i=0;i<this.tongHoaDon;i++) {
			if(dsHoaDon[i] != null && dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(mahoadon)) {
				 return true;
			}
		}
		return false;
	}
}