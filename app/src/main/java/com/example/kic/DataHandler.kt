package com.example.kic

import android.content.Context
import android.content.SharedPreferences


class DataHandler {
    private var dataStore: SharedPreferences? = null

    fun DataHandler(mContext: Context) {
        dataStore = mContext.getSharedPreferences("appname", Context.MODE_PRIVATE)
    }

    fun which(): Boolean {
        return dataStore!!.getBoolean("some_key", false)
    }

    fun setCheckedItem(itemwhat: Boolean) {
        dataStore!!.edit().putBoolean("some_key", itemwhat).apply()
    }

}