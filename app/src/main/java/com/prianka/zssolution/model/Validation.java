package com.prianka.zssolution.model;

import android.widget.EditText;

public class Validation {

    public static CharSequence hintName;

    //Edittext validation
    public static boolean editTextValidation(final EditText editText, String errorMssage){
        if(!editText.getText().toString().isEmpty()){
            editText.clearFocus();

            return true;
        }
        else {

            editText.requestFocus();
            hintName = editText.getHint();
            return false;
        }

    }

}
