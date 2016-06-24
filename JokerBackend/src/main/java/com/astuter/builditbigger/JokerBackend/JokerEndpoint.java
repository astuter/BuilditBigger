/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.astuter.builditbigger.JokerBackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(name = "jokerApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "JokerBackend.builditbigger.astuter.com",
                ownerName = "JokerBackend.builditbigger.astuter.com",
                packagePath = ""
        )
)
public class JokerEndpoint {

    /**
     * A simple endpoint method that takes a jokr and shows it
     */
    @ApiMethod(name = "sayJoke")
    public JokerBean sayJoke(JokerBean joke) {
        return joke;
    }

}
