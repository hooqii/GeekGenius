package com.geek.app.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.geekgenius.R
import com.example.geekgenius.WellcomePage
import com.example.geekgenius.databinding.FragmentProfileBinding
import com.geek.app.data.shared_preference.UserPreference
import com.geek.app.model.User
import com.example.geekgenius.ui.profile.EditProfileFragment

class ProfileFragment : Fragment(), EditProfileFragment.EditProfileListener {

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
                etName.setText(username)
            }

            btnEditProfile.setOnClickListener {
                navigateToEditProfileFragment()
            }

            btnLogout.setOnClickListener {
                preference.clearData()
                Toast.makeText(requireActivity(), "Logout Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), WellcomePage::class.java)
                startActivity(intent)
            }
        } ?: run {
            // Handle the case when binding is null
            Toast.makeText(requireActivity(), "Binding is null", Toast.LENGTH_SHORT).show()
            // You can choose to show some default content or handle it as appropriate for your case.
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onProfileUpdated() {
        // Handle profile update logic here
        Toast.makeText(requireActivity(), "Profile updated", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToEditProfileFragment() {
        val editProfileFragment = EditProfileFragment.newInstance()
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in_right,  // enter animation
            R.anim.slide_out_left,   // exit animation
        )
        transaction.replace(android.R.id.content, editProfileFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
