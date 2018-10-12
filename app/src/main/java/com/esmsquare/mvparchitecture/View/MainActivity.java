package com.esmsquare.mvparchitecture.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.esmsquare.mvparchitecture.View.Interface.MainView;
import com.esmsquare.mvparchitecture.Model.GetQuoteInteractorImpl;
import com.esmsquare.mvparchitecture.Presenter.Interface.MainPresenter;
import com.esmsquare.mvparchitecture.Presenter.MainPresenterImpl;
import com.esmsquare.mvparchitecture.R;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements MainView {

    private TextView textView;
    private Button button;
    private ProgressBar progressBar;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView    = findViewById(R.id.textView);
        button      = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);

        presenter = new MainPresenterImpl(this, new GetQuoteInteractorImpl());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        textView.setText(string);
    }
}