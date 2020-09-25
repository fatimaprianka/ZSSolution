package com.prianka.zssolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prianka.zssolution.model.LoginResponse;
import com.prianka.zssolution.model.Validation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        EditText email, password;
        Button loginBtn;

        private ApiInterface apiInterface;
        LoginResponse loginResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);

        loginBtn = findViewById(R.id.login_btn);

        // Network call
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(Validation.editTextValidation(email,getResources().getString(R.string.error_msg))
                    && Validation.editTextValidation(password, getResources().getString(R.string.error_msg))){

            //method call
            signIn();
        }
    }


    private void signIn(){
        try{
            Call<LoginResponse>call = apiInterface.userSignIn(email.getText().toString(), password.getText().toString());

            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if(response.isSuccessful() && response.body() != null){

                        loginResponse = response.body();

                        Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });
        }
        catch (Exception ex){

        }

    }
}
