package test.task.cft.focus.start.com.presentation.screens.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import test.task.cft.focus.start.com.R
import test.task.cft.focus.start.com.databinding.FragmentSplashBinding

@AndroidEntryPoint
class SplashFragment: Fragment(R.layout.fragment_splash) {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSplashView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initSplashView() {
        with(binding.content) {
            alpha = 0f
            animate().setDuration(2000).alpha(1f).withEndAction {
                navigateToSearch()
            }
        }
    }

    private fun navigateToSearch() {
        findNavController().navigate(R.id.action_splashFragment_to_searchFragment)
    }

}