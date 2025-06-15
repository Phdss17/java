public class Item {
    private String label;
    private int volume;

    Item(String label, int volume){
        setLabel(label);
        setVolume(volume);
    }

    public String getLabel(){
        return label;
    }

    public int getVolume(){
        return volume;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    @Override
    public String toString(){
        return label + ":" + volume;
    }
}
