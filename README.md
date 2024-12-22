# Swift Strider

Swift Strider adalah aplikasi fitness yang memanfaatkan teknologi Android, termasuk
Jetpack Compose, arsitektur MVVM, dan Google Maps API. Aplikasi ini memungkinkan pengguna untuk
melacak aktivitas lari mereka, menampilkan rute waktu nyata di peta interaktif
sambil menyimpan statistik penting menggunakan database Room.

## Anggota Kelompok
- Cliff Reynard (00000075936)
- Maha Ligat Dewa Cindra (00000075361)
- Andre Gamalion (00000076974)
- Michael Squanto M (00000059593)

## Fitur
1. Pelacakan langsung aktivitas lari menggunakan GPS.
2. Pelacakan jalur lari pengguna di Peta menggunakan perpustakaan Google Map Compose.
3. Menggunakan Layanan Foreground, bahkan pengguna menutup aplikasi dan menghapusnya
   dari latar belakang, aplikasi ini masih terus melacak statistik lari pengguna.
4. Ruang database untuk menyimpan dan mengelola statistik yang sedang berjalan.
5. Menangani navigasi bersarang, Tautan dalam, navigasi bersyarat ke aktif
   layar boarding menggunakan Komponen Navigasi Jetpack.
6. Pemilih gambar Jetpack Compose baru - membantu memilih gambar
   tanpa izin apa pun.
7. Integrasi Page3.
8. Dukungan warna dinamis dalam tema gelap dan terang.
9. Statistik Mingguan dengan filter dalam grafik.

## Package Structure

* [`background`](app/src/main/java/com/kel2/swiftstrider/background): Menangani terkait latar belakang
  proses seperti layanan.
* [`data`](app/src/main/java/com/kel2/swiftstrider/data): Bertanggung jawab untuk menghasilkan data. Berisi
  entitas, database, dan kelas terkait pelacakan.
    * [`tracking`](app/src/main/java/com/kel2/swiftstrider/data/tracking): Kelas yang menangani
      pelacakan seperti pelacakan lokasi.
* [`di`](app/src/main/java/com/kel2/swiftstrider/di) : Modul Hilt.
* [`domain`](app/src/main/java/com/kel2/swiftstrider/domain): Berisi kasus penggunaan umum dan
  antarmuka.
* [`ui`](app/src/main/java/com/kel2/swiftstrider/ui): Lapisan UI aplikasi.
    * `nav`: Berisi navigasi dan tujuan aplikasi.
    * `screen`: Berisi UI.
    * `theme`: Material3 theme.
    * `common`: UI utility classes & common components.
* [`common`](app/src/main/java/com/kel2/swiftstrider/common): Kelas utilitas yang digunakan di seluruh aplikasi.

## Build With

[Kotlin](https://kotlinlang.org/):
As the programming language.

[Jetpack Compose](https://developer.android.com/jetpack/compose) :
To build UI.

[Jetpack Navigation](https://developer.android.com/jetpack/compose/navigation) :
For navigation between screens and deep linking.

[Room](https://developer.android.com/jetpack/androidx/releases/room) :
To store and manage running statistics.

[Google Maps API](https://developers.google.com/maps/documentation/android-sdk) :
To track user's running activity such as speed, distance and path on the map.

[Hilt](https://developer.android.com/training/dependency-injection/hilt-android) :
For injecting dependencies.

[Preferences DataStore](https://developer.android.com/topic/libraries/architecture/datastore) :
To store user related data.

[Coil](https://coil-kt.github.io/coil/compose/) :
To load image asynchronously.

[Vico](https://patrykandpatrick.com/vico/) :
To show graphs in statistics screen.
