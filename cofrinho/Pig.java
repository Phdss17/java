import java.util.ArrayList;

public class Pig {
    private boolean broken;
    private ArrayList<Coin> coins;
    private ArrayList<Item> items;
    private int volumeMax;

    public Pig(int volumeMax){
        this.broken = false;
        this.coins = new ArrayList<>();
        this.items = new ArrayList<>();
        this.volumeMax = volumeMax;
    }
    
    public boolean addCoin(Coin coin){
        if(isBroken()){
            IO.println("fail: the pig is broken");
            return false;
        }
        if(getVolume() + coin.getVolume() >= volumeMax){
            IO.println("fail: the pig is full");
            return false;
        }
        coins.add(coin);
        return true;
    }
    
    public boolean addItem(Item item){
        if(isBroken()){
            IO.println("fail: the pig is broken");
            return false;
        }
        if(getVolume() + item.getVolume() >= volumeMax){
            IO.println("fail: the pig is full");
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean breakPig(){
        if(isBroken()){
            IO.println("fail: the pig is already broken");
            return false;
        }
        broken = true;
        return broken;
    }

    public ArrayList<Coin> extractCoins(){
        if (!isBroken()) {
            IO.println("fail: you must break the pig first");
            return new ArrayList<>(); 
        }
        ArrayList<Coin> extracted = new ArrayList<>(coins);
        coins.clear();
        return extracted;
    }

    public ArrayList<Item> extractItems() {
        if (!isBroken()) {
            IO.println("fail: you must break the pig first");
            return new ArrayList<>(); 
        }
        ArrayList<Item> extracted = new ArrayList<>(items);
        items.clear();
        return extracted;
    }

    public int getVolume(){
        int volume = 0;
        if(!isBroken()){
            for(Coin c : coins){
                volume += c.getVolume();
            }
    
            for(Item i : items){
                volume += i.getVolume();
            }
        }
        return volume;
    }

    public double getValue(){
        double totalValue = 0.0;
            for(Coin c : coins){
                totalValue += c.getValue();    
            }
        return totalValue;
    }

    public int volumeMax(){
        return volumeMax;
    }

    public boolean isBroken(){
        return broken;
    }

    @Override
    public String toString(){
        String str = "state=";if(isBroken()){str += "broken : coins=[";}else{str += "intact : coins=[";}

        if(!coins.isEmpty()){
            for(int i = 0; i < coins.size(); i++){
                Coin c = coins.get(i);
                if(i < coins.size()-1){
                    str += c + ", ";
                }else{
                    str += c;
                }
            }
        }

        str += "] : items=[";

        if(!items.isEmpty()){
            for(int i = 0; i < items.size(); i++){
                Item aux = items.get(i);
                if(i < items.size()-1){
                    str += aux + ", ";
                }else{
                    str += aux;
                }
            }
        }
        str += "] : value=" +  String.format("%.2f", getValue()) + " : volume=" + getVolume() + "/" + volumeMax;
        return str;
    }
}