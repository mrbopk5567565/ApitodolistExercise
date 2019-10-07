package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.viewmodel;

import androidx.lifecycle.MutableLiveData;

import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.Registerresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.respository.RegisterRespository;

public class RegisterViewModel {
    public RegisterViewModel() {

    }

    public MutableLiveData<Registerresponse> checkRegister(String username, String password){
        return RegisterRespository.getInstance().getDataRegister(username, password);
    }
}
