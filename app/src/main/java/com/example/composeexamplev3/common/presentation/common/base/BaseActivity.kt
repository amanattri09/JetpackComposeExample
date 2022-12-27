package com.example.composeexamplev3.common.presentation.common.base

import androidx.activity.ComponentActivity
import com.example.composeexamplev3.R
import com.example.composeexamplev3.common.presentation.common.showToast


open class BaseActivity : ComponentActivity() {

    fun onError(throwable: Throwable) {
        showToast(throwable.message ?: getString(androidx.compose.ui.R.string.default_error_message))
    }

    fun onLoading(showLoading: Boolean) {
        if (showLoading)
            showToast(resources.getString(R.string.title_loading))
    }


}