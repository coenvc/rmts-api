package data.crud;

import com.google.gson.Gson;
import model.Crudable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import utility.StringCombiner;

public class CrudService {

    private CrudOperation crudOperation;
    private Gson gson;

    public CrudService(CrudOperation crudOperation) {
        this.crudOperation = crudOperation;
        gson = new Gson();
    }

    public ResponseEntity<String> insert(Crudable crudable) {
        if (crudable.isIncomplete()) return getErrorMessage(crudable);

        try {
            if (crudOperation.create(crudable)) {
                return new ResponseEntity<String>("true", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("false", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(gson.toJson(e), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> update(Crudable crudable) {
        if (crudable.isIncomplete()) getErrorMessage(crudable);

        try {
            if (crudOperation.update(crudable)) {
                return new ResponseEntity<String>("true", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("false", HttpStatus.CONFLICT);
            }

        } catch (Exception e) {
            return new ResponseEntity<String>(gson.toJson(e), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> delete(Crudable crudable) {
        if (crudable.isIncomplete()) getErrorMessage(crudable);

        try {
            if (crudOperation.delete(crudable)) {
                return new ResponseEntity<String>("true", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("false", HttpStatus.CONFLICT);
            }

        } catch (Exception e) {
            return new ResponseEntity<String>(gson.toJson(e), HttpStatus.BAD_REQUEST);
        }
    }

    //region Helper methods
    private ResponseEntity<String> getErrorMessage(Crudable crudable) {
        String message = StringCombiner.combineList(crudable.getIncompleteProperties());
        return new ResponseEntity<String>(gson.toJson("Object is incomplete, missing: " + message), HttpStatus.CONFLICT);
    }
    //endregion
}
