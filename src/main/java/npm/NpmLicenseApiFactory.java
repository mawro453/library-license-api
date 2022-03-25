package npm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NpmLicenseApiFactory {

    private static final String BASE_URL = "http://registry.npmjs.com/";

    public static NpmLicenseApi create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(NpmLicenseApi.class);
    }
}
