class ClienteException extends Exception {
    private boolean existe;

    public ClienteException(boolean existe) {
        this.existe = existe;
    }

    @Override
    public String getMessage() {
        if (this.existe)
            return "fail: cliente ja existe";
        else
            return "fail: cliente nao existe";
    }
}