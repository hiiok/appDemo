package Michal.appdemo.validators;

import Michal.appdemo.constants.AppDemoConstants;
import Michal.appdemo.user.User;
import Michal.appdemo.utilities.AppDemoUtilis;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EditUserProfileValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User u = (User) obj;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lasntName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");

        if (!u.getEmail().equals(null)) {
            boolean isMatch = AppDemoUtilis.checkEmailOrPassword(AppDemoConstants.EMAIL_PATTERN, u.getEmail());
            if (!isMatch) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }
    }
}
