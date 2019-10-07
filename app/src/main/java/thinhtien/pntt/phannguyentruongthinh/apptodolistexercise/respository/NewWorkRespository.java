package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.respository;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.NewWorkresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.retrofit.Responseapi;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.retrofit.Retrofitinit;

public class NewWorkRespository {

    private static NewWorkRespository newWorkRespository;
    private Responseapi responseapi;

    private NewWorkRespository() {
        responseapi = Retrofitinit.getApi();
    }

    public static NewWorkRespository getInstance(){
        if (newWorkRespository == null){
            newWorkRespository = new NewWorkRespository();
        }
        return newWorkRespository;
    }

    public MutableLiveData<NewWorkresponse> getDataNewWork(String projectname, long time, int iduser){
        final MutableLiveData<NewWorkresponse> mutableLiveData = new MutableLiveData<>();

        responseapi.getNewWorkapi(projectname, time, iduser).enqueue(new Callback<NewWorkresponse>() {
            @Override
            public void onResponse(Call<NewWorkresponse> call, Response<NewWorkresponse> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<NewWorkresponse> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
