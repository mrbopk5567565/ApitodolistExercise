package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.respository;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.Registerresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.retrofit.Responseapi;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.retrofit.Retrofitinit;

public class RegisterRespository {

    private static RegisterRespository registerRespository = null;
    private Responseapi responseapi;

    private RegisterRespository() {
        responseapi = Retrofitinit.getApi();
    }

    public static RegisterRespository getInstance(){
        if (registerRespository == null){
            registerRespository = new RegisterRespository();
        }
        return registerRespository;
    }

    public MutableLiveData<Registerresponse> getDataRegister(String username, String password){
        final MutableLiveData<Registerresponse> mutableLiveData = new MutableLiveData<>();

        responseapi.getRegisterapi(username, password).enqueue(new Callback<Registerresponse>() {
            @Override
            public void onResponse(Call<Registerresponse> call, Response<Registerresponse> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Registerresponse> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
