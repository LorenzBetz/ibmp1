package classmates.cloudant;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.IndexField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cloudant.client.api.model.Response;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    @Autowired
    private Database db;

    // Create new Student
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveStudent(@RequestBody Student student){
        System.out.println("Save Student"+ student);
        Response r = null;
        if(student != null){
            r = db.post(student);
        }
        return r.getId();
    }

    // Get all Students
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    List<Student> getAll(@RequestParam(required=false) Integer matrikel_nr) {
        // Get all Students
        List<Student> allStudents = null;
        try {
            if (matrikel_nr == null) {
                allStudents = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(Student.class);
            } else {
                db.createIndex("querybyMtrNrView","mtrNr","json",
                        new IndexField[]{new IndexField("matrikel_nr", IndexField.SortOrder.asc)});
                System.out.println("Successfully created index");
                allStudents = db.findByIndex("{\"matrikel_nr\" : " + matrikel_nr + "}", Student.class);
            }
        } catch (Exception e) {
            System.out.println("Exception thrown : " + e.getMessage());
        }
        return allStudents;
    }
}
