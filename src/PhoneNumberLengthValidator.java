public class PhoneNumberLengthValidator implements Validator{
    int length;

    public PhoneNumberLengthValidator(int length){
        this.length = length;
    }

    @Override
    public boolean validate(String input) {
        return input.length() == this.length;
    }

    @Override
    public String getErrorMessage() {
        return "Phone Number length is not ok";
    }
}
