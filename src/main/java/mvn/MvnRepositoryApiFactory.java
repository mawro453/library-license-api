package mvn;

import pl.droidsonroids.retrofit2.JspoonConverterFactory;
import retrofit2.Retrofit;

public class MvnRepositoryApiFactory {

    private static final String BASE_URL = "https://mvnrepository.com/";

    public static MvnRepositoryApi create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JspoonConverterFactory.create())
                .build();

        return retrofit.create(MvnRepositoryApi.class);
    }
}
