import java.util.ArrayList;

public class SupplierManagement {
    ArrayList <Supplier> supplierList;
    Supplier defaultSupplier1;
    Supplier defaultSupplier2;

    public SupplierManagement(){
        supplierList = new ArrayList<>();
        defaultSupplier1 = new Supplier("Safeguard Pro Solutions", 07856738657f, "safeguardprosolutions@email.com");
        defaultSupplier2 = new Supplier("Pinnacle Survey Systems", 02074657694f, "pinnacle@survey.com");

        supplierList.add(defaultSupplier1);
        supplierList.add(defaultSupplier2);
    }

    //allowing for suppliers to be added to the array
    public void addSupplierToList(Supplier supplier){
        supplierList.add(supplier);
    }

    //deleting suppliers from the array
    public void deleteSupplierFromList(Supplier supplier){
        supplierList.remove(supplier);
    }

    //updating supplier contact details
    public void updateSupplierContactDetails(Supplier supplier, int phoneNumber, String email){
        supplier.setSupplierPhoneNumber(phoneNumber);
        supplier.setSupplierEmail(email);
    }

    public Supplier getSupplierById (int id){
        Supplier supplierTarget = null;
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplierId() == id) {
                supplierTarget = supplier;
                break;
            }
        }
        return supplierTarget;
    }
}
