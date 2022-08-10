package com.hdd.criminalitent

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import java.util.*
import kotlin.time.Duration.Companion.hours

class TimePickerFragment : DialogFragment() {

    private val args: TimePickerFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val timeListener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->

            val calender = Calendar.getInstance()
            calender.time = args.crimeTime
            calender[Calendar.HOUR_OF_DAY] = hourOfDay
            calender[Calendar.MINUTE] = minute
            val resultTime = calender.time
            setFragmentResult(REQUEST_KEY_TIME, bundleOf(BUNDLE_KEY_TIME to resultTime))
        }

        val calender = Calendar.getInstance()
        calender.time = args.crimeTime

        val initHour = calender.get(Calendar.HOUR_OF_DAY)
        val initMinute = calender.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireContext(),
            timeListener, initHour, initMinute, true

        )
    }

    companion object {
        const val REQUEST_KEY_TIME = "REQUEST_KEY_TIME"
        const val BUNDLE_KEY_TIME = "BUNDLE_KEY_TIME"
    }
}