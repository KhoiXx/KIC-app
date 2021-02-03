package com.example.kic

import android.content.Context
import android.content.SharedPreferences


class DataHandler {
    private var dataStore: SharedPreferences? = null

    fun DataHandler(mContext: Context) {
        dataStore = mContext.getSharedPreferences("appname", Context.MODE_PRIVATE)
    }

    fun which(key:String): Boolean {
        return dataStore!!.getBoolean(key, false)
    }

    fun setCheckedItem(key: String,itemwhat: Boolean) {
        dataStore!!.edit().putBoolean(key, itemwhat).apply()
    }

}