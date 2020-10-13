package com.light.mytablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    //      TODO Yang di comment dalam Home Fragment serta SectionPager Adapater adalah untuk menampilkan 3 Tab Layout tetapi isinya mirip
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        var index = 1
//        if(arguments != null){
//            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
//        }
//
//        section_label.text = "${getString(R.string.content_tab_text)} $index"
//    }

    companion object {

//      TODO Yang di comment dalam Home Fragment serta SectionPager Adapater adalah untuk menampilkan 3 Tab Layout tetapi isinya mirip

//        private val ARG_SECTION_NUMBER = "section_number"
//
//        @JvmStatic
//        fun newInstance(index: Int): HomeFragment{
//            val fragment = HomeFragment()
//            val bundle = Bundle()
//            bundle.putInt(ARG_SECTION_NUMBER, index)
//            fragment.arguments = bundle
//            return fragment
//        }

    }
}