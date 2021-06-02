package com.capstone.eratani.monitor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.eratani.R
import com.capstone.eratani.databinding.FragmentMonitorBinding
import com.capstone.eratani.utils.DataDummy

class MonitorFragment : Fragment() {
    private lateinit var fragmentMonitorBinding: FragmentMonitorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMonitorBinding = FragmentMonitorBinding.inflate(layoutInflater, container, false)
        return fragmentMonitorBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
//            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MoviesViewModel::class.java]
            val monitor = DataDummy.generateDummyMonitor()
            val monitorAdapter = MonitorAdapter()
            monitorAdapter.setMonitor(monitor)

            with(fragmentMonitorBinding.rvMonitor) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = monitorAdapter
            }
        }
    }
}