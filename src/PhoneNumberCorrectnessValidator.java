public class PhoneNumberCorrectnessValidator implements Validator{
    @Override
    public boolean validate(String phoneNumber) {
        return phoneNumber.startsWith("09");
    }

    @Override
    public String getErrorMessage() {
        return "Input is not a valid Number";
    }
}