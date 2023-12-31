package ChuyenBay;

import java.util.Arrays;
import Interface.Pthuc;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import SanBay.DanhSachSanBay;
import MayBay.DanhSachMayBay;


public class DanhSachChuyenBay implements Pthuc {
	private ChuyenBay dsChuyenBay[];
	private int tongChuyenBay; 
	private int soCBHH; // so chuyen bay hien huu ( bien dem cho so nv kh nam trong danh sach xoa ) 
	File d = new File("src/InputOutput/DanhSachChuyenBay.txt");
	
	DanhSachMayBay mb = new DanhSachMayBay(100);
	DanhSachSanBay sb = new DanhSachSanBay(100);
	
	//constructor
	public DanhSachChuyenBay(int n) {
		dsChuyenBay = new ChuyenBay[n];
		this.tongChuyenBay=0;
		this.soCBHH=0;
	}
	public DanhSachChuyenBay(ChuyenBay dsChuyenBay[], int tongChuyenBay, int soCBHH) {
		this.dsChuyenBay = dsChuyenBay;
		this.tongChuyenBay = tongChuyenBay;
		this.soCBHH = soCBHH;
	}
	public DanhSachChuyenBay(DanhSachChuyenBay a) {
		this.dsChuyenBay = a.dsChuyenBay;
		this.tongChuyenBay = a.tongChuyenBay;
		this.soCBHH = a.soCBHH;
	}
	
	// get/set
	public ChuyenBay[] getDsChuyenBay() {
		return dsChuyenBay;
	}
	public void setDsChuyenBay(ChuyenBay[] dsChuyenBay) {
		this.dsChuyenBay = dsChuyenBay;
	}
	public int gettongChuyenBay() {
		return tongChuyenBay;
	}
	public void settongChuyenBay(int tongChuyenBay) {
		this.tongChuyenBay = tongChuyenBay;
	}
	public void setsoCBHH(int soCBHH) {
		this.soCBHH = soCBHH;
	}
	public int getsoCBHH() {
		return this.soCBHH;
	}
	
