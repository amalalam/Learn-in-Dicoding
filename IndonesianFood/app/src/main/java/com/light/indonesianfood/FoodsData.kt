package com.light.indonesianfood

object FoodsData {
    private val foodsNames = arrayOf("Ayam Betutu",
    "Ayam Taliwang",
    "Bika Ambon",
    "Kerak Telor",
    "Lumpia",
    "Mie Aceh",
    "Nasi Gudeg",
    "Otak-Otak",
    "Pempek",
    "Rendang",
    "Sate Banden",
    "Serabi",)

    private val foodsDetails = arrayOf("Betutu adalah lauk yang terbuat dari ayam atau bebek yang utuh yang berisi bumbu, kemudian dipanggang dalam api sekam. Betutu ini telah dikenal di seluruh kabupaten di Bali. Betutu merupakan jenis makanan tradisional daerah Bali yang bahan mentahnya berupa karkas utuh itik dan ayam. Kata betutu berasal dari kata tunu yang berarti bakar dan dirangkai dengan kata be yang berarti daging. Berdasarkan uraian tersebut betutu berarti daging yang dibakar.",
    "Ayam Taliwang adalah makanan khas Pulau Lombok dari Kampung Karang Taliwang, Kota Mataram, Nusa Tenggara Barat yang berbahan dasar daging ayam. Daging ayam yang disajikan berasal dari ayam kampung muda yang dibakar kemudian dibumbui dengan semacam saus yang bahannya antara lain cabai merah kering, bawang merah, bawang putih, tomat, terasi goreng, kencur, gula merah, dan garam. Makanan ini biasanya disajikan bersama makanan khas Lombok yang lain, misalnya plecing kangkung.",
    "Jika Aceh mendunia dengan mienya, berbeda lagi dengan Sumatera Utara yang populer dengan bika ambon. Yakni sejenis kue dengan rasa yang sangat lezat. Bika ambon bahkan juga dijual dengan beberapa varian rasa terbaik, seperti keju hingga durian.",
    "Ibukota Indonesia juga tidak ketinggalan dengan kuliner khasnya yang bernama kerak telor, yakni menu masakan yang terbuat dari beras keran putih, ebi, telur ayam yang kemudian di sangrai. Akan semakin lezat dengan tambahan beberapa bumbu rahasia lainnya.",
    "Lumpia merupakan kuliner khas Jateng yang terbuat dari rebung, daging udang dan telur yang dibungkus kemudian di goreng. Dijamin Anda akan ketagihan dengan rasanya.",
    "Aceh merupakan salah satu provinsi di Indonesia yang terkenal dengan berbagai kuliner khas terbaik yang bahkan telah mendunia. Saat berkunjung ke Aceh, belum lengkap rasanya jika Anda tidak bisa mencicipi menu dengan bahan mie kuning tebal plus irisan daging yang disajikan dalam sup kari gurih dan pedas yang satu ini.",
    "Nasi gudeg khas Yogyakarta terbuat dari olahan nangka muda plus santan. Kuliner dengan tambahan nasi, ayam kampung, telur dan lainnya ini akan membius lidah Anda dengan citarasanya yang teramat manis dan lezat.",
    "Otak-otak merupakan kuliner khas Kepulauan Riau yang mudah ditemukan di Batam, Pulau Penyengat hingga Tanjung Pinang. Anda bisa mencicipi otak-otak cumi maupun ikan dengan citarasa yang sama-sama juara.",
    "Pempek merupakan kuliner khas Sumatera Selatan yang terbuat dari olahan sagu dan ikan plus tambahan kuah coklat yang dinamai cukpo. Cita rasanya dijamin akan menggugah selera Anda.",
    "Sumatera Barat memang telah berhasil mencuri mata dunia dengan bumbu khas masakan padangnya. Salah satunya tentu saja rendang yang terbuat dari berbagai jenis rempah dengan citarasa yang sangat kuat juga nikmat.",
    "Banten juga menghadirkan kuliner terbaik khasnya yang bernama sate bandeng dengan daging empuk tak bertulang yang ditambah santan dan gula coklat. Pastikan Anda mencicipinya saat berkunjung ke Banten ya.",
    "Serabi khas Jawa Barat terbuat dari tepung beras yang disiram kuah cair manis dengan citarasa nikmat yang dijamin menggugah selera semua lidah yang mencicipinya.",
    )
    private val foodsImages = arrayOf(
        R.drawable.ayam_betutu,
    R.drawable.ayam_taliwang,
    R.drawable.bika_ambon,
    R.drawable.kerak_telor,
    R.drawable.lumpia,
    R.drawable.mie_aceh,
    R.drawable.nasi_gudeg,
    R.drawable.otak_otak,
    R.drawable.pempek,
    R.drawable.rendang,
    R.drawable.sate_banden,
    R.drawable.serabi)

    val listData: ArrayList<Foods>
        get() {
            val list = arrayListOf<Foods>()
            for (position in foodsNames.indices) {
                val foods = Foods()
                foods.name = foodsNames[position]
                foods.detail = foodsDetails[position]
                foods.photo = foodsImages[position]
                list.add(foods)
            }
            return list
        }
}