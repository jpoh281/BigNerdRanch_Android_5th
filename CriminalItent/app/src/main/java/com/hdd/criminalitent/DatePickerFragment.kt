package com.hdd.criminalitent

import android.app.DatePickerDialog
import android.app.Dialog

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import java.util.*

class DatePickerFragment : DialogFragment() {

    private val args: DatePickerFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dateListener =
            DatePickerDialog.OnDateSetListener { _, year: Int, month: Int, dayOfMonth: Int ->

                val resultDate = GregorianCalendar(year, month, dayOfMonth).time

                setFragmentResult(REQUEST_KEY_DATE, bundleOf(BUNDLE_KEY_DATE to resultDate))
            }

        val calendar = Calendar.getInstance()
        calendar.time = args.crimeDate
        val initYear = calendar.get(Calendar.YEAR)
        val initMonth = calendar.get(Calendar.MONTH)
        val initDay = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            requireContext(),
            null,
            initYear,
            initMonth,
            initDay
        )

    }

    companion object {
        const val REQUEST_KEY_DATE = "REQUEST_KEY_DATE"
        const val BUNDLE_KEY_DATE = "BUNDLE_KEY_DATE"
    }
}