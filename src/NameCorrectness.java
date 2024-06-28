public class NameCorrectness implements Validator{
    @Override
    public boolean validate(String name) {
        return name.matches("[a-zA-Z]+");
    }

    @Override
    public String getErrorMessage() {
        return "Input is not a valid Name";
    }
}
