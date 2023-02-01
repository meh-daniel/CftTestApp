package test.task.cft.focus.start.com.presentation.screens.history

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import test.task.cft.focus.start.com.R
import test.task.cft.focus.start.com.databinding.FragmentHistoryBinding
import test.task.cft.focus.start.com.utils.observeInLifecycle

@AndroidEntryPoint
class HistoryFragment: Fragment(R.layout.fragment_history) {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HistoryViewModel by viewModels()

    private lateinit var binAdapter: BinAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binAdapter = BinAdapter(requireContext())
        initRecyclerView()
        setupSubscribers()
        setupListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupSubscribers() {
        viewModel.state.onEach { state ->
            if(state is HistoryState.Loaded) binAdapter.submitList(state.data)

            if(state is HistoryState.Empty) {
                context?.let {
                    AlertDialog
                        .Builder(it)
                        .setTitle("Error")
                        .setMessage("you weren't looking for anything")
                        .setNegativeButton("Ok") { _, _ ->
                            findNavController().navigate(R.id.action_historyFragment_to_searchFragment)
                        }
                        .show()
                }
            }

            if(state is HistoryState.Error) {
                context?.let {
                    AlertDialog
                        .Builder(it)
                        .setTitle("Error")
                        .setMessage(state.error)
                        .setNegativeButton("Ok") { _, _ ->
                            findNavController().navigate(R.id.action_historyFragment_to_searchFragment)
                        }
                        .show()
                }
            }

        }.observeInLifecycle(this)
    }

    private fun setupListeners() {
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_historyFragment_to_searchFragment)
        }
    }

    private fun initRecyclerView() {
        binding.binRv.adapter = binAdapter
        binding.binRv.layoutManager =
            LinearLayoutManager(
                this.context,
                LinearLayoutManager.VERTICAL,
                false
            )
    }

}