package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.respository;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.Loginresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.retrofit.Responseapi;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.retrofit.Retrofitinit;

public class Loginrespository {

    private static Loginrespository loginrespository = null;
    private Responseapi responseapi;

    private Loginrespository(){
        responseapi = Retrofitinit.getApi();
    }

    public static Loginrespository getInstance(){
        if (loginrespository == null){
            loginrespository = new Loginrespository();
        }
        return loginrespository;
    }

    public MutableLiveData<Loginresponse> getDataLogin (String username, String password){
        final MutableLiveData<Loginresponse> mutableLiveData = new MutableLiveData<>();

        responseapi.getLoginapi(username, password).enqueue(new Callback<Loginresponse>() {
            @Override
            public void onResponse(Call<Loginresponse> call, Response<Loginresponse> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Loginresponse> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
