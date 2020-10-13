# Learn-in-Dicoding

Menambahkan Bottom Navigation

1. Buat Fragment baru untuk fungsi dan tampilan dari bottom navigation baru
2. Masukin ke bottom_nav_menu > (untuk memasukan icon serta title(tulisan dibawah icon) ke dalam bottom navigation)
    -> <item 
            android:id="@+id/navigation_example"
            android:icon="@drawable/(location_example_icon)"
            android:title="@string/(lokasi_title)" />
3. Masukan kedalam Mobile Navigation (untuk mengetahui lokasi fragment yang dimaksud)
    -> <Fragment
            android:id="@+id/navigation_example"
            android:name="(lokasi_kt_fragment_file)"
            android:label="@string/(lokasi_label)" -> biasanya isinya sama dengan title diatas
            android:layout="@layout/(lokasi_layout)"
4. Deklarasikan ke dalam MainActivity agar ketika ditekan bottom navigation maka pindah ke fragment
    -> masukan id R.id.navigation_example ke dalam AppBarConfiguration(setOf( .. ))
    -> masukan didalam  ..
