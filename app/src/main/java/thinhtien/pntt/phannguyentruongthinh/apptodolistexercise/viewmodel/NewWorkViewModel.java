package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.viewmodel;

import androidx.lifecycle.MutableLiveData;

import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.NewWorkresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.respository.NewWorkRespository;

public class NewWorkViewModel {
    public NewWorkViewModel() {
    }

    public MutableLiveData<NewWorkresponse> checkNewWork(String projectname, long time, int iduser){
        return NewWorkRespository.getInstance().getDataNewWork(projectname, time, iduser);
    }
}
