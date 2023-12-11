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
    public void nhap() {
        do {
            System.out.println(" - Ma Ve (Toi Thieu 3 Ki Tu Va Toi Da 5 Ki Tu): ");
            System.out.println(" - Nhap Ma Ve: ");
            maVe = sc.nextLine();
            if(maVe.length() < 3 || maVe.length() > 5) {
                System.err.println(" --- Nhap Thieu Hoac Thua Ki Tu, Hay Nhap Lai!!! ---");
            }
        }while(maVe.length() < 3 || maVe.length() > 5);
        // UPDATTING ...
        
        System.out.println(" - Gia Tien Cua Ve(VND): ");
        gia = sc.nextFloat();
        sc.nextLine();
        do {
            System.out.println("Hang Ve Co 2 Loai: ");
            System.out.println("1.Neu La Hang Ve Tieu Chuan Thi Nhap(a|A): ");
            System.out.println("2.Neu La Hang Ve Pho Thong Tiet Kiem Thi Nhap(b|B): ");
            System.out.println(" - Loai Hang Ve: ");
            hangVe = sc.nextLine();
            if((!"a".equals(hangVe) && !"A".equals(hangVe) && !"b".equals(hangVe) && !"B".equals(hangVe))) {
                System.err.println(" --- Nhap Sai Ki Tu!!! ---");
            }
        }while((!"a".equals(hangVe) && !"A".equals(hangVe) && !"b".equals(hangVe) && !"B".equals(hangVe)));
    }
    // OUTPUT
    @Override
    public void xuat() {
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
