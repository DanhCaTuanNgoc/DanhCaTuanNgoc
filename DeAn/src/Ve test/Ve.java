
import java.util.Scanner ;
public abstract class Ve  {
    private String maVe ;
    private String maChuyenBay ;
    private String giaVe ;
    
    // CONSTRUCTOR DEFAULT
    public Ve() {
        maVe = "" ;
        maChuyenBay = "" ;
        giaVe = "" ;
    }
    // CONSTRUCTOR PORPERTY
    public Ve(String maVe , String maChuyenBay , String giaVe) {
        this.maVe = maVe ;
        this.maChuyenBay = maChuyenBay ;
        this.giaVe = giaVe ;
    }
    // COPY CONSTRUCTOR
    public Ve(Ve ve1) {
        maVe = ve1.maVe ;
        maChuyenBay = ve1.maChuyenBay ;
        giaVe = ve1.giaVe ;
    }
    // GETTER AND GET
    public String getMaVe() {
        return maVe ;
    }
    public String getMaChuyenBay() {
        return maChuyenBay ;
    }
    public String getGiaVe() {
        return giaVe ;
    }
    public void setMaVe(String maVe) {
        this.maVe = maVe ;
    }
    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay ;
    }
    public void setGiaVe(String giaVe) {
        this.giaVe = giaVe ;
    }
     //ABSTRACT 
    public abstract String getLoaiVe() ;
    
    //METHOD
    public void nhap() {
        Scanner input = new Scanner(System.in) ;
        System.out.print("Nhap Ma Ve : ");
        maVe = input.nextLine() ;
        System.out.print("Nhap Ma Chuyen Bay : ");
        maChuyenBay = input.nextLine() ;
        System.out.print("Nhap Gia Ve : ");
        giaVe =input.nextLine() ;
    }
    public void xuat() {
    System.out.println("Thong Tin Ve: " );
    System.out.println("Ma Ve: " + maVe + 
            " / Ma Chuyen Bay: " + maChuyenBay + 
            " / Gia Ve: " + giaVe);
    }
}
