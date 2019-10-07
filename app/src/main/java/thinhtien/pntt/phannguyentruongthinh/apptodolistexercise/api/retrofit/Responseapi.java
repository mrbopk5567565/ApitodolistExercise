package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.Loginresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.NewWorkresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.Registerresponse;

public interface Responseapi {

    // xem huong dan POST tren google : retrofit

    @FormUrlEncoded
    @POST("login.php")
    Call<Loginresponse> getLoginapi(@Field("username") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<Registerresponse> getRegisterapi(@Field("username") String username,
                                           @Field("password") String password);

    @FormUrlEncoded
    @POST("newwork.php")
    Call<NewWorkresponse> getNewWorkapi(@Field("projectname") String projectname,
                                        @Field("time") long time,
                                        @Field("iduser") int iduser);
}
