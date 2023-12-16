
import java.util.Scanner ;
public class VePhoThong extends Ve {
    private String hangVe;
    // CONSTRUCTOR DEFAULT
    public VePhoThong() {
        super();
        hangVe = "" ; 
    }
    // CONSTRUCTOR PROPERTY 
    public VePhoThong(String maVe, String maChuyenBay, String giaVe, String hangVe) {
        super(maVe, maChuyenBay, giaVe);
        this.hangVe = hangVe;
    }
    // COPY CONSTRUCTOR 
    public VePhoThong(VePhoThong pt1) {
        super(pt1);
        hangVe = pt1.hangVe;
    }
    // ABSTRACT
    @Override
    public String getLoaiVe() {
        return "Day La Ve Pho Thong";
    }
    // GET AND SET
    public String getHangVe() {
        return hangVe;
    }
    public void setHangVe(String hangVe) {
        this.hangVe = hangVe;
    }
    
    // METHOD
    @Override
    public void nhap() {
        Scanner input = new Scanner(System.in) ;
        super.nhap();
        System.out.print("Nhap Hang Ve : ");
        hangVe = input.nextLine();
    }
    @Override
    public void xuat() {
        System.out.println("Thong Tin Ve Pho Thong : ");
        super.xuat() ;
        System.out.println(" / Hang Ve : " + hangVe);
    }
    //TESST ABSTRACT
    public static void main(String[] args) {
        Ve pt = new VePhoThong() ;
        pt.nhap();
        pt.xuat(); 
        System.out.println(pt.getLoaiVe());
    }
}
