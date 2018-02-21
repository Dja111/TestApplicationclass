import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MB_ApplicationTest {
     private MB_Application app;
     private CA_Adapter ca;

    String name = "Aurele";
    AddressData address = new AddressData("veleda", 5, 45355, "Essen");
    String email = "monEmail@yahoo.fr";
    TimeData timeData = new TimeData(14, 02, 2018);
    int phonenumber = 017614;


    @BeforeEach

    public void SetUp(){
        app = MB_Application.getInstance();

        ca = mock(CA_Adapter.class);

        app.setCA(ca);

         when(ca.addCustomerAccount(this.name, this.address, this.email, this.timeData, this.phonenumber)).thenReturn(4);

     }

     @Test
    public  void testForwardRegisterCOK(){
            int result = ca.addCustomerAccount(this.name,this.address,this.email,this.timeData,this.phonenumber);
            assertEquals(result,4);
         verify(ca, times(1)).addCustomerAccount(this.name, this.address, this.email, this.timeData, this.phonenumber);

     }

     @Test
    public void  testForwardRegisterCFAIL(){

         int result = app.forwardRegisterC(null, this.address, this.email, this.timeData, this.phonenumber);
         assertEquals(0, result);
         verify(ca, times(0)).addCustomerAccount(this.name, this.address, this.email, this.timeData, this.phonenumber);
     }
}