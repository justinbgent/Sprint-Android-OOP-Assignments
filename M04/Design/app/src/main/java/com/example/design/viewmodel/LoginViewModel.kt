package com.example.design.viewmodel

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.example.design.model.User

class LoginViewModel: BaseObservable() {

    private val successMessage = "Login Succeeded"
    private val failureMessage = "Login Failed"

    private val user: User = User("", "")

    // below is same as: private val user: User = User("", "")
//    init {
//        user = User("", "")
//    }
    @Bindable
    var toastMessage: String? = null
    set(value){
        field = value
        notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getUserEmail(): String? {
        return user.email
    }

    @Bindable
    fun getUserPassword(): String? {
        return user.password
    }

    fun setUserEmail(email: String) {
        user.email = email
        notifyPropertyChanged(BR.userEmail)
    }

    fun setUserPassword(password: String) {
        user.password = password
    }

    fun onLoginClicked() {
        toastMessage = if (isValid()){
            successMessage
        }
        else{
            failureMessage
        }
    }

    fun isValid(): Boolean {
        return !TextUtils.isEmpty(getUserEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() &&
                (getUserPassword()?.length ?: 0) > 7
    }
}