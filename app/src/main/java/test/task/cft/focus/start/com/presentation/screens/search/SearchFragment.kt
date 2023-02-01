package test.task.cft.focus.start.com.presentation.screens.search

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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import test.task.cft.focus.start.com.R
import test.task.cft.focus.start.com.databinding.FragmentSearchBinding
import test.task.cft.focus.start.com.utils.observeInLifecycle
import test.task.cft.focus.start.com.utils.convertToLinkGeo

@AndroidEntryPoint
class SearchFragment: Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSubscribers()
        setupListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupSubscribers() {
        viewModel.state.onEach { state ->
            with(binding){
                // Number Card
                numberCard.text = if (state is SearchState.Loaded) state.data.number.numberCard else "-"
                numberCardLength.text = if (state is SearchState.Loaded) state.data.number.length.toString() else "-"
                numberCardLuhn.text = if (state is SearchState.Loaded) {
                    if(state.data.number.luhn) "yes" else "no"
                } else "-"
                // General
                generalScheme.text = if (state is SearchState.Loaded) state.data.scheme else "-"
                generalType.text = if (state is SearchState.Loaded) state.data.type else "-"
                generalBrand.text = if (state is SearchState.Loaded) state.data.brand else "-"
                generalPrepaid.text = if (state is SearchState.Loaded) {
                    if(state.data.number.luhn) "yes" else "no"
                } else "-"

                // Country
                countryNumeric.text = if (state is SearchState.Loaded) state.data.country.numeric else "-"
                countryAlpha2.text = if (state is SearchState.Loaded) state.data.country.alpha2 else "-"
                countryName.text = if (state is SearchState.Loaded) {
                    countryName.setTextColor(resources.getColor(R.color.urlColor, null))
                    countryName.convertToLinkGeo(requireContext(), state.data.country.name)
                    state.data.country.name
                } else {
                    "-"
                }
                countryEmoji.text = if (state is SearchState.Loaded) state.data.country.emoji else "-"
                countryCurrency.text = if (state is SearchState.Loaded) state.data.country.currency else "-"
                countryLatitude.text = if (state is SearchState.Loaded) state.data.country.latitude.toString() else "-"
                countryLongitude.text = if (state is SearchState.Loaded) state.data.country.longitude.toString() else "-"

                // Bank
                bankName.text = if (state is SearchState.Loaded) state.data.bank.name else "-"
                bankUrl.text = if (state is SearchState.Loaded) state.data.bank.url else "-"
                bankPhone.text = if (state is SearchState.Loaded) state.data.bank.phone else "-"
                bankCity.text = if (state is SearchState.Loaded) {
                    bankCity.setTextColor(resources.getColor(R.color.urlColor, null))
                    bankCity.convertToLinkGeo(requireContext(), state.data.bank.city)
                    state.data.bank.city
                } else {
                    "-"
                }

                // Error
                if(state is SearchState.Error) {
                    context?.let {
                        AlertDialog
                            .Builder(it)
                            .setTitle("Error")
                            .setMessage(state.error)
                            .setNegativeButton("Ok") { _, _ -> }
                            .show()
                    }
                }
            }
        }.observeInLifecycle(this)
    }

    private fun setupListeners() {
        binding.searchBtn.setOnClickListener {
            viewModel.searchBin(binding.searchNameEdTxt.text.toString())
        }
        binding.lookHistoryBtn.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_historyFragment)
        }
    }

}