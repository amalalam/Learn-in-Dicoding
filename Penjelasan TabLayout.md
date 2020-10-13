Tab Layout adalah Button yang disebelah kanan dan harus di click apabila mau pindah fragment

tab-1 | tab-2 | tab-3

ViewPager disini digunakan supaya dapat berpindah antar tab dengan menggunakan swipe tanpa memilih tab

Untuk menghubungkan antara TabLayout dengan ViewPager menggunakan kode
tabs.setupWithViewPager(view_pager) (dalam MainActivity)               (tabs -> adalah id dari TabLayout yang dideklarasikan dan , view_pager adalah id dari ViewPager

Fungsi 1 :
          Untuk mengatur ViewPager dan komponen yang ada di dalamnya, Anda menggunakan SectionsPagerAdapter yang extend ke kelas FragmentPagerAdapter.

          Fungsi getItem digunakan untuk menampilkan fragment sesuai dengan posisi tab-nya.
          Pada kode di sini pada posisi 0 (tab pertama) menampilkan HomeFragment dan pada posisi 1 (tab kedua) menampilkan ProfileFragment.

          Fungsi getPageTitle digunakan untuk memberikan judul pada masing-masing tab di sini Anda menggunakan teks yang berasal dari resource Strings.xml

          Fungsi getCount digunakan untuk menentukan jumlah tab yang ingin ditampilkan. Pada kode di atas, Anda mencoba untuk menampilkan dua tab.

          Untuk menghubungkan SectionsPagerAdapter dengan ViewPager pada MainActivity Anda menggunakan kode berikut:
                    val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
                    view_pager.adapter = sectionsPagerAdapter

Fungsi 2 : Mengirim Data Ke Fragment
  Untuk menggunakan TabLayout dengan hanya satu Fragment, Anda bisa mensiasatinya dengan mengirim data ke Fragment tersebut. 
  Penggunaan satu fragment ini digunakan jika data yang ditampilkan mirip, sehingga tidak perlu membuat banyak fragment dan layout. 
