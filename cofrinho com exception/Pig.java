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
    
    public boolean addCoin(Coin coin) throws Exception{
        if(isBroken())
            throw new BreakPigException(isBroken());
        if(getVolume() == volumeMax())
            throw new FullPigexception();
        coins.add(coin);
        return true;
    }
    
    public boolean addItem(Item item) throws Exception{
        items.add(item);
        return true;
    }

    public boolean breakPig() throws Exception{
        broken = true;
        return broken;
    }

    public Coin[] extractCoins() throws Exception{
        Coin[] removed = new Coin[coins.size()];
        for(int i = 0; i < coins.size(); i++){
            removed[i] = coins.get(i);
            coins.remove(i);
        }
        return removed;
    }

    public Item[] extractItems()throws Exception{
        Item[] removed = new Item[items.size()];
        for(int i = 0; i < items.size(); i++){
            removed[i] = items.get(i);
            items.remove(i);
        }
        return removed;
    }

    public int getVolume(){
        int volume = 0;
        for(Coin c : coins){
            volume += c.getVolume();
        }

        for(Item i : items){
            volume += i.getVolume();
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

        str += "] : value=" + getValue() + " : volume=" + getVolume();

        return str;
    }
}