package kg.nurtelecom.swiftapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeveloperSignUpResponse(
        Long id,

        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,


        String position,

        String phone,

        String email
) {
}
