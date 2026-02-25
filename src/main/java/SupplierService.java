import java.util.ArrayList;

public class SupplierService {
    public ArrayList <Supplier> supplierList;
    public Supplier defaultSupplier1;
    public Supplier defaultSupplier2;

    public SupplierService(){
        supplierList = new ArrayList<>();
        defaultSupplier1 = new Supplier("Safeguard Pro Solutions", "07856738657", "safeguardprosolutions@email.com");
        defaultSupplier2 = new Supplier("Pinnacle Survey Systems", "02074657694", "pinnacle@survey.com");

        supplierList.add(defaultSupplier1);
        supplierList.add(defaultSupplier2);
    }

    //allowing for suppliers to be added to the array
    public boolean addSupplierToList(Supplier supplier){
        if (!supplierList.contains(supplier) && supplier != null){
            supplierList.add(supplier);
            return true;
        }
        return false; //-this in case of a duplicate
    }

    //enabling user friendly ways to refer to objects/suppliers
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

    //deleting suppliers from the array
    public void deleteSupplierFromList(int id){
        Supplier supplier = getSupplierById(id);
        supplierList.remove(supplier);
    }

    //updating supplier contact details
    public void updateSupplierContactDetails(Supplier supplier, String phoneNumber, String email){
        supplier.setSupplierPhoneNumber(phoneNumber);
        supplier.setSupplierEmail(email);
    }
}