	// methods 
	Scanner sc = new Scanner(System.in);
	public void them() {
		sb.docfile();
		mb.docfile();
		sb.xemds();
		mb.xemds();
		System.out.println("\n ------------ Them chuyen bay ------------");
		this.tongChuyenBay++; this.soCBHH++; 
		System.out.println(" 	$ Nhap thong tin chuyen bay $ ");
		dsChuyenBay = Arrays.copyOf(dsChuyenBay, this.tongChuyenBay);
		dsChuyenBay[this.tongChuyenBay - 1] = new ChuyenBay();
		dsChuyenBay[this.tongChuyenBay - 1].nhap(); 
		System.out.println("");
		ghifile();
		System.out.print(" Tiep tuc (1) | Dung lai (phim bat ky): ");
		String n = sc.next();
		System.out.println("");
		if(n.equals("1")) { them(); } 
		else { 
			System.out.println(" -------- Hoan tat thao tac --------");
		}
	}	
	public void docfile() {
		tongChuyenBay = 0;
		try {
			if(!d.exists()) {
				d.createNewFile();
			}
			FileReader fr = new FileReader(d);
			BufferedReader br = new BufferedReader(fr);
			String lines = br.readLine();
			while(lines != null) {
				String []line = lines.split("/");
				dsChuyenBay[tongChuyenBay] = new ChuyenBay(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], Integer.parseInt(line[8]), Integer.parseInt(line[9]));
				if(line[9].equalsIgnoreCase("0")) {
					this.soCBHH++;
				}
				tongChuyenBay++;
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
			for(ChuyenBay nv : dsChuyenBay) {
				if(nv != null) {
					br.write(nv.getMaChuyenBay() + "/" + nv.getMaMayBay() + "/" + nv.getNgayDi() + "/" + nv.getNgayDen() + "/" + nv.getMaSanBayDi() + "/" +
							nv.getMaSanBayDen() + "/" + nv.getGioDi() + "/" + nv.getGioDen() + "/" + nv.getTongSoVe()
							+ "/" + nv.getDeleted() + "\n");
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
		System.out.println("\t\t\t\t\t ------------ Danh sach chuyen bay ------------");
		System.out.printf("| %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s","Ma chuyen bay","Ma may bay","Ngay di","Ngay den","Ma san bay di","Ma san bay den","Gio di","Gio den","Tong so ve");
		System.out.println();
		int checkList = -1;
        for(ChuyenBay nv : dsChuyenBay) {
        	if (nv != null && nv.getDeleted() != 1) {
            	nv.xuat(); System.out.println(""); checkList++; 
        	}
        }
        if(checkList == -1) {
        	System.out.println("\n	........Danh sach trong........");
        }
	}
	public void xoa() {
		System.out.println(" ------------ Xoa chuyen bay ------------");
		System.out.print(" - Hay nhap ma chuyen bay can xoa | Thoat(0): ");
		String x = sc.next(); int m = 0;
		if(x.equalsIgnoreCase("0")) {
			;
		} else {
			for(int i=0;i<this.tongChuyenBay;i++) {
				if(dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(x) && dsChuyenBay[i].getDeleted() != 1) {
					m++; 
					dsChuyenBay[i].setDeleted(1); this.soCBHH--;
					System.out.println("");
					System.out.println(" -------- Hoan tat thao tac --------");
					break;
					}
				} 
			}
			if(m == 0) {
				System.out.println("\n -------- Khong tim thay ma chuyen bay --------");
			}
	}
	public void timkiem(){
		System.out.println(" ------------ Tim kiem ------------");
		System.out.print(" + Ma chuyen bay ( x de bo qua): ");
		String tk1= sc.next();
		System.out.print(" + Ma may bay ( x de bo qua): ");
		String tk2= sc.next();
		System.out.print(" + Ngay di ( x de bo qua): ");
		sc.nextLine();
		String tk3= sc.nextLine();
		System.out.print(" + Ngay den ( x de bo qua): ");
		String tk4= sc.nextLine();
		System.out.print(" + Ma san bay di ( x de bo qua): ");
		String tk5= sc.nextLine();
		System.out.print(" + Ma san bay den ( x de bo qua): ");
		String tk6= sc.nextLine();
		System.out.print(" + Gio di ( x de bo qua): ");
		String tk7= sc.nextLine();
		System.out.print(" + Gio den ( x de bo qua): ");
		String tk8= sc.nextLine();
		int m = 0;
		System.out.println();
		System.out.printf("| %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s","Ma chuyen bay","Ma may bay","Ngay di","Ngay den","Ma san bay di","Ma san bay den","Gio di","Gio den","Tong so ve");
		System.out.println();
		for(int i=0;i<this.tongChuyenBay;i++) {
			if((dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(tk1)||tk1.equalsIgnoreCase("x"))
			&&(dsChuyenBay[i].getMaMayBay().equalsIgnoreCase(tk2)||tk2.equalsIgnoreCase("x"))
			&&(dsChuyenBay[i].getNgayDi().equalsIgnoreCase(tk3)||tk3.equalsIgnoreCase("x"))
			&&(dsChuyenBay[i].getNgayDen().equalsIgnoreCase(tk4)||tk4.equalsIgnoreCase("x"))
			&&(dsChuyenBay[i].getMaSanBayDi().equalsIgnoreCase(tk5)||tk5.equalsIgnoreCase("x"))
			&&(dsChuyenBay[i].getMaSanBayDen().equalsIgnoreCase(tk6)||tk6.equalsIgnoreCase("x"))
			&&(dsChuyenBay[i].getGioDi().equalsIgnoreCase(tk7)||tk7.equalsIgnoreCase("x"))
			&&(dsChuyenBay[i].getGioDen().equalsIgnoreCase(tk8)||tk8.equalsIgnoreCase("x"))
			&& dsChuyenBay[i].getDeleted() != 1){
				dsChuyenBay[i].xuat(); m++;
				System.out.println("");
			}
		}
		if(m == 0) {
			System.out.println("\n\t\t\t\t\t\t .....Khong tim thay ket qua tim kiem.....");
		}
	}
	public void sua() {
		System.out.println(" ------------ Sua chuyen bay ------------");
		System.out.print(" - Hay nhap ma chuyen bay can sua: ");
		String x = sc.next(); int m = 1;
		System.out.println("");
		// Nhap ma chuyen bay sau do tuy chon cach sua.
		for (int i=0;i<this.tongChuyenBay;i++) {
			if(dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(x) && dsChuyenBay[i].getDeleted() != 1) {
				System.out.println(" (1) Ma chuyen bay");
				System.out.println(" (2) Ma may bay");
				System.out.println(" (3) Ngay di va ngay den");
				System.out.println(" (4) San di va san den");
				System.out.println(" (5) Gio di va gio den");
				System.out.println(" (6) Tong so ve");
				System.out.println(" (7) Tat ca");
				System.out.println(" (0) Thoat");
				System.out.print(" - Lua chon gia tri can sua: ");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.print(" - Sua ma chuyen bay: ");
						String ma = sc.next();
						dsChuyenBay[i].setMaChuyenBay(ma);
						break;
					case 2:
						System.out.println(" - Sua ma may bay: ");
						String mamb = sc.next();
						dsChuyenBay[i].setMaMayBay(mamb);
						break;
					case 3: 
						System.out.print(" - Sua ngay di: ");
						String ngaydi = sc.next();
						dsChuyenBay[i].setNgayDi(ngaydi);
						System.out.println(" - Sua ngay den: ");
						String ngayden = sc.next();
						dsChuyenBay[i].setNgayDen(ngayden);
						break;
					case 4:
						System.out.println(" - Sua ma san bay di: ");
						sc.nextLine();
						String sanbaydi = sc.nextLine();
						System.out.println(" - Sua ma san bay den: ");
						String sanbayden = sc.nextLine();
						dsChuyenBay[i].setMaSanBayDen(sanbayden);
						dsChuyenBay[i].setMaSanBayDi(sanbaydi);
						break;
					case 5:
						System.out.println(" - Sua gio di: ");
						String giodi = sc.nextLine();
						System.out.println(" - Sua gio den: ");
						String gioden = sc.nextLine();
						dsChuyenBay[i].setGioDi(giodi);
						dsChuyenBay[i].setGioDen(gioden);
						break;
					case 6: 
						System.out.println(" - Sua tong so ve: ");
						int tongve = sc.nextInt();
						dsChuyenBay[i].setTongSoVe(tongve);
						break;
					case 7: 
						dsChuyenBay[i].nhap();
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
			System.out.println("\n ------ Khong tim thay chuyen bay ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("\n ----- Hoan tat thao tac -----");
		}
	}
	public void thongke() {
		System.out.println(" - Tong so chuyen bay : " + this.soCBHH);
	}
	
	//
	public void truyxuatSanbay(String sanbaydi, String sanbayden) {
		System.out.printf("\n| %-10s | %-30s | %-15s","Ma san bay","Ten san bay","Dia chi san bay");
		System.out.println();
		sb.truyXuat(sanbayden);
		System.out.println();
		sb.truyXuat(sanbaydi);
	}
	public void truyXuat() {
		sb.docfile(); mb.docfile();
		System.out.println(" ------------ Truy xuat san bay va may bay ------------");
		System.out.print(" - Nhap ma chuyen bay can truy xuat | Thoat(0): ");
		String tx = sc.next();
		if(tx.equalsIgnoreCase("0")) {
			; 
		} else {
			for(int i=0;i<this.tongChuyenBay;i++) {
				if(dsChuyenBay[i] != null && dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(tx)) {
					truyxuatSanbay(dsChuyenBay[i].getMaSanBayDi(), dsChuyenBay[i].getMaSanBayDen());
					System.out.println("");
					mb.truyXuat(dsChuyenBay[i].getMaMayBay());
					break;
				}
			}
		}
		System.out.println("");
	}
	
	public boolean Check_Available(String machuyenbay) {
		for(int i=0;i<this.tongChuyenBay;i++) {
			if(dsChuyenBay[i] != null && dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(machuyenbay)) {
				 return true;
			}
		}
		return false;
	}
	
	public void truyXuat(String maCB) {
		System.out.println();
		System.out.printf("| %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s","Ma chuyen bay","Ma may bay","Ngay di","Ngay den","Ma san bay di","Ma san bay den","Gio di","Gio den","Tong so ve");
		System.out.println();
		for(int i=0;i<this.tongChuyenBay;i++) {
			if(dsChuyenBay[i].getDeleted() == 0 && dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(maCB)) {
				dsChuyenBay[i].xuat(); System.out.println(); break; 
			}
		}
	}
}