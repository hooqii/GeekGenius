package com.geek.app.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.geekgenius.R
import com.example.geekgenius.RegisterPage
import com.example.geekgenius.WellcomePage
import com.example.geekgenius.databinding.FragmentProfileBinding
import com.geek.app.data.shared_preference.UserPreference
import com.geek.app.model.User

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding
    private val preference by lazy {
        UserPreference(
            requireContext().getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            preference.getData().run {
                etEmail.setText(email)
                etUsername.setText(username)
                etPassword.setText(password)
            }

            btnEditProfile.setOnClickListener {
                preference.saveData(
                    User(
                        username = etUsername.text.toString().trim(),
                        password = etPassword.text.toString().trim(),
                        email = etEmail.text.toString().trim(),
                    )
                )
                Toast.makeText(requireActivity(), "Edit Sukses", Toast.LENGTH_SHORT).show()
            }

            btnLogout.setOnClickListener {
                // Clear user data or perform logout actions
                preference.clearData()
                Toast.makeText(requireActivity(), "Logout Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), WellcomePage::class.java)
                startActivity(intent)
                
                // Navigate to login screen or any other desired destination
                // For example, if you are using Navigation Component:
                // findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}