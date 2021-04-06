package com.example.android.navigationadvancedsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.android.navigationadvancedsample.listscreen.MyAdapter


class CommonFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_common, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("TAG") ?: "Tag not found in bundle"
        view.findViewById<TextView>(R.id.tag_tv).text = "Hello from: $name"

        view.findViewById<TextView>(R.id.tag_tv).setOnClickListener {
            findNavController(this).navigate(
                    R.id.action_commonFragment_to_begin, //R.id.titleScreen,
                    bundleOf("TEST" to System.currentTimeMillis())
            )
        }
    }

    companion object {
        fun navigateToCommonFragment(context: Fragment, tag: String, action: Int) {
            val bundle = bundleOf("TAG" to tag)

            findNavController(context).navigate(
                    action,
                    bundle)
        }
    }
}