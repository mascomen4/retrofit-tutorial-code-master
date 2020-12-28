package com.thetehnocafe.gurleensethi.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    // Метод get, который будет иметь следующую строку. Функция, которая будет вызываться с этим именем, для нее использовать данный метод get
    @GET("/employees/{id}")
    public Call<Post> getEmployeeWithID(@Path("id") int id);

    @GET("/employees")
    public Call<List<Post>> getAllEmployees();

//    @GET("/posts")
//    public Call<List<Post>> getPostOfUser(@Query("userId") int id);
//
//    @POST("/posts")
//    public Call<Post> postData(@Body Post data);
}
