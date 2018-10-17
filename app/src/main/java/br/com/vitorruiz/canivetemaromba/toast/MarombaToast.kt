package br.com.vitorruiz.canivetemaromba.toast

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import br.com.vitorruiz.canivetemaromba.R
import br.com.vitorruiz.canivetemaromba.toast.MarombaToast.ToastType.*

class MarombaToast(val context: Context, val inflater: LayoutInflater) {

    private enum class ToastType {
        INFO, SUCCESS, WARNING, ERROR, DEFAULT
    }

    fun showToast(text: String) {
        val customToastroot = configToast(context, )
        val customtoast = Toast(context)

        val textView = customToastroot.findViewById<TextView>(R.id.textView1)
        textView.text = text

        customtoast.view = customToastroot
        customtoast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM, 0, 0)
        customtoast.duration = Toast.LENGTH_LONG

        customtoast.show()
    }

    private fun configToast(context: Context, type: ToastType): View {
        val customToastroot = inflater.inflate(R.layout.maromba_toast, null)
        val toastContainer = customToastroot.findViewById<LinearLayout>(R.id.toast_container)

        when (type) {
            INFO -> toastContainer.background = ContextCompat.getDrawable(context, R.drawable.info_toast_border)
            SUCCESS -> toastContainer.background = ContextCompat.getDrawable(context, R.drawable.success_toast_border)
            WARNING -> toastContainer.background = ContextCompat.getDrawable(context, R.drawable.warning_toast_border)
            ERROR -> toastContainer.background = ContextCompat.getDrawable(context, R.drawable.error_toast_border)
            DEFAULT -> toastContainer.background = ContextCompat.getDrawable(context, R.drawable.default_toast_border)
        }

        return customToastroot
    }
}