package com.tech.jpmorgan.ui.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModels: Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            return viewModels[modelClass]?.get() as T
        } catch (e: Exception) {
            throw RuntimeException("Error creating view model for class: " + modelClass.simpleName, e)
        }

    }
}
