package com.zephyr.base_ui

import android.app.ProgressDialog
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast

/**
 * created by zephyr on 2020/12/11 13 : 49
 *
 */
class UIOperateImpl(private val context: Context) : IUIOperate {

    private lateinit var toast: Toast

    private val loadingDialog: ProgressDialog by lazy {
        val progressDialog = ProgressDialog(
            context,
            R.style.style_loading_dialog
        )
        progressDialog.setCanceledOnTouchOutside(true)
        progressDialog
    }


    override fun showLoading(message: String, cancelable: Boolean) {
        if (loadingDialog.isShowing) return
        loadingDialog.setCancelable(true)
        loadingDialog.show()
        loadingDialog.setContentView(R.layout.layout_default_loading_dialog)
        val textView = loadingDialog.findViewById(R.id.tv_content) as TextView
        textView.text = message
    }

    override fun showLoading(resId: Int, cancelable: Boolean) {
        if (loadingDialog.isShowing) return
        loadingDialog.setCancelable(true)
        loadingDialog.show()
        loadingDialog.setContentView(R.layout.layout_default_loading_dialog)
        val textView = loadingDialog.findViewById(R.id.tv_content) as TextView
        textView.setText(resId)
    }

    override fun dismissLoading() {
        loadingDialog.dismiss()
    }

    override fun isLoadingShowing(): Boolean {
        return loadingDialog.isShowing
    }

    override fun showToast(message: String?) {
        if (TextUtils.isEmpty(message)) return
        val view = LayoutInflater.from(context).inflate(R.layout.layout_default_toast, null)
        val textView = view.findViewById(R.id.tv_toast) as TextView
        textView.text = message
        if (!this::toast.isInitialized) { // check if initialized
            toast = Toast(context)
            toast.view = view
            toast.duration = Toast.LENGTH_SHORT
        } else {
            toast.view = view
        }
        toast.show()
    }

    override fun showToast(resId: Int) {
        if (resId == 0 || TextUtils.isEmpty(context.resources.getString(resId))) return
        val view = LayoutInflater.from(context).inflate(R.layout.layout_default_toast, null)
        val textView = view.findViewById(R.id.tv_toast) as TextView
        textView.setText(resId)
        if (!this::toast.isInitialized) { // check if initialized
            toast = Toast(context)
            toast.view = view
            toast.duration = Toast.LENGTH_SHORT
        } else {
            toast.view = view
        }
        toast.show()
    }

    companion object {
        fun create(context: Context): UIOperateImpl {
            return UIOperateImpl(context)
        }
    }
}