package Calculadora.src;

class Calculator{
    private int batteryMax;
    int battery;
    float display;
    
    Calculator(int bM){
        batteryMax = bM;
        battery = 0;
        display = 0.0f;
    }
    
    public void charge(int b){
        battery += b;
        if(battery > batteryMax){
            battery = batteryMax;
        }
    }
    
    public void sum(int a, int b){
        if(battery < 1){
            IO.println("fail: bateria insuficiente");
        }else{
        battery--;
        display = a+b;
        }
    }
    
    public void div(float a, float b){
        if(battery < 1){
            IO.println("fail: bateria insuficiente");
        }else if(b == 0){
            IO.println("fail: divisao por zero");
            battery--;
        }else{
        battery--;
        display = a/b;
        }
    }
    
    @Override
    public String toString(){
        String Display = String.format("%.2f", display);
        return "display = " + Display + ", battery = " + battery;
    }
}