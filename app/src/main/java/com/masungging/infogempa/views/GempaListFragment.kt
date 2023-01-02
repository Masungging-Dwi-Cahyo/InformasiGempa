package com.masungging.infogempa.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.masungging.infogempa.R
import com.masungging.infogempa.adapter.GempaListener
import com.masungging.infogempa.adapter.ListGempaAdapter
import com.masungging.infogempa.databinding.FragmentGempaListBinding

// Kelas fragmen untuk menunjukkan status layanan API.
class GempaListFragment : Fragment() {

    private val viewModel: OverViewModel by activityViewModels()

    // Mengaktifkan Data Binding dan menyetel tata letak GempaListFragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding = FragmentGempaListBinding.inflate(inflater)
        viewModel.getGempaTerkiniList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvListGempa.adapter = ListGempaAdapter(GempaListener { detail ->
            viewModel.onGempaTerkiniClicked(detail)
            findNavController()
                .navigate(R.id.action_gempaListFragment_to_gempaDetailFragment)
        })

        // Menetapkan tata letak dengan root
        return binding.root
    }
}