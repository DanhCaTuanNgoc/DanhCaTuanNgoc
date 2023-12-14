import java.util.Scanner;
public class VeThuongGia extends Ve {
    private String maPhongCho;
    private String dichVuVIP;

    public VeThuongGia() {
        super();
        maPhongCho = "";
        dichVuVIP = "";
    }

    public VeThuongGia(String maVe, String maChuyenBay, String giaVe, String maPhongCho, String dichVuVIP) {
        super(maVe, maChuyenBay, giaVe);
        this.maPhongCho = maPhongCho;
        this.dichVuVIP = dichVuVIP;
    }

    public VeThuongGia(VeThuongGia tg1) {
        super(tg1);
        maPhongCho = tg1.maPhongCho;
        dichVuVIP = tg1.dichVuVIP;
    }
    // ABSTRACT
    @Override
    public String getLoaiVe() {
        return "Day La Ve Thuong Gia";
    }

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

    @Override
    public void nhap() {
        Scanner input = new Scanner(System.in) ;
        super.nhap();
        System.out.print("Nhap Ma Phong Cho: ");
        maPhongCho = input.nextLine();
        System.out.print("Nhap Dich Vu VIP : ");
        dichVuVIP = input.nextLine() ;
    }

    @Override
public void xuat() {
    super.xuat(); // Gọi phương thức xuat() của lớp cha để hiển thị thông tin chung
    System.out.println("Ma Phong Cho: " + maPhongCho);
    System.out.println("Dich Vu VIP: " + dichVuVIP);
}
    // test
    public static void main(String[] args) {
        Ve tg = new VeThuongGia();
        tg.nhap();
        tg.xuat();
        System.out.println(tg.getLoaiVe());
    }
}

