package KhachHang;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

final class DanhSachKhachHang {
	private KhachHang dsKhachHang[];
	private int tongKhachHang;
	File d = new File("src/InputOutput/DanhSachKhachHang.txt");
	//constructor
	public DanhSachKhachHang(int n) {
		dsKhachHang = new KhachHang[n];
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
	Scanner sc = new Scanner(System.in);
	public void them() {
		System.out.println(" ------------ Them khach hang ------------");
		this.tongKhachHang++; 
		System.out.println(" 	$ Nhap thong tin khach hang $ ");
		dsKhachHang = Arrays.copyOf(dsKhachHang, this.tongKhachHang);
		dsKhachHang[this.tongKhachHang - 1] = new KhachHang();
		dsKhachHang[this.tongKhachHang - 1].nhap(); 
		System.out.println("");
		System.out.print(" Tiep tuc (1) | Dung lai (phim bat ky): ");
		String n = sc.next();
		if(n.equals("1")) { them(); } 
		else { 
			System.out.println("\n -------- Hoan tat thao tac --------");
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
				dsKhachHang[tongKhachHang] = new KhachHang(line[0], line[1], line[2], line[3], line[4], line[5], Integer.parseInt(line[6]));
				tongKhachHang++;
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
			for(KhachHang nv : dsKhachHang) {
				if(nv != null) {
					br.write(nv.getMaKhachHang() + "/" + nv.getHo() + "/" + nv.getTen() + "/" + nv.getCccd() + "/" + nv.getDiaChi() + "/" + nv.getSdt() + "/" + nv.getDeleted() + "\n");
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
		System.out.println(" ------------ Danh sach khach hang ------------");
		System.out.printf("%-15s %-7s %-15s %-15s %-20s %-10s","Ma khach hang","Ho","Ten","CCCD", "Dia chi", "So dien thoai");
		System.out.println();
		int checkList = -1;
		for(KhachHang nv : dsKhachHang) {
			if (nv != null && nv.getDeleted() != 1) {
				nv.xuat(); System.out.println(""); checkList++;
			}
		}
		if(checkList == -1) {
			System.out.println("\n			........Danh sach trong........");
		}
	}
	public void xemdsXoa() {
		System.out.println(" ------------ Danh sach khach hang da xoa ------------");
		System.out.printf("%-15s %-7s %-15s %-15s %-20s %-10s","Ma khach hang","Ho","Ten","CCCD", "Dia chi", "So dien thoai");
		System.out.println();
		int checkList = -1;
		for(KhachHang nv : dsKhachHang) {
			if(nv != null && nv.getDeleted() == 1) {
				nv.xuat(); System.out.println(""); checkList++;
			}
		}
		System.out.println("");
		if(checkList != -1) {
			System.out.print(" Xoa vinh vien(1) | Khoi phuc(2) | Thoat(0): ");
			int n = sc.nextInt();
			System.out.println("");
			switch (n) {
				case 1:
					System.out.println(" ------------ Xoa vinh vien ------------");
					sc.nextLine();
					System.out.print(" - Nhap ma khach hang can xoa: ");
					String maXoa = sc.nextLine();
					int delete_point = -1;
					for(int i = 0;i < this.tongKhachHang;i++) {
						if(dsKhachHang[i] != null && dsKhachHang[i].getDeleted() == 1 && dsKhachHang[i].getMaKhachHang().equalsIgnoreCase(maXoa)) {
							delete_point = i;
							break;
						}
					}
					if(delete_point != -1) {
						for(int i=delete_point;i<this.tongKhachHang - 1;i++) {
							dsKhachHang[i] = dsKhachHang[i+1];
						}
						this.tongKhachHang--;
						dsKhachHang = Arrays.copyOf(dsKhachHang, this.tongKhachHang);
						System.out.println("/n -------- Hoan tat thao tac --------");
					} else { 
						System.out.println("/n -------- Khong tim thay ma khach hang --------");
					} 
					break;
				case 2:
					System.out.println(" ------------ Khoi phuc ------------");
					sc.nextLine();
					System.out.print(" - Nhap ma khach hang can khoi phuc: ");
					String maKP = sc.nextLine(); int m = 0;
					for(KhachHang nv : dsKhachHang) {
						if(nv != null && nv.getDeleted() == 1 && nv.getMaKhachHang().equalsIgnoreCase(maKP)) {
							nv.setDeleted(0); m++; ;
							System.out.println("\n -------- Hoan tat thao tac --------");
							break;
						}
					}
					if(m == 0) {
						System.out.println("\n -------- Khong tim thay ma khach hang --------");
					}
				case 0:
					break;
				default:
					System.out.println(" Lua chon khong hop le, xin thu lai !!!");
					xemdsXoa();
					break;
			}
		} else {
			System.out.println("			........Danh sach trong........");
		}
		
	}
	public void xoa() {
		System.out.println(" ------------ Xoa khach hang ------------");
		System.out.print(" - Hay nhap ma khach hang can xoa: ");
		String x = sc.next(); int m = 0; int delete_point = -1;
		for(int i=0;i<this.tongKhachHang;i++) {
			if(dsKhachHang[i].getMaKhachHang().equalsIgnoreCase(x) && dsKhachHang[i].getDeleted() != 1) {
				m++; delete_point = i;
				System.out.print(" Cho vao danh sach xoa(1) | Xoa vinh vien(2): ");
				int n = sc.nextInt();
				switch(n) {
					case 1:
						dsKhachHang[i].setDeleted(1);
						System.out.println("\n -------- Hoan tat thao tac --------");
						break;
					case 2: 
						if(delete_point != -1) {
							for(int j=delete_point;j<this.tongKhachHang - 1;j++) {
								dsKhachHang[j] = dsKhachHang[j+1]; 
							}
							this.tongKhachHang --;
							System.out.println("\n -------- Hoan tat thao tac --------");
						}
						break;
					default :
						System.out.println(" Lua chon khong hop le, xin thu lai!!!");
						xoa();
						break;
				}
				break;
			} 
		}
		if(m == 0) {
			System.out.println("\n -------- Khong tim thay ma khach hang --------");
		}
	}
	public void timkiem(){
		System.out.println(" ------------ Tim kiem ------------");
		System.out.print(" + Ma khach hang ( x de bo qua): ");
		String tk1= sc.next();
		System.out.print(" + So dien thoai ( x de bo qua): ");
		String tk2= sc.next();
		System.out.print(" + Ho ( x de bo qua): ");
		String tk3= sc.next();
		System.out.print(" + Ten ( x de bo qua): ");
		sc.nextLine();
		String tk4= sc.nextLine(); int m = 0;
		System.out.print(" + CCCD (x de bo qua): ");
		String tk5 = sc.next();
		System.out.print(" + Dia chi (x de bo qua): ");
		sc.nextLine();
		String tk6 = sc.nextLine();
 		System.out.println();
		System.out.printf("%-15s %-7s %-15s %-15s %-20s %-10s","Ma khach hang","Ho","Ten","CCCD", "Dia chi", "So dien thoai");
		System.out.println();
		for(int i=0;i<this.tongKhachHang;i++) {
			if((dsKhachHang[i].getMaKhachHang().equalsIgnoreCase(tk1)||tk1.equalsIgnoreCase("x"))
			&&(dsKhachHang[i].getSdt().equalsIgnoreCase(tk2)||tk2.equalsIgnoreCase("x"))
			&&(dsKhachHang[i].getHo().equalsIgnoreCase(tk3)||tk3.equalsIgnoreCase("x"))
			&&(dsKhachHang[i].getTen().equalsIgnoreCase(tk4)||tk4.equalsIgnoreCase("x"))
			&&(dsKhachHang[i].getCccd().equalsIgnoreCase(tk5)||tk5.equalsIgnoreCase("x"))
			&&(dsKhachHang[i].getDiaChi().equalsIgnoreCase(tk6)||tk6.equalsIgnoreCase("x"))){
				dsKhachHang[i].xuat(); m++;
				System.out.println("");
			}
		}
		System.out.println("");
		if(m != 0) { 
			System.out.println(" -------- Hoan tat thao tac --------");
		} else {
			System.out.println(" -------- Khong tim thay ket qua tim kiem --------");
		}
	}
	public void sua() {
		System.out.println(" ------------ Sua khach hang ------------");
		System.out.print(" - Hay nhap ma khach hang can sua: ");
		String x = sc.next(); int m = 1;
		System.out.println("");
		// Nhap ma khach hang sau do tuy chon cach sua.
		for (int i=0;i<this.tongKhachHang;i++) {
			if(dsKhachHang[i].getMaKhachHang().equalsIgnoreCase(x) && dsKhachHang[i].getDeleted() != 1) {
				System.out.println(" (1) Ma khach hang.");
				System.out.println(" (2) Ho ten.");
				System.out.println(" (3) So dien thoai.");
				System.out.println(" (4) CCCD.");
				System.out.println(" (5) Dia chi.");
				System.out.println(" (6) Tat ca.");
				System.out.println(" (0) Thoat.");
				System.out.print(" - Hay chon gia tri muon sua: ");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.print(" - Sua ma khach hang: ");
						String ma = sc.next();
						dsKhachHang[i].setMaKhachHang(ma);
						break;
					case 2:
						System.out.print(" - Sua ho khach hang: ");
						String ho = sc.next();
						sc.nextLine();
						System.out.print(" - Sua ten khach hang: ");
						String ten = sc.nextLine();
						dsKhachHang[i].setHo(ho);
						dsKhachHang[i].setTen(ten);
						break;
					case 3: 
						System.out.print(" - Sua sdt khach hang: ");
						String sdt = sc.next();
						dsKhachHang[i].setSdt(sdt);
						break;
					case 4:
						System.out.println(" - Sua CCCD khach hang: ");
						String cccd = sc.next();
						dsKhachHang[i].setCccd(cccd);
						break;
					case 5:
						System.out.println(" - Sua dia chi khach hang: ");
						sc.nextLine();
						String dc = sc.nextLine();
						dsKhachHang[i].setDiaChi(dc);
						break;
					case 6: 
						dsKhachHang[i].nhap();
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
			System.out.println("\n ------ Khong tim thay khach hang ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("\n ----- Hoan tat thao tac -----");
		}
	}
	public void thongke() {
		System.out.println(" ------------ Thong ke ------------");
		System.out.println(" - Tong so khach hang: " + this.tongKhachHang);
	}
}
