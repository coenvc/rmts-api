package repository.prospect;

import model.*;
import model.status.StatusCode;
import model.status.StatusFactory;
import org.omg.PortableInterceptor.ACTIVE;

import java.util.ArrayList;
import java.util.List;


public class TestProspectRepository implements ProspectRepository {

    public static List<Prospect> prospectList(){
        List<Prospect> prospects = new ArrayList<Prospect>();

        Prospect p1 = new ProspectBuilder()
                .name("Henk Jansen")
                .phoneNumber("0612345678")
                .emailAddress("HansJansen@gmail.com")
                .imageUrl("Google.com")
                .address(new AddressBuilder()
                        .street("Kerkstraat")
                        .houseNumber("10")
                        .city("Tilburg")
                        .zipcode("5032HJ")
                        .build())
                .profession(new ProfessionBuilder()
                        .name("Bankzitter")
                        .build())
                .socialLinks(new SocialLinksBuilder()
                        .facebook("")
                        .linkedin("")
                        .twitter("")
                        .build())
                .status(new StatusFactory()
                        .build(StatusCode.ACTIVE))
                .build();

        Prospect p2 = new ProspectBuilder()
                .name("Jan De Vries")
                .phoneNumber("0687654321")
                .emailAddress("JanDeVries@gmail.com")
                .imageUrl("Google.com")
                .address(new AddressBuilder()
                        .street("Kerkstraat")
                        .houseNumber("15")
                        .city("Tilburg")
                        .zipcode("5032JV")
                        .build())
                .profession(new ProfessionBuilder()
                        .name("Gansewinkel")
                        .build())
                .socialLinks(new SocialLinksBuilder()
                        .facebook("adsfadsf")
                        .linkedin("adsfasdf")
                        .twitter("asdfasdf")
                        .build())
                .status(new StatusFactory()
                        .build(StatusCode.DENIED))
                .build();

        p1.setid(1);
        p2.setid(2);

        prospects.add(p1);
        prospects.add(p2);

        return prospects;
    }

    public boolean insert(Prospect prospect) {
        return false;
    }

    public List getAll() {



        return prospectList();
    }

    public Prospect find(int id) {
        List<Prospect> prospects = prospectList();

        for(int i = 0; i < prospectList().size(); i++){
            if(prospects.get(i).getid() == id){
                return prospects.get(i);
            }
        }
        return null;
    }
}
