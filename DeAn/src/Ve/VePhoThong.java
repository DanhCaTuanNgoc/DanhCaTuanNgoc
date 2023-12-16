
package Ve;

import ChuyenBay.DanhSachChuyenBay;

public class VePhoThong extends Ve {
    private String hangVe;
    DanhSachChuyenBay ds=new DanhSachChuyenBay(100);
    // CONSTRUCTOR DEFAULT / PROPERTY / COPY
    public VePhoThong() {
        hangVe = "";
    }
    public VePhoThong(String maVe, String maChuyenBay, int gia, String hangVe, int Deleted) {
        super(maVe, maChuyenBay, gia,Deleted);
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
        ds.docfile();
		System.out.print(" - Moi nhap ma ve: ");
		this.maVe = sc.nextLine();
        System.out.print(" - Nhap ma chuyen bay: ");
        this.maChuyenBay=sc.nextLine();
        while(! ds.Check_Available(maChuyenBay)){
            System.err.print("Ma chuyen bay khong ton tai!Vui long nhap lai");
            System.out.print(" - Nhap ma chuyen bay: ");
            this.maChuyenBay=sc.nextLine();
        }
        System.out.print(" - Loai Hang Ve: ");
        this.hangVe = sc.nextLine();		
		System.out.print(" - Gia ve(VND): ");
		gia = sc.nextInt();
    }
    // OUTPUT
    @Override
    public void xuat() {
        System.out.format("| %-8s | %-8s | %-8.2s | %-9s", maVe, maChuyenBay, gia, hangVe);
    }
   @Override
   public void loaive(){
        System.out.print("ve pho thong");
   }
}