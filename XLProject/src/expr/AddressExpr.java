package expr;

import model.Environment;
import xl.Address;

class AddressExpr extends Expr {
    private Address address;

    AddressExpr(String s) {
        address = new Address(s);
    }

    public String toString(int prec) {
        return address.toString();
    }

    public double value(Environment env) {
        return env.value(address);
    }
}