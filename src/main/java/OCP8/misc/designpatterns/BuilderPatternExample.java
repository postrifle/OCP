package OCP8.misc.designpatterns;

public class BuilderPatternExample {
    private String obligatoryParameter;
    private int optionalInt;
    private char optionalChar;
    private double optionalDouble;
    private boolean optionalBoolean;

    private BuilderPatternExample(){}

    static class Builder{
        private String obligatoryParameter;
        private int optionalInt;
        private char optionalChar;
        private double optionalDouble;
        private boolean optionalBoolean;

        public Builder(String obligatoryParameter) {
            this.obligatoryParameter = obligatoryParameter;
        }

        public Builder setOptionalInt(int optionalInt) {
            this.optionalInt = optionalInt;
            return this;
        }

        public Builder setOptionalChar(char optionalChar) {
            this.optionalChar = optionalChar;
            return this;
        }

        public Builder setOptionalDouble(double optionalDouble) {
            this.optionalDouble = optionalDouble;
            return this;
        }

        public Builder setOptionalBoolean(boolean optionalBoolean) {
            this.optionalBoolean = optionalBoolean;
            return this;
        }

        public BuilderPatternExample build(){
            BuilderPatternExample bpe = new BuilderPatternExample();
            bpe.setObligatoryParameter(this.obligatoryParameter);
            bpe.setOptionalBoolean(this.optionalBoolean);
            bpe.setOptionalChar(this.optionalChar);
            bpe.setOptionalDouble(this.optionalDouble);
            bpe.setOptionalInt(this.optionalInt);
            return bpe;
        }
    }

    public String getObligatoryParameter() {
        return obligatoryParameter;
    }

    public void setObligatoryParameter(String obligatoryParameter) {
        this.obligatoryParameter = obligatoryParameter;
    }

    public int getOptionalInt() {
        return optionalInt;
    }

    public void setOptionalInt(int optionalInt) {
        this.optionalInt = optionalInt;
    }

    public char getOptionalChar() {
        return optionalChar;
    }

    public void setOptionalChar(char optionalChar) {
        this.optionalChar = optionalChar;
    }

    public double getOptionalDouble() {
        return optionalDouble;
    }

    public void setOptionalDouble(double optionalDouble) {
        this.optionalDouble = optionalDouble;
    }

    public boolean isOptionalBoolean() {
        return optionalBoolean;
    }

    public void setOptionalBoolean(boolean optionalBoolean) {
        this.optionalBoolean = optionalBoolean;
    }

    @Override
    public String toString() {
        return "BuilderPatternExample{" +
                "obligatoryParameter='" + obligatoryParameter + '\'' +
                ", optionalInt=" + optionalInt +
                ", optionalChar=" + optionalChar +
                ", optionalDouble=" + optionalDouble +
                ", optionalBoolean=" + optionalBoolean +
                '}';
    }
}
