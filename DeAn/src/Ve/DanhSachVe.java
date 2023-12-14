package Ve;

import ChuyenBay.ChuyenBay;

import java.util.Arrays;
import java.util.Scanner;

final class DanhSachVe {
	private Ve [] dsVe;
	private ChuyenBay [] dsChuyenBay;
	private int tongVe; 
	
	// constructor 
	public DanhSachVe() {
		dsVe = new Ve[1];
		tongVe = 0;
	}
	public DanhSachVe(Ve [] dsve, int tongve) {
		this.dsVe = dsve;
		this.tongVe = tongve;
	}
	public DanhSachVe(DanhSachVe a) {
		this.dsVe = a.dsVe;
		this.tongVe = a.tongVe;
	}
	
	// get/set
	public Ve[] getDsVe() {
		return dsVe;
	}
	public void setDsVe(Ve[] dsVe) {
		this.dsVe = dsVe;
	}
	public int getTongVe() {
		return tongVe;
	}
	public void setTongVe(int tongve) {
		this.tongVe = tongve;
	}

	
	// methods
	Scanner sc = new Scanner(System.in);
	int tg = 0; int pt = 0;
	public void them() {
		System.out.println("                ----- Them ve -----");
		System.out.print("Nhap so ve muon them: ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			this.tongVe++;
			dsVe = Arrays.copyOf(dsVe, this.tongVe);
			System.out.print("Ban muon them ve phothong/thuonggia (1/2): ");
			int loaive = sc.nextInt();
	        Ve ve = null;
	        switch(loaive) {
	        	case(1): 
	        		ve = new PhoThong();
        			dsVe[this.tongVe - 1] = ve;
	        		ve.nhap(); pt++;
	        		break;
	        	case(2): 
	        		ve = new ThuongGia();
        			dsVe[this.tongVe - 1] = ve;
	        		ve.nhap(); tg++;
	        		break;
	        	default: 
	        		System.out.println("Vui long nhap lai.");
	        		i--; continue;
	        }
		}
	}
	public void xemds() {
		System.out.println("                ----- Danh sach ve -----");
		System.out.println("Tong ve: " + this.tongVe);
		for(Ve ve : dsVe) {
			if(ve != null) {
				ve.xuat();
				System.out.println("");
			}
		}
	}
	public void xoa() {
		System.out.println("                ----- Xoa ve -----");
		System.out.print("Hay nhap ma ve can xoa: ");
		int x = sc.nextInt();
		int delete_point = -1;		
		for(int i=0;i<this.tongVe;i++){
			if(dsVe[i].getMaVe() == x) {
				delete_point = i;
				if(dsVe[i] instanceof PhoThong) {pt--;}
				else {tg--;}
				break;
			}
		}
		if(delete_point != -1) {
			for(int i=delete_point;i<this.tongVe-1;i++) {
				dsVe[i] = dsVe[i+1];
			}
			this.tongVe--;
			dsVe = Arrays.copyOf(dsVe, this.tongVe);
			System.out.println("Da xoa ma ve " + x);
		} else {
			System.out.println("Khong tim thay ma ve " + x);
		}
	}
	public void timkiem() {
		System.out.println("                ----- Tim kiem ve -----");
		System.out.println("                1. Tim theo ma ve.");
		System.out.println("                2. Tim theo hang ve pho thong.");
		System.out.println("                3. Tim theo hang ve thuong gia.");
		System.out.println("                4. Thoat.");
		System.out.print("Chon hanh dong: ");
		int n = sc.nextInt();
		switch(n) {
			case 1:
				System.out.print("Hay nhap ma ve tim kiem: ");
				int x = sc.nextInt();
				int m = 1;
				for(Ve ve : dsVe) {
					if(ve.getMaVe() == x) {
						ve.xuat();
						m++;
						break;
					}
				}
				if(m == 1) {
					System.out.println("Khong tim thay ma ve " + x);
				}
				System.out.println("");
				break;
			case 2:
				System.out.println("Cac ve hang pho thong: ");
				for(Ve ve : dsVe) {
					if(ve != null) {
						if(ve instanceof PhoThong) {
							ve.xuat();
							System.out.println("");
						}
					} else {continue;}
				}
				break;
			case 3: 
				System.out.println("Cac ve hang thuong gia: ");
				for(Ve ve : dsVe) {
					if(ve != null) {
						if(ve instanceof ThuongGia) {
							ve.xuat();
							System.out.println("");
						}
					} else {
						continue;
					}
				}
				break;
			case 4: break;
			default: break;
		}
	}
	public void sua() {
		System.out.println("                ----- Sua ve -----");
		System.out.print("Hay nhap ma ve can sua: ");
		int x = sc.nextInt(); int m = 1;
		for(int i=0;i<this.tongVe;i++) {
			if(dsVe[i].getMaVe() == x) {
				if(dsVe[i] instanceof PhoThong) {
					dsVe[i] = new PhoThong(); dsVe[i].nhap();
				} else if(dsVe[i] instanceof ThuongGia) {
					dsVe[i] = new ThuongGia(); dsVe[i].nhap();
				} else {
					System.out.println("NULL");
				}
				m++;
			}
		}
		if(m == 1) {
			System.out.println("Khong tim thay ma ve " + x);
		}
	}
	public void nanghang() {
		System.out.println("                ----- Nang hang ve -----");
		System.out.print("Nhap ma ve pho thong can nang hang: ");
		int x = sc.nextInt(); int m = 1;
		for(int i=0;i<this.tongVe;i++) {
			if(dsVe[i].getMaVe() == x) {
				m++;
				if(dsVe[i] instanceof ThuongGia) {
					System.out.println("Khong the nang hang cho ve thuong gia !!!");
				} else if(dsVe[i] instanceof PhoThong) {
					pt--; tg++;
					dsVe[i] = new ThuongGia(); dsVe[i].nhap();
					System.out.println("Nang hang thang cong cho ma ve " + x);
				}
			}
		}
		if(m == 1) {
			System.out.println("Khong tim thay ve co ma ve " + x);
		}
	}
	public void thongke() {
		System.out.println("                ----- Thong ke -----");
		System.out.println("Tong ve: " + this.tongVe);
		System.out.println("So ve Pho Thong: " + pt);
		System.out.println("So ve Thuong Gia: " + tg);
		System.out.print("Danh sach phong cho duoc su dung: ");
		for(Ve ve : dsVe) {
			if(ve instanceof ThuongGia) {
				System.out.print(((ThuongGia)ve).getMaPhongCho() + " ");
			}
		}
		System.out.println("");
	}




//	package com.ThongTinChuongTrinh;
//
//	import java.util.Date;
//	import java.text.SimpleDateFormat;
//	import java.util.Calendar;
//
//	public class ThongTinChuongTrinh {
//
//	    String sPhienBan, sTenChuongTrinh, sMoTa, sTeamDev;
//	    Date dtNgayBatDau, dtNgayKetThuc;
//
//	    ThongTinChuongTrinh(String sPhienBan, String sTenChuongTrinh, String sMoTa, String sTeamDev, Date dtNgayBatDau, Date dtNgayKetThuc) {
//	        this.sPhienBan = sPhienBan;
//	        this.sTenChuongTrinh = sTenChuongTrinh;
//	        this.sMoTa = sMoTa;
//	        this.sTeamDev = sTeamDev;
//	        this.dtNgayBatDau = dtNgayBatDau;
//	        this.dtNgayKetThuc = dtNgayKetThuc;
//	    }
//
//	    public static void display() {
//	        Calendar calStart = Calendar.getInstance();
//	        calStart.set(2023, Calendar.NOVEMBER, 8, 20, 30);
//	        Date startDate = calStart.getTime();
//
//	        Calendar calEnd = Calendar.getInstance();
//	        calEnd.set(2023, Calendar.JANUARY, 1);
//	        Date endDate = calEnd.getTime();
//
//	        ThongTinChuongTrinh chuongTrinh = new ThongTinChuongTrinh(
//	                "1.0.0",
//	                "Chuong trinh Ban van phong pham",
//	                "",
//	                "1. Nguyen Dai Quoc\n"
//	                + "   - Facebook: fb.com/wolfdzai\n"
//	                + "   - Email: luutrithon1996@gmail.com\n"
//	                + "   - Phone: 0931454176\n"
//	                + "2. Dinh Phuc Thinh\n"
//	                + "   - Facebook: fb.com/dinfucthin\n"
//	                + "   - Email: zaikaman123@gmail.com\n"
//	                + "   - Phone: 0931816175\n"
//	                + "3. Tran Trung Viet\n"
//	                + "   - Facebook: cutt.ly/qwTNnwZY\n"
//	                + "4. Tran Dang Phat\n"
//	                + "   - Facebook: cutt.ly/TwTNb3Ur\n"
//	                + "5. Nguyen Hoang Sang\n"
//	                + "   - Facebook: cutt.ly/4wTNbGKf\n"
//	                + "   - Email: lesang01227982715@gmail.com\n"
//	                + "   - Phone: 0776592967\n",
//	                startDate,
//	                endDate
//	        );
//	        Date check = new Date();
//	        System.out.println("Chuong trinh: " + chuongTrinh.sTenChuongTrinh);
//	        System.out.println("Version: " + chuongTrinh.sMoTa);
//	        System.out.println("Release Date: " + chuongTrinh.dtNgayBatDau);
//	        if (chuongTrinh.dtNgayKetThuc == check) {
//	            System.out.println("Stop Date: " + chuongTrinh.dtNgayKetThuc);
//	        }
//	        System.out.println("Dev team:");
//	        System.out.println(chuongTrinh.sTeamDev);
//	    }
//
//	}
}


