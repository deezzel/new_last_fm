package com.newlastfm.app.validation;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/3/14.
 */
public class TextValidationListener implements TextWatcher {
    final IValidatable validatable;

    public TextValidationListener(final IValidatable validatable) {
        this.validatable = validatable;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        validatable.validate();
    }
}
