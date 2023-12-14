package TEST;

import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ChiTietHoaDon {
//	DanhSachNhanVien dsnv = new DanhSachNhanVien();
//	DanhSachVe dsv = new DanhSachVe();
//	DanhSachKhachHang dskh = new DanhSachKhachHang();
//	DanhSachHoaDon dshd = new DanhSachHoaDon();
	
	private String maHoaDon, maKhachHang, maVe, maNhanVien;
	private int sl;
	private double thanhtien, giaVe;
	Scanner sc = new Scanner(System.in);
	//CONSTRUCTOR
	public ChiTietHoaDon() {

	}
	public ChiTietHoaDon(String maHoaDon, String maKhachHang, String maVe, String maNhanVien, int sl, double thanhtien) {
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.maVe = maVe;
		this.maNhanVien = maNhanVien;
		this.sl = sl;
		this.thanhtien = thanhtien;
		
	}

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
	public void Nhap() {
		do {
			System.out.print("\nMa hoa don toi thieu 3 toi da 4 ki tu: ");
			maHoaDon = sc.nextLine();
			if(maHoaDon.length() < 3 || maHoaDon.length() > 4)
				System.err.println("Ma hoa don bi thieu hoac thua ki tu!!!");;
		}while(maHoaDon.length() < 3 || maHoaDon.length() > 4);
		
		
		do {
			dsKhachHang.DocFileJava("KhachHang.txt");
			dsKhachHang.XuatDanhSach();
			System.out.print("Nhap ma khach hang: ");
			maKhachHang = sc.nextLine();
			if(dskh.TruyenDuLieu_KH(maKhachHang) == null)
				System.err.println("\nMa khach hang khong hop le hoac khong co trong danh sach!!!");
		}while(dskh.TruyenDuLieu_KH(maKhachHang) == null);
		tenKH = dskh.TruyenDuLieu_KH(maKhachHang);
                
                do {
			dsnv.DocFileJava("NhanVien.txt");
			dsnv.XuatDanhSachNV();
			System.out.print("Nhap ma nhan vien phu trach: ");
			maNhanVien = sc.nextLine();
			if(dsnv.timKiem_MNV(maNhanVien) == null) {
				System.err.println("\nMa nhan vien khong hop le hoac khong co trong danh sach!!!");
			}
		}while(dsnv.timKiem_MNV(maNhanVien) == null);
		maNhanVien = dsnv.timKiem_MNV(maNhanVien);
		
		do {
                        dsv.DocFileJava("Ve.txt");
                        dsv.XuatDanhSach();
                        System.out.print("Nhap ma ve: ");
                        maVe = sc.nextLine();
                        if (!dsv.timKiem_MV(maVe)) {
                            System.err.println("\nMa ve khong hop le hoac khong co trong danh sach!!!");
                        } else {
                        // Ở DSVE TẠO THÊM METHOD LẤY GIÁ VÉ ĐỂ TÍNH THÀNH TIỀN
                        giaVe = dsv.layGiaVe(maVe); 
                        
                    }
                } while (!dsv.timKiem_MV(maVe));
                System.out.println("Nhap so luong khach hang dat ve: ");
                sl = sc.nextInt();
                thanhtien = sl * giaVe;
            }
		
	}
	
	public void Xuat() {
		System.out.format(" %10s | %13s | %30s | %25s | %15s | %15s  ||\n", maHoaDon, maVe, maKhachHang, maNhanVien, sl, thanhtien);
	}
	//ĐỌC FILE GHI FILE
	public void GhiFile(String filename) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, Boolean.TRUE));
		dos.writeUTF(maHoaDon);
                dos.writeUTF(maVe);
		dos.writeUTF(maKhachHang);
		dos.writeUTF(maNhanVien);
		dos.writeInt(sl);
		dos.writeDouble(thanhtien);
		dos.close();
	}
}
