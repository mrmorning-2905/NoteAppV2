package com.example.noteappv2.ui.fragment

import android.view.View
import androidx.fragment.app.Fragment
import com.example.noteappv2.R
import com.example.noteappv2.databinding.NoteListFragmentBinding

class NotesListFragment : BaseFragment() {
    private var _binding: NoteListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun getLayoutId(): Int {
        return R.layout.note_list_fragment
    }

    override fun initView(rootView: View) {
        _binding = NoteListFragmentBinding.bind(rootView)
        binding.testUserId.text = ""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}