public class NameLengthValidator implements Validator{
    int min,max;

    public NameLengthValidator(int min,int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean validate(String input) {
        return input.length() <= this.max && input.length() >= this.min;
    }

    @Override
    public String getErrorMessage() {
        return "Name length is not between [" + min +" , "+ max + "]";
    }

}
