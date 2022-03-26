package io.github.mwrod453.mvn;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * API for accessing <a href="https://mvnrepository.com/">mvnrepository.com</a>.
 */
public interface MvnRepositoryApi {

    /**
     * @param groupId    Id of the artifact's group
     * @param artifactId Id of the artifact (project)
     * @param version    Version of the artifact
     * @return License of the package
     */
    @GET("/artifact/{groupId}/{artifactId}/{version}")
    Call<MvnArtifactVersion> getLicense(@Path("groupId") String groupId,
                                        @Path("artifactId") String artifactId,
                                        @Path("version") String version);
}
