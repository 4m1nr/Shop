import java.util.*;

public class Rating {
    int total,count;
    double average;
    private Map<String /*User ID*/,Integer /*Rate*/> rates;

    public Rating(String serializedRatings) {
        /*rates = new HashMap<>();
        if (serializedRatings != null){
            String[] ratings = serializedRatings.split("-");
            for (String rating : ratings) {
                String[] rateForUser = rating.split(":");
                addRating(rateForUser[0], Integer.parseInt(rateForUser[*//*1*//*0]));
            }
        }*/
    }

    public Rating() {
        rates = new HashMap<>();
    }

    //getter
    public Map<String,Integer> getRates() {return rates;}

    //setters
    public void addRating(User user,int rating)  {rates.put(user.getId(),rating);}
    public void addRating(String ID,int rating)  {rates.put(ID,rating);}
    public void removeRating(User user)          {rates.remove(user.getId());}
    public void removeRating(String ID)          {rates.remove(ID);}
    public void removeAllRatings()               {rates.clear();}

    public String serializeRatings(){
        if (rates.isEmpty()) return null;
        else {
            Set<String> keySet = rates.keySet();
            StringBuilder string = new StringBuilder();
            rates.forEach((key,value) -> {
                string.append(key).append(":").append(value).append("-");
            });
            string.deleteCharAt(string.length()-1);
            return string.toString();
        }
    }

    public Double getAverage(){
        total = 0;
        count = rates.size();
        rates.forEach((key,value) -> {
            total += value;
        });
        average = (double) total / (double) count;
        return average;
    }
}
