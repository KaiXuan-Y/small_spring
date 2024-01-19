package ykx.manual.spring.springframework.beans.factory;

public final class NullBean {
    public NullBean() {
    }

    @Override
    public boolean equals(Object other) {
        return (this == other || other == null);
    }

    @Override
    public int hashCode() {
        return NullBean.class.hashCode();
    }

    @Override
    public String toString() {
        return "null";
    }
}
