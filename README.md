# Penjelasan SIngkat
Program ini dirancang untuk menemukan solusi IQ Puzzler Pro menggunakan pendekatan brute force. Program akan mencoba semua kemungkinan kombinasi peletakan blok pada papan hingga menemukan solusi yang sesuai. Jika solusi ditemukan, program akan menampilkan papan permainan beserta warna untuk setiap blok yang ditempatkan.

# Requirement Program
Program ini ditulis dalam bahasa Java, pastikan bahwa Java telah terinstall.
java -version

# Struktur Program
PuzzlerSolver/
├── bin/
├── doc/
│   ├── Tucil1_13523157.pdf
├── src/
│   ├── Blok.Java
│   ├── Main.java   
│   ├── Papan.java 
│   ├── PuzzleSolver.java 
│   ├── TxtHandler.java 
├── test/
│   ├── hasil/
│   │     ├── solusi_testcase1.txt
│   │     ├── solusi_testcase2.txt
│   │     ├── solusi_testcase4.txt
│   │     ├── solusi_testcase5.txt
│   │     ├── solusi_testcase6.txt
│   │     ├── solusi_testcase7.txt
│   ├── testcase1.txt
│   ├── testcase2.txt
│   ├── testcase3.txt
│   ├── testcase4.txt
│   ├── testcase5.txt
│   ├── testcase6.txt
│   ├── testcase7.txt
└── README.md   

# Cara Mengkompilasi Program
git clone https://github.com/nataliadesiany/Tucil1_13523157

Kompilasi semua file Java dengan perintah berikut:
javac -d bin src/*.java

# Cara Menjalankan Program
Jalankan program di terminal dengan perintah:
java -cp bin Main

1. Kemudian, masukkan file input yang berisi testcase dan tuliskan nama file berformat .txt ke dalam folder test.
2. Program akan langsung memproses solusi dan menampilkan hasil pada terminal.
3. Pengguna kemudian dapat menentukan apakah hasil akan disimpan dengan mengetik "ya" atau "tidak".
4. Jika pengguna memilih untuk menyimpan, maka file berisi solusi testcase akan tersimpan di folder test.

# Author
Natalia Desiany Nursimin - 13523157 - K03
