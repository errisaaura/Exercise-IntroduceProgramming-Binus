package exercisetwo;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/**
 *
 * @author erisa
 */
public class ManageKaryawan {
    
    private static final ArrayList<Karyawan> listKaryawan = new ArrayList<>();
    private static int counter = 1;
    
    private static String getCurrentDate() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter myformat = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(myformat);
    }
    
    private static String generateId() {
        String dateNow = getCurrentDate();
        
        return dateNow + String.format("%05d", counter++);
    }
    
    private static Karyawan findKaryawanByName(String name) {
        for (Karyawan karyawan : listKaryawan) {
            if (karyawan.getName().equalsIgnoreCase(name)) {
                return karyawan;
            }
        }
        return null;
    }
    
    private Karyawan findKaryawanById(String id) {
        for (Karyawan karyawan : listKaryawan) {
            if (karyawan.getId().equals(id)) {
                return karyawan;
            }
        }
        return null;
    }
    
    public void displayKaryawan(){
        if(!(listKaryawan.isEmpty())){
            for(int i = 1; i <= listKaryawan.size(); i++){
                System.out.println("Karyawan#" + i);
                System.out.println(listKaryawan.get(i - 1) + "\n");
            }
        }else{
            System.out.println("Tidak ada data karyawan.");
        }
    }
    
    public void addKaryawan(Scanner scanner) {
        System.out.print("Masukkan nama karyawan: ");
        String name = scanner.nextLine();

        Karyawan foundKaryawan = findKaryawanByName(name);

        if (foundKaryawan != null) {
            System.out.println("Nama karyawan duplikat");
        } else {
            String id = generateId();
            Karyawan karyawanBaru = new Karyawan(id, name);
            listKaryawan.add(karyawanBaru);

            System.out.println("Data karyawan berhasil ditambahkan!");
        }
    }
    
    public void updateKaryawan(Scanner scanner) {
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();

        Karyawan foundKaryawan = findKaryawanById(id);
        if (foundKaryawan != null) {
            System.out.print("Masukkan nama karyawan yang baru: ");
            String newName = scanner.nextLine();

            foundKaryawan.setName(newName);

            System.out.println("Data karyawan berhasil diubah!");
        } else {
            System.out.println("Mohon maaf data karyawan tidak ditemukan!");

        }
    }
    
    public void deleteKaryawan(Scanner scanner) {
        System.out.print("Masukkan ID Karyawan: ");
        String id = scanner.nextLine();

        Karyawan foundKaryawan = findKaryawanById(id);
        if (foundKaryawan != null) {
            listKaryawan.remove(foundKaryawan);

            System.out.println("Data karyawan berhasil dihapus!");
        }else{
            System.out.println("Mohon maaf data karyawan tidak ditemukan!");
        }
    }
    
    public void exitApp(){
        listKaryawan.clear();
        System.out.println("Semua data karyawan telah dihapus dan terima kasih telah menggunakan aplikasi pendataan kami...");
    }
    
}


class Karyawan {
    String id;
    String name;
    
    public Karyawan (String id, String name) {
        this.id = id; 
        this.name = name; 
    }
    
    //setting set and get untuk akses 
    public String getName(){
        return name;
    }
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name; 
    }
    
    
    @Override
    public String toString() {
        return "ID " + id + "\nNama: " + name;
    }
    
}