public class MB_Application {

    private CA_Adapter ca;
    private static MB_Application instance = null;

    public void setCA(CA_Adapter ca) {
        this.ca = ca;
    }

    public static MB_Application getInstance() {
        if (instance == null) {
            instance = new MB_Application();
        }
        return instance;
    }

    public int forwardRegisterC(String name, AddressData address, String email, TimeData birthday, int phonenumber) {
        if (name != null || address != null || email != null) {
            return ca.addCustomerAccount(name, address, email, birthday, phonenumber);
        } else {
            return 0;
        }
    }
}
