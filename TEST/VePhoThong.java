/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

/**
 *
 * @author Luong Thanh Tuan
 */
import java.io.*;
public class VePhoThong extends Ve {
    DanhSachVe dsv = new DanhSachVe();
    //DanhSachChuyenBay dsCB = new DanhSachChuyenBay();
    private String hangVe;
    // CONSTRUCTOR DEFAULT / PROPERTY / COPY
    public VePhoThong() {
        hangVe = "";
    }
    public VePhoThong(String maVe, String maChuyenBay, float gia, String hangVe) {
        super(maVe, maChuyenBay, gia);
        this.hangVe = hangVe;
    }
    public VePhoThong(VePhoThong a) {
        super((Ve) a);
        hangVe = a.hangVe;
    }
    // GET AND SET
     public String getHangVe() {
        return hangVe;
    }

    public void setHangVe(String hangVe) {
        this.hangVe = hangVe;
    }
    // INPUT
    @Override
    public void Nhap() {
        do {
			System.out.println("Khi nhap ma ve, toi thieu 3 ki tu va toi da 5 ki tu:");
			System.out.print("MMoi nhap ma Ve: ");
			maVe = sc.nextLine();
			if(maVe.length() < 3 || maVe.length() > 5) 
				System.err.println("Ban nhap thua haoc thieu ki tu moi nhap lai!!!");
		}while(maVe.length() < 3 || maVe.length() > 5);
		
		
		// KHOA NGOAI
//		do {
//			dsCB.DocFileJava("ChuyenBay.txt");
//			dsCB.XuatDanhSach();
//			System.out.print("Nhap ma chuyen bay: ");
//			dsCB = sc.nextLine();
//			if(dsCB.TruyenDuLieu_CB(maChuyenBay) == null)
//				System.err.println("\nMa chuyen bay khong hop le hoac khong cho trong danh sach!!!");
//		}while(dsCB.TruyenDuLieu_CB(maChuyenBay) == null);
		do {
                System.out.println("Hang Ve Co 2 Loai: ");
                System.out.println("1.Neu La Hang Ve Tieu Chuan Thi Nhap(a|A): ");
                System.out.println("2.Neu La Hang Ve Pho Thong Tiet Kiem Thi Nhap(b|B): ");
                System.out.print("Loai Hang Ve: ");
                hangVe = sc.nextLine();
                if((!"a".equals(hangVe) && !"A".equals(hangVe) && !"b".equals(hangVe) && !"B".equals(hangVe))) {
                    System.err.println("Nhap Sai Ki Tu!!!");
                }
                }while((!"a".equals(hangVe) && !"A".equals(hangVe) && !"b".equals(hangVe) && !"B".equals(hangVe)));
		
		System.out.print("Gia cua moi ve(VND): ");
		gia = sc.nextFloat();
    }
    // OUTPUT
    @Override
    public void Xuat() {
        System.out.format("| %-8s | %-8s | %-8.2f | %-9s\n", maVe, maChuyenBay, gia, hangVe);
    }
    // FILE
    @Override
	public void GhiFile(String filename) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, Boolean.TRUE));
		int code = 0;
		dos.writeInt(code);
		dos.writeUTF(maVe);
		dos.writeUTF(maChuyenBay);
		dos.writeFloat(gia);
                dos.writeUTF(hangVe);
		dos.close();
	}
   
}