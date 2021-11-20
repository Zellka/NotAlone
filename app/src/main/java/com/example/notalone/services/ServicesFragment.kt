package com.example.notalone.services

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notalone.R
import com.example.notalone.adapter.ClickListener
import com.example.notalone.adapter.ServicesAdapter
import com.example.notalone.databinding.FragmentServicesBinding
import com.example.notalone.entity.Services

class ServicesFragment : Fragment(), ClickListener {
    private var _binding: FragmentServicesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val services = listOf<Services>(
            Services(R.drawable.i1, R.drawable.f1, "Journeys"),
            Services(R.drawable.i2, R.drawable.f2, "Pets"),
            Services(R.drawable.i3, R.drawable.f3, "Art"),
            Services(R.drawable.i4, R.drawable.f4, "Shopping"),
            Services(R.drawable.i5, R.drawable.f5, "Social"),
            Services(R.drawable.i6, R.drawable.f6, "Music"),
        )

        binding.recycler.layoutManager = GridLayoutManager(this.requireContext(), 2)
        binding.recycler.adapter = ServicesAdapter(services, this)
    }

    override fun showServices(book: Services) {
        startActivity(Intent(this.requireContext(), ServicesActivity::class.java))
    }
}