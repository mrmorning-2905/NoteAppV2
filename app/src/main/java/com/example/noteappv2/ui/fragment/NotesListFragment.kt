package com.example.noteappv2.ui.fragment

import android.content.Context
import android.os.Bundle
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

    private val ownerId: Long
        get() = arguments?.getLong("owner_id") ?: -1L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noteListViewModel.observerNotesWithOwner(ownerId, this)
    }
    override fun getLayoutId(): Int {
        return R.layout.note_list_fragment
    }

    override fun initView(rootView: View) {
        _binding = NoteListFragmentBinding.bind(rootView)
        binding.testUserId.text = ownerId.toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}