import java.util.ArrayList;

class Client {
    private String name;
    private int limite;
    ArrayList<Operation> operations;

    public Client(String name, int limite) {
        this.name = name;
        this.limite = limite;
        this.operations = new ArrayList<>();
    }

    @Override
    public String toString() {
        String ss = this.name + " " + this.getBalance() + "/" + this.limite + "\n";
        for ( Operation oper : this.operations ) {
            ss += oper + "\n";
        }
        return ss;
    }

    public String getName() {
        return this.name;
    }

    public int getLimite() {
        return this.limite;
    }
    
    public ArrayList<Operation> getOperations() {
        return this.operations;
    }

     public void addOperation(String name, Label label, int value) {
        this.operations.add( new Operation(name, label, value) );
    }

    public void addOperation(Operation operation) {
        this.operations.add( operation );
    }

    public int getBalance() {
        int divida = 0;
        for(Operation op : operations){
            if(op.getLabel().equals(Label.TAKE)){
                divida -= op.getValue();
            }else{
                divida += op.getValue();
            }
        }
        return divida;
    }
}