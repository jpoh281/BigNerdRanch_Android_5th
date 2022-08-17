package com.hdd.criminalitent

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.content.FileProvider
import androidx.core.view.doOnLayout
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.hdd.criminalitent.databinding.DialogImageViewBinding
import com.hdd.criminalitent.databinding.FragmentCrimeDetailBinding
import com.hdd.criminalitent.databinding.FragmentCrimeListBinding
import java.io.File


class DetailDisplayFragment : DialogFragment() {

    private val args: DetailDisplayFragmentArgs by navArgs()

    private var _binding: DialogImageViewBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogImageViewBinding.inflate(layoutInflater, container, false)


        binding.apply {
            val photoFile = File(requireContext().applicationContext.filesDir, args.fileName)
//                Log.d("FFFFF!", photoFile.path)
            var bitmap = BitmapFactory.decodeFile(photoFile.path)
            binding.imageView.setImageBitmap(bitmap)
        }
//        binding.apply {
//            imageView.doOnLayout {
//
//
//                binding.imageView.setImageBitmap(bitmap)
//            }
//        }

        return binding.root
    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//
//
//        binding.apply {
//
//            val photoFile = File(requireContext().applicationContext.filesDir, args.fileName)
//            val options = BitmapFactory.Options()
//            options.inJustDecodeBounds = true
//            var bitmap = BitmapFactory.decodeFile(photoFile.path, options)
//
//            binding.imageView.setImageBitmap(bitmap)
//        }
//        val photoUri = FileProvider.getUriForFile(
//            requireContext(),
//            "com.hdd.criminalitent.fileprovider",
//            photoFile
//        )
//        val file = File(photoFile.path)
//        if (file.exists()) {
//            Log.d("AAAAAAA", "${file.path}")
//            Log.d("WIDTH", "${  imageView.width}")
//            val options = BitmapFactory.Options()
//            options.inJustDecodeBounds = true
//            var bitmap = BitmapFactory.decodeFile(photoFile.path, options)
//
//            imageView.setImageBitmap(bitmap)
//        }
//
//        val dialog = AlertDialog(requireContext()).let {
//            it.window?.setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
//                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//            )
//            it.setView(imageView)
//            create()
//        }
//        return AlertDialog.appl
//
//            .Builder(requireContext())
//            .setView(imageView).create()
//        var dialog: Dialog = Dialog(requireContext())

//        dialog.window?.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
//            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//        )
//

//
//        dialog.window?.setContentView(imageView)
//
//        dialog.setTitle("Item Details")
//        dialog.show()

//        return AlertDialog.Builder(requireContext())
////            .setMessage("asd")
//            .setView(binding.imageView)
////            .setPositiveButton(getString(R.string.send_report)) { _, _ -> }
//            .create()
//    }
}