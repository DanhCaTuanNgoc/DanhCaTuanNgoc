package ChiTietHoaDon;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Interface.Pthuc;


public class DanhSachCTHoaDon implements Pthuc {
	private CTHoaDon dsCTHoaDon[];
	private int tongCTHoaDon; 
	private int soCTHDHH; // so CHI TIET HOA DON hien huu ( bien dem cho so ct kh nam trong danh sach xoa ) 
	File d = new File("src/InputOutput/DanhSachCTHoaDon.txt");
	
	//constructor
	public DanhSachCTHoaDon(int n) {
		dsCTHoaDon = new CTHoaDon[n];
		this.tongCTHoaDon=0;
		this.soCTHDHH=0;
	}
	public DanhSachCTHoaDon(CTHoaDon dsCTHoaDon[], int tongCTHoaDon, int soCTHDHH) {
		this.dsCTHoaDon = dsCTHoaDon;
		this.tongCTHoaDon = tongCTHoaDon;
		this.soCTHDHH = soCTHDHH;
	}
	public DanhSachCTHoaDon(DanhSachCTHoaDon a) {
		this.dsCTHoaDon = a.dsCTHoaDon;
		this.tongCTHoaDon = a.tongCTHoaDon;
		this.soCTHDHH = a.soCTHDHH;
	}
	
	// get/set
	public CTHoaDon[] getDsCTHoaDon() {
		return dsCTHoaDon;
	}
	public void setDsCTHoaDon(CTHoaDon[] dsCTHoaDon) {
		this.dsCTHoaDon = dsCTHoaDon;
	}
	public int gettongCTHoaDon() {
		return tongCTHoaDon;
	}
	public void settongCTHoaDon(int tongCTHoaDon) {
		this.tongCTHoaDon = tongCTHoaDon;
	}
	public void setsoCTHDHH(int soCTHDHH) {
		this.soCTHDHH = soCTHDHH;
	}
	public int getsoCTHDHH() {
		return this.soCTHDHH;
	}
	
