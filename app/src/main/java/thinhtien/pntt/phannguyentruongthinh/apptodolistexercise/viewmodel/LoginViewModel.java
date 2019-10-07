package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.viewmodel;

import androidx.lifecycle.MutableLiveData;

import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.Loginresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.respository.Loginrespository;

public class LoginViewModel {
    public LoginViewModel() {
    }

    public MutableLiveData<Loginresponse> checklogin(String username, String password){
        return Loginrespository.getInstance().getDataLogin(username, password);
    }
}
