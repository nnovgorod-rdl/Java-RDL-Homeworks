package pks.builder;

public class Recipient {
    private final String name;
    private final String address;

    private Recipient(RecipientBuilder recipientBuilder) {
        this.name = recipientBuilder.name;
        this.address = recipientBuilder.address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class RecipientBuilder {
        private String name;
        private final String address;

        public RecipientBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public RecipientBuilder(String address) {
            this.address = address;
            //address считаю обязательным
        }

        public Recipient build() {
            return new Recipient(this);
        }
    }

}
