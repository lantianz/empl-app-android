package com.ltz.my_empl.api;

public interface Callback {

    void onSuccess(final String res);

    void onFailure(Exception error);
}
