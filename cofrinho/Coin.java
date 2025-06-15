enum Coin {
    C10( "C10",0.10,1),
    C25( "C25",0.25,2),
    C50( "C50",0.50,3),
    C100("C100",1.00,4);

    private String label;
    private double value;
    private int volume;


    private Coin(String label, double value, int volume) {
        this.label = label;
        this.value = value;
        this.volume = volume;
    }

    public String getLabel(){
        return label;
    }

    public double getValue(){
        return value;
    }

    public int getVolume(){
        return volume;
    }

    @Override
    public String toString() {
         return String.format("%.2f", value) + ":" + volume;
    }
}
