package com.example.properties;

/**
 * @author <a href="mailto:josh@joshlong.com">Josh Long</a>
 * @author Dave Syer
 */
public class ValueHoldingObject {

    private final String value;

    public ValueHoldingObject(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + this.value;
    }
}
