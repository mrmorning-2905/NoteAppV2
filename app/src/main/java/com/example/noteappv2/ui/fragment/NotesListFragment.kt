package com.example.noteappv2.ui.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.noteappv2.R
import com.example.noteappv2.databinding.NoteListFragmentBinding
import com.example.noteappv2.ui.NoteViewModelFactory
import com.example.noteappv2.ui.viewmodels.NotesListViewModel

class NotesListFragment : BaseFragment() {
    private var _binding: NoteListFragmentBinding? = null

    private val noteListViewModel by viewModels<NotesListViewModel> { NoteViewModelFactory }

    private val binding get() = _binding!!

    override fun getLayoutId(): Int {
        return R.layout.note_list_fragment
    }

    override fun initView(rootView: View) {
        _binding = NoteListFragmentBinding.bind(rootView)
        val uId = arguments?.getLong("owner_id") ?: -1L
        binding.testUserId.text = uId.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}