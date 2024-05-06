package com.example.noteappv2.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.noteappv2.R
import com.example.noteappv2.utils.log.Logger
import java.util.Stack

abstract class BaseFragment : Fragment() {
    
    protected open val logTag: String = BaseFragment::class.java.simpleName
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Logger.d(logTag, "onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d(logTag, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //init view, menu...
        Logger.d(logTag, "onCreateView()")
        val rootView = inflater.inflate(getLayoutId(), container, false)
        rootView?.let { initView(it) }
        return rootView
    }

    abstract fun getLayoutId(): Int

    abstract fun initView(rootView: View)

    fun setupToolbar(title: String, needHomeAsUp: Boolean) {
        val actionbar = (activity as? AppCompatActivity)?.supportActionBar
        actionbar?.let {
            it.setDisplayHomeAsUpEnabled(needHomeAsUp)
            it.setHomeButtonEnabled(needHomeAsUp)
            it.setDisplayShowTitleEnabled(needHomeAsUp)
            it.title = title
            it.setDisplayShowCustomEnabled(false)
            it.customView = null
            it.setBackgroundDrawable(null)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.d(logTag, "onViewCreated()")
    }

    override fun onStart() {
        super.onStart()
        Logger.d(logTag, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Logger.d(logTag, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Logger.d(logTag, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Logger.d(logTag, "onStop()")
    }

    override fun onDestroyView() {
        Logger.d(logTag, "onDestroyView()")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Logger.d(logTag, "onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        Logger.d(logTag, "onDetach()")
        super.onDetach()
    }
}