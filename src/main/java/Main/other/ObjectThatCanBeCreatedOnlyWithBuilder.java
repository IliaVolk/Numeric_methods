package Main.other;

public class ObjectThatCanBeCreatedOnlyWithBuilder {
    public class C{
        public String m(){
            return "From C.m: " + ObjectThatCanBeCreatedOnlyWithBuilder.this.toString().replace('\n', ' ');
        }
    }

    /**
     * Builder for class ObjectThatCanBeCreatedOnlyWithBuilder.
     * @see Main.other.ObjectThatCanBeCreatedOnlyWithBuilder
     * Has set-method for all ObjectThatCanBeCreatedOnlyWithBuilder fields
     * and creation-object method build().
     *
     * Class ObjectThatCanBeCreatedOnlyWithBuilder has many fields
     * for initialization, Builder simplifies creation new instances
     * of it.
     */
    public static class Builder{
        private String a;
        private String b;
        private String c;
        private String d;
        private Builder(){
            a = " ";
            b = " ";
            c = " ";
            d = " ";
        }
        public Builder setA(String a){
            this.a = a;
            return this;
        }
        public Builder setB(String b){
            this.b = b;
            return this;
        }
        public Builder setC(String c){
            this.c = c;
            return this;
        }
        public Builder setD(String d){
            this.d = d;
            return this;
        }

        /**
         *
         * @return built ObjectThatCanBeCreatedOnlyWithBuilder instance.
         */
        public ObjectThatCanBeCreatedOnlyWithBuilder build(){
            return new ObjectThatCanBeCreatedOnlyWithBuilder(this);
        }
    }

    /**
     *
     * @return Builder, implementation of "Builder" pattern, that
     * is used for creation new instance of ObjectThatCanBeCreatedOnlyWithBuilder.
     * @see Main.other.ObjectThatCanBeCreatedOnlyWithBuilder.Builder
     *
     */
    public static Builder getBuilder(){
        return new Builder();
    }
    private String a;
    private String b;
    private String c;
    private String d;

    /**
     *
     * Constructor for class ObjectThatCanBeCreatedOnlyWithBuilder.
     *
     * @param builder takes ObjectThatCanBeCreatedOnlyWithBuilder.Builder instance as a param
     *                and accepts all it's fields.
     * Decelerated as private, so only Builder can use this constructor.
     */
    private ObjectThatCanBeCreatedOnlyWithBuilder(Builder builder){
        a = builder.a;
        b = builder.b;
        c = new C().m();//builder.c;
        d = builder.d;
    }
    public void method(){}

    /**
     *
     * @return String information about class fields
     * in format: <b>field = value\n</b>
     */
    @Override
    public String toString() {
        return String.format("a = %s\n b = %s\n c = %s\n d = %s\n", a,b,c,d);
    }
}
