
import java.util.Scanner ;
public class Main {
    public static void main(String [] args){
        boolean tieptuc = true ;
        DanhSachVe danhSachVe=new DanhSachVe(999);
        danhSachVe.DocFile();
        while(tieptuc) {
            Scanner input = new Scanner(System.in) ;
            System.out.println("0. SO LUONG VE.");
            System.out.println("1. THEM VE.");
            System.out.println("2. SUA VE.");
            System.out.println("3. XOA VE.");
            System.out.println("4. TIM KIEM.");
            System.out.println("5. THONG KE.");
            System.out.println("6. DANH SACH VE.");
            System.out.print("Moi BAN NHAP LUA CHON : ");
            int luaChon = input.nextInt() ;
            switch(luaChon) {
                case 0 : 
                    System.out.println("Nhap So Luong Ve : ");
                    int n = input.nextInt() ;
                    danhSachVe.nhapSoLuongVe(n);
                    break ;
                case 1 : 
                    danhSachVe.themVe();
                    break ;
                case 2 : 
                    System.out.println("1- Sua PT | 2- Sua TG");
                    int suaVe = input.nextInt();
                    input.nextLine();
                    if (suaVe == 1) {
                        System.out.println("Nhap Hang Ve Can Sua : ");
                        String hangVe = input.nextLine();
                        danhSachVe.suaVePT(hangVe);
                    } else if (suaVe == 2) {
                        System.out.println("Nhap Dich Vu VIP Can Sua : ");
                        String dichVuVIP = input.nextLine();
                        danhSachVe.suaVeTG(dichVuVIP);
                    }

                    break ;
                case 3 : 
                    System.out.println("1-Xoa PT || 2-Xoa TG");
                    int loaiVe = input.nextInt() ;
                    input.nextLine() ;
                    if(loaiVe == 1) {
                        System.out.println("Nhap Hang Ve Can Xoa : ");
                        String hangVe = input.nextLine() ;
                        danhSachVe.xoaVePT(hangVe);
                        System.out.println("Da Xoa Sinh Vien Co DRL = " + hangVe);    
                    } else if(loaiVe == 2) {
                        System.out.println("Nhap Ma Phong Cho Can Xoa : ");
                        String maPhongCho = input.nextLine() ;
                        danhSachVe.xoaVeTG(maPhongCho);
                        System.out.println("Da Xoa Sinh Vien Co Nam Tot Nghiep = " + maPhongCho);
                    } 
                    break ; 
                case 4 :
                    System.out.println("1- Search PT | 2- Search TG");
                    int timKiem = input.nextInt() ;
                    input.nextLine() ;
                    if(timKiem == 1) {
                        System.out.println("Nhap Hang Ve Can Tim Kiem : ");
                        String hangVe = input.nextLine() ;
                        System.out.println("Thong Tin Ve PT : ");
                        danhSachVe.timKiemPT(hangVe);
                    } else if(timKiem == 2) {
                        System.out.println("Nhap Dich Vu VIP Can Tim Kiem : ");
                        String dichVuVIP = input.nextLine() ;
                        System.out.println("Thong Tin Ve PT : ");
                        danhSachVe.timKiemTG(dichVuVIP);
                    }
                    break ;
                case 5 : 
                    System.out.println("1- Thong Ke PT | 2- Thong Ke TG");
                    int thongKe = input.nextInt() ;
                    if(thongKe == 1) {
                        danhSachVe.thongKePT();
                    }
                    break ;
                case 6 : 
                    System.out.println("Danh Sach Ve : ");
                    danhSachVe.hienThiVe();
                    break ;
                default: tieptuc=false;
            }
        }
        danhSachVe.LuuFile();
    }
}