	// methods 
	Scanner sc = new Scanner(System.in);
	public void them() {
		System.out.println(" ------------ Them chi tiet hoa don ------------");
		this.tongCTHoaDon++; this.soCTHDHH++; 
		System.out.println(" 	$ Nhap thong tin chi tiet hoa don $ ");
		dsCTHoaDon = Arrays.copyOf(dsCTHoaDon, this.tongCTHoaDon);
		dsCTHoaDon[this.tongCTHoaDon - 1] = new CTHoaDon();
		dsCTHoaDon[this.tongCTHoaDon - 1].nhap(); 
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
		tongCTHoaDon=0;
		try {
			if(!d.exists()) {
				d.createNewFile();
			}
			FileReader fr = new FileReader(d);
			BufferedReader br = new BufferedReader(fr);
			String lines = br.readLine();
			while(lines != null) {
				String []line=lines.split("/");
				dsCTHoaDon[tongCTHoaDon] = new CTHoaDon(line[0], line[1] , Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[3]));
				if(line[3].equalsIgnoreCase("0")) {
					this.soCTHDHH++;
				}
				tongCTHoaDon++;
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
			for(CTHoaDon ct : dsCTHoaDon) {
				if(ct != null) {
					br.write(ct.getMaHoaDon() + "/" + ct.getMaVe() + "/" + ct.getGiaTien() + "/" +ct.getKhuyenmai() + "/" + ct.getDeleted() + "\n");
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
		System.out.println(" ------------ Danh sach chi tiet hoa don ------------");
		System.out.printf("| %-10s | %-10s | %-15s | %-10s","Ma hoa don","Ma ve","Gia tien","Khuyen mai");
		System.out.println();
		int checkList = -1;
        for(CTHoaDon ct : dsCTHoaDon) {
        	if (ct != null && ct.getDeleted() != 1) {
            	ct.xuat(); System.out.println(""); checkList++; 
        	}
        }
        if(checkList == -1) {
        	System.out.println("\n	........Danh sach trong........");
        }
	}
	public void xoa() {
		System.out.println(" ------------ Xoa chi tiet hoa don ------------");
		System.out.print(" - Hay nhap ma chi tiet hoa don can xoa | Thoat(0): ");
		String x = sc.next(); int m = 0;
		if(x.equalsIgnoreCase("0")) {
			;
		} else {
			for(int i=0;i<this.tongCTHoaDon;i++) {
				if(dsCTHoaDon[i].getMaHoaDon().equalsIgnoreCase(x) && dsCTHoaDon[i].getDeleted() != 1) {
					m++; 
					dsCTHoaDon[i].setDeleted(1); this.soCTHDHH--;
					System.out.println("");
					System.out.println(" -------- Hoan tat thao tac --------");
					break;
				} 
			}
			if(m == 0) {
				System.out.println("\n -------- Khong tim thay ma chi tiet hoa don --------");
			}
		}
	}
	public void timkiem(){
		System.out.println(" ------------ Tim kiem ------------");
		System.out.print(" + Ma chi tiet hoa don ( x de bo qa): ");
		String tk1= sc.next();
		System.out.print(" + Ma ve ( x de bo qa): ");
		String tk2= sc.next();
		System.out.print(" + So luong ( x de bo qa): ");
		sc.nextLine();
		String tk3= sc.nextLine();
		System.out.print(" + Gia tien ( x de bo qa): ");
		String tk4= sc.nextLine(); int m = 0;
		System.out.println();
		System.out.printf("| %-10s | %-10s | %-15s ","Ma hoa don","Ma ve","Gia tien");
		System.out.println();
		for(int i=0;i<this.tongCTHoaDon;i++) {
			if((dsCTHoaDon[i].getMaHoaDon().equalsIgnoreCase(tk1)||tk1.equalsIgnoreCase("x"))
			&&(dsCTHoaDon[i].getMaVe().equalsIgnoreCase(tk2)||tk2.equalsIgnoreCase("x"))
			&&(String.valueOf(dsCTHoaDon[i]).equals(tk3)||tk3.equalsIgnoreCase("x"))
			&&(String.valueOf(dsCTHoaDon[i]).equals(tk4)||tk4.equalsIgnoreCase("x"))
			&& dsCTHoaDon[i].getDeleted() != 1){
				dsCTHoaDon[i].xuat(); m++;
				System.out.println("");
			}
		}
		if(m == 0) {
			System.out.println("\n 	.....Khong tim thay ket qua tim kiem.....");
		}
	}
	public void sua() {
		System.out.println(" ------------ Sua chi tiet hoa don ------------");
		System.out.print(" - Hay nhap ma chi tiet hoa don can sua: ");
		String x = sc.next(); int m = 1;
		System.out.println("");
		// Nhap ma chi tiet hoa don sau do tuy chon cach sua.
		for (int i=0;i<this.tongCTHoaDon;i++) {
			if(dsCTHoaDon[i].getMaHoaDon().equalsIgnoreCase(x) && dsCTHoaDon[i].getDeleted() != 1) {
				System.out.println(" (1) Ma chi tiet hoa don");
				System.out.println(" (2) Ma ve");
				System.out.println(" (3) Gia tien");
				System.out.println(" (4) Tat ca");
				System.out.println(" (0) Thoat");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.print(" - Sua ma chi tiet hoa don: ");
						String ma = sc.next();
						dsCTHoaDon[i].setMaHoaDon(ma);
						break;
					case 2:
						System.out.print(" - Sua ma ve: ");
						String mave = sc.next();
						dsCTHoaDon[i].setMaVe(mave);
						break;
					case 3: 
						System.out.println(" - Sua gia tien: ");
						int giatien = sc.nextInt();
						dsCTHoaDon[i].setGiaTien(giatien);
						break;		
					case 4: 
						dsCTHoaDon[i].nhap();
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
			System.out.println("\n ------ Khong tim thay chi tiet hoa don ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("\n ----- Hoan tat thao tac -----");
		}
	}
	public void thongke() {
		System.out.println(" ------------ Thong ke ------------");
		System.out.println(" - Tong so chi tiet hoa don hien co: " + this.soCTHDHH);
	}
	
	///////
	public void truyXuatCTHD(String maHd) {
		for(int i=0;i<this.tongCTHoaDon;i++) {
			if(dsCTHoaDon[i] != null && dsCTHoaDon[i].getMaHoaDon().equalsIgnoreCase(maHd)) {
				dsCTHoaDon[i].xuat();
				System.out.println("");
			}
		}
	}
	public boolean Check_Available(String mave) {
		for(int i=0;i<this.tongCTHoaDon;i++) {
			if(dsCTHoaDon[i] != null && dsCTHoaDon[i].getMaVe().equalsIgnoreCase(mave)) {
				 return true;
			}
		}
		return false;
	}
	public int tongtien(String mahoadon){
		int tong=0;
		for(int i=0;i<this.tongCTHoaDon;i++) {
			if(dsCTHoaDon[i] != null && dsCTHoaDon[i].getMaHoaDon().equalsIgnoreCase(mahoadon)) {
				tong=dsCTHoaDon[i].getGiaTien()+tong;
			}
		}
		return tong;
	}
}