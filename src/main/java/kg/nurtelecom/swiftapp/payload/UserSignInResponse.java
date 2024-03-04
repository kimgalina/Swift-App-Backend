package kg.nurtelecom.swiftapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserSignInResponse(
        @JsonProperty("access_token")
        String accessToken
) {
}
