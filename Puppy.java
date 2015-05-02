/*

    Happiness notes -
        -9 - :( *** FOR PUPPIES WITH ONE NEIGHBOR
        -2 - :(
        -1 - :|
         0 - :|
         1 - :|
         2 - :)
         9 - :) *** FOR PUPPIES WITH ONE NEIGHBOR

 */
public class Puppy {
    private int _biscuitSize;
    private int _happiness;


    public Puppy(int _biscuitSize) {
        this._biscuitSize = _biscuitSize;
    }

    public int get_biscuitSize() {
        return _biscuitSize;
    }

    public int get_happiness() {
        return _happiness;
    }

    public void set_happiness(int _happiness) {
        this._happiness = _happiness;
    }

    public void minusOneHappiness() {
        _happiness--;
    }

    public void addOneHappiness() {
        _happiness++;
    }

    public String toString() {
        if (_happiness == -9 || _happiness == -2) {
            return ":(";
        } else if (_happiness > -2 && _happiness < 2) {
            return ":|";
        } else if (_happiness == 9 || _happiness == 2) {
            return ":)";
        }
        return "ER";
    }
}
