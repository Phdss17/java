public interface Valuable {
    String getLabel();
    double getValue();
    int getVolume();

    @Override
    String toString();
}
