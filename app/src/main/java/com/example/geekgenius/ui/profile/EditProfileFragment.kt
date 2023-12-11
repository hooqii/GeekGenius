package com.example.geekgenius.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.geekgenius.R
import com.example.geekgenius.databinding.FragmentEditProfileBinding

class EditProfileFragment : DialogFragment() {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding

    interface EditProfileListener {
        fun onProfileUpdated()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnSave?.setOnClickListener {
            // Save logic here

            // Notify the listener (hosting activity)
            val listener = activity as? EditProfileListener
            listener?.onProfileUpdated()

            // Dismiss the dialog
            dismiss()
        }
    }

    companion object {
        const val TAG = "EditProfileFragment"

        @JvmStatic
        fun newInstance() = EditProfileFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
