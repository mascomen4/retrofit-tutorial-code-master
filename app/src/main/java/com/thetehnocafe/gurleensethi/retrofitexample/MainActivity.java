package com.thetehnocafe.gurleensethi.retrofitexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Button call_first_employee = findViewById(R.id.button_1);
        call_first_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView textView = findViewById(R.id.textView_output);
                TextInputEditText textInputLayout = findViewById(R.id.employee_id);
                String text = textInputLayout.getText().toString();
                Integer Id = Integer.parseInt(text);


                NetworkService.getInstance()
                        .getJSONApi()
                        .getEmployeeWithID(Id)

                        .enqueue(new Callback<Post>() {
                            @Override
                            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                                Post post = response.body();

                                //textView.append((response.raw().toString()));
                                textView.append("\n" + post.getId() + "\n");
                                textView.append(post.getFirstName() + "\n");
                                textView.append(post.getLastName() + "\n");
                            }

                            @Override
                            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                                textView.append("Error occurred while getting request!");
                                t.printStackTrace();
                            }
                        });


//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

//        Button call_all = findViewById(R.id.button_all);
//        call_all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final TextView textView = findViewById(R.id.textView_output);
//
//                NetworkService.getInstance()
//                        .getJSONApi()
//                        .getAllEmployees()
//
//                        .enqueue(new Callback<Post>() {
//                            @Override
//                            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
//                                Post post = response.body();
//
//                                textView.append((response.raw().toString()));
//
////                                textView.append("\n" + post.getId() + "\n");
////                                textView.append(post.getFirstName() + "\n");
////                                textView.append(post.getLastName() + "\n");
//                            }
//
//                            @Override
//                            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
//
//                                textView.append("Error occurred while getting request!");
//                                t.printStackTrace();
//                            }
//                        });
//
//
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });


    }
}
