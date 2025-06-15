import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Comparador implements Comparator<Client> {
    public int compare(Client c1, Client c2) {
        return c1.getName().compareTo(c2.getName());
    }
}

class Agiota {
    private ArrayList<Client> aliveList;
    private ArrayList<Client> deathList;
    private ArrayList<Operation> aliveOper;
    private ArrayList<Operation> deathOper;

    public Agiota() {
        this.aliveList = new ArrayList<>();
        this.deathList = new ArrayList<>();
        this.aliveOper = new ArrayList<>();
        this.deathOper = new ArrayList<>();
    }

    /*private boolean findClient(String name) {
        for (Client cli : this.aliveList) {
            if (cli.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }*/

    private int searchClient(String name) {
         for (int i = 0; i < this.aliveList.size(); i++) {
            if (this.aliveList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void pushOperation(Client client, String name, Label label, int value) {
        Operation oper = new Operation(name, label, value);
        this.aliveOper.add(oper);
        client.addOperation(oper);
    }

    private void sortAliveList() {
        // this.aliveList.sort(); //para inteiros
        // Collections.sort (this.aliveList); //para inteiros

        // this.aliveList.sort( new Comparator<Client>() {
        // public int compare(Client c1, Client c2) {
        // return c1.getName().compareTo(c2.getName());
        // // if (c1.getLimite() < c2.getLimite()) return -1;
        // // else if (c1.getLimite() > c2.getLimite()) return 1;
        // // else return 0;
        // }
        // });

        // Collections.sort (this.aliveList, new Comparator<Client>() {
        // public int compare(Client c1, Client c2) {
        // return c1.getName().compareTo(c2.getName());
        // }
        // });

        Collections.sort (this.aliveList, new Comparador());
    }

    public Client getClient(String name) throws Exception {
        int index = this.searchClient(name);
        if (index == -1) {
            throw new Exception("Fail: cliente nao existe");
        }

        return this.aliveList.get(index);
    }

    public void addClient(String name, int limite) throws Exception {
        if (this.searchClient(name) != -1) {
            throw new ClienteException(true);
        }

        Client cli = new Client(name, limite);
        this.aliveList.add(cli);
    }

    public void give(String name, int value) throws Exception {
        int index = this.searchClient(name);
        if (index == -1) {
            throw new ClienteException(false);
        }

        if(aliveList.get(index).getBalance() + value > aliveList.get(index).getLimite()){
            throw new Exception("fail: limite excedido");
        }

        this.pushOperation(aliveList.get(index), name, Label.GIVE, value);
    }

    public void take(String name, int value) throws Exception {
        int index = this.searchClient(name);
        if (index == -1) {
            throw new ClienteException(false);
        }
        
        this.pushOperation(aliveList.get(index), name, Label.TAKE, value);
    }

    // public void kill(String name) throws Exception {
    //     int index = this.searchClient(name);
    //     if (index == -1) {      
    //         throw new ClienteException(false);
    //     }

    //     ArrayList<Operation> toKill = new ArrayList<>(this.aliveOper);
    //     for (int i = 0; i < toKill.size(); i++) {
    //         Operation oper = toKill.get(i);
    //         if (oper.getName().equals(name)) {
    //             this.deathOper.add(oper);
    //             this.aliveOper.remove(i);
    //         }
    //     }

    //     this.deathList.add(aliveList.get(index));
    //     this.aliveList.remove(index);
    // }

    public void kill(String name) throws Exception {
        int index = this.searchClient(name);
        if (index == -1) {
            throw new ClienteException(false);
        }

        Iterator<Operation> iter = aliveOper.iterator();
        while (iter.hasNext()) {
            Operation oper = iter.next();
            if (oper.getName().equals(name)) {
                this.deathOper.add(oper);
                iter.remove();
            }
        }

        this.deathList.add(aliveList.get(index));
        this.aliveList.remove(index);
    }

    public void plus() throws Exception{
        if(aliveList.size() == 0){
            throw new Exception("Fail: sem clientes");
        }

        if(aliveOper.size() == 0){
            throw new Exception("Fail: sem operacoes");
        }

        for (Client client : this.aliveList) {
            int juros = (int) Math.ceil(0.1*client.getBalance() );
            this.pushOperation( client, client.getName(), Label.PLUS, juros);
        }

        ArrayList<Client> toKill = new ArrayList<>(this.aliveList);
        for ( Client client : toKill) {
            if ( client.getBalance() > client.getLimite() ) {
                this.kill( client.getName() );
            }
        }

        // for (int i = 0; i < this.aliveList.size(); i++) {
        //     Client client = this.aliveList.get(i);
        //     if ( client.getBalance() > client.getLimite() ) {
        //     this.kill( client.getName() );
        //     i--;
        // }
        // }
    }

    @Override
    public String toString() {
        String ss = "";
        sortAliveList();
        for (Client client : this.aliveList) {
            ss += ":) " + client.getName() + " " + client.getBalance() + "/" + client.getLimite() + "\n";
        }
        for (Operation oper : this.aliveOper) {
            ss += "+ " + oper + "\n";
        }
        for (Client client : this.deathList) {
            ss += ":( " + client.getName() + " " + client.getBalance() + "/" + client.getLimite() + "\n";
        }
        for (Operation oper : this.deathOper) {
            ss += "- " + oper + "\n";
        }
        return ss;
    }
}