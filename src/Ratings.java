import java.util.*;

public class Ratings {
    private Map<String,Integer> ratings = new HashMap<>();

    public Ratings(){}
    public Ratings(String serializedRatings) {
        String[] ratings = serializedRatings.split("-");
        for (int i = 0; i < ratings.length; i++) {
            String tmp[] = ratings[i].split(":");
            addRating(tmp[0],Integer.parseInt(tmp[1]));
        }
    }

    //getter
    public Map<String,Integer> getRatings() {return ratings;}

    //setters
    public void addRating(User user,int rating) {
        ratings.put(user.getId(),rating);}
    public void addRating(String ID,int rating){
        ratings.put(ID,rating);}
    public void removeRating(User user) {
        ratings.remove(user.getId());}
    public void removeRating(String ID) {
        ratings.remove(ID);}
    public void removeAllRatings() {
        ratings.clear();}

    public String getSerializedRatings(){
        if (ratings.isEmpty()) return "";
        Set<String> keySet = ratings.keySet();
        String string = "";
        for(String key : keySet){
            string += key + ":" + ratings.get(key) + "-";
        }
        return string.substring(0,string.length()-1);
    }

    public Double getAverage(){
        Set<String> keySet = ratings.keySet();
        int sum = 0;
        for(String key : keySet) sum += ratings.get(key);
        return (double) sum / keySet.size();
    }
}
