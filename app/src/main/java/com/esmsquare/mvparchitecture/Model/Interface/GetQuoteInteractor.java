package com.esmsquare.mvparchitecture.Model.Interface;

public interface GetQuoteInteractor {

    interface OnFinishedListener {
        void onFinished(String string);
    }
    void getNextQuote(OnFinishedListener listener);
}
