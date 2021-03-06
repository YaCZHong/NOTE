package com.czh.note.ui.base

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.czh.note.ui.dialog.LoadingDialog

open class BaseActivity : AppCompatActivity() {

    private var loadingDialog: LoadingDialog? = null

    fun showLoadingDialog(msg: String? = null, cancelable: Boolean = true) {
        loadingDialog?.dismiss()
        loadingDialog = LoadingDialog(msg, cancelable).also {
            it.show(supportFragmentManager, "loading")
        }
    }

    fun hideLoadingDialog() {
        loadingDialog?.dismiss()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    open fun setToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}