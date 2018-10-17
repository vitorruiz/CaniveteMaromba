package br.com.vitorruiz.canivetemaromba.toast

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import br.com.vitorruiz.canivetemaromba.R
import br.com.vitorruiz.canivetemaromba.toast.MarombaToast.ToastType.*

class MarombaToast(val context: Context, val inflater: LayoutInflater) {

    private enum class ToastType {
        INFO, SUCCESS, WARNING, ERROR, DEFAULT
    }

    fun show(text: String) {
        configToast(DEFAULT, text).show()
    }

    fun showSuccess(text: String) {
        configToast(SUCCESS, text).show()
    }

    fun showError(text: String) {
        configToast(ERROR, text).show()
    }

    fun showInfo(text: String) {
        configToast(INFO, text).show()
    }

    fun showWarning(text: String) {
        configToast(WARNING, text).show()
    }

    private fun configToast(type: ToastType, text: String): Toast {
        val customToastRoot = inflater.inflate(R.layout.maromba_toast, null)

        val image = customToastRoot.findViewById<ImageView>(R.id.imageView1)
        val textView = customToastRoot.findViewById<TextView>(R.id.textView1)
        val toastContainer = customToastRoot.findViewById<LinearLayout>(R.id.toast_container)
        val customToast = Toast(context)

        when (type) {
            INFO -> {
                toastContainer.background = ContextCompat.getDrawable(context, R.drawable.info_toast_border)
                image.setImageResource(R.drawable.ic_info)
            }
            SUCCESS -> {
                toastContainer.background = ContextCompat.getDrawable(context, R.drawable.success_toast_border)
                image.setImageResource(R.drawable.ic_success)
            }
            WARNING -> {
                toastContainer.background = ContextCompat.getDrawable(context, R.drawable.warning_toast_border)
                image.setImageResource(R.drawable.ic_warning)
            }
            ERROR -> {
                toastContainer.background = ContextCompat.getDrawable(context, R.drawable.error_toast_border)
                image.setImageResource(R.drawable.ic_error)
            }
            DEFAULT -> {
                toastContainer.background = ContextCompat.getDrawable(context, R.drawable.default_toast_border)
                image.setImageResource(R.drawable.ic_default)
            }
        }


        textView.text = text

        customToast.view = customToastRoot
        customToast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM, 0, 0)
        customToast.duration = Toast.LENGTH_LONG

        return customToast
    }
}