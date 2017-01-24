package olabs.kit.registration;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputLayout;

import olabs.kit.BaseViewModel;
import olabs.kit.registration.API.RegistrationAPIListener;
import olabs.kit.registration.model.RegisterResponse;
import olabs.kit.registration.model.RegistrationRequest;


/**
 * Created by ttnd on 16/11/16.
 */

public class RegisterViewModel extends BaseViewModel {
    RegistrationAPIListener mRegistrationAPIListener;

    public RegisterViewModel(Context context) {
        super(context);
        mRegistrationAPIListener = new RegistrationAPIListener(this);
    }

    @Override
    public void onResume() {
        mRegistrationAPIListener.subscribe();
    }

    @Override
    public void onPause() {
//        mRegistrationAPIListener.unsubscribe();
    }


    public void onSubmit(RegistrationRequest registrationRequest){
        mOnProgressListener.showProgress();
        registerUser(registrationRequest);

    }

    public void onCancel(){
        ((Activity)context).finish();
    }

    private void registerUser(RegistrationRequest registrationRequest){
        mRegistrationAPIListener.doRegistration(registrationRequest);
    }

    public boolean isValidInput(TextInputLayout tilar, TextInputLayout tilba, TextInputLayout tilmobile, TextInputLayout tilemail){
        if(tilar.isErrorEnabled() || tilba.isErrorEnabled() || tilmobile.isErrorEnabled() || tilemail.isErrorEnabled())
            return  false;
       return true;
    }

    @Override
    public void onDestroy() {
//        mRegistrationAPIListener.unsubscribe();;
        mRegistrationAPIListener = null;
    }

    public void onRegistrationSuccess(RegisterResponse registerResponse){
        mOnProgressListener.hideProgress();
        if(registerResponse.getStatus()) {
            mOnProgressListener.showMessage(registerResponse.getMessage());
        }else{
            mOnProgressListener.showMessage(registerResponse.getMessage());
        }
    }

}