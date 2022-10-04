package com.example.aps.APIService;

import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.GetNextPartData;
import com.example.aps.DataResponse.GetPreManuData;
import com.example.aps.DataResponse.GetSoDataData;
import com.example.aps.DataResponse.LoginData;
import com.example.aps.DataResponse.LoginUserGet;
import com.example.aps.DataResponse.SearchCustomer;
import com.example.aps.DataResponse.SearchSoId;
import com.example.aps.DataResponse.SearchAllData;
import com.example.aps.DataResponse.SoIdData;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
//登入
    @POST("auth/login")
    Single<LoginUserGet> login(@Body LoginData login);
//模糊so_id
    @GET("app-search-so")
    Single<Response<List<SearchSoId>>> getSo_Id(@Query("token") String token,
                                                @Query("so_id") String so_id);
//模糊客戶查詢
    @GET("app-search-customer")
    Single<Response<List<SearchCustomer>>> getCustomer(@Query("token") String token,
                                                       @Query("customer_name") String customer);
//soid_item & data
    @GET("get-sale-order")
    Single<Response<List<SoIdData>>> getSaleOrder(@Query("token") String token,
                                                  @Query("sale_order") String sale_order ,
                                                  @Query("online_date") String online_data,
                                                  @Query("customer") String customer);
//mo_sh_recyclerview
    @GET("get-manufacture")
    Single<Response<List<SearchAllData>>> getSearchData(@Query("token") String token,
                                                        @Query("sale_order") String sale_order,
                                                        @Query("manufacture") String manufacture);

//前
    @GET("get-prev-manufacture")
    Single<Response<List<GetPreManuData>>> GetPreManu(@Query("token") String token,
                                                      @Query("so_id") String so_id,
                                                      @Query("item_id") String item_id);
//本2
    @GET("get-current-stage-com")
    Single<Response<List<GetCurrentStageData>>> GetCurrentStage(@Query("token") String token,
                                                                @Query("item_id") String item_id);
//後
    @GET("get-next-part")
    Single<List<GetNextPartData>> GetNextPart(@Query("token") String token,
                                              @Query("sale_order") String sale_order,
                                              @Query("id") String id);
//裝配
    @GET("get-so-data")
    Single<Response<GetSoDataData>> GetSoData(@Query("token") String token,
                                              @Query("sale_order") String so_id,
                                              @Query("item") String item_id);

}



