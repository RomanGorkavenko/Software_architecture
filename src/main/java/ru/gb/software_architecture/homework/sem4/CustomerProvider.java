package ru.gb.software_architecture.homework.sem4;

class CustomerProvider {

    private Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        return new Customer();
    }

}
