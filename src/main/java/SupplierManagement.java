import java.util.ArrayList;

public class SupplierManagement {
    ArrayList <Supplier> supplierList;

    public SupplierManagement(){
        supplierList = new ArrayList<>();
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
