package com.capstone.eratani.detail.monitor

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.eratani.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.security.KeyStore

class DetailMonitorActivity : AppCompatActivity() {
//    private val lineChartView = LineChart(this)
//    private val revenueComp1 = arrayListOf(10000f, 20000f, 30000f, 40000f)
//    private val revenueComp2 = arrayListOf(12000f, 23000f, 35000f, 48000f)
    private val rev1 = ArrayList<Entry>()
    private val rev2 = ArrayList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_monitor)

        val lineChartView = LineChart(this)
//        setContentView(lineChartView)

        lineChartView.description.isEnabled = false

        rev1.add(Entry(0f, 10000f))
        rev1.add(Entry(1f, 20000f))
        rev1.add(Entry(2f, 30000f))
        rev1.add(Entry(3f, 40000f))

        rev2.add(Entry(0f, 12000f))
        rev2.add(Entry(1f, 23000f))
        rev2.add(Entry(2f, 35000f))
        rev2.add(Entry(3f, 48000f))

        val rev1LineDataSet = LineDataSet(rev1, "Comp1")
        rev1LineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        rev1LineDataSet.color = Color.BLUE
        rev1LineDataSet.circleRadius = 5f
        rev1LineDataSet.setCircleColor(Color.BLUE)

        val rev2LineDataSet = LineDataSet(rev2, "Comp2")
        rev2LineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        rev2LineDataSet.color = Color.GREEN
        rev2LineDataSet.circleRadius = 5f
        rev2LineDataSet.setCircleColor(Color.BLUE)

        //Setup Legend
        val legend = lineChartView.legend
        legend.isEnabled = true
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP)
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER)
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL)
        legend.setDrawInside(false)

        lineChartView.description.isEnabled = false
        lineChartView.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChartView.data = LineData(rev1LineDataSet, rev2LineDataSet)
        lineChartView.animateXY(100, 500)
    }
}