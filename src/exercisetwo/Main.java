
package exercisetwo;

import java.util.Scanner;

/**
 *
 * @author erisa
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ManageKaryawan manageKaryawan = new ManageKaryawan();
        
        while (true) {
            System.out.println("======DAFTAR KARYAWAN===========");
            manageKaryawan.displayKaryawan();
            
            System.out.println("");
            System.out.println("=========PILIHAN MENU==========");
            System.out.println("1. Tambah Data Karywan");
            System.out.println("2. Ubah Data Karyawan");
            System.out.println("3. Hapus Data Karyawan");
            System.out.println("0. Exit Aplikasi");
            System.out.println("");
            System.out.print("INPUT MENU : ");
            int selectionMenu = scanner.nextInt();
            scanner.nextLine();
            
            //logic untuk pilihan menu
            switch(selectionMenu) {
                case 1:
                    manageKaryawan.addKaryawan(scanner);
                    break;
                case 2:
                    manageKaryawan.updateKaryawan(scanner);
                    break;
                case 3:
                    manageKaryawan.deleteKaryawan(scanner);
                    break;
                case 0:
                    manageKaryawan.exitApp();
                    return;
                default:    
                    System.out.println("Kode Menu Yang Anda Input Tidak Valid!");
                    
            } 
        }   
    } 
}
