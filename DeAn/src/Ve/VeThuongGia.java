package Ve;

import ChuyenBay.DanhSachChuyenBay;

public class VeThuongGia extends Ve {
    DanhSachChuyenBay ds=new DanhSachChuyenBay(100);
    DanhSachVe ve=new DanhSachVe(100);
    private String maPhongCho, dichVuVIP;
    // CONSTRUCTOR DEFAULT / PROPERTY / COPY
    public VeThuongGia() {
        maPhongCho = "";
        dichVuVIP = "";
    }
    public VeThuongGia(String maVe, String maChuyenBay, int gia, String maPhongCho, String dichVuVIP,int deleted) {
        super(maVe, maChuyenBay, gia,deleted);
        this.maPhongCho = maPhongCho;
        this.dichVuVIP = dichVuVIP;
    }
    public VeThuongGia(VeThuongGia a) {
        super((Ve) a);
        maPhongCho = a.maPhongCho;
        dichVuVIP = a.dichVuVIP;
    }
    // GET AND SET
    public String getMaPhongCho() {
        return maPhongCho;
    }

    public void setMaPhongCho(String maPhongCho) {
        this.maPhongCho = maPhongCho;
    }

    public String getDichVuVIP() {
        return dichVuVIP;
    }

    public void setDichVuVIP(String dichVuVIP) {
        this.dichVuVIP = dichVuVIP;
    }
    // INPUT
    @Override
    public void nhap() {
        ds.docfile();
		System.out.print(" - Moi nhap ma Ve: ");
		maVe = sc.nextLine();
        while(ve.Check_Available(maVe)){
            System.err.print(" Ma ve da ton tai ! Vui long nhap lai");
            System.out.print(" - Nhap ma ve: ");
            this.maVe=sc.nextLine();
        }
        System.out.print(" - Nhap ma chuyen bay: ");
        this.maChuyenBay=sc.nextLine();
        while(!ds.Check_Available(maChuyenBay)){
            System.out.println(" Ma chuyen bay khong ton tai ! Vui long nhap lai!");
            System.out.print(" - Nhap ma chuyen bay: ");
            this.maChuyenBay=sc.nextLine();
        }
        System.out.print(" - Gia Tien Cua Ve(VND): ");
        gia = sc.nextInt();
        sc.nextLine();
        System.out.print(" - Nhap Ma Phong Cho: ");
        maPhongCho = sc.nextLine();       
        System.out.print(" - Dich Vu VIP: ");
        dichVuVIP = sc.nextLine();
        
    }
    // OUTPUT
    @Override
    public void xuat() {
        System.out.format("| %-10s | %-15s | %-15s | %-14s | %-10s ", maVe, maChuyenBay, gia, maPhongCho, dichVuVIP);

    }
    @Override
    public void loaive(){
        System.out.print("| ve thuong gia");
    }
}