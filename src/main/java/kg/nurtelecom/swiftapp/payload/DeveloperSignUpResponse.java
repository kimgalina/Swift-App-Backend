package kg.nurtelecom.swiftapp.payload;

public record DeveloperSignUpResponse(
        Long id,

        String firstName,

        String lastName,


        String position,

        String phone,

        String email
) {
}
