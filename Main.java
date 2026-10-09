import java.util.Scanner;

// Class Mahasiswa
class Mahasiswa {
    // Attribute
    String nama;
    String NIM;
    double nilai;

    // Constructor untuk mengisi data mahasiswa
    Mahasiswa(String nama, String NIM, double nilai) {
        this.nama = nama;
        this.NIM = NIM;
        this.nilai = nilai;
    }

    // Method untuk menampilkan data mahasiswa
    void tampilkanData() {
        System.out.println("Nama  : " + nama);
        System.out.println("NIM   : " + NIM);
        System.out.println("Nilai : " + nilai);
        cekKelulusan();
    }

    // Method untuk memeriksa kelulusan
    void cekKelulusan() {
        if (nilai >= 60) {
            System.out.println("Status: Lulus");
        } else {
            System.out.println("Status: Tidak Lulus");
        }
    }
}

// Class utama program
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menyimpan maksimal 100 objek mahasiswa
        Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
        int jumlah = 0;
        int pilihan;

        // Loop untuk menampilkan menu
        do {
            System.out.println("\n=== PROGRAM DATA MAHASISWA ===");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {
                if (jumlah < daftarMahasiswa.length) {
                    System.out.println("\n--- Input Data Mahasiswa ---");

                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan NIM: ");
                    String NIM = input.nextLine();

                    System.out.print("Masukkan nilai: ");
                    double nilai = input.nextDouble();
                    input.nextLine();

                    // Membuat objek mahasiswa
                    daftarMahasiswa[jumlah] =
                        new Mahasiswa(nama, NIM, nilai);

                    jumlah++;

                    System.out.println("Data mahasiswa berhasil ditambahkan!");
                } else {
                    System.out.println("Data mahasiswa sudah penuh!");
                }

            } else if (pilihan == 2) {
                if (jumlah == 0) {
                    System.out.println("Belum ada data mahasiswa.");
                } else {
                    System.out.println("\n=== DAFTAR DATA MAHASISWA ===");

                    // Loop untuk menampilkan seluruh data
                    for (int i = 0; i < jumlah; i++) {
                        System.out.println("\nMahasiswa ke-" + (i + 1));
                        daftarMahasiswa[i].tampilkanData();
                    }
                }

            } else if (pilihan == 3) {
                System.out.println("Program selesai. Terima kasih!");

            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 3);

        input.close();
    }
}
