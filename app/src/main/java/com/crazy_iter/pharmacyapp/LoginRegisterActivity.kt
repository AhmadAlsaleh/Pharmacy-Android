package com.crazy_iter.pharmacyapp

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_login_register.*

class LoginRegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        showLoginView()

        loginBTN.setOnClickListener(this)
        haveAccountTV.setOnClickListener(this)
        newTV.setOnClickListener(this)
        forgetTV.setOnClickListener(this)

    }

    override fun onBackPressed() {
        if (forgetRL.visibility == View.VISIBLE) {
            forgetRL.visibility = View.GONE
            return
        }
        super.onBackPressed()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loginBTN -> if (loginBTN.text.toString().contains("login", ignoreCase = true)) {
                login()
            } else {
                register()
            }
            R.id.haveAccountTV -> showLoginView()
            R.id.newTV -> showRegisterView()
            R.id.forgetTV -> {
                forgetRL.visibility = View.VISIBLE
                (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                        .showSoftInput(forgetUsernameTIL.editText, InputMethodManager.SHOW_IMPLICIT)
            }

        }
    }

    private fun login() {

    }

    private fun register() {

    }

    @SuppressLint("SetTextI18n")
    private fun showLoginView() {
        loginTitleTV.text = "Login"
        loginBirthDateTIL.visibility = View.GONE
        haveAccountTV.visibility = View.GONE
        newTV.visibility = View.VISIBLE
        forgetTV.visibility = View.VISIBLE
        loginBTN.text = "Login"
    }

    @SuppressLint("SetTextI18n")
    private fun showRegisterView() {
        loginTitleTV.text = "Register"
        loginBirthDateTIL.visibility = View.VISIBLE
        haveAccountTV.visibility = View.VISIBLE
        newTV.visibility = View.GONE
        forgetTV.visibility = View.GONE
        loginBTN.text = "Register"
    }

}
