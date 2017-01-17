package onsterlabs.android.kit.registration.API;


import onsterlabs.android.kit.registration.model.RegisterResponse;
import onsterlabs.android.kit.registration.model.RegistrationRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by ttnd on 16/11/16.
 */

public interface IRegistrationAPI {

    @POST("v1/registration/otp/generate")
    Observable<RegisterResponse> doRegistration(@Body RegistrationRequest registrationRequest);
}
