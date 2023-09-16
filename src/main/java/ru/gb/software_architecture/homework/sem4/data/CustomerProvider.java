package ru.gb.software_architecture.homework.sem4.data;

class CustomerProvider {

    private Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        Customer customer = new Customer();
        database.addCustomer(customer);
        return customer;
    }

}
